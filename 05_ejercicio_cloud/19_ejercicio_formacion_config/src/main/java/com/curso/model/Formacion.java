package com.curso.model;


public class Formacion {
	
	private String nombre;
	private int asignatura;
	private int precio;
	public Formacion(String nombre, int asignatura, int precio) {
		super();
		this.nombre = nombre;
		this.asignatura = asignatura;
		this.precio = precio;
	}
	public Formacion() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(int asignatura) {
		this.asignatura = asignatura;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
