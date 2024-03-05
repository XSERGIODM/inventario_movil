package com.app.services;

import com.app.models.Familia;

import java.util.List;

public interface FamiliaService {
    Familia save(Familia familia);
    Familia update(Familia familia);
    Familia findById(Long id);
    List<Familia> findAll();
    void deleteById(Long id);
    void deshabilitarHabilitar(Long id);
}
