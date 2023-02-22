package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
