package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentarioDAOHibernate;
import br.ufc.dao.FotosDAOHibernate;
import br.ufc.dao.UsuarioDAOHibernate;
import br.ufc.model.Comentario;
import br.ufc.model.Fotos;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class ComentarioController {
	
	@Autowired
	@Qualifier(value="comentarioDAOHibernate")
	private ComentarioDAOHibernate comentarioDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAOHibernate")
	private UsuarioDAOHibernate usuarioDAO;
	
	@Autowired
	@Qualifier(value="fotosDAOHibernate")
	private FotosDAOHibernate fotosDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(Long id, Model model){
		Fotos f = fotosDAO.recuperar(id);
		
		model.addAttribute("fotos_id", f);
		model.addAttribute("comentarios", f.getComentarios());
		return "comentario/inserir_comentario_formulario";
	}
	
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(Long usuario_id, Long fotos_id, @Valid Comentario comentario,
							   BindingResult result){		
		
		if(result.hasFieldErrors("comentario")){
			return "comentario/inserir_comentario_formulario";
		}
		
		Fotos fotos = fotosDAO.recuperar(fotos_id);
		comentario.setFotos(fotos);
		
		Usuario usuario = usuarioDAO.recuperar(usuario_id);
		comentario.setAutorComentario(usuario);
		
		this.comentarioDAO.inserir(comentario);
		
		return "redirect:listarComentario";
	}
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model){
				
		List<Comentario> comentarios = this.comentarioDAO.listar();
		model.addAttribute("comentarios", comentarios);
				
		return "comentario/listar_comentario";
	}	
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id){
		
		this.comentarioDAO.apagar(id);
		return "redirect:listarComentario";
	}
	

	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		
		Comentario comentario = this.comentarioDAO.recuperar(id);
		model.addAttribute("comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario comentario){
		
		this.comentarioDAO.alterar(comentario);
		return "redirect:listarComentario";
	}	
}
