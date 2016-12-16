package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CATEGORIA")

public class Categoria {
		@Id
		@Column(name="CAT_ID")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long catid;
		
		@Column(name="NOME")
		private String nome;
		
		/*ONE-TO.MANY*/
		@OneToMany(mappedBy="categoria", 
				targetEntity = Comunidade.class, 
				fetch = FetchType.EAGER)
		private Collection<Comunidade> comunidade;

		public Long getCatid() {
			return catid;
		}

		public void setCatid(Long catid) {
			this.catid = catid;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Collection<Comunidade> getComunidade() {
			return comunidade;
		}

		public void setComunidade(Collection<Comunidade> comunidade) {
			this.comunidade = comunidade;
		}

	
		
		
		
}