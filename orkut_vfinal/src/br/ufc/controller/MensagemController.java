package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IForumDAO;
import br.ufc.dao.IMensagemDAO;
import br.ufc.dao.UsuarioDAOHibernate;
import br.ufc.model.Forum;
import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;
@Controller
@Transactional
public class MensagemController {
	
	@Autowired
	@Qualifier(value="mensagemDAOHibernate")
	private IMensagemDAO mensagemDAO;
	
	@Autowired
	@Qualifier(value="forumDAOHibernate")
	private IForumDAO forumDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private UsuarioDAOHibernate usuarioDAO;
	
	@Autowired
	private ServletContext context;
	

		
		@RequestMapping("/inserirMensagemFormulario")
		public String inserirMensagemFormulario(Long id, Model model){
			Forum f = forumDAO.recuperar(id);
			model.addAttribute("forum_id", f);
			
			model.addAttribute("mensagens", f.getMensagens());

			return "mensagens/inserir_mensagem_formulario";
		}
		
		
	
		
		@RequestMapping("/inserirMensagem")
		public String inserirMensagem(Long usuario_id, Long forum_id, @Valid Mensagem mensagem,
				   BindingResult result){		
			if(result.hasFieldErrors("mensagem")){
				return "mensagens/inserir_mensagem_formulario";
			}
			
			Forum forum = forumDAO.recuperar(forum_id);
			mensagem.setForum(forum);
			
			Usuario usuario = usuarioDAO.recuperar(usuario_id);
			mensagem.setAutorMensagem(usuario);
		
			
			this.mensagemDAO.inserir(mensagem);
			
			return "redirect:listarMensagem";
		}

		@RequestMapping("/listarMensagem")
		public String listarMensagem(Model model){
					
			List<Mensagem> mensagens = this.mensagemDAO.listar();
			model.addAttribute("mensagens", mensagens);
					
			return "mensagens/listar_mensagens";
		}	
		
		@RequestMapping("/apagarMensagem")
		public String apagarMensagem(Long id){
			
			this.mensagemDAO.apagar(id);
			return "redirect:listarMensagem";
		}
	
	
		
		@RequestMapping("/alterarMensagemFormulario")
		public String alterarMensagemFormulario(HttpSession session, Long id, Model model, Forum forum){
			
			Usuario u = (Usuario)session.getAttribute("usuario_logado");
			Mensagem mensagem = this.mensagemDAO.recuperar(id);
			mensagem.setAutorMensagem(u);
			mensagem.setForum(forum);
			model.addAttribute("mensagem", mensagem);
			return "mensagem/alterar_mensagem_formulario";
		}
		
		@RequestMapping("/alterarMensagem")
		public String alterarMensagem(Mensagem mensagem){
			
			this.mensagemDAO.alterar(mensagem);
			return "redirect:listarMensagem";
		}	
		
		
}
