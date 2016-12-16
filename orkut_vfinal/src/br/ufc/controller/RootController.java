package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("menu")
	public String menu() {
		return "menu";
	}
}
