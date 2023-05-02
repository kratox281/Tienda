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
  margin-top:60%;
  width: 100%;
  background-color: #f0f0f0; /* Puedes cambiar el color de fondo a tu gusto */
}
</style>
<title>Cesta de la compra</title>
</head>
<body>
<%@include file="fragments/Header.jsp"%>
<% Map<Producto,Integer> cesta =(Map<Producto,Integer>) request.getSession().getAttribute("cesta"); %>
<% double total = 0; %>
<table>
<tr>
<th>Producto</th>
<th>Cantidad</th>
</tr>
  <%for(Map.Entry<Producto,Integer> entrada : cesta.entrySet()){
	  Producto p = entrada.getKey();
	  System.out.print(p.toString());
	  total+= (p.getPrecio()*entrada.getValue());
	%><tr>
	<td style="text-align: center"><%= p.getNombre() %></td>
	
	<td style="text-align: center"><%=entrada.getValue() %></td>
	</tr>
	<% 
} %>
</table>
<p>Total:<b><%=total %></b></p>
<form action="pago" method="post"  style="text-align: center;">
<label>Seleccione su metodo de pago</label>
<button class="btn btn-success rounded-pill px-3" type="submit">PayPal</button>
<button class="btn btn-success rounded-pill px-3" type="submit">Tarjeta</button>
</form>
<div class="relleno"></div>
<%@include file="fragments/Footer.jsp"%>
</body>
</html>