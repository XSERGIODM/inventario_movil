package com.app.services;

import com.app.models.Marca;

import java.util.List;

public interface MarcaService {
    Marca save(Marca marca);
    Marca findById(Long id);
    List<Marca> findAll();
    void deleteById(Long id);
    Marca update(Marca marca);
    void deshabilitarHabilitar(Long id);
}
