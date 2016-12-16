package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import br.ufc.model.Comunidade;
import br.ufc.model.Forum;


@Repository
public class ComunidadeDAOHibernate implements IComunidadeDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Comunidade comunidade) {
		
		manager.persist(comunidade);
	}
	
	@Override
	public void inserirForum(Forum forum) {
		
		manager.persist(forum);
	}
	
	@Override
	public List<Forum> listarForuns(Long id){


		String hql = "select a from FORUM as a where comid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();
	}
	
	@Override
	public List<Comunidade> listarParticipantes(Long id){


		String hql = "select a from COMUNIDADE as a"
				+ " where comid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();
	}

	@Override
	public void atualizar(Comunidade comunidade) {
		
		manager.merge(comunidade);

	}

	@Override
	public Comunidade recuperar(Long comid) {
		return manager.find(Comunidade.class, comid);

	}
	
	public Comunidade recuperarCategoria(Long catid) {
		return manager.find(Comunidade.class, catid);

	}
	
	public List<Comunidade> listarComunidade() {
		String hql = "select co from USUARIO_COMUNIDADES as co";

		return manager.createQuery(hql, Comunidade.class).getResultList();

	}
	


	@Override
	public Comunidade recuperar(String nome) {
		String hql = "select c from COMUNIDADE as c "
				+ "where c.nome =:var_nome";
		Query query = manager.createQuery(hql, Comunidade.class);
		query.setParameter("var_nome", nome);
		List<Comunidade> comunidade = query.getResultList();

		if (comunidade != null && !comunidade.isEmpty()) {
			return comunidade.get(0);
		}

		return null;
	}

	
	@Override
	public List<Comunidade> listar() {
		String hql = "select c from COMUNIDADE as c";

		return manager.createQuery(hql, Comunidade.class).getResultList();
	}

	@Override
	public void apagar(Long comid) {
		Comunidade c = this.recuperar(comid);
		
		manager.remove(c);

	}
	
	

}
