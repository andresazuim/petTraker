package com.petTracker.petTracker.services;

import com.petTracker.petTracker.entities.Usuario;
import com.petTracker.petTracker.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public List<Usuario> buscarUsuarios() {
        return userRepository.findAll();
    }

    public Usuario findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));
    }

    public Usuario deleteUser(Long id) {
        var user = findById(id);

        if (user != null) {
            if (user.getAtivo()) {
                user.setAtivo(false);
                userRepository.save(user);
            }
        } else {
            throw new EntityNotFoundException("Usuário não encontrado com id: " + id);
        }

        return user;
    }


}
