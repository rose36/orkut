package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="AMIZADE")
public class Amizade {

	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USU_ID")
	private Usuario usuarioFonte;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="AMIGO_ID")
	private Usuario usuarioAlvo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuarioFonte() {
		return usuarioFonte;
	}

	public void setUsuarioFonte(Usuario usuarioFonte) {
		this.usuarioFonte = usuarioFonte;
	}

	public Usuario getUsuarioAlvo() {
		return usuarioAlvo;
	}

	public void setUsuarioAlvo(Usuario usuarioAlvo) {
		this.usuarioAlvo = usuarioAlvo;
	}
	
	
}
