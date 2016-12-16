package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMENTARIO")
public class Comentario {
	@Id
	@Column(name="COM_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comid;

	@Column(name="FOT_ID", insertable=false, updatable=false, nullable=false)
	private Long fotid;
	
	@Column(name="TEXTO")
	private String texto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FOT_ID",
				referencedColumnName="FOT_ID", unique=false)
	private Fotos fotos;

	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="USU_ID",
				referencedColumnName="USU_ID", unique=false)	
	private Usuario autorComentario;
	
	
	

	public Usuario getAutorComentario() {
		return autorComentario;
	}

	public void setAutorComentario(Usuario autorComentario) {
		this.autorComentario = autorComentario;
	}

	

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getFotid() {
		return fotid;
	}

	public void setFotid(Long fotid) {
		this.fotid = fotid;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Fotos getFotos() {
		return fotos;
	}

	public void setFotos(Fotos fotos) {
		this.fotos = fotos;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Comentario)){
			return false;
		}
		Comentario ref = (Comentario)obj; 
		if(ref.getComid()==this.comid)
			return true;
		return false;
	}	
}
