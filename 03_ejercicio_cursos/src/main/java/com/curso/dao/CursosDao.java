package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {

	//List<Curso> findBy(int precioMin, int precioMax);

}
