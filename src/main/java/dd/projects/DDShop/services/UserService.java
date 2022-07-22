package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.UserCreateDTO;
import dd.projects.DDShop.DTOs.UserDTO;
import dd.projects.DDShop.enitities.User;


import dd.projects.DDShop.mapperss.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.DDShop.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private UserMapperImpl userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserRepository getUserRepository(){
        return userRepository;
    }
    public UserCreateDTO createUser(UserCreateDTO userCreateDTO){
        User user= userMapper.UserCreateDTOToUser(userCreateDTO);
        return userMapper.UserToUserCreateDTO(userRepository.save(user));
    }
  public List<UserDTO> getUsers(){
        return userRepository.findAll().stream()
                .map(user -> userMapper.UserToUserDTo(user))
                .collect(Collectors.toList());
    }
    public UserCreateDTO updateUser(int id,UserCreateDTO userDTO){
        User user=userMapper.UserCreateDTOToUser(userDTO);
        Optional<User> oldUser=userRepository.findById(id);
        userRepository.deleteById(id);
        if(oldUser.isPresent()) {
            user.setOrders(oldUser.get().getOrders());
            user.setId(id);
        }
        return userMapper.UserToUserCreateDTO(userRepository.save(user));
    }
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public UserDTO getUserById(int id){
        Optional<User> user=userRepository.findById(id);
            return userMapper.UserToUserDTo(user.get());


    }


}
