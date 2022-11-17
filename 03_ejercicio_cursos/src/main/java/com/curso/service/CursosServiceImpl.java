package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosDao dao;
	
	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

	@Override
	public void altaCurso(Curso curso) {
		dao.save(curso);

	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);;
		return dao.findAll();
	}

	@Override
	public void actualizarDuracion(Curso curso) {
		dao.save(curso);
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	/*@Override
	public List<Curso> buscarCursoPrecio(int precioMin, int precioMax) {
		Curso curso_1 = dao.
		Curso curso_2 = dao.findBy(precioMax);
		return List<curso_1, curso_2>;
	}*/

}
