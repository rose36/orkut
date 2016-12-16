package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value = "usuarioDAOHibernate")
	private IUsuarioDAO usuarioDAO;

	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";

	}
	//não alterar
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){

		Usuario u = usuarioDAO.recuperar(usuario.getLogin());

		if(u!=null){
			String teste1 = u.getSenha();
			String teste2= DigestUtils.md5Hex(usuario.getSenha());
			if(teste1.equals(teste2)){
				session.setAttribute("usuario_logado", u);
				return "menu";
			}

		}
		//tela inicial
		return "redirect:loginFormulario";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";

	}
	
	
	
}
