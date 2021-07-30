package com.example.UserDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager {

    @Autowired
    UserDao userDao;

    public List<User> getUserList(){
        return userDao.findAll();
    }

    public User getUserById(long id){
        return userDao.getById(id);
    }

    public User addUser(User user){
        userDao.save(user);
        return user;
    }
}
