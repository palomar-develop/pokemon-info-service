package com.palomar.pokemoninfoservice.service;

import com.palomar.pokemoninfoservice.model.entity.Bitacora;
import com.palomar.pokemoninfoservice.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitacoraService {
    private final BitacoraRepository bitacoraRepository;

    @Autowired
    public BitacoraService(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    public Bitacora guardar(Bitacora bitacora) {
        return bitacoraRepository.save(bitacora);
    }
}

