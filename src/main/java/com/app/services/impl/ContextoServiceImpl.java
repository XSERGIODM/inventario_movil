package com.app.services.impl;

import com.app.models.Contexto;
import com.app.repositories.ContextoRepository;
import com.app.services.ContextoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class ContextoServiceImpl implements ContextoService {
    ContextoRepository contextoRepository;

    @Override
    public Contexto save(Contexto contexto) {
        log.info("Contexto save=  " + contexto.getContextoId());
        Contexto newContexto = new Contexto();
        newContexto.setContextoMovil(contexto.getContextoMovil());
        newContexto.setContextoUbicacion(contexto.getContextoUbicacion());
        newContexto.setContextoDetalle(contexto.getContextoDetalle());
        newContexto.setContextoEstado(true);
        newContexto.setContextoFechaEntrada(LocalDateTime.now());
        return contextoRepository.save(newContexto);
    }

    @Override
    public Contexto findById(Long id) {
        log.info("contexto id buscar = " + id);
        return contextoRepository.findById(id).orElse(null);
    }

    @Override
    public Contexto update(Contexto contexto) {
        log.info("Contexto update:  " + contexto);
        Contexto contextoAux = findById(contexto.getContextoId());
        contextoAux.setContextoFechaSalida(LocalDateTime.now());
        contextoAux.setContextoEstado(false);
        contextoAux.setContextoDetalleSalida(contexto.getContextoDetalleSalida());
        return contextoRepository.save(contextoAux);
    }

    @Override
    public void delete(Long id) {

    }
}
