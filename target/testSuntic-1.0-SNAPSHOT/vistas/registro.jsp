<%-- 
    Document   : registro
    Created on : 19/03/2022, 09:15:19 AM
    Author     : User
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modeloDao.TipoIdentificacion"%>
<%@page import="java.util.List"%>
<%@page import="modeloDao.UserD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <title>Registration Form</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          List l=(List) request.getAttribute("succ");
          if(l!=null){
          for (Iterator it = l.iterator(); it.hasNext();) {
                String mensaje=(String) it.next();
                %>
                <font color="red" >
    <li class="text-uppercase"><%=mensaje%></li>
                </font>
                <%
                 
              }
          }
        %>  
        <div  id="registration-form"  >
            <div class="image"></div>
            <div class="col-lg-4 control-label" >
                <h1>Sign up</h1>
                <form action="UserCon" method="Post" onsubmit="return validar_nombre()">
                    <div class="form-group" >
                        <label  for="username">Username:</label>
                        <input type="text" class="form-control" id="usernameI" name="username" placeholder="Enter username"  >
                    </div>
                    <div class="form-group">
                        <label for="username">Apellido:</label>
                        <input type="text" class="form-control" id="apellidoI" name="apellido" placeholder="Enter username" required >
                    </div>
                    <div class="form-group">
                        <select class="form-select" aria-label="Default select example" name="tipoI" required id="tipoII">
                            <option value="0" selected>Seleccione tipo de identidad</option>
                            <%
                                UserD pd = new UserD();
                                List<TipoIdentificacion> list = pd.listar();
                                Iterator<TipoIdentificacion> iter = list.iterator();
                                TipoIdentificacion pro = null;
                                while (iter.hasNext()) {
                                    pro = iter.next();
                                    System.out.println(pro.getId());
                                    System.out.println(pro.getNombre());

                            %>

                            <option value=<%=pro.getId()%> ><%=pro.getNombre()%></option>
                            <%}%>   
                        </select>   
                        
                    </div>
                    <div class="form-group">
                        <label for="email">numero Identificacion:</label>
                        <input type="number" class="form-control" id="numIdenI" name="numIden" placeholder="Enter email" required >
                    </div>
                    <div class="form-group">
                        <label for="number">Numero fijo o movil:</label>
                        <input type="number" class="form-control" id="NumerTelI" name="NumerTel" placeholder="Enter email" required >
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="emailI" name="email" placeholder="Enter email" required >
                    </div>
                    <div class="form-group">
                        <label for="email">Confirmar Email:</label>
                        <input type="email" class="form-control" id="ConfmailI"  name="Confmail" placeholder="Enter email" required >
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwdI" name="pwd" placeholder="Enter password" required >
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-lg"  name="accion" value="crear">Submit</button>
                    </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                               acepta <a href="#" class="link-primary">teminos y condiciones</a>
                                 
                            </label>
                        </div>
                </form>
            </div>
        </div>
    </body>
    <script src="js/alertify.js" type="text/javascript"></script>
    <script>
            function validar_nombre() {
                nom = document.getElementById("usernameI").value;
                apel = document.getElementById("apellidoI").value;
                tipoi = document.getElementById("tipoII").value;
                numid = document.getElementById("numIdenI").value;
                numT = document.getElementById("NumerTelI").value;
                emai = document.getElementById("emailI").value;
                emmaiC = document.getElementById("ConfmailI").value;
                window.console.log(emmaiC);
                pw =document.getElementById("pwdI").value;
               
               if (emai != emmaiC)
                {
                      alertify.alert("Error", "no coinciden las direcciones email").set('label', 'Ok');
            return false;
                }
               if (document.getElementById('flexCheckDefault').checked== false )
                {
                      alertify.alert("Error", "acepte terminos y condiciones").set('label', 'Ok');
            return false;
                }
                if (nom.length == 0||apel.length == 0||tipoi.length == 0||numid.length == 0||numT.length == 0||emai.length == 0||emmaiC.length == 0||pw.length == 0) {
                    alertify.alert("Error", "Hay campos vacios").set('label', 'Ok');
                    return false;
                }
                else {
                   
                    return true;
                }
            }
           
        </script>
</html>
