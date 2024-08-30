package com.school.management.api_crud.service;

import java.util.List;

import com.school.management.api_crud.entity.Materia;


//Se implementan interfaces en la capa servicios para aplicar polimorfismo
public interface MateriaService {
	
		List<Materia> obtenerMaterias();
		Materia obtenerMateriaPorId(Long id);
		Materia crearMateria(Materia materia);
		Materia modificarMateria(Long id, Materia materia);
		void borrarMateria(Long id);
}
