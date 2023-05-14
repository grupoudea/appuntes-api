package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    @Query("SELECT m " +
            "FROM Materia m " +
            "JOIN FETCH m.materiaUniversidad mu " +
            "WHERE m.idEstudianteFk = :idEstudiante " +
            "AND ((m.profesor LIKE concat('%', :busqueda, '%')) " +
            "OR (mu.materia LIKE concat('%', :busqueda, '%'))) ")
    List<Materia> filtrarMaterias(@Param("busqueda") String busqueda, @Param("idEstudiante") Integer idEstudiante);

    List<Materia> findMateriaByIdEstudianteFk(Integer id);
}
