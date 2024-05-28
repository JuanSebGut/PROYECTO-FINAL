package com.sistema.colegio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
	
	private String documento;
	
	private float nota;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "asignatura_id")
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario;

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
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Estudiante(Integer id, String nombre, String documento, float nota, Curso curso, Asignatura asignatura, Horario horario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.nota = nota;
		this.curso = curso;
		this.asignatura = asignatura;
		this.horario = horario;
	}

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String documento, float nota, Curso curso, Asignatura asignatura, Horario horario) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.nota = nota;
		this.curso = curso;
		this.asignatura = asignatura;
		this.horario = horario;
	}
	

	public Estudiante(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Estudiante(Integer id) {
		super();
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + "]";
	}

}
