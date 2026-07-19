package com.omjr.act3_t4.services;

import com.omjr.act3_t4.entities.Autor;
import com.omjr.act3_t4.entities.Libro;
import com.omjr.act3_t4.repositories.AutorRepository;
import com.omjr.act3_t4.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibrosService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizar(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminar(Libro libro) {
        libroRepository.delete(libro);
    }

    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAllByOrderByIdAsc();
    }
}
