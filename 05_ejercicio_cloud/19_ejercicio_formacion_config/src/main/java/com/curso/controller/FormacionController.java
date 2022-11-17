package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;
@CrossOrigin("*")
@RestController
public class FormacionController {

	@Autowired
	FormacionService service;
	
	@PostMapping(value="formacion/{nombre}/{asignatura}/{precio}")
	public List<Formacion> altaCurso(@PathVariable("nombre") String nombre, 
			@PathVariable("asignatura") int asignatura, 
			@PathVariable("precio") int precio){
		Formacion formacion = new Formacion(nombre, asignatura, precio);
		return service.nuevaFormacion(formacion);
	}
}
