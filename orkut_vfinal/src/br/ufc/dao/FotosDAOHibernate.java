package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Fotos;

@Repository
public class FotosDAOHibernate implements IFotosDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Fotos fotos) {
		manager.persist(fotos);	
		
	}

	@Override
	public void alterar(Fotos fotos) {
		manager.merge(fotos);
		
	}

	@Override
	public Fotos recuperar(Long id) {
		return manager.find(Fotos.class, id);
	}

	@Override
	public void apagar(Long id) {
		Fotos ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
		
	}

	
	@Override
	public List<Fotos> listarFotos(Long id) {
		String hql = "select a from FOTOS as a where alid = :var";
		Query query = manager.createQuery(hql);
		query.setParameter("var", id);
		return query.getResultList();
	}
	
	@Override
	public List<Fotos> listar() {
		return manager.createQuery("select f from FOTOS as f",
				Fotos.class).getResultList();
	}
	
	

	@Override
	public Fotos recuperar(String login) {
		String hql = "select c from classificado as c "
				+"where c.login = :param_login";
	
	Query query = manager.createQuery(hql);
		List<Fotos> fotos = 
				query.setParameter("param_login", login).getResultList();
		
		if(fotos.size()!=0){
			return fotos.get(0);
		}
		
		return null;
}
	

}
