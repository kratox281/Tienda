<%@page import="model.Pedido"%>
<%@page import="model.Detalle"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.relleno {
  margin-top:60%;
  width: 100%;
  background-color: #f0f0f0; /* Puedes cambiar el color de fondo a tu gusto */
}
</style>
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Detalle> detalles = (ArrayList<Detalle>) request.getAttribute("detalles");
  Pedido pedido = (Pedido) request.getAttribute("pedido");	
%>
	<%@include file="fragments/Header.jsp"%>
	<h1>Su pedido ha sido realizado con exito</h1>
	<br><p>Detalles de su pedido</p>
	<div style="text-align: center;">
	<p><%=pedido.toString() %></p>
	<%for(Detalle d:detalles){ %>
	<p><%=d.toString() %></p>
	<%} %>
	</div>
		<div class="relleno"></div>	
	<%@include file="fragments/Footer.jsp"%>

	
</body>
</html>