package com.school.management.api_crud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name= "alumno_id")
	private Alumno alumno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="profesor_id", referencedColumnName = "id")
	private Profesor profesor;

}
