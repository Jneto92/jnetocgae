package com.jneto.cgae.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jneto.cgae.entities.Publico;

@RestController
@RequestMapping(value = "/publico")
public class PublicoResource {
	
	@GetMapping
	public ResponseEntity<Publico> findAll(){
		Publico p = new Publico(1L, "Neto", "neto@gmail.com", "999999");
		return ResponseEntity.ok().body(p);
	}
}
