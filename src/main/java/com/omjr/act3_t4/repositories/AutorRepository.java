package com.omjr.act3_t4.repositories;

import com.omjr.act3_t4.entities.Autor;
import com.omjr.act3_t4.entities.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
    List<Libro> findAllByOrderByIdAsc();
}