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
import br.ufc.dao.ICategoriaDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Controller
@Transactional
public class ComunidadeController {

	@Autowired
	@Qualifier(value="comunidadeDAOHibernate")
	private IComunidadeDAO comunidadeDAO;

	
	@Autowired
	@Qualifier(value="categoriaDAOHibernate")
	private ICategoriaDAO categoriaDAO;

	@Autowired
	private ServletContext context;

	@RequestMapping("/inserirComunidadeFormulario")
	//links
	public String inserirComunidadeFormulario(Model model){
		List<Categoria> categoria = categoriaDAO.listar();
		model.addAttribute("categoria", categoria);
		
		return "comunidades/inserir_comunidade_formulario";
	}
	@RequestMapping("/inserirComunidade")
	public String inserirComunidade(HttpSession session, Comunidade comunidade,
			@RequestParam(value="image",required=false)MultipartFile image){

		if(image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="resources/comunidade/"+comunidade.getNome()+".png";
			AulaFileUtil.saveFile(path, image);

		}
		Categoria c = categoriaDAO.recuperar(comunidade.getCatid());
		comunidade.setCategoria(c);	
		comunidadeDAO.inserir(comunidade);
		
		return "comunidades/participar_comunidade_ok";

	}

	@RequestMapping("/listarComunidade")
	public String listarComunidade(Model model){
		List<Comunidade> comunidades = comunidadeDAO.listar();
		model.addAttribute("comunidades", comunidades);
		return "comunidades/listar_comunidade";
	}
	
	
	
	
	@RequestMapping("/apagarComunidade")
	public String apagarComunidade(Long comid){
		comunidadeDAO.apagar(comid);
		return "redirect:listarComunidade";

	}
	@RequestMapping("/alterarComunidadeFormulario")
	public String alterarComunidadeFormulario(Long comid, Model model){
		
		Comunidade co = comunidadeDAO.recuperar(comid);
		model.addAttribute("comunidade",co);
		List<Categoria> categoria = categoriaDAO.listar();
		model.addAttribute("categoria", categoria);
	
		return "comunidades/alterar_comunidade_formulario";
		
		
	


	}

	@RequestMapping("/alterarComunidade")
	public String alterarComunidade(Comunidade c, Model model,
		@RequestParam(value="image",required=false)MultipartFile image){

			if(image!=null && !image.isEmpty()){
				String path = context.getRealPath("/");
				path+="resources/comunidade/"+c.getNome()+".png";
				AulaFileUtil.saveFile(path, image);

			}
			
			comunidadeDAO.atualizar(c);
			return "redirect:listarComunidade";

	}
	
	@RequestMapping("/participarComunidadeListar")
	public String participarComunidadeListar(Model model){
		
		List<Comunidade> comunidades = comunidadeDAO.listar();
		model.addAttribute("comunidades", comunidades);
		


		return "comunidades/listar_comunidade";
		
	}
		
	@RequestMapping("/participarComunidade")
	public String participarComunidade(HttpSession session, Comunidade comunidade){

		
		Usuario u = (Usuario)session.getAttribute("usuario_logado");
		
		Comunidade tempComunidade = comunidadeDAO.recuperar(comunidade.getComid());
		

		tempComunidade.getUsuarios().add(u);
		comunidadeDAO.atualizar(tempComunidade);
		return "comunidades/participar_comunidade_ok";
		
	}
	
	
	

	
	
	

}
