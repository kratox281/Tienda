<%@page import="model.Producto"%>
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
<%Producto p =(Producto) request.getAttribute("productoDetalle"); %>
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSheet">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header border-bottom-0">
        <h1 class="modal-title fs-5"><%=p.getNombre() %></h1>
      </div>
      <div class="modal-body py-0">
      <%System.out.print(p.getUrl()); %>
      <img  alt="" src=<%=p.getUrl() %> style="width: 150px;
  height: 150px;
  border-radius: 5px 0 0 5px;">
	<p ><%=p.getDescripcion() %></p>
      </div>
      <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
      <form action="CarritoController" method="post">
      <%System.out.print(p.getNombre()); %>
      <input type="hidden" name="producto_nombre" value="<%=p.getNombre()%>">
      <input type="hidden" name="cantidad" value="1">
      <%if(p.getStock()>0){ %>
        <button type="submit"  class="btn btn-lg btn-primary">Añadir al Carrito</button>
        <%}else{ %>
        <small style="color: red"> No hay stock de este articulo</small>
        <% }%>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="fragments/Footer.jsp"%>
</body>
</html>