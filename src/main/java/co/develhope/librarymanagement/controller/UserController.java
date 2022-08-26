package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.CustomerService;
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
        return UserService.findAllUser();
    }

    @PostMapping("/InsertNewUser")
    public void insertNewUser(@RequestBody User user) {
        UserService.addUser(user);
    }


    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User updatedUser) {
        userService.

    }


    @DeleteMapping("/DeleteUser")
    public void deleteUser(@RequestParam int id) {
        userRepository.deleteAll();
    }

}













