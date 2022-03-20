<%-- 
    Document   : autenticacion
    Created on : 18/03/2022, 05:05:42 PM
    Author     : User
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List l = (List) request.getAttribute("succ");
            if (l != null) {
                for (Iterator it = l.iterator(); it.hasNext();) {
                    String mensaje = (String) it.next();
        %>
        <div class="alert alert-primary" role="alert">
            
            <%=mensaje%>
            
            <%

                    }
                }
            %>
            </div>
            <h3>AUTENTICACION</h3>

            <div class="container">
                <div class="abs-center">
                    <form action="LoginCon" method="Post">
                        <div class="form-group">
        <label for="email">clave::</label>
        
         <input type="text" id="login" class="form-control" name="claveTxt" placeholder="ingrese clave">
      </div>
                       

                        <!-- <input type="submit" class="fadeIn fourth" value="Log In">-->
                        <input class="btn btn-primary" type="submit" name="accion" value="validate">

                    </form>
                </div>
            </div>
    </body>
</html>
