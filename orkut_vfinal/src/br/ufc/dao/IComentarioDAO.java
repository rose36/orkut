package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO {
	public void inserir(Comentario comentario);
	public void alterar(Comentario comentario);
	public Comentario recuperar(Long id);
	public void apagar(Long id);
	public List<Comentario> listar();

}
