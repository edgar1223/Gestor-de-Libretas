package com.GestionLibros.GestionLibros.Repositories;

import com.GestionLibros.GestionLibros.models.Libreta;
import com.GestionLibros.GestionLibros.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface LibretaRepository extends JpaRepository<Libreta, Long>
    {
        List<Libreta> findByUsuario_id(long usuario_id);

    }
