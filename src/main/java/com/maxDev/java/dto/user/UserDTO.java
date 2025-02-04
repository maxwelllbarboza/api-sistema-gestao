package com.devsuperior.dslist.dto.user;

import com.devsuperior.dslist.entities.User;
import org.springframework.beans.BeanUtils;

public class UserDTO {

    private Long id;

    private String name;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User entity){
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
