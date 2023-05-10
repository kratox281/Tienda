<%@page import="model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="fragments/Header.jsp"%>
<%Usuario user = (Usuario)request.getSession().getAttribute("user"); 
ArrayList<Pedido>pedidos = (ArrayList<Pedido>)request.getAttribute("pedidos");	
	%>
<h1>Bienvenido a tu perfil <%=user.getNombre() %></h1>
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSignin" >
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header p-5 pb-4 border-bottom-0">
        <h1 class="fw-bold mb-0 fs-2">Tus datos</h1>
      </div>

      <div class="modal-body p-5 pt-0" >
        <form action="perfil" method="post">
         <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="email" value=<%=user.getEmail() %>>
            <label for="floatingInput">Correo Electronico</label>
          </div>
           <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="nombre" value=<%=user.getNombre() %>>
            <label for="floatingInput">Nombre</label>
          </div>
           <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="apell" value=<%=user.getApellidos()%>>
            <label for="floatingInput">Apellidos</label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password" name="contrasenia" >
            <label for="floatingPassword">Contraseña</label>
          </div>
          <small>Confirma tu contraseña</small>
           <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password" name="contrasenia2">
            <label for="floatingPassword">Contraseña</label>
          </div>
          <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Modificar</button>
       <br>
       
         
        </form>
      </div>
      
      
    </div>
  </div>
</div>
<%for(Pedido p:pedidos){ %>
<p><%=p.toString() %></p>
<%} %>
<%@include file="fragments/Footer.jsp"%>
</body>
</html>