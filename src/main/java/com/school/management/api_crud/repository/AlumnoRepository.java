package com.school.management.api_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.api_crud.entity.Alumno;

public interface AlumnoRepository extends JpaRepository <Long, Alumno>{

	Optional<Alumno> findById(Long id);

	Alumno save(Alumno alumno);

	
}
