/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Persistence.Conexion;
import Persistence.DAO.IntegranteProyectoDAO;
import Persistence.DTO.IntegranteProyectoDTO;
import Persistence.DTO.ProyectoInvestigacionDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author orell
 */

public class ProyectoInvestigacionController extends HttpServlet {

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
       // this.doPost(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProyectoInvestigacionController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProyectoInvestigacionController at " + request.getContextPath() + "</h1>");
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
    //Metodo para obtener datos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                  PrintWriter out = response.getWriter();

        //
        HttpSession sesion = request.getSession();
        sesion.getAttribute("autenticado");
        //Verificacion de si está logueqado o no
        if (sesion.getAttribute("autenticado") == null) {
            System.out.println("Ha ocurrido un error");
                        out.println("<p>No ha iniciado sesion  </p>");

        } else {
            //

            //Legajo debe obtenerse de la sesion del usuario
            String legajo = (String) sesion.getAttribute("legajoDocente");
            System.out.println(legajo);
            IntegranteProyectoDAO proyectoDAO = new IntegranteProyectoDAO();
            ArrayList<ProyectoInvestigacionDTO> proyectos = proyectoDAO.obtenerProyectos(legajo);
            System.out.println(proyectos.size());

            System.out.println(proyectos.get(0).getCodProyecto());

            ArrayList<IntegranteProyectoDTO> integrantes = proyectoDAO.buscarIntegrantes(proyectos.get(0).getCodProyecto());

            out.println("<p>El docente tiene " + proyectos.size() + " proyectos. Y tiene" + integrantes.size() + " </p>");
            out.println("<p>Nombre del proyecto" + proyectos.get(0).getTituloProy() + " </p>");

            processRequest(request, response);
        }
    }
     
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
       //Metodo para cargar integrante
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
// '104/2019', '1025', 'investigador', '18/11/2023', 5, 'Muchas', 'activo'

IntegranteProyectoDTO integranteNuevo = new IntegranteProyectoDTO();

//Lo siguiente se deberia obstener del formulario


String legajo = request.getParameter("legajo");
String codigoProyecto =request.getParameter("codigoProyecto");
String rol=request.getParameter("rol"); 
String fecha=request.getParameter("fechaInscripcion");
int horasSemanales=Integer.parseInt(request.getParameter("horasSemanales")); 
String actividades = request.getParameter("actividades");
String estado=request.getParameter("estado"); 
integranteNuevo.setLegajoEst(legajo);
integranteNuevo.setCodProyecto(codigoProyecto);
integranteNuevo.setRol(rol);
integranteNuevo.setFechaInscripcion(fecha);
integranteNuevo.setHsSemanales(horasSemanales);
integranteNuevo.setDescripAct(actividades);
integranteNuevo.setEstadoRegistro(estado);
// hasta aqui se debe de obtener desde el formulario 
IntegranteProyectoDAO proyectoDAO = new IntegranteProyectoDAO();
 boolean inscripto=  proyectoDAO.incribir(integranteNuevo,"alumno");
if(inscripto){
    System.out.println("Integrante agregado");
} else{
    System.out.println("Ha ocurrido un error");
}
        
      //  processRequest(request, response);
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


    
    //Metodo para actualizar el 
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Esto es un put ");
    }
    
    
    
    
      @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
//Eliminar integrante
        String legajo = request.getParameter("legajoEliminar");
        Conexion conec = new Conexion();
       IntegranteProyectoDAO proyectoDAO = new IntegranteProyectoDAO();
      boolean eliminado = proyectoDAO.eliminarIntegrante(legajo);
        
        System.out.println("Estado de eliminaicon" +eliminado);
    }
}
