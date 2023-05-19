package curso.java.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.java.tienda.model.Empleado;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.service.EmpleadoService;
import curso.java.tienda.service.RolService;

@Controller
public class EmpleadoController {

	@Autowired
	EmpleadoService service;
	
	@Autowired
	RolService rService;
	
	@PostMapping("/login")
	public String redirigir(Model model, @RequestParam String usuario,@RequestParam String contrasenia,HttpSession session) {
		Empleado user = service.iniciarSesion(usuario, contrasenia);
		if(user!=null) {
			session.setAttribute("emple", user);
			return "Succes";
		}else {
			return "Login";
		}
		
	}
	
	@GetMapping("/profile")
	public String mostrarPerfil(Model model,HttpSession session) {
		Empleado user = (Empleado) session.getAttribute("emple");
		model.addAttribute("roles",rService.getAll());
			model.addAttribute("nombre",user.getNombre());
			model.addAttribute("apellidos",user.getApellidos());
			model.addAttribute("email",user.getEmail());
		return "Perfil";
	}
	
	@PostMapping("/profile")
	public String editarPerfil(Model model,HttpSession session,@RequestParam String email,@RequestParam String nombre,@RequestParam String clave,@RequestParam String clave2,@RequestParam String apellidos) {
		if(clave.equals(clave2)) {
		Empleado emple = (Empleado) session.getAttribute("emple");
		emple.setClave(service.encriptar(clave));
		emple.setEmail(email);
		emple.setNombre(nombre);
		emple.setApellidos(apellidos);
		session.setAttribute("emple", emple);
		}
		return "redirect:/profile";
	}
	@GetMapping("/editEmpleado")
	public String edit(Model model,@RequestParam String id) {
	Empleado user = service.getById(Integer.parseInt(id));
	model.addAttribute("roles",rService.getAll());
		model.addAttribute("nombre",user.getNombre());
		model.addAttribute("apellidos",user.getApellidos());
		model.addAttribute("email",user.getEmail());
		model.addAttribute("id",id);
		return "EmpleadoFormularioEdicion";
	}
	
	@PostMapping("/editEmpleado")
	public String guardarCambios(@RequestParam String id,@RequestParam String rol,@RequestParam String email,@RequestParam String nombre,@RequestParam String apellidos) {
		Empleado user =  service.getById(Integer.parseInt(id));
		user.setApellidos(apellidos);
		user.setRol_id(Integer.parseInt(rol));
		user.setEmail(email);
		user.setNombre(nombre);
		service.guardar(user);
		return "redirect:/empleados";
	}
	
	@GetMapping("/createEmpleado")
	public String crear(Model model) {
		model.addAttribute("roles",rService.getAll());
		return "EmpleadoFormularioCreacion";
	}
	@PostMapping("/createEmpleado")
	public String guardar(@RequestParam String email,@RequestParam String rol,@RequestParam String nombre,@RequestParam String clave,@RequestParam String apellidos) {
		clave = service.encriptar(clave);
		service.guardar(new Empleado(Integer.parseInt(rol),email, clave, nombre, apellidos));
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleados")
	public String mostrar(Model model) {
		model.addAttribute("empleados",service.getAll());
		return"Empleados";
	}
	
	@GetMapping( "/logout")
	public String out() {
		return "Login";
	}
	
	@GetMapping("/deleteEmpleado")
	public String delete(@RequestParam String id) {
		service.delete(Integer.parseInt(id));
		return "redirect:/empleados";

	}
}
