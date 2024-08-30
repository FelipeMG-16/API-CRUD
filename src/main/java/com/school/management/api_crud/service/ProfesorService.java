package com.school.management.api_crud.service;

import java.util.List;

import com.school.management.api_crud.entity.Profesor;

//Se implementan interfaces en la capa servicios para aplicar polimorfismo
public interface ProfesorService {

	List<Profesor> obtenerProfesores();
	Profesor obtenerProfesorPorId(Long id);
	Profesor crearProfesor(Profesor profesor);
	Profesor modificarProfesor(Long id, Profesor profesor);
	void borrarProfesor(Long id);
}
