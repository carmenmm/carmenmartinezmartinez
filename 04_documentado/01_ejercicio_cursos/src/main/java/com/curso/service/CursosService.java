package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> cursos();
	void altaCurso(Curso curso);
	List <Curso> eliminarCurso(String curso);
	void actualizarDurancion(Curso curso);
	Curso buscarCurso(String curso);
	void altaCurso_asig(Curso curso);
}
