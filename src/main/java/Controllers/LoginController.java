/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Persistence.Conexion;
import Persistence.DAO.UsuarioDAO;
import Persistence.DTO.UsuarioDTO;
import Seguridad.Cifrador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orell
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
      out.println("<h1>Servlet dddddddddddddddd at " + request.getContextPath() + "</h1>");
    processRequest(request, response);

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
        
            PrintWriter out = response.getWriter();
            
            String u = request.getParameter("txtUser");
            String p = request.getParameter("txtPwd");
            
            System.out.println(u);
         UsuarioDAO user = new UsuarioDAO();
        UsuarioDTO usuarioDB = user.buscarUsuario(u);
        if(usuarioDB != null){
                try {
                    //Verifico password
                    //Ver si se puede poner la clave en un archivo de texto y usarla desde ahi. 
                    String pwdCifrado =Cifrador.cifrar(p, "SIUGUARANI");
                    //
                    //
                    System.out.println(pwdCifrado);
                    if(usuarioDB.getPassword().equals(pwdCifrado)){
                        System.out.println("Ingreso correctamente");
                        HttpSession sesion = request.getSession();
                        String legajo = user.obtenerDocente(usuarioDB.getUsuario(), "Docente");
                        
                        System.out.println("legajo del usuaior es: " + legajo);
                        sesion.setAttribute("legajoDocente", legajo);
                        sesion.setAttribute("autenticado", true);
                        //Si en 30 minutos no hace nada, se cierra la sesion. 
                        sesion.setMaxInactiveInterval(1800);
                        
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }   } catch (GeneralSecurityException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } else{
            System.out.println("Usuario inexistente. Solicite crear uno");
        }
            System.out.println(usuarioDB.getPassword());
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
