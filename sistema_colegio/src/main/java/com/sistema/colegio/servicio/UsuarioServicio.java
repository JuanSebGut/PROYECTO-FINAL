package com.sistema.colegio.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sistema.colegio.dto.UsuarioRegistroDTO;
import com.sistema.colegio.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
