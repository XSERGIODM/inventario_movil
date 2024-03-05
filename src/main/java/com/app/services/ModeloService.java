package com.app.services;

import com.app.models.Moodelo;

import java.util.List;

public interface ModeloService {
    Moodelo save(Moodelo modelo);
    Moodelo findById(Long id);
    Moodelo update(Moodelo modelo);
    void deleteById(Long id);
    List<Moodelo> findAll();
    void deshabilitarHabilitar(Long id);
}
