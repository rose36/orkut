package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Categoria;


	@Repository
	public class CategoriaDAOHibernate implements ICategoriaDAO{

		@PersistenceContext
			private EntityManager manager;

		@Override
		public Categoria recuperar(Long catid) {
			return manager.find(Categoria.class, catid);
		
		}

		public Categoria recuperar(Categoria categoria) {
			return manager.find(Categoria.class, categoria);
		
		}
		@Override
		public Categoria recuperar(String nome) {
			String hql = "select u from CATEGORIA as u "
					+ "where u.categoria =:var_categoria";
			Query query = manager.createQuery(hql, Categoria.class);
			query.setParameter("var_categoria", nome);
			List<Categoria> categorias = query.getResultList();

			if (categorias != null && !categorias.isEmpty()) {
				return categorias.get(0);
			}

			return null;			
			}

		@Override
		public List<Categoria> listar() {
			String hql = "select c from CATEGORIA as c";

			return manager.createQuery(hql, Categoria.class).getResultList();
			
		}
			
		
			
		
	
		
	
	}


