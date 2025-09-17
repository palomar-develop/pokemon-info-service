package com.palomar.pokemoninfoservice.repository;

import com.palomar.pokemoninfoservice.model.entity.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}

