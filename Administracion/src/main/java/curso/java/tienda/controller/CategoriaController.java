package curso.java.tienda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.service.CategoriaService;

@Controller
public class CategoriaController {

	
	@Autowired
	CategoriaService service;
	
	@GetMapping("/categorias")
	public String getAll(Model model) {
		model.addAttribute("categorias",service.getAll());
		return "Categorias";
	}
	
	@GetMapping("/editCategory")
	public String editarCate(Model model,@RequestParam String id) {
		model.addAttribute("id",id);
		Categoria cat =  service.getbyId(Integer.parseInt(id));
		model.addAttribute("nombre",cat.getNombre());
		return "CategoriaFormularioEdicion";
	}
	
	@PostMapping("/editCategory")
	public String modificar(Model model,@RequestParam String id,@RequestParam String nombre) {
		service.save(new Categoria(Integer.parseInt(id),nombre));
		return "redirect:/categorias";
	}
	
	@GetMapping("/createCategory")
	public String crearCate(Model model) {
		return "CategoriaFormularioCreacion";
	}
	
	@PostMapping("/createCategory")
	public String crear(Model model,@RequestParam String nombre) {
		int cantidad = service.getAll().size()+1;
		service.save(new Categoria(cantidad,nombre));
		return "redirect:/categorias";
	}
	
	@GetMapping("/deleteCat")
	public String delete(@RequestParam String id) {
		service.delete(Integer.parseInt(id));
		return "redirect:/categorias";

	}
}
