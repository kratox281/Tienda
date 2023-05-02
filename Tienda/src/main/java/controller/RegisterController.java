package controller;



import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UserService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/login").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("error", "e");
	
		
		HttpSession sesion = request.getSession();
		String psswrd = request.getParameter("contrasenia").equals(null)?"es nulo":request.getParameter("contrasenia");
		String email = request.getParameter("email").equals(null)?"es nulo":request.getParameter("email");
		int rol =0; //Integer.parseInt(request.getParameter("rol").equals(null)?"0":request.getParameter("rol"));
		String nombre = request.getParameter("nombre").equals(null)?"es nulo":request.getParameter("nombre");
		String apellidos = request.getParameter("apell").equals(null)?"es nulo":request.getParameter("apell");
		String psswrd2 = request.getParameter("contrasenia").equals(null)?"es nulo":request.getParameter("contrasenia");
		if(!UserService.comprobarContrasenias(psswrd, psswrd2)) {
			request.getSession().setAttribute("logged", "no"); 
			request.getSession().setAttribute("error", "error");
			//cambiar
			request.getRequestDispatcher("Registro.jsp").forward(request, response);

		}else {
			try {
			UserService.insertar(new Usuario(email,UserService.encriptar(psswrd),nombre,apellidos));
			request.getSession().removeAttribute("error");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				request.getSession().setAttribute("logged", "no"); 
				request.getSession().setAttribute("error", "error");
				//cambiar
				request.getRequestDispatcher("Registro.jsp").forward(request, response);
			}
			
		}
	}

}
