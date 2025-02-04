package com.devsuperior.dslist.controllers.user;

import com.devsuperior.dslist.dto.user.UserDTO;
import com.devsuperior.dslist.entities.User;
import com.devsuperior.dslist.services.user.UserService;
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
