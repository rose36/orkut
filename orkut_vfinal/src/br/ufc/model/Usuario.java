package br.ufc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="USU_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usuid;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="IDADE")
	private Long idade;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="SENHA")
	private String senha;
	

	@OneToMany(mappedBy="usuarioFonte")
	private List<Amizade> amizades = new ArrayList<Amizade>();
	
	@ManyToMany(mappedBy="usuarios", fetch=FetchType.LAZY)
	private List<Comunidade> comunidade;
	
	@OneToMany(mappedBy="usuario", 
			   targetEntity=Album.class,
			   fetch=FetchType.EAGER)
	private Collection<Album> album;
	

	
	public Collection<Album> getAlbum() {
		return album;
	}

	public void setAlbum(Collection<Album> album) {
		this.album = album;
	}

	public Long getUsuid() {
		return usuid;
	}

	public void setUsuid(Long usuid) {
		this.usuid = usuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Comunidade> getComunidade() {
		return comunidade;
	}

	public void setComunidade(List<Comunidade> comunidade) {
		this.comunidade = comunidade;
	}

	
	public List<Amizade> getAmizades() {
		return amizades;
	}

	public void setAmizades(List<Amizade> amizades) {
		this.amizades = amizades;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuid == null) ? 0 : usuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuid == null) {
			if (other.usuid != null)
				return false;
		} else if (!usuid.equals(other.usuid))
			return false;
		return true;
	}

	
	
	

}
