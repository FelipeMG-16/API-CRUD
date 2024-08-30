package com.school.management.api_crud.service;

import java.util.List;

import com.school.management.api_crud.entity.Alumno;

//Se implementan interfaces en la capa servicios para aplicar polimorfismo
public interface AlumnoService {
	
	List<Alumno> obtenerAlumnos();
	Alumno obtenerAlumnoPorId(Long id);
	Alumno crearAlumno(Alumno alumno);
	Alumno modificarAlumno(Long id, Alumno alumno);
	void borrarAlumno(Long id);
	
}
