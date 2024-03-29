package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Apunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApunteRepository extends JpaRepository<Apunte, Integer> {

    @Query("SELECT a " +
            "FROM Apunte a " +
            "WHERE a.idGrupoApunte = :idGrupoApunte " +
            "AND a.contenido LIKE concat('%', :busqueda, '%') ")
    List<Apunte> filtrarApuntes(@Param("busqueda") String busqueda, @Param("idGrupoApunte") Integer idGrupoApunte);
}
