package com.aistgroup.security;

import com.aistgroup.entity.User;
import com.aistgroup.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySessionInfo {

    @Autowired
    private UserServiceInter userObj;

    private User user;

    public User getCurrentUser() {
        if (user == null) {
            user = userObj.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return user;
    }
}
