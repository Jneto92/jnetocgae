package com.jneto.cgae.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jneto.cgae.entities.Publico;
import com.jneto.cgae.services.PublicoService;

@RestController
@RequestMapping(value = "/publico")
public class PublicoResource {
	@Autowired
	private PublicoService service;
	
	@GetMapping
	public ResponseEntity<List<Publico>> findAll(){
		List<Publico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publico> findById(@PathVariable Long id){
		Publico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
