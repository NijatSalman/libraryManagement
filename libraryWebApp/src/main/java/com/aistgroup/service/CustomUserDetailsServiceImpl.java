package com.aistgroup.service;

import com.aistgroup.entity.GroupUser;
import com.aistgroup.entity.User;
import com.aistgroup.service.inter.GroupUserServiceInter;
import com.aistgroup.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceInter userObj;

    @Autowired
    private GroupUserServiceInter grObj;

    private User user;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user =userObj.findByEmail(email);
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if(user !=null){
            UserBuilder builder=org.springframework.security.core.userdetails.User.withUsername(email);


            builder.disabled(false); //I have taken this for manually,because i did not consider on DB side
            builder.password((user.getPassword()));

            //String[] authoritiesArr=new String[]{"USER","ROLE_ADMIN","ROLE_USER"};//(My laws) This is HardCode: I have taken this for manually,
            // because i did not consider on DB side,but i will change it after !!
            String[] authoritiesArr=getAuthorities();
            System.out.println(authoritiesArr[0].toString());
            builder.authorities(authoritiesArr);

            return builder.build();
        }else{
            System.out.println("error happening here");
            throw new UsernameNotFoundException("User not found");
        }
    }

        private String[] getAuthorities() {
        System.out.println("-----------------");
        System.out.println(user.getId()+" user.getId()");
        System.out.println("----------------");
        Integer userId=user.getId();
        List<GroupUser> list = grObj.getAllGroupByUserId(userId);
        System.out.println(list.get(0)+"list.get(0)");
        System.out.println(list.size()+"list.size()-1");
        String[] arr = new String[list.size()];
        System.out.println(arr.length+"arr.length");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(list.get(i).getGroupId().getName()+"list.get(i).getGroupId().getName()");
            arr[i]=list.get(i).getGroupId().getName();
        }
        return arr;
    }

}