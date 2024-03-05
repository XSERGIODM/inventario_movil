package com.app.repositories;

import com.app.models.Movil;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Long> {
}