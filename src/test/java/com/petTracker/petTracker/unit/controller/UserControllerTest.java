package com.petTracker.petTracker.controllers;

import com.petTracker.petTracker.entities.Usuario;
import com.petTracker.petTracker.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa os mocks
    }

    // Teste para criar um novo usuário
    @Test
    public void testCriarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        when(userService.criarUsuario(usuario)).thenReturn(usuario);

        ResponseEntity<Usuario> response = userController.criarUsuario(usuario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(userService, times(1)).criarUsuario(usuario);
    }

    // Teste para buscar todos os usuários
    @Test
    public void testFindAllUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.add(new Usuario());

        when(userService.buscarUsuarios()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> response = userController.findAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarios, response.getBody());
        verify(userService, times(1)).buscarUsuarios();
    }

    // Teste para buscar um usuário por ID
    @Test
    public void testFindById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        when(userService.findById(1L)).thenReturn(usuario);

        ResponseEntity<Usuario> response = userController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(userService, times(1)).findById(1L);
    }

    // Teste para deletar um usuário
    @Test
    public void testDeleteUser_Success() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(userService.deleteUser(1L)).thenReturn(usuario);

        ResponseEntity<?> response = userController.deleteUser(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(userService, times(1)).deleteUser(1L);
    }

    // Teste para deletar um usuário que não existe
    @Test
    public void testDeleteUser_NotFound() {
        when(userService.deleteUser(1L)).thenThrow(new EntityNotFoundException("Usuário não encontrado"));

        ResponseEntity<?> response = userController.deleteUser(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Usuário não encontrado", response.getBody());
        verify(userService, times(1)).deleteUser(1L);
    }
}
