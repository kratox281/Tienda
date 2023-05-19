<%@page import="model.Producto"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<style type="text/css">
.relleno {
	margin-top: 60%;
	width: 100%;
	background-color: #f0f0f0;
	/* Puedes cambiar el color de fondo a tu gusto */
}
</style>
<title>Cesta de la compra</title>
</head>
<body>
	<%@include file="fragments/Header.jsp"%>
	<%
	Map<Producto, Integer> cesta = (Map<Producto, Integer>) request.getSession().getAttribute("cesta");
	%>
	<%
	double total = 0;
	%>
	<div class="container py-5 align-content-center">
		<div class="p-5 text-center bg-body-tertiary">
			<div class="my-5">
				<h1 class="text-body-emphasis">Su Cesta de la compra</h1>

				<table class="col-lg-8 mx-auto lead">
					<tr>
						<th>Producto</th>
						<th></th>
						<th>Cantidad</th>
						<th></th>
						<th>Precio</th>
					</tr>
					<%
					for (Map.Entry<Producto, Integer> entrada : cesta.entrySet()) {
						Producto p = entrada.getKey();
						System.out.print(p.toString());
						total += (p.getPrecio() * entrada.getValue());
					%><tr>
						<td style="text-align: center"><%=p.getNombre()%></td>
						<td></td>
						<td style="text-align: center"><%=entrada.getValue()%></td>
						<td></td>
						<td style="text-align: center"><%=p.getPrecio()%>$</td>

					</tr>
					<%
					}
					%>
				</table>
				<br>
				<p>
					Total:<b><%=total%>$</b>
				</p>

				<div style="text-align: center;">
					<label>Seleccione su metodo de pago</label>
					<form action="pago" method="post">
						<input type="hidden" name="metodo" value="PayPal"> <input
							type="hidden" name="total" value=<%=total%>>
						<button class="btn btn-success rounded-pill px-3" type="submit">PayPal</button>
					</form>
					<form action="pago" method="post">
						<input type="hidden" name="metodo" value="Tarjeta"> <input
							type="hidden" name="total" value=<%=total%>>
						<button class="btn btn-success rounded-pill px-3" type="submit">Tarjeta</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="fragments/Footer.jsp"%>
</body>
</html>