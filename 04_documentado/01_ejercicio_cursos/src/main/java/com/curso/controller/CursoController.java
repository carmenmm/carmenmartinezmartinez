package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursoController {
	
	@Autowired
	CursosService service;
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos(){
		return service.cursos();
	}
	
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	@PostMapping(value="cursoAlta/{nombre}/{asignatura}/{precioFormacion}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregarFormacion(@PathVariable("nombre") String nombre, 
			@PathVariable("asignatura") int asignatura, 
			@PathVariable("precioFormacion") int precio) {
		int duracion = asignatura * 10;
		String codCurso = nombre.substring(0,3).concat(Integer.toString(duracion));
		Curso curso = new Curso(codCurso, nombre, duracion, precio);
		service.altaCurso_asig(curso);
	}
	
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable("codCurso") String codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@PutMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		service.actualizarDurancion(curso);
	}
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
}
