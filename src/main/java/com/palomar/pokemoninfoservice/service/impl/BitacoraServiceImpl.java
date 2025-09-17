package com.palomar.pokemoninfoservice.service.impl;

import com.palomar.pokemoninfoservice.model.entity.Bitacora;
import com.palomar.pokemoninfoservice.repository.BitacoraRepository;
import com.palomar.pokemoninfoservice.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BitacoraServiceImpl implements BitacoraService {
    private final BitacoraRepository bitacoraRepository;

    @Autowired
    public BitacoraServiceImpl(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }
    @Override
    @Async
    public void guardar(Bitacora bitacora) {
       bitacoraRepository.save(bitacora);
    }
}

