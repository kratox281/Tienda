<%@page import="model.Pedido"%>
<%@page import="model.Detalle"%>
<%@page import="java.util.ArrayList"%>
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
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<Detalle> detalles = (ArrayList<Detalle>) request.getAttribute("detalles");
	Pedido pedido = (Pedido) request.getAttribute("pedido");
	%>
	<%@include file="fragments/Header.jsp"%>
				<div class="container py-5 align-content-center" >
				<div class="p-5 text-center bg-body-tertiary">
				<div class="my-5">
				<h1 class="text-body-emphasis">Pedido Completado</h1>
				<h2>Resumen de su pedido</h2>
				<p>Numero de Pedido: <%=pedido.getId() %></p>
				<p>Metodo de Pago: <%=pedido.getMetodoPago() %></p>

				<table class="col-lg-8 mx-auto lead">
					<tr>
						<th>Producto</th>
						
						<th>Cantidad</th>
						
						<th>Precio</th>
						
						<th>Coste</th>
					</tr>
					<%
					for (Detalle d: detalles) {
					%><tr>
						<td style="text-align: center"><%=d.getNombreProducto()%></td>
					
						<td style="text-align: center"><%=d.getUnidades()%></td>
						
						<td style="text-align: center"><%=d.getPreciounidad()%>$</td>
						
						<td style="text-align: center"><%=d.getTotal() %>$</td>

					</tr>
					<%
					}
					%>
				</table>
				<br>
				<p >
					Total:<b><%=pedido.getTotal()%>$</b>
				</p>
			</div>
		</div>
	</div>


	<!--  <div class="relleno"></div>-->
	<%@include file="fragments/Footer.jsp"%>


</body>
</html>