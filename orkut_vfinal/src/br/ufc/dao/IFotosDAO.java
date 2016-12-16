package br.ufc.dao;

import java.util.List;

import br.ufc.model.Fotos;



public interface IFotosDAO {
	public void inserir(Fotos fotos);
	public void alterar(Fotos fotos);
	public Fotos recuperar(Long id);
	public void apagar(Long id);
	public List<Fotos> listar();
	public Fotos recuperar(String login);
	public List<Fotos> listarFotos(Long id);

}
