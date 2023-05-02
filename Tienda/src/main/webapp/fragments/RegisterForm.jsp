<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSignin">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header p-5 pb-4 border-bottom-0">
        <h1 class="fw-bold mb-0 fs-2">Crea tu Cuenta</h1>
      </div>

      <div class="modal-body p-5 pt-0">
        <form action="register" method="post">
         <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="email">
            <label for="floatingInput">Correo Electronico</label>
          </div>
           <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="nombre">
            <label for="floatingInput">Nombre</label>
          </div>
           <div class="form-floating mb-3">
            <input type="text" class="form-control rounded-3" id="floatingInput" placeholder="paco" name="apell">
            <label for="floatingInput">Apellidos</label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password" name="contrasenia">
            <label for="floatingPassword">Contrase�a</label>
          </div>
          <small>Confirma tu contrase�a</small>
           <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password" name="contrasenia2">
            <label for="floatingPassword">Contrase�a</label>
          </div>
          <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Registro</button>
        <small class="text-body-secondary">Al darle a registrar estas aceptando las condiciones de uso.</small> <br>
       <small> �Tienes una cuenta ya? <a href="Login.jsp"> Inicia Sesion</a></small>
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