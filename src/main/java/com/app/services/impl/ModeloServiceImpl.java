package com.app.services.impl;

import com.app.models.Moodelo;
import com.app.repositories.ModeloRepository;
import com.app.services.ModeloService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ModeloServiceImpl implements ModeloService {

    ModeloRepository modeloRepository;

    @Override
    public Moodelo save(Moodelo modelo) {
        modelo.setModelo_id(null);
        modelo.setModelo_estado(true);
        return modeloRepository.save(modelo);
    }

    @Override
    public Moodelo findById(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    @Override
    public Moodelo update(Moodelo modelo) {
        if (modelo.getModelo_id() == null)
            throw new RuntimeException("El id del modelo no puede ser nulo");

        return modeloRepository.save(modelo);
    }

    @Override
    public void deleteById(Long id) {
        modeloRepository.deleteById(id);
    }

    @Override
    public List<Moodelo> findAll() {
        return modeloRepository.findAll();
    }

    @Override
    public void deshabilitarHabilitar(Long id) {
        Moodelo modelo = findById(id);
        modelo.setModelo_estado(!modelo.getModelo_estado());
        update(modelo);
    }
}
