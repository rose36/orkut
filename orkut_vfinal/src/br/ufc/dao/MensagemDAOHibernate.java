package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import br.ufc.model.Mensagem;
@Repository
public class MensagemDAOHibernate implements IMensagemDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Mensagem recuperar(Long id) {
		
		return manager.find(Mensagem.class, id);
	}
	
	@Override
	public void inserir(Mensagem mensagem) {
		manager.persist(mensagem);
	}
	
	@Override
	public void apagar(Long id) {
	Mensagem ref = this.recuperar(id);
		
		if(ref!=null){
			manager.remove(ref);
		}		
		
	}

	@Override
	public void alterar(Mensagem mensagem) {
		manager.merge(mensagem);
		
	}
	@Override
	public List<Mensagem> listar() {
		return manager.createQuery("select m from MENSAGEM as m", Mensagem.class).getResultList();
	}


	

}