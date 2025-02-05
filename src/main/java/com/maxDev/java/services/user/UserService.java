package com.maxDev.java.services.user;

import com.maxDev.java.dto.user.UserDTO;
import com.maxDev.java.entities.User;
import com.maxDev.java.exceptions.EmailAlreadyExistsException;
import com.maxDev.java.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> result = userRepository.findAll();
        return result.stream().map(x -> new UserDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User result = userRepository.findById(id).get();
        return new UserDTO(result);
    }

    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email já cadastrado!");
        }
        return userRepository.save(user);    }



}
