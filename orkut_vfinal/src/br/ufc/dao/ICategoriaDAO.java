package br.ufc.dao;

import java.util.List;

import br.ufc.model.Categoria;

public interface ICategoriaDAO {
	public Categoria recuperar(Categoria categoria);

	public Categoria recuperar(Long catid);
	public Categoria recuperar(String nome);
	public List<Categoria> listar();
}