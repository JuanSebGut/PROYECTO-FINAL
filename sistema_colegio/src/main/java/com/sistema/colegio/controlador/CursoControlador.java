package com.sistema.colegio.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.colegio.modelo.Curso;
import com.sistema.colegio.repositorio.CursoRepositorio;

@Controller
public class CursoControlador {

	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@GetMapping("/cursoo")
	public String listarCurso(Model modelo) {
		List<Curso> listaCurso = cursoRepositorio.findAll();
		modelo.addAttribute("listaCurso", listaCurso);
		return "curso";
	}

	@GetMapping("/curso/nuevo")
	public String mostrarFormularioDeNuevaCurso(Model modelo) {
		modelo.addAttribute("curso", new Curso());
		
		return "curso_formulario";
	}
	
	@PostMapping("/curso/guardar")
	public String guardarCurso(Curso curso) {
		cursoRepositorio.save(curso);
		
		return "redirect:/cursoo";
	}
	
	@GetMapping("/curso/editar/{id}")
	public String mostrarFormularioDeModificarCurso(@PathVariable("id") Integer  id,Model modelo) {
		Curso curso = cursoRepositorio.findById(id).get();
		modelo.addAttribute("curso", curso);
		
		return "curso_formulario";
	}
	
	@GetMapping("/curso/eliminar/{id}")
	public String eliminarCurso(@PathVariable("id") Integer id,Model modelo) {
		cursoRepositorio.deleteById(id);
		
		return "redirect:/cursoo";
	}
	
}
