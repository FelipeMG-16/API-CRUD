package com.school.management.api_crud.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.api_crud.entity.Materia;
import com.school.management.api_crud.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

	Optional<Materia> findAllById(Long id);

	

	
}
