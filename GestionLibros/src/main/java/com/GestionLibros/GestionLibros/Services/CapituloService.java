package com.GestionLibros.GestionLibros.Services;

import com.GestionLibros.GestionLibros.Repositories.CapituloRepository;
import com.GestionLibros.GestionLibros.models.Capitulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CapituloService
    {
        private CapituloRepository capituloRepository;
        @Autowired

        public CapituloService(CapituloRepository capituloRepository)
            {
                this.capituloRepository= capituloRepository;
            }

        public Capitulo saveCapitulo(Capitulo capitulo)
            {
                return capituloRepository.save(capitulo);
            }


    }
