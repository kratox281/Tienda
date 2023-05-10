package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.*;
@WebFilter(urlPatterns = {"/Respuesta.jsp","/Pago.jsp","/pago","/Perfil.jsp"})
public class FiltroSesion implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Aquí puedes hacer cualquier inicialización necesaria para el filtro.
    }
   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Este es el método que se llama cada vez que se hace una solicitud al servlet al que este filtro está asociado.
        // Aquí puedes hacer cualquier procesamiento necesario en la solicitud o en la respuesta antes de que se llame al siguiente filtro o al servlet.
       
        // Comprobamos si existe una sesión.
    	
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String referer = httpRequest.getHeader("Referer");
        System.out.println(referer);
        if(referer.contains("Cesta")) {
        	httpRequest.getSession().setAttribute("comprando", "si");
        	System.out.println("Deberia redirigir al pago");
        }
        HttpSession session = httpRequest.getSession(false);
        if(session.getAttribute("logged").equals("no")) {
        	 HttpServletResponse httpResponse = (HttpServletResponse) response;
             httpResponse.sendRedirect("Login.jsp");
             return;
        }
      
       
        // Después de hacer cualquier procesamiento necesario, debes llamar al siguiente filtro o al servlet.
        chain.doFilter(request, response);
    }
   
    public void destroy() {
        // Aquí puedes hacer cualquier limpieza necesaria para el filtro.
    }
}