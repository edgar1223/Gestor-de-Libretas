package com.GestionLibros.GestionLibros.Controllers;

import com.GestionLibros.GestionLibros.Services.UsuarioService;
import com.GestionLibros.GestionLibros.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GestionLibros.GestionLibros.DTO.UsuarioDTO;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService)
        {
            this.usuarioService = usuarioService;
        }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setContraseña(usuarioDTO.getContraseña());
        Usuario creado = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(new UsuarioDTO(creado.getNombre(), null));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable String nombre) {
        return usuarioService.obtenerUsuarioPorNombre(nombre)
                .map(usuario -> ResponseEntity.ok(new UsuarioDTO(usuario.getNombre(), null)))
                .orElse(ResponseEntity.notFound().build());
    }
}
