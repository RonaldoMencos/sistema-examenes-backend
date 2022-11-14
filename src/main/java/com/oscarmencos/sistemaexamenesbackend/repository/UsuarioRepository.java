package com.oscarmencos.sistemaexamenesbackend.repository;

import com.oscarmencos.sistemaexamenesbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
