package com.school.management.api_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.api_crud.entity.Profesor;

public interface ProfesorRepository extends JpaRepository <Long, Profesor>{

	Optional<Profesor> findById(Long id);

	Profesor save(Profesor profesor);

}
