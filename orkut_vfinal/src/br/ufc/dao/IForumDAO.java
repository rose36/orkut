package br.ufc.dao;

import java.util.List;

import br.ufc.model.Forum;
import br.ufc.model.Mensagem;

public interface IForumDAO {
	public void inserir(Forum forum);
	public void alterar(Forum forum);
	public Forum recuperar(Long id);
	public void apagar(Long id);
	public List<Forum> listar();
	public void inserirMensagem(Mensagem mensagem);
	public List<Mensagem> listarMensagensId(Long id);
	public List<Mensagem> listarMensagens();

}
