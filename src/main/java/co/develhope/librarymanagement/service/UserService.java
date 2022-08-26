package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository

    public static void addUser(User user){
        userRepository

    }

    public static List<User> findAllUser(){
        return userRepository.findAll();
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }

    public static void updateUser(User user){
        userRepository.save(user);
    }


}
