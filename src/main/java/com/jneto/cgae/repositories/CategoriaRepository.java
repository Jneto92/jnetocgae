package com.jneto.cgae.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jneto.cgae.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
