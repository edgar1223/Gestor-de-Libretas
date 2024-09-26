package com.GestionLibros.GestionLibros.Repositories;

import com.GestionLibros.GestionLibros.models.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapituloRepository  extends JpaRepository<Capitulo, Long> {
}
