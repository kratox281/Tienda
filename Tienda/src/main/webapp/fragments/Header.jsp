<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
</head>
<body>
	<header class="p-3 text-bg-dark">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
						<use xlink:href="#bootstrap" /></svg>
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="Respuesta.jsp"
						class="nav-link px-2 text-white">Inicio</a></li>
					<li><a href="Carrito.jsp" class="nav-link px-2 text-white">Catalogo</a></li>
					<li><a href="Cesta.jsp" class="nav-link px-2 text-white">Cesta</a></li>
									</ul>

	 

				<div class="text-end">
					<%
					if (request.getSession().getAttribute("logged").equals("no")) {
					%>
					<form action="Login.jsp">
						<button type="submit" class="btn btn-outline-light me-2"
							>Iniciar sesion</button>
						<button type="submit" class="btn btn-warning"
							formaction="Registro.jsp">Registrar</button>
					</form>
					<%
					}else{%>
						<form action="cerrar">
						<button type="submit" class="btn btn-outline-light me-2"
							>Cerrar sesion</button>
					</form>
					<%}
					%>
				</div>
			</div>
		</div>
	</header>
</body>
</html>