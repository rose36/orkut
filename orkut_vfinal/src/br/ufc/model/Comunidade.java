package br.ufc.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity(name="COMUNIDADE")

public class Comunidade {
		@Id
		@Column(name="COM_ID")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long comid;
		
		@Column(name="NOME")
		private String nome;
			
			
		/*MANY-TO-MANY:*/
		@ManyToMany
		@JoinTable(name = "USUARIO_COMUNIDADES",
					joinColumns = @JoinColumn(name = "COM_ID", referencedColumnName = "COM_ID"),
					inverseJoinColumns = @JoinColumn (name = "USU_ID", referencedColumnName = "USU_ID" )
			
				)
		private List<Usuario> usuarios;
		
		
		
		
		 
		@Column(name = "CAT_ID", insertable=false, updatable = false, nullable=false)
		private Long catid;
		
		/*many-to-one*/
		@ManyToOne(optional = false)
		@JoinColumn(name = "CAT_ID",
					referencedColumnName = "CAT_ID")
		private Categoria categoria;
		
		
		
		

		

	

		public Long getCatid() {
			return catid;
		}

		public void setCatid(Long catid) {
			this.catid = catid;
		}

		public Long getComid() {
			return comid;
		}

		public void setComid(Long comid) {
			this.comid = comid;
		}

		public String getNome() {
			return nome;
		}

		

		

		

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}

	

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		


		

}