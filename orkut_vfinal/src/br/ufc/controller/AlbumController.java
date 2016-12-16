package br.ufc.controller;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import br.ufc.dao.IAlbumDAO;
import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Album;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;


@Controller
@Transactional
public class AlbumController {

	@Autowired
	private ServletContext context;
	
	@Autowired
	@Qualifier(value="albumDAOHibernate")
	private IAlbumDAO albumDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier(value="amizadeDAOHibernate")
	private IAmizadeDAO amizadeDAO;
	
	
	
	
	@RequestMapping("/inserirAlbumFormulario")
	//links
	public String inserirAlbumFormulario(Model model){
		return "albuns/inserir_albuns_formulario";
	}
	
	@RequestMapping("/inserirAlbum")
	public String inserirComunidade(HttpSession session, Album album,
			@RequestParam(value="image",required=false)MultipartFile image){
		
		if(image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="resources/album/"+album.getNome()+".png";
			AulaFileUtil.saveFile(path, image);

		}
		
		Usuario u = (Usuario)session.getAttribute("usuario_logado");
		album.setUsuario(u);
		albumDAO.inserir(album);
		
		return "redirect:listarAlbum";
	}
	
	
	
	@RequestMapping("/listarAlbum")
	public String listarAlbum(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		List<Album> album = albumDAO.meusAlbuns(u.getUsuid());
		model.addAttribute("album", album);
		return "albuns/meus_albuns";
	}
	
	
	
	@RequestMapping("/listarAlbunsAmigos")
	public String listarAlbunsAmigos(Long id, Model model){
	
		List<Album> album = albumDAO.albunsAmigos(id);
		model.addAttribute("album",album);
		return "albuns/listar_albuns";
	}
	
	@RequestMapping("/alterarAlbum")
	public String alterarAlbum(Album a, Model model,
		@RequestParam(value="image",required=false)MultipartFile image){

			if(image!=null && !image.isEmpty()){
				String path = context.getRealPath("/");
				path+="resources/album/"+a.getNome()+".png";
				AulaFileUtil.saveFile(path, image);

			}
			
			albumDAO.alterar(a);
			return "redirect:listarAlbum";

	}
	


}
