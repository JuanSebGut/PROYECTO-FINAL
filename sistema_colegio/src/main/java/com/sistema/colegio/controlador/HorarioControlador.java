package com.sistema.colegio.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sistema.colegio.modelo.Horario;
import com.sistema.colegio.repositorio.HorarioRepositorio;

@Controller
public class HorarioControlador {

	@Autowired
	private HorarioRepositorio horarioRepositorio;
	
	@GetMapping("/horario")
	public String listarHorario(Model modelo) {
		List<Horario> listaHorario = horarioRepositorio.findAll();
		modelo.addAttribute("listaHorario", listaHorario);
		return "horario";
	}

	@GetMapping("/horario/nuevo")
	public String mostrarFormularioDeNuevaHorario(Model modelo) {
		modelo.addAttribute("horario", new Horario());
		
		return "horario_formulario";
	}
	
	@PostMapping("/horario/guardar")
	public String guardarHorario(Horario horario) {
		horarioRepositorio.save(horario);
		
		return "redirect:/horario";
	}
	
	@GetMapping("/horario/editar/{id}")
	public String mostrarFormularioDeModificarHorario(@PathVariable("id") Integer  id,Model modelo) {
		Horario horario = horarioRepositorio.findById(id).get();
		modelo.addAttribute("horario", horario);
		
		return "horario_formulario";
	}
	
	@GetMapping("/horario/eliminar/{id}")
	public String eliminarHorario(@PathVariable("id") Integer id,Model modelo) {
		horarioRepositorio.deleteById(id);
		
		return "redirect:/horario";
	}
	
}
