package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Conexion;

import model.Usuario;
import service.UserService;


/**
 * Servlet implementation class LoginControlador
 */
@WebServlet("/login")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Usuario: "+user+" contra: "+psswrd);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("error", "e");
		HttpSession sesion = request.getSession();
		
		Map<String, String[]>mapa = request.getParameterMap();
		for(Map.Entry<String, String[]>entrada:mapa.entrySet()) {
			if(entrada.getValue()==null) {
				request.getSession().setAttribute("logged", "no"); 
				request.getSession().setAttribute("error", "error");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				break;
			}
		}
		
		
		String username = request.getParameter("usuario").equals(null)?"es nulo":request.getParameter("usuario");
		String psswrd = request.getParameter("contrasenia").equals(null)?"es nulo":request.getParameter("contrasenia");
		Usuario user = UserService.comprobarUser(username, UserService.encriptar(psswrd));
		if(user!=null) {
			//System.out.println("Usuario correcto");
			//request.getSession().setAttribute("logged", true);

			sesion.setAttribute("user", user);
			request.getSession().setAttribute("logged", "si");
			if(request.getSession().getAttribute("comprando")!=null) {
				request.getSession().removeAttribute("comprando");
				request.getRequestDispatcher("pago").forward(request, response);
			}else {
				request.getRequestDispatcher("Respuesta.jsp").forward(request, response);
			}
			
			//doGet(request, response);
		}else {
			//String error = "Datos incorrectos";
			//request.setAttribute("error", error);
			request.getSession().setAttribute("logged", "no"); 
			request.getSession().setAttribute("error", "error");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
		
	}

}
