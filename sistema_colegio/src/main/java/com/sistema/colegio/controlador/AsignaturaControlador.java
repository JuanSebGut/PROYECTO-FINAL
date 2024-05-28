package com.sistema.colegio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.colegio.modelo.Asignatura;
import com.sistema.colegio.repositorio.AsignaturaRepositorio;


@Controller
public class AsignaturaControlador {

	@Autowired
	private AsignaturaRepositorio asignaturaRepositorio;
	
	@GetMapping("/asignatura")
	public String listarAsignatura(Model modelo) {
		List<Asignatura> listaAsignatura = asignaturaRepositorio.findAll();
		modelo.addAttribute("listaAsignatura", listaAsignatura);
		
		return "asignatura";
	}
	
	@GetMapping("/asignatura/nuevo")
	public String mostrarFormularioDeNuevaAsignatura(Model modelo) {
		modelo.addAttribute("asignatura", new Asignatura());
		
		return "asignatura_formulario";
	}
	
	@PostMapping("/asignatura/guardar")
	public String guardarAsignatura(Asignatura asignatura) {
		asignaturaRepositorio.save(asignatura);
		return "redirect:/asignatura";
	}
	


	@GetMapping("/asignatura/editar/{id}")
	public String mostrarFormularioDeModificarAsignatura(@PathVariable("id") Integer id,Model modelo) {
		Asignatura asignatura = asignaturaRepositorio.findById(id).get();
		modelo.addAttribute("asignatura",asignatura);
		return "asignatura_formulario";
	}
	
	@GetMapping("/asignatura/eliminar/{id}")
	public String eliminarAsignatura(@PathVariable("id") Integer id,Model modelo) {
		asignaturaRepositorio.deleteById(id);
		
		return "redirect:/asignatura";
	}
}
