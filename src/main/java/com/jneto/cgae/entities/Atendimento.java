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

@Entity
public class Atendimento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	@ManyToOne
	@JoinColumn(name = "publico_id")
	private Publico solicitante;
	
	public Atendimento() {
		
	}
	
	public Atendimento(Long id, Instant moment, Publico solicitante) {
		super();
		this.id = id;
		this.moment = moment;
		this.solicitante = solicitante;
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
