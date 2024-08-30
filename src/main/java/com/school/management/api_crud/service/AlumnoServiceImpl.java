package com.school.management.api_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.api_crud.entity.Alumno;
import com.school.management.api_crud.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	//Instancia de AlumnoRepository
	private final AlumnoRepository alumnoRepository;
	
	
	//Inyeccion de la instancia en el constructor
	@Autowired
	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	
	
	//Metodo para obtener todos los alumnos
	@Override
	public List<Alumno> obtenerAlumnos() {
		return alumnoRepository.findAll();
	}


	//Metodo para obtener un alumno por id
	@Override
	public Alumno obtenerAlumnoPorId(Long id) {
		return alumnoRepository.findById(id).orElse(null);
	}

	//Metodo para crear un alumno
	@Override
	public Alumno crearAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}


	//Metodo para actualizar un alumno
	@Override
	public Alumno modificarAlumno(Long id, Alumno alumno) {
		Optional<Alumno> alumnoExistente = alumnoRepository.findById(id);
			if(alumnoExistente.isPresent()) {
				Alumno modificarAlumno = alumnoExistente.get();
				modificarAlumno.setNombre(alumno.getNombre());
				modificarAlumno.setMaterias(alumno.getMaterias());
		}else {
			return null;
		}
		return alumno;
	}


	//Metodo para borrar un alumno
	@Override
	public void borrarAlumno(Long id) {
		alumnoRepository.delete(id);
		
	}

}
