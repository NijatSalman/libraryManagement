package com.aistgroup.dao;

import com.aistgroup.entity.User;

import java.util.List;

public interface UserRepositoryCustom {

        public List<User> getAll();

        public User findByEmailAndPassword(String email, String password);

        public User findByEmail(String email);

        public List<User> getAll(String name,String surname,String email);

        public User getById(int id);

        public boolean addUser(User u);

        public boolean updateUser(User u);

        public boolean visibleUser(User u); //it will change visible(true/false)

        public boolean removeUser(int id); //it will delete

}
