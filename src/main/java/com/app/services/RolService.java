package com.app.services;

import com.app.models.Rol;

import java.util.List;

public interface RolService {
    List<Rol> findAll();
    Rol findById(Long id);
    Rol save(Rol rol);
    void deshabilitarHabilitar(Rol rol);
}
