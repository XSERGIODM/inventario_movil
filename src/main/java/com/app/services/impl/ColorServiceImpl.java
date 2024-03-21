package com.app.services.impl;

import com.app.models.Color;
import com.app.repositories.ColorRepository;
import com.app.services.ColorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ColorServiceImpl implements ColorService {

    ColorRepository colorRepository;

    @Override
    public Color save(Color color) {
        color.setColorId(null);
        color.setColorEstado(true);
        return colorRepository.save(color);
    }

    @Override
    public Color findById(Long id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color update(Color color) {
        if (color.getColorId() == null) {
            throw new RuntimeException("El id del color no puede ser nulo");
        }
        return colorRepository.save(color);
    }

    @Override
    public void deleteById(Long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public void deshabilitarHabilitar(Long id) {
        Color color = findById(id);
        if (color == null) {
            throw new RuntimeException("El color no existe");
        }
        color.setColorEstado(!color.getColorEstado());
        colorRepository.save(color);
    }
}
