package com.school.management.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.api_crud.entity.Materia;

public interface MateriaRepository extends JpaRepository <Long, Materia> {

}
