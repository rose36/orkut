package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAOHibernate implements IUsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Usuario usuario) {
		
		manager.persist(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		
		manager.merge(usuario);

	}

	@Override
	public Usuario recuperar(Long usuId) {
		return manager.find(Usuario.class, usuId);

	}

	@Override
	public Usuario recuperar(String login) {
		String hql = "select u from USUARIO as u "
				+ "where u.login =:var_login";
		Query query = manager.createQuery(hql, Usuario.class);
		query.setParameter("var_login", login);
		List<Usuario> usuarios = query.getResultList();

		if (usuarios != null && !usuarios.isEmpty()) {
			return usuarios.get(0);
		}

		return null;
	}

	@Override
	public List<Usuario> listar() {
		String hql = "select u from USUARIO as u";

		return manager.createQuery(hql, Usuario.class).getResultList();

	}

	public List<Usuario> listarComunidade() {
		String hql = "select c from USUARIO_COMUNIDADES as c";

		return manager.createQuery(hql, Usuario.class).getResultList();

	}

	@Override
	public void apagar(Long id) {
		Usuario u = this.recuperar(id);
		manager.remove(u);

	}
}
