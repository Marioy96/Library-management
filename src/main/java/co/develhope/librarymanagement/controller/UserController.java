package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertNewUser(@RequestBody User user) {
       //TODO exception handling
        userService.addNewUser(user);
        //System.out.println(user.toString());
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













