package com.sistema.colegio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 70, nullable = false, unique = true)
	private String nombre;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Horario() {
		super();
	}

	public Horario(Integer id) {
		super();
		this.id = id;
	}

	public Horario(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Horario(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
}
