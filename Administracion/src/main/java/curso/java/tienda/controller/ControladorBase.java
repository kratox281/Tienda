package curso.java.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControladorBase {

	@GetMapping("")
	public String saludo(Model model) {
		System.out.println("get");
		model.addAttribute("nombre","Ruben");
		return "Login";
	}
	
	
	@GetMapping("/error")
	public String saludo1() {
		
		System.out.println("post");
		return "Login";
	}
}
