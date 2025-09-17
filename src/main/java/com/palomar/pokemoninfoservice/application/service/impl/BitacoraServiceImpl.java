package com.palomar.pokemoninfoservice.application.service.impl;

import com.palomar.pokemoninfoservice.domain.model.Bitacora;
import com.palomar.pokemoninfoservice.domain.port.in.BitacoraService;
import com.palomar.pokemoninfoservice.domain.port.out.BitacoraRepository;
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
