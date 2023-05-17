<%@page import="model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="fragments/Header.jsp"%>
	<%
	Usuario user = (Usuario) request.getSession().getAttribute("user");
	ArrayList<Pedido> pedidos = (ArrayList<Pedido>) request.getAttribute("pedidos");
	%>
	
	<div
		class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5"
		tabindex="-1" role="dialog" id="modalSignin">
		<div class="modal-dialog" role="document">
		<h1>
		Bienvenido a tu perfil
		<%=user.getNombre()%></h1>
			<div class="modal-content rounded-4 shadow">
				<div class="modal-header p-5 pb-4 border-bottom-0">
					<h1 class="fw-bold mb-0 fs-2">Tus datos</h1>
				</div>

				<div class="modal-body p-5 pt-0">
					<form action="perfil" method="post">
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-3"
								id="floatingInput" placeholder="paco" name="email"
								value=<%=user.getEmail()%>> <label for="floatingInput">Correo
								Electronico</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-3"
								id="floatingInput" placeholder="paco" name="nombre"
								value=<%=user.getNombre()%>> <label for="floatingInput">Nombre</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-3"
								id="floatingInput" placeholder="paco" name="apell"
								value=<%=user.getApellidos()%>> <label
								for="floatingInput">Apellidos</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control rounded-3"
								id="floatingPassword" placeholder="Password" name="contrasenia">
							<label for="floatingPassword">Contraseña</label>
						</div>
						<small>Confirma tu contraseña</small>
						<div class="form-floating mb-3">
							<input type="password" class="form-control rounded-3"
								id="floatingPassword" placeholder="Password" name="contrasenia2">
							<label for="floatingPassword">Contraseña</label>
						</div>
						<button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary"
							type="submit">Modificar</button>
						<br>


					</form>
				</div>


			</div>
		</div>
		<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSheet">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header border-bottom-0">
        <h1 class="modal-title fs-5"><b>Tus Pedidos</b></h1>
        <br>
		<div
		class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 align-items-center justify-content-center" >
		<div class="list-group" >
			<%
			for (Pedido p : pedidos) {
			%>
			<%
			String url = "/Tienda/pedido?id=" + p.getId();
			%>
			<a href=<%=url%>
				class="list-group-item list-group-item-action d-flex gap-3 py-3"
				aria-current="true" >
				<div class="d-flex gap-2 w-100 justify-content-between" >
					<div>
						<h6 class="mb-0">Pedido <%=p.getId()%></h6>
						<p class="mb-0 opacity-75">Realizado el <%=p.getFecha().toString()%></p>
						<p class="mb-0 opacity-75">Estado: <%=p.getEstado() %></p>
					</div>
					<small class="opacity-50 text-nowrap"><%=p.getTotal() %>€</small>
				</div>
			</a>
			<%
			}
			%>
		</div>
		
	</div>
	</div>
		</div>
		</div>
		</div>
		</div>
	

	<%@include file="fragments/Footer.jsp"%>
</body>
</html>