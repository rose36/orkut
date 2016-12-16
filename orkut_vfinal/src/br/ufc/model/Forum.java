package br.ufc.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="FORUM")
public class Forum {
	@Id
	@Column(name="FOR_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long forid;
	
	@Column(name="COM_ID", insertable=false, updatable=false, nullable=false)
	private Long comid;
	
	@Column(name="TITULO")
	private String titulo;
	

	
	@ManyToOne(optional=false)
	@JoinColumn(name="COM_ID", 
				referencedColumnName="COM_ID")
	private Comunidade comunidade;

	
	@OneToMany(mappedBy="forum",targetEntity=Mensagem.class,fetch=FetchType.EAGER)
	private List<Mensagem> mensagens = new ArrayList<Mensagem>();
	
	
	

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Long getForid() {
		return forid;
	}

	public void setForid(Long forid) {
		this.forid = forid;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
	
	
	

}
