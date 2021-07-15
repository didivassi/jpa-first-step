package academy.mindswap.jpafirststep.controllers;

import academy.mindswap.jpafirststep.persistance.User;
import academy.mindswap.jpafirststep.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

     private UserService userService;

     @GetMapping("/users")
     public List<User> getUsers(){
         return userService.getUsers();
     }

    @GetMapping("/users/{id}")
    public User getUseById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


     @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
