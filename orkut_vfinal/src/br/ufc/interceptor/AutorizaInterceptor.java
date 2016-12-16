package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizaInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object handler) throws Exception {
		String uri = request.getRequestURI();
		//System.out.println(uri);
		//liberar
		if(uri.startsWith("/br.ufc/resources/")){
			return true;
		}
		
		if(uri.endsWith("loginFormulario") || uri.endsWith("login")){
			return true;
		}
		
		if(uri.endsWith("inserirUsuarioFormulario") || uri.endsWith("inserirUsuario")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuario_logado")!=null){
			
			return true;
		}
		
		
		
		response.sendRedirect("loginFormulario");
		return false;
				
	}
}
