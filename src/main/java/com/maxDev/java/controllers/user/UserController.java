package com.maxDev.java.controllers.user;


import com.maxDev.java.dto.user.UserDTO;
import com.maxDev.java.entities.User;
import com.maxDev.java.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        List<UserDTO> result = userService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        UserDTO result = userService.findById(id);
        return result;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(createdUser));
    }

}
