package com.GestionLibros.GestionLibros.Services;

import com.GestionLibros.GestionLibros.Repositories.UsuarioRepository;
import com.GestionLibros.GestionLibros.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService

    {
        private final UsuarioRepository usuarioRepository;

        public UsuarioService(UsuarioRepository usuarioRepository) {

            this.usuarioRepository = usuarioRepository;
        }

        public Usuario crearUsuario(Usuario usuario) {
            // Aquí puedes implementar reglas de negocio antes de guardar
            return usuarioRepository.save(usuario);
        }

        public Optional<Usuario> obtenerUsuarioPorNombre(String nombre) {
            return usuarioRepository.findByNombre(nombre);
        }
        public Usuario findById(long id){
            return usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        }
    }
