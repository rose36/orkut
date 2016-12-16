package br.ufc.dao;

import java.util.List;

import br.ufc.model.Album;


public interface IAlbumDAO {

	public void inserir(Album album);
	public void alterar(Album album);
	public Album recuperar(Long id);
	public void apagar(Long id);
	public List<Album> listar();
	public List<Album> meusAlbuns(Long id);
	public List<Album> albunsAmigos(Long id);
	

}
