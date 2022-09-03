package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addNewUser(User user){
        userRepository.save(user);
    }
    //TODO implementare il get degli utenti tramite id,tramite email e usarname;

    public List<User> findAllUser(){
         return userRepository.findAll();
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }
    //TODO

    public User updateUser(User user) throws NullPointerException{
        User updateUser = userRepository.findById(user.getId()).orElse(null);
        try{
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmail(user.getEmail());
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return userRepository.save(user);

    }
}
