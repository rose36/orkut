package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;


@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;
	
	
	@Autowired
	@Qualifier(value="amizadeDAOHibernate")
	private IAmizadeDAO amizadeDAO;
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "usuarios/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario, 
								 @RequestParam(value="image",required=false)MultipartFile image){

		if(image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="resources/usuario/"+usuario.getLogin()+".png";
			AulaFileUtil.saveFile(path, image);
			
		}
		usuario.setSenha(DigestUtils.md5Hex(usuario.getSenha()));	
		usuarioDAO.inserir(usuario);
		return "usuarios/inserir_ok";
		
	}

	//listar
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = usuarioDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listar_usuario";
	}
	


	//apagar
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		usuarioDAO.apagar(id);
		return "redirect:logout";
		
	}
	
	//alterar
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		Usuario u = usuarioDAO.recuperar(id);
		model.addAttribute("usuario",u);
		return "usuarios/alterar_usuario_formulario";
		
	}
	
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario u,
			 @RequestParam(value="image",required=false)MultipartFile image){

		if(image!=null && !image.isEmpty()){
			String path = context.getRealPath("/");
			path+="resources/usuario/"+u.getLogin()+".png";
			AulaFileUtil.saveFile(path, image);
			
		}
		
		u.setSenha(DigestUtils.md5Hex(u.getSenha()));			
		usuarioDAO.atualizar(u);
		return "usuarios/alterar_usuario_formulario";
		
	}
	
	
	@RequestMapping("/inserirAmizadeFormulario")
	public String inserirAmizadeFormulario(HttpSession session, Model model){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);
		
	
		
		AmizadeCheckboxForm acf = new AmizadeCheckboxForm();
		List<Amizade> minhasAmizades = this.amizadeDAO.listarAmizadesDeId(usuario.getUsuid());
		
		if(minhasAmizades!=null && minhasAmizades.size()>0){

			for(Amizade amizade:minhasAmizades){
				Long amigoId = amizade.getUsuarioAlvo().getUsuid();
				Usuario amigoTemp = new Usuario();
				amigoTemp.setUsuid(amigoId);
				potenciaisAmigos.remove(amigoTemp);
				

			}
			
		}
		
		model.addAttribute("amizade",acf);
		model.addAttribute("usuario",usuario);
		model.addAttribute("potenciais_amigos", potenciaisAmigos);
	
		return "usuarios/inserir_amizade_formulario";
	}
	
	@RequestMapping("/inserirAmizade")
	public String inserirAmizade(HttpSession session, AmizadeCheckboxForm amizades){
		
		Usuario amigoFonte = (Usuario) session.getAttribute("usuario_logado");
		
		for(Long usuid:amizades.getAmigos()){
			Usuario amigoAlvo = usuarioDAO.recuperar(usuid);
			Amizade amizade = new Amizade();
			amizade.setUsuarioFonte(amigoFonte);
			amizade.setUsuarioAlvo(amigoAlvo);
			amizadeDAO.inserir(amizade);
		                                
		}
		
		return "redirect:listarAmizade";
	}
	
	@RequestMapping("/listarAmizade")
	public String listarAmizade(HttpSession session, Model model){
		Usuario u = (Usuario) session.getAttribute("usuario_logado");

		List<Amizade> amigos = this.amizadeDAO.listarAmizadesDeId(u.getUsuid());
		// Array para armazenar todos os amigos do usuario atual
		List<Usuario> usuarios = new ArrayList<Usuario>(); 

		for(Amizade a: amigos){
			Long amigoId = a.getUsuarioAlvo().getUsuid();			
			Usuario usuario = usuarioDAO.recuperar(amigoId);
			usuarios.add(usuario);			
		}

		//		model.addAttribute("amizades",amigos);
		model.addAttribute("amizades",usuarios);
		return "amizades/listar_amigos";
	}
	
	@RequestMapping("/dadosUsuario")
	public String configuracoes(){
		return "usuarios/dados_usuario";
	}
	
	@RequestMapping("/visitarPerfil")
	public String visitarPerfil(Model model , Long id){		
		Usuario u = usuarioDAO.recuperar(id);
		model.addAttribute("perfil",u);
		return "usuarios/perfil";
	}
		
	
}
