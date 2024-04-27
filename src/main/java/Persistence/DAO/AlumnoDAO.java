/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DAO;

import Persistence.Conexion;
import Persistence.DTO.AlumnoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author orell
 */
public class AlumnoDAO {
    
    
      public AlumnoDTO buscarAlumno(String legajo){
        AlumnoDTO vo = null;
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM alumno where legajoEst='"+legajo+"';";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                vo = new AlumnoDTO();
                vo.setLegajoEst(rs.getString(1));
                
                vo.setApeAlumno(rs.getString(2));
                vo.setNomAlumno(rs.getString(3));
                vo.setDNI(rs.getString(4));
                vo.setCorreo(rs.getString(5));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return vo;
      }
       
       public ArrayList<AlumnoDTO> buscarAlumnos(){
        ArrayList<AlumnoDTO> listadoAlumnos = new ArrayList<AlumnoDTO>() ;
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM alumno ;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                AlumnoDTO vo = new AlumnoDTO();
                vo.setLegajoEst(rs.getString(1));
                
                vo.setApeAlumno(rs.getString(2));
                vo.setNomAlumno(rs.getString(3));
                vo.setDNI(rs.getString(4));
                vo.setCorreo(rs.getString(5));
                listadoAlumnos.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return listadoAlumnos;
      }
}
