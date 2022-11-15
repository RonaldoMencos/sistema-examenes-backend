package com.oscarmencos.sistemaexamenesbackend.service.impl;

import com.oscarmencos.sistemaexamenesbackend.model.Usuario;
import com.oscarmencos.sistemaexamenesbackend.model.UsuarioRol;
import com.oscarmencos.sistemaexamenesbackend.repository.RolRepository;
import com.oscarmencos.sistemaexamenesbackend.repository.UsuarioRepository;
import com.oscarmencos.sistemaexamenesbackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioLocal !=null) {
            System.out.println("El usuario ya existe!");
            throw new Exception("El usuario ya existe!");
        } else {
            for (UsuarioRol usuarioRol: usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }

            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuario.setActivo(true);
            int strength = 10; // work factor of bcrypt
            BCryptPasswordEncoder bCryptPasswordEncoder =
                    new BCryptPasswordEncoder(strength, new SecureRandom());
            String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Iterable<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}
