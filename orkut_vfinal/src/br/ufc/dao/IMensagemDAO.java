package br.ufc.dao;

import java.util.List;

import br.ufc.model.Mensagem;

public interface IMensagemDAO {
	public Mensagem recuperar(Long id);
	public void inserir(Mensagem mensagem);
	public List<Mensagem> listar();
	public void alterar(Mensagem mensagem);
	public void apagar(Long id);
	

}
