package com.app.services;

import com.app.models.Color;

import java.util.List;

public interface ColorService {
    Color save(Color color);
    Color findById(Long id);
    List<Color> findAll();
    Color update(Color color);
    void deleteById(Long id);
    void deshabilitarHabilitar(Long id);
}
