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
	private Instant moment;
	
	private Integer atendimentoStatus;
	
	@ManyToOne
	@JoinColumn(name = "publico_id")
	private Publico solicitante;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	public Atendimento() {
		
	}
	
	public Atendimento(Long id, Instant moment, AtendimentoStatus atendimentoStatus, Publico solicitante, Categoria categoria) {
		super();
		this.id = id;
		this.moment = moment;
		setAtendimentoStatus(atendimentoStatus);
		this.solicitante = solicitante;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
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

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", moment=" + moment + ", solicitante=" + solicitante + "]";
	} 
	
	
}
