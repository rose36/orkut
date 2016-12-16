package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="FOTOS")
public class Fotos {
	@Id
	@Column(name="FOT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long fotid;
	


	/*one-to-many*/
	@OneToMany(mappedBy="fotos", 
			   targetEntity=Comentario.class,
			   fetch=FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	@Column(name = "AL_ID", insertable=false, updatable = false, nullable=false)
	private Long alid;
	
	/*many-to-one*/
	@ManyToOne(optional = false)
	@JoinColumn(name = "AL_ID",
				referencedColumnName = "AL_ID")
	private Album album;
	
	
	
	

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getAlid() {
		return alid;
	}

	public void setAlid(Long alid) {
		this.alid = alid;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

//	public Collection<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(Collection<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}

	

	
	public Long getFotid() {
		return fotid;
	}

	public void setFotid(Long fotid) {
		this.fotid = fotid;
	}

	


	
	

}
