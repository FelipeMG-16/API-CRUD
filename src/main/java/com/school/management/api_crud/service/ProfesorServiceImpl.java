package com.school.management.api_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.api_crud.entity.Profesor;
import com.school.management.api_crud.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	private final ProfesorRepository profesorRepository;
	
	
	@Autowired
	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		this.profesorRepository = profesorRepository;
	}

	//Metodo para obtener todos los profesores
	@Override
	public List<Profesor> obtenerProfesores(){
		return profesorRepository.findAll();
	}
	
	
	//Metodo para obtener un profesor por id
	@Override
	public Profesor obtenerProfesorPorId(Long id) {
		return profesorRepository.findById(id).orElse(null);
	}
	
	
	//Metodo para crear un profesor
	@Override
	public Profesor crearProfesor(Profesor profesor) {
		return profesorRepository.save(profesor);
	}
	
	
	//Metodo para actualizar un profesor
	@Override
	public Profesor modificarProfesor(Long id, Profesor profesor) {
		Optional<Profesor> profesorExistente = profesorRepository.findById(id);
		if(profesorExistente.isPresent()) {
			Profesor modificarProfesor = profesorExistente.get();
			modificarProfesor.setNombre(profesor.getNombre());
		}else {
			return null;
		}
		return profesor;
	}
	
	//Metodo para borrar un profesor
	@Override
	public void borrarProfesor(Long id) {
		profesorRepository.deleteById(id);
	}

	
	
}
