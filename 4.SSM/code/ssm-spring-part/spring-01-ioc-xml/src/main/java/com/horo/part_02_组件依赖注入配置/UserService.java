package com.horo.part_02_组件依赖注入配置;

public class UserService {
        
        private UserDao userDao;

        public UserService(UserDao userDao) {
            this.userDao = userDao;
        }
        private int age;

        private String name;

        public UserService(int age , String name ,UserDao userDao) {
            this.userDao = userDao;
            this.age = age;
            this.name = name;
    }
    }