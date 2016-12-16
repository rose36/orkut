package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.FotosDAOHibernate;
import br.ufc.dao.IAlbumDAO;
import br.ufc.dao.UsuarioDAOHibernate;
import br.ufc.model.Album;
import br.ufc.model.Fotos;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class FotosController {

	@Autowired
	private ServletContext context;
	
	@Autowired
	@Qualifier(value="fotosDAOHibernate")
	private FotosDAOHibernate fotosDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private UsuarioDAOHibernate usuarioDAO;
	
	@Autowired
	@Qualifier(value="albumDAOHibernate")
	private IAlbumDAO albumDAO;

		
	@RequestMapping("/inserirFotosFormulario")
	public String inserirFotosFormulario(Model model){
		
		List<Album> album = albumDAO.listar();
		model.addAttribute("album", album);
		return "fotos/inserir_fotos_formulario";
	}
	
	@RequestMapping("/inserirFotos")
	public String inserirFotos(Fotos fotos,
			@RequestParam(value="image",required=false)MultipartFile image){
		if(image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="resources/fotos/"+fotos.getFotid()+".png";
			AulaFileUtil.saveFile(path, image);

		}
		
	
		Album a = albumDAO.recuperar(fotos.getAlid());
		
		fotos.setAlbum(a);	
		fotosDAO.inserir(fotos);	
		
		return "redirect:listarAlbum";

	}
	

	
	@RequestMapping("/listarFotos")
	public String listarFotos(Model model, Long id){
		List<Fotos> fotos = fotosDAO.listarFotos(id);
		model.addAttribute("fotos",fotos);
		return "fotos/listar_fotos";
	}
	
	@RequestMapping("/apagarFotos")
	public String apagarFotos(Long id){
		
		this.fotosDAO.apagar(id);
		return "redirect:listarFotos";
	}
	
	@RequestMapping("/alterarFotosFormulario")
	public String alterarFotosFormulario(Long id, Model model){
		Fotos fotos = this.fotosDAO.recuperar(id);
		model.addAttribute("fotos", fotos);
		return "fotos/alterar_fotos_formulario";
	}
	
	@RequestMapping("/alterarFotos")
	public String alterarFotos(Fotos fotos, Long album){
		
		Album a = albumDAO.recuperar(album);
		fotos.setAlbum(a);
		
		this.fotosDAO.alterar(fotos);
		return "redirect:listarFotos";
	}

}
