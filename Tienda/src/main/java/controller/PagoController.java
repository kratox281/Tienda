package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Detalle;
import model.Pedido;
import model.Producto;
import model.Usuario;
import service.DetalleService;
import service.PedidoService;

/**
 * Servlet implementation class PagoController
 */
@WebServlet("/pago")
public class PagoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("comprando");
		Map<Producto,Integer> cesta =(Map<Producto,Integer>) request.getSession().getAttribute("cesta"); 
		Usuario u = (Usuario)request.getSession().getAttribute("user");
		int idUser = u.getId();
		Pedido p = new Pedido(PedidoService.countAll()+1,idUser,Date.valueOf(LocalDate.now()),request.getParameter("metodo"),"",Double.parseDouble(request.getParameter("total")),"PE");
		PedidoService.save(p);
		ArrayList<Detalle>details = new ArrayList();
		for(Map.Entry<Producto, Integer> e: cesta.entrySet()) {
			Producto pe = e.getKey();
			Detalle d = new Detalle(DetalleService.count()+1,p.getId(),pe.getId(),pe.getNombre(),e.getValue(),pe.getPrecio(),0,(pe.getPrecio()*e.getValue()));
			System.out.println(d.toString());
			DetalleService.save(d);
			details.add(d);
		}
		request.getSession().removeAttribute("cesta");
		
		request.setAttribute("pedido", p);
		request.setAttribute("detalles", details);
		request.getRequestDispatcher("Pago.jsp").forward(request, response);
	}

}
