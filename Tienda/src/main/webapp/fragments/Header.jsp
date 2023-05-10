<%@page import="model.Usuario"%>
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
<link rel="apple-touch-icon"
	href="/docs/5.3/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg"
	color="#712cf9">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
<script

    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"

    integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"

    crossorigin="anonymous"></script>

</head>
<body>
	<%
	if (request.getSession().getAttribute("logged").equals("no")) {
	%>
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
					<li><a href="Respuesta.jsp" class="nav-link px-2 text-white">Inicio</a></li>
					<li><a href="Carrito.jsp" class="nav-link px-2 text-white">Catalogo</a></li>
					<li><a href="Cesta.jsp" class="nav-link px-2 text-white">Cesta</a></li>
				</ul>
				<div class="text-end">

					<form action="Login.jsp">
						<button type="submit" class="btn btn-outline-light me-2">Iniciar
							sesion</button>
						<button type="submit" class="btn btn-warning"
							formaction="Registro.jsp">Registrar</button>
					</form>


				</div>
			</div>
		</div>
	</header>

	<%
	} else {
	%>
	<header class="p-3 text-bg-dark">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="Respuesta.jsp" class="nav-link px-2 text-white">Inicio</a></li>
					<li><a href="Carrito.jsp" class="nav-link px-2 text-white">Catalogo</a></li>
					<li><a href="Cesta.jsp" class="nav-link px-2 text-white">Cesta</a></li>
				</ul>
				

				<div class="dropdown text-end">
				<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li>
				<a href="Cesta.jsp"
						class="d-block link-dark text-decoration-none dropdown-toggle"
						aria-expanded="false"> <img
						src="https://iconsplace.com/wp-content/uploads/_icons/ffffff/256/png/shopping-basket-icon-18-256.png" alt="mdo" width="32" height="32"
						>
					</a>
				</li>
				<li>
					<a href="#"
						class="d-block link-dark text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="https://www.citypng.com/public/uploads/small/11639594348a46oiqppgm5q073rktaaxu4szgn0lvrp0eq0j39kqc08skbq931nzhc8ogm7bvemplm5uzurkb29ohqernyblwsoelhbbmmmgzxb.png" alt="mdo" width="32" height="32"
						class="rounded-circle">
					</a>
					<ul class="dropdown-menu text-small">
						<li><a class="dropdown-item" href="perfil">Perfil</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="cerrar">Cerrar Sesión</a></li>
					</ul>
					</li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<%
	}
	%>
</body>
</html>