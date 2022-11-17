package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestTemplate template;

	//private String url="http://localhost:8080/";
	private String url="http://servicio-formacion";
	@Override
	public List<Formacion> nuevaFormacion(Formacion formacion) {
		int duracion = formacion.getAsignatura() * 10;
		String cod_Curso = formacion.getNombre().substring(0,3).concat(Integer.toString(duracion));
		Formacion exist_formacion = template.getForObject(url+"curso/{codCurso}", Formacion.class, cod_Curso);
		
		if(exist_formacion == null) {
			template.postForLocation(url+"cursoAlta/{nombre}/{asignatura}/{precioFormacion}",Formacion.class, formacion.getNombre(), formacion.getAsignatura(), formacion.getPrecio());
		}
		
		Formacion[] insert_formacion = template.getForObject(url+"cursos", Formacion[].class, formacion.getAsignatura());
		return Arrays.asList(template.getForObject(url+"cursos", Formacion[].class, formacion.getAsignatura()));
	}

}
