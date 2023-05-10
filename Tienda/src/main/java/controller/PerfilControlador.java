package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.PedidoService;
import service.UserService;

/**
 * Servlet implementation class PerfilControlador
 */
@WebServlet("/perfil")
public class PerfilControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario user = (Usuario)request.getSession().getAttribute("user"); 
		request.setAttribute("pedidos", PedidoService.getByUser(user));
		request.getRequestDispatcher("Perfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario user = (Usuario)request.getSession().getAttribute("user"); 
		HttpSession sesion = request.getSession();
		String psswrd = request.getParameter("contrasenia").equals(null)?"es nulo":request.getParameter("contrasenia");
		String email = request.getParameter("email").equals(null)?"es nulo":request.getParameter("email");
		int rol =0; //Integer.parseInt(request.getParameter("rol").equals(null)?"0":request.getParameter("rol"));
		String nombre = request.getParameter("nombre").equals(null)?"es nulo":request.getParameter("nombre");
		String apellidos = request.getParameter("apell").equals(null)?"es nulo":request.getParameter("apell");
		String psswrd2 = request.getParameter("contrasenia").equals(null)?"es nulo":request.getParameter("contrasenia2");
		if(!UserService.comprobarContrasenias(psswrd, psswrd2)) {
			System.out.println("error en la contraseña");
			request.getSession().setAttribute("error", "error");
			//cambiar
			doGet(request, response);

		}else {
			try {
				
			//	System.out.println(user.toString());
			UserService.modificar(new Usuario(user.getId(),0,email,psswrd,nombre,apellidos));
			 user = UserService.comprobarUser(email, UserService.encriptar(psswrd));
			 sesion.setAttribute("user", user);
			request.getSession().removeAttribute("error");
			doGet(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				
				request.getSession().setAttribute("error", "error");
				//cambiar
				doGet(request, response);
			}
	}
	}

}
