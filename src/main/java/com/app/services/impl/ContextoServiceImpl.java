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
        log.info("Contexto save=  " + contexto.getContexto_id());
        Contexto newContexto = new Contexto();
        newContexto.setContexto_movil(contexto.getContexto_movil());
        newContexto.setContexto_ubicacion(contexto.getContexto_ubicacion());
        newContexto.setContexto_detalle(contexto.getContexto_detalle());
        newContexto.setContexto_estado(true);
        newContexto.setContexto_fecha_entrada(LocalDateTime.now());
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
        Contexto contextoAux = findById(contexto.getContexto_id());
        contextoAux.setContexto_fecha_salida(LocalDateTime.now());
        contextoAux.setContexto_estado(false);
        contextoAux.setContexto_detalle_salida(contexto.getContexto_detalle_salida());
        return contextoRepository.save(contextoAux);
    }

    @Override
    public void delete(Long id) {

    }
}
