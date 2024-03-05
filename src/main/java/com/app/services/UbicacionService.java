package com.app.services;

import com.app.models.Ubicacion;

import java.util.List;

public interface UbicacionService {
    Ubicacion save(Ubicacion ubicacion);
    Ubicacion findById(Long id);
    void deleteById(Long id);
    List<Ubicacion> findAll();
    Ubicacion update(Ubicacion ubicacion);
    void deshabilitarHabilitar(Long id);
}
