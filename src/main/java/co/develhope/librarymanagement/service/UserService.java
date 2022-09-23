package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user){
        if( user == null)return null;
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Integer id){
       return userRepository.findById(id);
    }

    public List<User> findAllUser(){
         return userRepository.findAll();
    }

    public  String deleteAllUser(){
        userRepository.deleteAll();
        return "All user are deleted";
    }

    public String deleteUserById(Integer id){
        userRepository.deleteById(id);
        return String.format("User whit id %d as deleted ", id);

    }

    public User updateUser(User user,Integer id) throws Exception{
        if(!userRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return userRepository.save(user);

    }
}
