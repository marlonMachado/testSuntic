/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.User;
import modeloDao.UserD;

/**
 *
 * @author User
 */
public class LoginCon extends HttpServlet {

    String autenticacion = "vistas/autenticacion.jsp";
    String bienvenido = "vistas/home.jsp";
     String noLog = "./index.jsp";
    User usr;
    UserD usrD;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginCon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginCon at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);

//        String acceso = "";
//        String action = request.getParameter("accion");
//        if (action.equalsIgnoreCase("login")) {
//            String user = request.getParameter("userTxt");
//            String pass = request.getParameter("passTxt");
//            usr = new User();
//            usrD = new UserD();
//            usr.setUser(user);
//            usr.setPass(pass);
//            String ret = usrD.Login(usr);
//            List l = new LinkedList();
//            if (ret.contains("ngrese clave enviada a su correo")) {
//                //request.setAttribute("succ", l);
//                acceso = autenticacion;
//                l.add(ret);
//                request.setAttribute("succ", l);
//            }
//            if (!l.isEmpty()) {
//                //  request.setAttribute(pass, ret);
//            }
//            //  request.setAttribute(pass, ret);
//        } else if (action.equalsIgnoreCase("validate")) {  
//            String claveG = request.getParameter("claveTxt");
//            String valAcc = usrD.validarLogin(claveG);
//            if (valAcc.equals("concebido")) {
//  acceso = bienvenido;
//            }
//        }
//
//        RequestDispatcher vista = request.getRequestDispatcher(acceso);
//        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("login")) {
            String user = request.getParameter("userTxt");
            String pass = request.getParameter("passTxt");
            usr = new User();
            usrD = new UserD();
            usr.setUser(user);
            usr.setPass(pass);
            String ret = usrD.Login(usr);
            List l = new LinkedList();
            if (ret.contains("ngrese clave enviada a su correo")) {
                //request.setAttribute("succ", l);
                acceso = autenticacion;
                l.add(ret);
                request.setAttribute("succ", l);
            }else if(ret.contains("Usuario no registrado")){   
                  acceso = noLog;
                   l.add(ret);
                request.setAttribute("succ", l);
            }
            if (!l.isEmpty()) {
                //  request.setAttribute(pass, ret);
            }
            //  request.setAttribute(pass, ret);
        } else if (action.equalsIgnoreCase("validate")) {
            String claveG = request.getParameter("claveTxt");
            String valAcc = usrD.validarLogin(claveG);
            if (valAcc.equals("concebido")) {
                acceso = bienvenido;
            }

        }else if(action.equalsIgnoreCase("cerrar")){
         acceso = noLog;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
