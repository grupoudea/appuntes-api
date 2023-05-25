package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.EstudianteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteTagRepository extends JpaRepository<EstudianteTag, Integer> {

}
