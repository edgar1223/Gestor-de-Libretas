package com.GestionLibros.GestionLibros.Services;

import com.GestionLibros.GestionLibros.Repositories.LibretaRepository;
import com.GestionLibros.GestionLibros.Repositories.UsuarioRepository;
import com.GestionLibros.GestionLibros.models.Libreta;
import com.GestionLibros.GestionLibros.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LibretaService
    {
        private LibretaRepository libretaRepository;
        private  UsuarioRepository usuarioRepository;

        @Autowired

        public LibretaService(LibretaRepository libretaRepository)
            {
                this.libretaRepository = libretaRepository;
            }

        public Libreta LibretaSave (Libreta libreta) {
            return libretaRepository.save(libreta);
        }
        public List<Libreta> LibretaByUsuario_id(long id) {
            return libretaRepository.findByUsuario_id(id);
        }

    }
