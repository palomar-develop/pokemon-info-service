package com.palomar.pokemoninfoservice.domain.port.out;

import com.palomar.pokemoninfoservice.domain.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}

