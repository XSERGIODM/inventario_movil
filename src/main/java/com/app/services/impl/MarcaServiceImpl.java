package com.app.services.impl;

import com.app.models.Marca;
import com.app.repositories.MarcaRepository;
import com.app.services.MarcaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MarcaServiceImpl implements MarcaService {

    MarcaRepository marcaRepository;

    @Override
    public Marca save(Marca marca) {
        marca.setMarcaId(null);
        marca.setMarcaEstado(true);
        return marcaRepository.save(marca);
    }

    @Override
    public Marca findById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public Marca update(Marca marca) {
        if (marca.getMarcaId() == null)
            throw new RuntimeException("El id de la marca no puede ser nulo");
        Marca marcaAux = marcaRepository.findById(marca.getMarcaId()).orElse(null);
        if (marcaAux == null)
            throw new RuntimeException("La marca con id " + marca.getMarcaId() + " no existe");
        marcaAux.setMarcaNombre(marca.getMarcaNombre());
        return marcaRepository.save(marcaAux);
    }

    @Override
    public void deshabilitarHabilitar(Long id) {
        Marca marca = marcaRepository.findById(id).orElse(null);
        if (marca == null)
            throw new RuntimeException("La marca con id " + id + " no existe");
        marca.setMarcaEstado(!marca.getMarcaEstado());
        marcaRepository.save(marca);
    }
}
