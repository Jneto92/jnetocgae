package com.jneto.cgae.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jneto.cgae.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}
