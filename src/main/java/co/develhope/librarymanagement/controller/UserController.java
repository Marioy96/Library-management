package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.UserService;
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
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


    @DeleteMapping("/DeleteUser")
    public void deleteUser(){
        userService.deleteAllUser();
    }

}













