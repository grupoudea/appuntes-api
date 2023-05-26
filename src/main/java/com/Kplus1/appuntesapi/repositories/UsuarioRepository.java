package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findUsuarioByNombreUsuarioAndPassword(String nombreUsuario, String password);

}
