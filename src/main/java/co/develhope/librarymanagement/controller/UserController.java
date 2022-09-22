package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping("/InsertNewUser")
    public ResponseEntity<User> insertNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


    @PutMapping("/updateUser")
    public ResponseEntity<User>updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @DeleteMapping("/DeleteUser")
    public ResponseEntity<User>deleteUser(){
        userService.deleteAllUser();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}













