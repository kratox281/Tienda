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
<%Pedido ped = (Pedido)request.getAttribute("pedido");
ArrayList<Detalle> detalles = (ArrayList<Detalle>)request.getAttribute("detalles");
%>
<%@include file="fragments/Header.jsp"%>
<h1><%=ped.toString() %></h1>
<table>
<tr>
<td>Producto</td>
<td>Unidades</td>
<td>Precio Unitario</td>
<td>Total</td>
</tr>
<%for(Detalle d: detalles){ %>
<tr>
<td><%=d.getNombreProducto() %></td>
<td><%=d.getUnidades() %></td>
<td><%=d.getPreciounidad() %></td>
<td><%=d.getTotal()%></td>
</tr>
<%}%>
</table>
<div>
<b>Total</b><%=ped.getTotal()%>$
</div>
<%@include file="fragments/Footer.jsp" %>
</body>
</html>