package com.school.management.api_crud.entity;

import java.util.List;

import lombok.Data;


@Data
public class Alumno {
	
	private Long id;
	private String nombre;
	private List<Materia> materias;
	
}
