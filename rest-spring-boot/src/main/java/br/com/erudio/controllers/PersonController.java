package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOVersion2;
import br.com.erudio.services.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	@GetMapping
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO personVO) {
		return services.create(personVO);
	}
	
	@PostMapping("/v2")
	public PersonVOVersion2 createVersion2(@RequestBody PersonVOVersion2 personVOVersion2) {
		return services.createVersion2(personVOVersion2);
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO personVO) {
		return services.update(personVO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
