package com.jneto.cgae.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jneto.cgae.entities.Atendimento;
import com.jneto.cgae.entities.Categoria;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
	@Query("select u from Atendimento u where u.categoria = ?1")
	List <Atendimento> findByCategoria(Categoria cat);
}


