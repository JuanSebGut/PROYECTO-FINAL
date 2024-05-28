package com.sistema.colegio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.colegio.modelo.Asignatura;
import com.sistema.colegio.modelo.Curso;
import com.sistema.colegio.modelo.Estudiante;
import com.sistema.colegio.modelo.Horario;
import com.sistema.colegio.repositorio.AsignaturaRepositorio;
import com.sistema.colegio.repositorio.CursoRepositorio;
import com.sistema.colegio.repositorio.EstudianteRepositorio;
import com.sistema.colegio.repositorio.HorarioRepositorio;


@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteRepositorio estudianteRepositorio;
	
	@Autowired
	private CursoRepositorio cursoRepositorio;
	
	@Autowired
	private AsignaturaRepositorio asignaturaRepositorio;
	
	@Autowired
	private HorarioRepositorio horarioRepositorio;
	
	@GetMapping("/estudiante/nuevo")
	public String mostrarFormularioDeNuevoEstudiante(Model modelo) {
		List<Curso> listaCurso = cursoRepositorio.findAll();
		List<Asignatura> listaAsignatura = asignaturaRepositorio.findAll();
		List<Horario> listaHorario = horarioRepositorio.findAll();
		modelo.addAttribute("estudiante", new Estudiante());
		modelo.addAttribute("listaCurso", listaCurso);
		modelo.addAttribute("listaAsignatura", listaAsignatura);
		modelo.addAttribute("listaHorario", listaHorario);
		return "estudiante_formulario";
	}
	
	@PostMapping("/estudiante/guardar")
	public String guardarEstudiante(Estudiante estudiante) {
		estudianteRepositorio.save(estudiante);
		return "redirect:/estudiante";
	}
	
	@GetMapping("/estudiante")
	public String listarEstudiante(Model modelo) {
		List<Estudiante> listaEstudiante = estudianteRepositorio.findAll();
		modelo.addAttribute("listaEstudiante", listaEstudiante);
		return "estudiantes";
	}
	
	@GetMapping("/estudiante/editar/{id}")
	public String mostrarFormularioDeModificarEstudiante(@PathVariable("id") Integer  id,Model modelo) {
		Estudiante estudiante = estudianteRepositorio.findById(id).get();
		modelo.addAttribute("estudiante", estudiante);
        List<Curso> listaCurso = cursoRepositorio.findAll();
		modelo.addAttribute("listaCurso", listaCurso);
		List<Asignatura> listaAsignatura = asignaturaRepositorio.findAll();
		modelo.addAttribute("listaAsignatura", listaAsignatura);
		List<Horario> listaHorario = horarioRepositorio.findAll();
		modelo.addAttribute("listaHorario", listaHorario);
		return "estudiante_formulario";
	}
	
	@GetMapping("/estudiante/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable("id") Integer id,Model modelo) {
		estudianteRepositorio.deleteById(id);
		return "redirect:/estudiante";
	}
 }
