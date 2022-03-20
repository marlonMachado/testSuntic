<%-- 
    Document   : index
    Created on : 19/03/2022, 08:50:14 AM
    Author     : User
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
    <li><%=mensaje%></li>
                </font>
                <%
                 
              }
          }
        %>
        <h1></h1>
           <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
    </div>
    <h1>SUNTIC</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="UserCon">Registrarse <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
       
 
<div class="container">
  <div class="abs-center">
    <form action="LoginCon" method="Post" class="border p-3 form">
      <div class="form-group">
        <label for="email">Email</label>
        <input type="text" id="login"  name="userTxt" placeholder="login" class="form-control">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password"  name="passTxt" placeholder="password"class="form-control">
      </div>
      <button type="submit"  name="accion" value="login" class="btn btn-primary">Login</button>
    </form> 
  </div>
</div>
    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>
    </body>
</html>
