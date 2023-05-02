	<%@page import="model.Producto"%>
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
<!-- Aunque se llame carrito este es el catalogo -->
<style type="text/css">
.elementos{
	align-items:center;
	width: 100%;
	float: left;
	margin-left: 7%;
	margin-right: 5%;

}
.card {
  align-items:center;
  display: flex;
  float:inherit;
  margin: 20px;
  width:25%;
  background-color: #fff;
  border: 1px solid #e6e6e6;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}

.card img {
  width: 150px;
  height: 150px;
  border-radius: 5px 0 0 5px;
}

.card .info {
  padding: 10px;
}

.card h2 {
  margin: 0;
  font-size: 24px;
}

.card p {
  margin: 10px 0;
  font-size: 16px;
  color: #999;
}

.card .actions {
  display: flex;
  align-items: center;
}

.card .actions button {
  background-color: #fff;
  border: 1px solid #e6e6e6;
  color: #333;
  font-size: 16px;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.card .actions button:hover {
  background-color: #333;
  color: #fff;
}

.card .actions .quantity {
  display: flex;
  align-items: center;
  margin: 0 20px;
}

.card .actions .quantity button {
  background-color: #fff;
  border: 1px solid #e6e6e6;
  color: #333;
  font-size: 16px;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
}

.card .actions .quantity button:hover {
  background-color: #333;
  color: #fff;
}

.card .actions .quantity input {
  width: 50px;
  text-align: center;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  color: #333;
}

.card .actions .remove-button {
  background-color: #f44336;
  border: none;
  color: #fff;
}

.card .actions .remove-button:hover {
  background-color: #d32f2f;
}

</style>
<meta charset="ISO-8859-1">
<title>Catalogo</title>
</head>


<body>
	<%@include file="fragments/Header.jsp"%>
	<!-- Llenar desde BDD -->
	<div class="elementos">
	<%ArrayList<Producto>productos = (ArrayList<Producto>) session.getAttribute("catalogo");
%>
	<%for(Producto producto:productos) {
		System.out.print(producto.toString());
	%>
	
	<div class="card">
	<a href="/Tienda/prod">
  <img src="https://www.gastronomiavasca.net/uploads/image/file/3390/manzana.jpg" alt="Imagen del producto">
  </a>
  <div class="info">
  
    <h2><a href="/Tienda/prod"><%=producto.getNombre() %> </a></h2>
   
    <p><%=producto.getDescripcion() %></p>
    <p>Precio: $<%=producto.getPrecio() %></p>
    <%if(producto.getStock()==0){  %>
    <small style="color: red"> No hay stock de este articulo</small>
    <%} %> 
    <form action="CarritoController" method="post">
      <input type="hidden" name="producto_id" value="<%=producto.getNombre()%>">
      <div class="actions">
        <button type="submit" class="add-button">Añadir</button>
        <div class="quantity">
          <button type="button" class="minus-button" >-</button>
          
          <input type="number" class="quantity-input" name="cantidad" value="0" min="0" max="<%=producto.getStock()%>">
          
          <button id="boton+" type="button" class="plus-button">+</button>
        </div>
        
      </div>
    </form>
  </div>
</div>
	<% 
}%>
</div>
<div>
<footer style="text-align: center">
<form action="Cesta.jsp" style="text-align: center;">
<button class="btn btn-success rounded-pill px-3" type="submit" >Pagar</button>
 </form>
 </footer>
<%@include file="fragments/Footer.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </div>
  <script>
  var contador = doc
	</script>
	
	
</body>
</html>