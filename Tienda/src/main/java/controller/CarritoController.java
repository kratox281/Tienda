package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;
import service.ProductService;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/CarritoController")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("catalogo", ProductService.getAll());
		request.getRequestDispatcher("Carrito.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<Producto,Integer> cesta ;
		
		if(request.getSession().getAttribute("cesta")==null) {
			System.out.println("crea la cesta");
			 cesta = new HashMap();
		}else {
			System.out.println("La cesta está creada");
			cesta = (Map<Producto, Integer>) request.getSession().getAttribute("cesta");
		}
		String nombre =  request.getParameter("producto_id");
		Producto producto = ProductService.findByName(nombre);
		System.out.println(producto.toString());
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		System.out.println(cantidad);
		ProductService.actualizarStock(nombre, cantidad);
		if(cesta.containsKey(producto)) {
			cantidad += cesta.get(producto);
			cesta.remove(producto);
			cesta.put(producto, cantidad);
		}else {
			cesta.put(producto, cantidad);
		}
		
		System.out.println(producto+" "+cantidad);
		request.getSession().setAttribute("cesta", cesta);
		doGet(request, response);
	}

}
