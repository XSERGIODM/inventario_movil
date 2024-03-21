package com.app.services.impl;

import com.app.models.Ubicacion;
import com.app.repositories.UbicacionRepository;
import com.app.services.UbicacionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UbicacionServiceImpl implements UbicacionService {

    UbicacionRepository ubicacionRepository;

    @Override
    public Ubicacion save(Ubicacion ubicacion) {
        ubicacion.setUbicacionId(null);
        ubicacion.setUbicacionEstado(true);
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public Ubicacion findById(Long id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ubicacionRepository.deleteById(id);
    }

    @Override
    public List<Ubicacion> findAll() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion update(Ubicacion ubicacion) {
        if (ubicacion.getUbicacionId() == null)
            throw new RuntimeException("El id de la ubicacion no puede ser nulo");
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public void deshabilitarHabilitar(Long id) {
        Ubicacion ubicacion = findById(id);
        ubicacion.setUbicacionEstado(!ubicacion.getUbicacionEstado());
        ubicacionRepository.save(ubicacion);
    }
}
