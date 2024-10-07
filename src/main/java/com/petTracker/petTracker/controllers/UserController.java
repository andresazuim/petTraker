package com.petTracker.petTracker.controllers;

import com.petTracker.petTracker.entities.Usuario;
import com.petTracker.petTracker.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = userService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsers() {
        List<Usuario> allUsers = userService.buscarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable  Long id) {
       Usuario usuario = userService.findById(id);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            Usuario usuario = userService.deleteUser(id);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
