package com.GestionLibros.GestionLibros.Controllers;

import com.GestionLibros.GestionLibros.DTO.CapituloDTO;
import com.GestionLibros.GestionLibros.DTO.LibretaDTO;
import com.GestionLibros.GestionLibros.DTO.UsuarioDTO;
import com.GestionLibros.GestionLibros.Services.FileStorageService;
import com.GestionLibros.GestionLibros.Services.LibretaService;
import com.GestionLibros.GestionLibros.Services.UsuarioService;
import com.GestionLibros.GestionLibros.models.Libreta;
import com.GestionLibros.GestionLibros.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libretas")
public class LibretaController
    {    @Autowired
        private  LibretaService libretaService;
        @Autowired
        private  UsuarioService usuarioService;
        @Autowired
        private FileStorageService fileStorageService;


        @PostMapping
       public  ResponseEntity<Object> crearUsuario(@ModelAttribute LibretaDTO libretaDTO )
        {
            try {
            String imgPath="";
            Libreta libreta=new Libreta();
            libreta.setNombre(libretaDTO.getNombre());
            libreta.setUsuario(usuarioService.findById(libretaDTO.getId_usario()));
            if (libretaDTO.getImg()!=null ) {
                imgPath = fileStorageService.storeFile(libretaDTO.getImg());
            }
            libreta.setImg(imgPath);
            Libreta creado = libretaService.LibretaSave(libreta);
            List<CapituloDTO> capituloDTOs = creado.getCapitulos().stream()
                    .map(capitulo -> new CapituloDTO(capitulo.getTitulo()))
                    .collect(Collectors.toList());
            LibretaDTO auxiliar=new LibretaDTO(
                    creado.getId(),creado.getNombre(),creado.getUsuario().getNombre(),capituloDTOs
            );
            auxiliar.setImgUrl(creado.getImg());
            return ResponseEntity.ok(auxiliar);
            } catch (IllegalArgumentException | IOException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<List<LibretaDTO>> obtenerLibrosUsuario(@PathVariable long id) {
            List<Libreta> libretas = libretaService.LibretaByUsuario_id(id);

            if (libretas.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            List<LibretaDTO> libretaDTOs = libretas.stream().map(libreta -> {
                List<CapituloDTO> capituloDTOs = libreta.getCapitulos().stream()
                        .map(capitulo -> new CapituloDTO(capitulo.getTitulo()))
                        .collect(Collectors.toList());

                LibretaDTO auxiliar = new LibretaDTO(
                        libreta.getId(),
                        libreta.getNombre(),
                        libreta.getUsuario().getNombre(),
                        capituloDTOs
                );
                auxiliar.setImgUrl(libreta.getImg());
                return auxiliar;
            }).collect(Collectors.toList());

            return ResponseEntity.ok(libretaDTOs);
        }

    }
