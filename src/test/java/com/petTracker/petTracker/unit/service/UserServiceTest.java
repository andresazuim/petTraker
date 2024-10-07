package com.petTracker.petTracker.unit.service;

import com.petTracker.petTracker.entities.Usuario;
import com.petTracker.petTracker.repositories.UserRepository;
import com.petTracker.petTracker.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    // Teste para criação de usuário
    @Test
    public void testCriarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        when(userRepository.save(usuario)).thenReturn(usuario);

        Usuario result = userService.criarUsuario(usuario);

        assertNotNull(result);
        assertEquals("Teste", result.getNome());
        verify(userRepository, times(1)).save(usuario);
    }

    // Teste para buscar todos os usuários
    @Test
    public void testBuscarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.add(new Usuario());

        when(userRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = userService.buscarUsuarios();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    // Teste para buscar um usuário por ID com sucesso
    @Test
    public void testFindById_Success() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        when(userRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario result = userService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Teste", result.getNome());
        verify(userRepository, times(1)).findById(1L);
    }

    // Teste para buscar um usuário por ID e lançar exceção
    @Test
    public void testFindById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            userService.findById(1L);
        });

        assertEquals("Usuário não encontrado com id: 1", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
    }

    // Teste para deletar um usuário com sucesso (desativando o usuário)
    @Test
    public void testDeleteUser_Success() {
        // Arrange
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        usuario.setAtivo(true); // Usuário ativo

        when(userRepository.findById(userId)).thenReturn(Optional.of(usuario));
        when(userRepository.save(usuario)).thenReturn(usuario); // Simular a persistência

        // Act
        Usuario result = userService.deleteUser(userId);

        // Assert
        assertTrue(result.getAtivo(), "O usuário deve estar inativo após a exclusão");
        verify(userRepository).save(usuario); // Verifica se save foi chamado
    }

    // Teste para deletar um usuário que não existe
    @Test
    public void testDeleteUser_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            userService.deleteUser(1L);
        });

        assertEquals("Usuário não encontrado com id: 1", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
    }
}
