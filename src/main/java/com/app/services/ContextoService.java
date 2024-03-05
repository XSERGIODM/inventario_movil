package com.app.services;

import com.app.models.Contexto;

public interface ContextoService {
    Contexto save(Contexto contexto);
    Contexto findById(Long id);
    Contexto update(Contexto contexto);
    void delete(Long id);
}
