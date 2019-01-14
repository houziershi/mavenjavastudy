package com.my.guice.example;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class UserService {

    public UserService() {
        System.out.println("UserService construct");
    }

    @Inject
    private UserDao mUserDao;

    public void say() {
        mUserDao.say();
    }

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector();
        final UserService userService = injector.getInstance(UserService.class);
        userService.say();
    }
}
