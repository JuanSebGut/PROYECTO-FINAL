package com.sistema.colegio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.colegio.modelo.Curso;


public interface CursoRepositorio extends JpaRepository<Curso,Integer>{

}
