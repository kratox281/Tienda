<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Respuesta</title>

</head>
<body>
<% request.getSession().removeAttribute("error"); 
	request.getSession().setAttribute("logged", "si");
	Usuario user = (Usuario)request.getSession().getAttribute("user");
	%>
	
<%@include file ="fragments/Header.jsp" %>
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSheet">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header border-bottom-0">
        <h1 class="modal-title fs-5"><%=user.getNombre()+user.getApellidos()%></h1>
      <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->  
      </div>
      <div class="modal-body py-0">
        <p><%= user.getNombre()+user.getApellidos()%>, bienvenido a este maravilloso Login con opcion de cerrar Sesion</p>
      </div>
      <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
      <form action="Carrito.jsp">
        <button type="submit" class="btn btn-lg btn-primary">Ir al catalogo</button>
       </form>
       <form action="cerrar">
        <button type="submit" class="btn btn-lg btn-secondary" data-bs-dismiss="modal">Cerrar Sesion</button>
        </form>
      </div>
      <div align="center">
      <iframe style="border-radius:12px" src="https://open.spotify.com/embed/track/0zOtZOvUZ31UeWekN6ESg5?utm_source=generator&theme=0" width="90%" height="100" frameBorder="0" allowfullscreen="" allow="autoplay;clipboard-write; encrypted-media; fullscreen; picture-in-picture" " ></iframe>
    </div>
    </div>
  </div>
</div>
<div>
<%@include file ="fragments/Footer.jsp" %>
</div>
</body>
</html>