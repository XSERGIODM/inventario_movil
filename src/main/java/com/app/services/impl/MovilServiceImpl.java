package com.app.services.impl;

import com.app.models.Movil;
import com.app.repositories.MovilRepository;
import com.app.services.MovilService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MovilServiceImpl implements MovilService {

    MovilRepository movilRepository;

    @Override
    public Movil save(Movil movil) {
        movil.setMovil_id(null);
        movil.setMovil_estado(true);
        return movilRepository.save(movil);
    }

    @Override
    public Movil findById(Long id) {
        return movilRepository.findById(id).orElse(null);
    }

    @Override
    public Movil update(Movil movil) {
        if (movil.getMovil_id() == null)
            throw new RuntimeException("El id del movil no puede ser nulo");
        return movilRepository.save(movil);
    }

    @Override
    public void deleteById(Long id) {
        movilRepository.deleteById(id);
    }

    @Override
    public List<Movil> findAll() {
        return movilRepository.findAll();
    }

    @Override
    public List<Movil> buscarMovil(String nombre) {
        return null;
    }
}
