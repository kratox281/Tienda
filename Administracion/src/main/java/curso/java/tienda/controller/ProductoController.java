package curso.java.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Producto;
import curso.java.tienda.service.CategoriaService;
import curso.java.tienda.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService service;
	@Autowired
	CategoriaService cService;

	@GetMapping("/productos")
	public String getAll(Model model) {
		System.out.println("controlador producto");
		model.addAttribute("productos", service.getAll());
		return "Productos";
	}

	@GetMapping("/editProducto")
	public String editar(Model model, @RequestParam String id) {
		Producto prod = service.getbyId(Integer.parseInt(id));
		model.addAttribute("categorias", cService.getAll());
		model.addAttribute("id", id);
		model.addAttribute("nombre",prod.getNombre());
		model.addAttribute("descripcion",prod.getDescripcion());
		model.addAttribute("precio",prod.getPrecio());
		model.addAttribute("stock",prod.getStock());
		model.addAttribute("imagen",prod.getUrl());
		return "ProductoFormularioEdicion";
	}
	
	@PostMapping("/editProducto")
	public String guardarCambios(@RequestParam String id,@RequestParam String nombre,@RequestParam String descripcion,@RequestParam String precio,@RequestParam String stock,@RequestParam String categoria,@RequestParam String imagen) {
		Producto prod = service.getbyId(Integer.parseInt(id));
		prod.setCategoria(Integer.parseInt(categoria));
		prod.setDescripcion(descripcion);
		prod.setNombre(nombre);
		prod.setPrecio(Integer.parseInt(precio));
		prod.setStock(Integer.parseInt(stock));
		prod.setUrl(imagen);
		service.save(prod);
		return "redirect:/productos";
	}
	
	@GetMapping("/crearProd")
	public String crear(Model model) {
		model.addAttribute("categorias", cService.getAll());
		return"ProductoFormularioCreacion";
	}
	
	@PostMapping("/crearProd")
	public String subir(@RequestParam String nombre,@RequestParam String descripcion,@RequestParam String precio,@RequestParam String stock,@RequestParam String categoria,@RequestParam String imagen) {
		int cantidad = service.getAll().size()+1;
		Producto p=new Producto(cantidad, nombre, descripcion, Double.parseDouble(precio), Integer.parseInt(stock),imagen,Integer.parseInt(categoria));
		System.out.println(p.toString());
		service.save(p);
		return "redirect:/productos";
	}
	
	@GetMapping("/deleteProd")
	public String delete(@RequestParam String id) {
		service.delete(Integer.parseInt(id));
		return "redirect:/productos";

	}
}
