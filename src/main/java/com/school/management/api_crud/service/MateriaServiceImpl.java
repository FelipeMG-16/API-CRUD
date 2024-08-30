package com.school.management.api_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.api_crud.entity.Materia;
import com.school.management.api_crud.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	
	//Instancia de MateriaRepository
	private final MateriaRepository materiaRepository;
	
	
	//Inyeccion de instancia de MateriaRepository en el constructor de MateriaServiceImpl
	@Autowired
	public MateriaServiceImpl(MateriaRepository materiaRepository) {
		this.materiaRepository = materiaRepository;
	}
	
	//Metodo para obtener todas las materias
	@Override
	public List<Materia> obtenerMaterias() {
		return materiaRepository.findAll();
	}
	
	
	//Metodo para obtener una materia por id
	@Override
	public Materia obtenerMateriaPorId(Long id){
		return materiaRepository.findById(id).orElse(null);
	}
	
	
	//Metodo para crear una materia
	@Override
	public Materia crearMateria(Materia materia) {
		return materiaRepository.save(materia);
	}
	
	
	//Metodo para actualizar una materia
	@Override
	public Materia modificarMateria(Long id, Materia materia) {
		Optional<Materia> materiaExistente = materiaRepository.findById(id);
		if (materiaExistente.isPresent()) {
			Materia modificarMateria = materiaExistente.get();
			modificarMateria.setNombre(materia.getNombre());
			modificarMateria.setAlumno(materia.getAlumno());
			modificarMateria.setProfesor(materia.getProfesor());
		}else {
			return null;
		}
		return materia;
	}
	
	
	//Metodo para borrar una materia
	@Override
	public void borrarMateria(Long id) {
		materiaRepository.delete(id);
	}


}
