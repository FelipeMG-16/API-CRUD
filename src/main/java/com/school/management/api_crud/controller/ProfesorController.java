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

import com.school.management.api_crud.entity.Profesor;
import com.school.management.api_crud.service.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	
	//Instancia de ProfesorService
	private final ProfesorService profesorService;
	
	//Inyeecion de instancia ProfesorService en constructor
	@Autowired
	public ProfesorController(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}
	
	//Get
	@GetMapping
	public List<Profesor> getAllProfesores(){
		return profesorService.obtenerProfesores();
	}
	
	
	//Get
	@GetMapping("/{id}")
	public Profesor getProfesorById(@PathVariable Long id) {
		return profesorService.obtenerProfesorPorId(id);
	}
	
	
	//Post
	@PostMapping("/{id}")
	public Profesor createProfesor (@RequestBody Profesor profesor) {
		return profesorService.crearProfesor(profesor);
	}
	
	
	//Put
	@PutMapping("/{id}")
	public Profesor updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
		return profesorService.modificarProfesor(id, profesor);
	}
	
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteProfesor(@PathVariable Long id) {
		profesorService.borrarProfesor(id);
	}
}
