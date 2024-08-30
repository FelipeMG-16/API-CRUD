package com.school.management.api_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.api_crud.entity.Alumno;
import com.school.management.api_crud.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
	
	//Instancia de AlumnoService
	private final AlumnoService alumnoService;
	
	
	//Inyeccion de instancia AlumnoService en constructor
	@Autowired
	public AlumnoController(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}
	
	
	//Get
	@GetMapping
	public List<Alumno> getAllAlumnos(){
		return alumnoService.obtenerAlumnos();
	}
	
	//Get
	@GetMapping("/{id}")
	public Alumno getAlumnoById(@PathVariable Long id) {
		return alumnoService.obtenerAlumnoPorId(id);
	}
	
	
	//Post
	@PostMapping
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return alumnoService.crearAlumno(alumno);
	}
	
	//Put
	@PutMapping("/{id}")
	public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
		return alumnoService.modificarAlumno(id, alumno);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteAlumno(@PathVariable Long id) {
		alumnoService.borrarAlumno(id);
	}
}
