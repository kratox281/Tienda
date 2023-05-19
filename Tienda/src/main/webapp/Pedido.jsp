<%@page import="model.Detalle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Pedido pedido = (Pedido)request.getAttribute("pedido");
ArrayList<Detalle> detalles = (ArrayList<Detalle>)request.getAttribute("detalles");
String estado;
switch(pedido.getEstado()){
case "PE":
	estado="Pendiente de Envio";
	break;
case "E":
	estado="Enviado";

	break;
case "C":
	estado="Cancelado";

	break;
	default:
		estado="Desconocido";
		break;
}
%>
<%@include file="fragments/Header.jsp"%>
	<div class="container py-5 align-content-center" >
				<div class="p-5 text-center bg-body-tertiary">
				<div class="my-5">
				<h1 class="text-body-emphasis">Pedido Completado</h1>
				<h2>Resumen de su pedido</h2>
				<p>Numero de Pedido: <%=pedido.getId() %></p>
				<p>Metodo de Pago: <%=pedido.getMetodoPago() %></p>
				<p>Estado del Pedido: <%=estado %></p>
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
				<%if(estado.equals("Pendiente de Envio")){ %>
				<form action="cancelar" method="post">
				<input type="hidden" name="id" value=<%=pedido.getId() %>>
				<button type="submit" class="btn btn-danger rounded-pill px-3" value="Cancelar Pedido" onclick="if(!confirm('¿Seguro que desea cancelar el pedido?')){return false;}">Cancelar Pedido</button>
				<%} %>
				</form>
			</div>
		</div>
	</div>
<%@include file="fragments/Footer.jsp" %>
</body>
</html>