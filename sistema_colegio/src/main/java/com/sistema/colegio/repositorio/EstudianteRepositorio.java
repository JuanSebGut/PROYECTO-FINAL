package com.sistema.colegio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.colegio.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{

}
