package com.jneto.cgae.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jneto.cgae.entities.enums.AtendimentoStatus;

@Entity
public class Atendimento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd 'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant momentSolicitacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd 'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant momentAtendimento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd 'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant momentEncerramento;
	
	private Integer atendimentoStatus;
	
	@ManyToOne
	@JoinColumn(name = "publico_id")
	private Publico solicitante;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Funcionario atendente;
	
	public Atendimento() {
		
	}
	
	public Atendimento(Long id, Instant moment, AtendimentoStatus atendimentoStatus, Publico solicitante, Categoria categoria) {
		super();
		this.id = id;
		this.momentSolicitacao = moment;
		setAtendimentoStatus(atendimentoStatus);
		this.solicitante = solicitante;
		this.categoria = categoria;
	}

	public Atendimento(Long id, Instant moment, AtendimentoStatus atendimentoStatus, Funcionario atendente) {
		super();
		this.id = id;
		this.momentAtendimento = moment;
		setAtendimentoStatus(atendimentoStatus);
		this.atendente = atendente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Publico getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Publico solicitante) {
		this.solicitante = solicitante;
	}
	
	public AtendimentoStatus getAtendimentoStatus() {
		return AtendimentoStatus.valueOf(atendimentoStatus);
	}

	public void setAtendimentoStatus(AtendimentoStatus atendimentoStatus) {
		if(atendimentoStatus != null) {
			this.atendimentoStatus = atendimentoStatus.getCode();
		}
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}

	public Instant getMomentSolicitacao() {
		return momentSolicitacao;
	}

	public void setMomentSolicitacao(Instant momentSolicitacao) {
		this.momentSolicitacao = momentSolicitacao;
	}

	public Instant getMomentAtendimento() {
		return momentAtendimento;
	}

	public void setMomentAtendimento(Instant momentAtendimento) {
		this.momentAtendimento = momentAtendimento;
	}

	public Instant getMomentEncerramento() {
		return momentEncerramento;
	}

	public void setMomentEncerramento(Instant momentEncerramento) {
		this.momentEncerramento = momentEncerramento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
