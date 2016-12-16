package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAOHibernate implements IComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Comentario comentario) {
		manager.persist(comentario);
	}

	@Override
	public void alterar(Comentario comentario) {
		manager.merge(comentario);
		
	}

	@Override
	public Comentario recuperar(Long id) {
		return manager.find(Comentario.class, id);
	}

	@Override
	public void apagar(Long id) {
	Comentario ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
		
	}

	@Override
	public List<Comentario> listar() {
		return manager.createQuery("select cm from COMENTARIO as cm", Comentario.class).getResultList();
	}

}
