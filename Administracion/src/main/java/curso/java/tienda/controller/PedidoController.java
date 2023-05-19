package curso.java.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.service.PedidoServiceImpl;

@Controller
public class PedidoController {
	
	@Autowired
	PedidoServiceImpl service;
	
	@GetMapping("/pedidos")
	public String getPedidos(Model model) {
		System.out.println("Pasa por pedidos");
		model.addAttribute("pedidos",service.getAll());
		return "Pedidos";
	}
	
	@PostMapping("/procesar")
	public String procesar(@RequestParam String id) {
		service.procesar(Integer.parseInt(id));
		return "redirect:/pedidos";
	}
	
	

}
