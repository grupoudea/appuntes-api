package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
