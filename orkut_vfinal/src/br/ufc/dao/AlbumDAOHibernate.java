package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Album;



@Repository
public class AlbumDAOHibernate implements IAlbumDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Album album) {
	
		manager.persist(album);
		
	}

	@Override
	public void alterar(Album album) {
		manager.merge(album);
		
	}

	@Override
	public Album recuperar(Long alid) {
		return manager.find(Album.class, alid);
	}

	@Override
	public void apagar(Long id) {
	Album ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}	
	}

	@Override
	public List<Album> listar() {
		String hql = "select a from ALBUM as a";
		
		return manager.createQuery(hql,Album.class).getResultList();
	}
	
	@Override
	public List<Album> albunsAmigos(Long id) {
		String hql = "select a from ALBUM as a where usuid = :var";
		
		Query query = manager.createQuery(hql);
		query.setParameter("var", id);
		return query.getResultList();
	}
	

	
	@Override
	public List<Album> meusAlbuns(Long id) {
		String hql = "select a from ALBUM as a where usuid = :var";
		Query query = manager.createQuery(hql);
		query.setParameter("var", id);
		return query.getResultList();
		
	}


}
