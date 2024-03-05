package com.app.services.impl;

import com.app.models.Familia;
import com.app.repositories.FamiliaRepository;
import com.app.services.FamiliaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FamiliaImpl implements FamiliaService {
    FamiliaRepository familiaRepository;

    @Override
    public Familia save(Familia familia) {
        familia.setFamilia_id(null);
        familia.setFamilia_estado(true);
        return familiaRepository.save(familia);
    }

    @Override
    public Familia update(Familia familia) {
        if (familia.getFamilia_id() == null)
            throw new RuntimeException("El id de la familia no puede ser nulo"
                    + " para actualizar un registro");
        return familiaRepository.save(familia);
    }

    @Override
    public Familia findById(Long id) {
        return familiaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Familia> findAll() {
        return familiaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
    }
    @Override
    public void deshabilitarHabilitar(Long id) {
        Familia familia = findById(id);
        if (familia == null)
            throw new RuntimeException("La familia con id " + id + " no existe");
        familia.setFamilia_estado(!familia.getFamilia_estado());
        familiaRepository.save(familia);
    }
}
