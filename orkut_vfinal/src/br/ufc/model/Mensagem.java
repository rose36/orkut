package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="MENSAGEM")
public class Mensagem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEN_ID",nullable=false)
	private Long menid;

	@Column(name="TEXTO")
	private String texto;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FOR_ID",
				referencedColumnName="FOR_ID", unique=false)
	private Forum forum;
	
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="USU_ID",
				referencedColumnName="USU_ID", unique=false)	
	private Usuario autorMensagem;
	
	
	

	

	public Usuario getAutorMensagem() {
		return autorMensagem;
	}

	public void setAutorMensagem(Usuario autorMensagem) {
		this.autorMensagem = autorMensagem;
	}

	public String getTexto() {
		return texto;
	}

	public Long getMenid() {
		return menid;
	}

	public void setMenid(Long menid) {
		this.menid = menid;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}



}