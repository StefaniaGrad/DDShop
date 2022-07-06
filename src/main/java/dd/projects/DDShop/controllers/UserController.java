package dd.projects.DDShop.controllers;

import dd.projects.DDShop.enitities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dd.projects.DDShop.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    List<User> read(){
        return userService.getUsers();
    }

    @PostMapping
    @ResponseBody
    User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    @ResponseBody
    User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        userService.deleteUserById(id);
    }
}
