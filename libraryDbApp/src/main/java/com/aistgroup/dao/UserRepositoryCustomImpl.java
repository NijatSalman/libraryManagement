package com.aistgroup.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.aistgroup.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userRepositoryCustomImpl")
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {

        Query query=em.createQuery("Select u from User u", User.class);
        List<User> list=query.getResultList();
        return list;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query=em.createQuery("Select u from User u where u.email=:e and u.password=:p",User.class);
        query.setParameter("e",email);
        query.setParameter("p",password);

        List<User> list= query.getResultList();

        if(list.size()==1){
        return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Query query=em.createQuery("Select u from User u where u.email=:e",User.class);
        query.setParameter("e",email);
        List<User> list=query.getResultList();

        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAll(String name, String surname,String email) {
        String jpql="select u from User u where 1=1";

        if (name!=null && !name.trim().isEmpty()){
            jpql+=" and u.name=:name";
        }
        if(surname!=null && !surname.trim().isEmpty()){
            jpql=" and u.surname=:surname";
        }
        if(email!=null && !email.trim().isEmpty()){
            jpql=" and u.email=:email";
        }

        Query query=em.createQuery(jpql);

        if (name!=null && !name.trim().isEmpty()){
            query.setParameter("name", name);
        }
        if (surname!=null && !surname.trim().isEmpty()){
            query.setParameter("surname", surname);
        }
        if(email!=null && !email.trim().isEmpty()){
            query.setParameter("email",email);
        }

        return query.getResultList();
    }

    @Override
    public User getById(int id) {
        User user=em.find(User.class,id);
        return user;
    }

    private BCrypt.Hasher crypt=BCrypt.withDefaults();
    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean visibleUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User user=em.find(User.class,id);
        em.remove(user);
        return true;
    }
}
