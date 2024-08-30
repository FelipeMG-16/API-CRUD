package com.school.management.api_crud.entity;

import lombok.Data;

@Data
public class Materia {
	
	private Long id;
	private String nombre;
	private Alumno alumno;
	private Profesor profesor;

}
