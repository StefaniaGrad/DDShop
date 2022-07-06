package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.User;
import org.springframework.stereotype.Service;
import dd.projects.DDShop.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserRepository getUserRepository(){
        return userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }


}
