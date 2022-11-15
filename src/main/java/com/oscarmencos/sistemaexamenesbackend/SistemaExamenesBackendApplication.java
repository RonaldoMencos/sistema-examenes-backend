package com.oscarmencos.sistemaexamenesbackend;

import com.oscarmencos.sistemaexamenesbackend.model.Rol;
import com.oscarmencos.sistemaexamenesbackend.model.Usuario;
import com.oscarmencos.sistemaexamenesbackend.model.UsuarioRol;
import com.oscarmencos.sistemaexamenesbackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

    private final UsuarioService usuarioService;

    public SistemaExamenesBackendApplication(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SistemaExamenesBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Oscar");
//        usuario.setApellido("Mencos");
//        usuario.setUsername("omencos2");
//        BCryptPasswordEncoder ps = new BCryptPasswordEncoder();
//        usuario.setPassword(ps.encode("123456"));
//        usuario.setEmail("oscaronaldo2001@gmail.com");
//        usuario.setTelefono("55759219");
//        usuario.setPerfil("foto.png");
//
//
//        Rol rol = new Rol();
//        rol.setRolId(1L);
//        rol.setNombre("ADMIN");
//
//        Set<UsuarioRol> usuarioRoles = new HashSet<>();
//        UsuarioRol usuarioRol = new UsuarioRol();
//        usuarioRol.setRol(rol);
//        usuarioRol.setUsuario(usuario);
//        usuarioRoles.add(usuarioRol);
//
//        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
//        System.out.println(usuarioGuardado.getUsername());
    }
}
