package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.ApunteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApunteTagRepository extends JpaRepository<ApunteTag, Integer> {

}
