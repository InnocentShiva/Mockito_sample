package com.example.UserDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserManager userManager;

//    @GetMapping
//    public List<User> findAllUsers() {
//        return (List<User>) userRepository.findAll();
//    }

    @GetMapping
    public List<User> findAllUsers() {
        return (List<User>) userManager.getUserList();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id){
//        Optional<User> user = userRepository.findById(id);
//
//        if(user.isPresent()) {
//            return ResponseEntity.ok().body(user.get());
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id){
        Optional<User> user = Optional.ofNullable(userManager.getUserById(id));

        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

//    @PostMapping
//    public User saveUser(@Validated @RequestBody User user){
//        return userRepository.save(user);
//    }

    @PostMapping
    public User saveUser(@Validated @RequestBody User user){
        return userManager.addUser(user);
    }


}
