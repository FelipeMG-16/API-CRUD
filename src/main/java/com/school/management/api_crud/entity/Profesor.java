package com.school.management.api_crud.entity;

import lombok.Data;

@Data
public class Profesor {

	private Long id;
	private String nombre;
	private Materia materia;
}
