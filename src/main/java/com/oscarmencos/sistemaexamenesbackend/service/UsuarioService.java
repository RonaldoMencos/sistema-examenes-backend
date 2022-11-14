package com.oscarmencos.sistemaexamenesbackend.service;

import com.oscarmencos.sistemaexamenesbackend.model.Usuario;
import com.oscarmencos.sistemaexamenesbackend.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    Usuario obtenerUsuario(String username);
    void eliminarUsuario(Long idUsuario);

    Iterable<Usuario> obtenerTodos();

}
