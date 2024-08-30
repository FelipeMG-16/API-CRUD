package com.school.management.api_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.api_crud.entity.Alumno;
import com.school.management.api_crud.entity.Materia;
import com.school.management.api_crud.entity.Profesor;
import com.school.management.api_crud.repository.AlumnoRepository;
import com.school.management.api_crud.repository.MateriaRepository;
import com.school.management.api_crud.repository.ProfesorRepository;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	
	//Instancias
	private final MateriaRepository materiaRepository;
	private final AlumnoRepository alumnoRepository;
	private final ProfesorRepository profesorRepository;
	
	
	//Inyeccion de instancia de MateriaRepository en el constructor de MateriaServiceImpl
	@Autowired
	public MateriaServiceImpl(MateriaRepository materiaRepository, AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository) {
		this.materiaRepository = materiaRepository;
		this.alumnoRepository = alumnoRepository;
		this.profesorRepository = profesorRepository;
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
        try {
            // Verificar y asignar Alumno si existe
            if (materia.getAlumno() != null && materia.getAlumno().getId() != null) {
                Alumno existingAlumno = alumnoRepository.findById(materia.getAlumno().getId())
                        .orElseThrow();
                materia.setAlumno(existingAlumno);
            }

            // Verificar y asignar Profesor si existe
            if (materia.getProfesor() != null && materia.getProfesor().getId() != null) {
                Profesor existingProfesor = profesorRepository.findById(materia.getProfesor().getId())
                        .orElseThrow();
                materia.setProfesor(existingProfesor);
            }

            return materiaRepository.save(materia);
        } finally {
    }
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
		materiaRepository.deleteById(id);
	}

	

}
