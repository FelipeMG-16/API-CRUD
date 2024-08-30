package com.school.management.api_crud.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.api_crud.entity.Alumno;
import com.school.management.api_crud.entity.Materia;

public interface AlumnoRepository extends JpaRepository <Alumno, Long>{

	Optional<Materia> findAllById(Long id);


	
}
