package com.example.UserDemo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @InjectMocks
    UserManager userManager;

    @Mock
    UserDao userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserListTest(){
        List<User> list = new ArrayList<User>();
        User us1 = new User(1 ,"Tweety");
        User us2 = new User(2,null);
        User us3 = new User(3,"Casper");

        list.add(us1);
        list.add(us2);
        list.add(us3);

        when(userDao.findAll()).thenReturn(list);

        List<User> user_list = userManager.getUserList();

        assertEquals(3,user_list.size());
        verify(userDao, times(1)).findAll();

    }


    @Test
    public void getUserByIdTest(){
        User us2 = new User(3L, "Kasper");
        when(userDao.findById(3L)).thenReturn(java.util.Optional.of(us2));
//        when(userManager.getUserById(3L)).thenReturn(new User(3, "Kasper"));
        User us1 = userManager.getUserById(3L);

        assertEquals(3L , us1.getId());
        assertEquals("Kasper", userManager.getUserById(3).getName());

    }

    @Test
    public void createUserTest(){
        User us1 = new User(4L , "Naruto");
        userManager.addUser(us1);
        verify(userDao , times(1)).save(us1);
    }

}
