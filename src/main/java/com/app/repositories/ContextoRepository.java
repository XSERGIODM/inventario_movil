package com.app.repositories;

import com.app.models.Contexto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextoRepository extends JpaRepository<Contexto, Long> {
}