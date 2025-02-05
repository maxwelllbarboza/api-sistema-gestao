package com.maxDev.java.services.usuario;

import com.maxDev.java.dto.RegisterRequestDTO;
import com.maxDev.java.entities.Usuario;
import com.maxDev.java.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDTO body){
        if (usuarioRepository.findByEmail(body.getEmail()) != null) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(body.getPassword());
        Usuario usuario = new Usuario();
        usuario.setName(body.getName());
        usuario.setEmail(body.getEmail());
        usuario.setPassword(encryptedPassword); // O hash da senha é feito na entidade
        usuario.setRole(body.getRole());
        usuarioRepository.save(usuario);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário cadastrado");
        return ResponseEntity.ok(response);
    }


}
