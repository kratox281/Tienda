package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Detalle;
import model.Pedido;
import service.DetalleService;
import service.PedidoService;

/**
 * Servlet implementation class CancelarController
 */
@WebServlet("/cancelar")
public class CancelarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		PedidoService.cancelar(Integer.parseInt(id));
		Pedido pedido = PedidoService.findById(Integer.parseInt(id));
		ArrayList<Detalle> detalles = DetalleService.obtenerPedido(pedido.getId());
		request.setAttribute("pedido", pedido);
		request.setAttribute("detalles", detalles);
		request.getRequestDispatcher("Pedido.jsp").forward(request, response);
	}

}
