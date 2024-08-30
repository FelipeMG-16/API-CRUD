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

import com.school.management.api_crud.entity.Materia;
import com.school.management.api_crud.service.MateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaController {
	
	//Instancia de MateriaService
	private final MateriaService materiaService;

	
	//Inyeccion de instancia MateriaService en constructor
	@Autowired
	public MateriaController(MateriaService materiaService) {
		this.materiaService = materiaService;
	}
	
	//Get
	@GetMapping
	public List<Materia> getAllMaterias(){
		return materiaService.obtenerMaterias();
	}
	
	
	//Get
	@GetMapping("/{id}")
	public Materia getMateriaById(@PathVariable Long id) {
		return materiaService.obtenerMateriaPorId(id);
	}
	
	
	//Post
	@PostMapping
	public Materia createMateria(@RequestBody Materia materia) {
		return materiaService.crearMateria(materia);
	}
	
	
	//Put
	@PutMapping("/{id}")
	public Materia updateMateria(@PathVariable Long id, @RequestBody Materia materia) {
		return materiaService.modificarMateria(id, materia);
	}
	
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteMateria(@PathVariable Long id) {
		materiaService.borrarMateria(id);
	}
}
