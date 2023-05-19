package curso.java.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping("/clientes")
	public String getAll(Model model) {
		model.addAttribute("clientes",service.getAll());
		return "Clientes";
	}
	
	@GetMapping("/editCliente")
	public String edit(Model model,@RequestParam String id) {
	Usuario user = service.getById(Integer.parseInt(id));
		model.addAttribute("nombre",user.getNombre());
		model.addAttribute("apellidos",user.getApellidos());
		model.addAttribute("email",user.getEmail());
		model.addAttribute("id",id);
		return "ClienteFormularioEdicion";
	}
	
	@PostMapping("/editCliente")
	public String guardarCambios(@RequestParam String id,@RequestParam String email,@RequestParam String nombre,@RequestParam String apellidos) {
		Usuario user =  service.getById(Integer.parseInt(id));
		user.setApellidos(apellidos);
		user.setEmail(email);
		user.setNombre(nombre);
		service.guardar(user);
		return "redirect:/clientes";
	}
	
	@GetMapping("/createCliente")
	public String crear() {
		return "ClienteFormularioCreacion";
	}
	 
	@PostMapping("/createCliente")
	public String guardar(@RequestParam String email,@RequestParam String nombre,@RequestParam String clave,@RequestParam String apellidos) {
		clave = service.encriptar(clave);
		service.guardar(new Usuario(email, clave, nombre, apellidos));
		return "redirect:/clientes";
	}
	
	@GetMapping("/deleteCliente")
	public String delete(@RequestParam String id) {
		service.delete(Integer.parseInt(id));
		return "redirect:/clientes";

	}
}
