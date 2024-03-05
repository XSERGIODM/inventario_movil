package com.app.services;

import com.app.models.Movil;

import java.util.List;

public interface MovilService {
    Movil save(Movil movil);
    Movil findById(Long id);
    Movil update(Movil movil);
    void deleteById(Long id);
    List<Movil> findAll();
    List<Movil> buscarMovil(String nombre);
}
