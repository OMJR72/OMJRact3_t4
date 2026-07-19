package com.omjr.act3_t4.services;

import com.omjr.act3_t4.entities.Autor;
import com.omjr.act3_t4.repositories.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void eliminar(Integer id) {
        autorRepository.deleteById(id);
    }
}