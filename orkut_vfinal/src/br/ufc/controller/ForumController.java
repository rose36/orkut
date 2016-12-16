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

import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IForumDAO;
import br.ufc.dao.UsuarioDAOHibernate;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;


@Controller
@Transactional
public class ForumController {
	
	@Autowired
	@Qualifier(value="forumDAOHibernate")
	private IForumDAO forumDAO;
	
	@Autowired
	@Qualifier(value="comunidadeDAOHibernate")
	private IComunidadeDAO comunidadeDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private UsuarioDAOHibernate usuarioDAO;

	@Autowired
	private ServletContext context;


		@RequestMapping("/inserirForumFormulario")
		public String inserirForumFormulario(Long id, HttpSession session){	
			Comunidade c = comunidadeDAO.recuperar(id);
			session.setAttribute("comunidade",c);
			return "forum/inserir_forum_formulario"; 

		}
		@RequestMapping("/inserirForum")
		public String inserirForum(Forum forum, HttpSession session){
			Comunidade c = (Comunidade) session.getAttribute("comunidade");		
			forum.setComunidade(c);
			comunidadeDAO.inserirForum(forum);
			return "comunidades/participar_comunidade_ok";
		}

			
		@RequestMapping("/listarForum")
		public String listarForum(Model model, Long id){
			List<Forum> foruns = comunidadeDAO.listarForuns(id);
			model.addAttribute("foruns",foruns);
			return "forum/listar_forum";
		}
	

	
	//alterar
	@RequestMapping("/alterarForumFormulario")
	public String alterarForumFormulario(Long forid, Model model){
		
		Forum f = forumDAO.recuperar(forid);
		model.addAttribute("forum",f);
		List<Comunidade> comunidade = comunidadeDAO.listar();
		model.addAttribute("comunidade", comunidade);
	
		return "forum/alterar_forum_formulario";
	
		
	}
	
	@RequestMapping("/alterarForum")
	public String alterarForum(Forum f){
		forumDAO.alterar(f);
		return "redirect:listarForum";
	}

			
}