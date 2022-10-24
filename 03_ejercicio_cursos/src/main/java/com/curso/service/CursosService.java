package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> cursos();
	void altaCurso(Curso curso);
	List <Curso> eliminarCurso(String curso);
	void actualizarDuracion(Curso curso);
	Curso buscarCurso(String curso);
	//List<Curso> buscarCursoPrecio(int precioMin, int precioMax);
}
