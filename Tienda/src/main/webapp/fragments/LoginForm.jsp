<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%request.getSession().removeAttribute("usuario"); %>
	
<%request.getSession().setAttribute("logged", "no"); %>
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSignin">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header p-5 pb-4 border-bottom-0">
        <h1 class="fw-bold mb-0 fs-2">Inicia Sesion</h1>
      </div>

      <div class="modal-body p-5 pt-0">
        <form action="login" method="post">
          <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="usuario">
            <label for="floatingInput">Nombre de Usuario</label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password" name="contrasenia">
            <label for="floatingPassword">Contraseña</label>
          </div>
          <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Iniciar sesion</button>
 <small> ¿Todavia no tienes cuenta? <a href="Registro.jsp"> Registrate aquí</a></small>        <!--  <small class="text-body-secondary">Al darle a registrar estas aceptando las condiciones de uso.</small>-->  
       <br>
         <%if(request.getSession().getAttribute("error")!=null){
        	  %>
          <small style="color: red"> Error en los datos introducidos </small>
          <%}%>
         
        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>