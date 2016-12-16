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

@Entity(name="ALBUM")
public class Album {
	
	@Id
	@Column(name="AL_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long alid;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	

	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuid;
	
	/*many-to-one*/
	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID",
				referencedColumnName = "USU_ID")
	private Usuario usuario;
	
	/*one-to-many*/
	@OneToMany(mappedBy="album", 
			targetEntity = Fotos.class, 
			fetch = FetchType.EAGER)
	private Collection<Fotos> fotos;



	public Long getUsuid() {
		return usuid;
	}

	public void setUsuid(Long usuid) {
		this.usuid = usuid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getAlid() {
		return alid;
	}

	public void setAlid(Long alid) {
		this.alid = alid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(Collection<Fotos> fotos) {
		this.fotos = fotos;
	}
	
	
	

}
