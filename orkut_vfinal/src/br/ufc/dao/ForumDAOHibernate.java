package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Forum;
import br.ufc.model.Mensagem;

@Repository
public class ForumDAOHibernate implements IForumDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Forum forum) {
		manager.persist(forum);
		
	}

	@Override
	public void alterar(Forum forum) {
		manager.merge(forum);
		
	}

	@Override
	public Forum recuperar(Long id) {
		return manager.find(Forum.class, id);
	}
	
	

	@Override
	public void apagar(Long id) {
		Forum f = this.recuperar(id);
		manager.remove(f);
		
	}

	@Override
	public List<Forum> listar() {
		String hql = "select f from FORUM as f";
		
		return manager.createQuery(hql,Forum.class).getResultList();
	}
	
	@Override
	public void inserirMensagem(Mensagem mensagem) {
		
		manager.persist(mensagem);
	}


	@Override
	public List<Mensagem> listarMensagensId(Long id) {
	
		String hql = "select a from MENSAGEM as a where forid = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);

		return query.getResultList();
	}


	@Override
	public List<Mensagem> listarMensagens() {
		String hql = "select a from MENSAGEM as a";
		return manager.createQuery(hql,Mensagem.class).getResultList();
		
	}

}
