package co.develhope.librarymanagement.library.services;

import co.develhope.librarymanagement.model.entities.User;
import co.develhope.librarymanagement.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user) throws Exception {
       try {
           if (user == null) return null;
           return userRepository.save(user);
       }catch (Exception e){
           throw new Exception("Incorrect input");
       }
    }

    public Optional<User> findUserById(Long id) throws Exception {
       try {
           return userRepository.findById(id);
       }catch (Exception e){
           throw new Exception ("Id not found");
       }
    }

    public List<User> findAllUser() throws Exception {
         List<User> allUser = userRepository.findAll();
         if(allUser.isEmpty()){
             throw new Exception("Not users found");
         }
         return allUser;
    }

    public  String deleteAllUser() throws Exception {
       try {
           userRepository.deleteAll();
           return "All user are deleted";
       }catch (Exception e){
           throw new Exception("Can't delete all user ");
       }
    }

    public String deleteUserById(Long id) throws Exception {
        try {
            userRepository.deleteById(id);
            return String.format("User whit id %d as deleted ", id);
        }catch (Exception e){
            throw new Exception("User id not foud");
        }

    }

    public User updateUser(User user,Long id) throws Exception{
        if(!userRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        user.setId(id);
        return userRepository.save(user);

    }
}
