package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.UserCreateDTO;
import dd.projects.DDShop.DTOs.UserDTO;
import dd.projects.DDShop.enitities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dd.projects.DDShop.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
   @ResponseBody
   List<UserDTO> read(){
        return userService.getUsers();
  }

    @PostMapping
    UserCreateDTO create(@RequestBody UserCreateDTO user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    @ResponseBody
    UserCreateDTO update(@PathVariable Integer id,@RequestBody UserCreateDTO user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
