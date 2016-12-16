package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comunidade;
import br.ufc.model.Forum;


public interface IComunidadeDAO {
	public void inserir(Comunidade comunidade);
	public void atualizar(Comunidade comunidade);
	public Comunidade recuperar(Long comid);
	public Comunidade recuperarCategoria(Long catid);

	public Comunidade recuperar(String nome);
	public List<Comunidade> listar();
	public void apagar(Long comid);
	public List<Comunidade> listarComunidade();
	public void inserirForum(Forum forum);
	public List<Forum> listarForuns(Long id);
	public List<Comunidade> listarParticipantes(Long id);
	
}