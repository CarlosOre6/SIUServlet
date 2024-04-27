/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DAO;

import Persistence.Conexion;
import Persistence.DTO.IntegranteProyectoDTO;
import Persistence.DTO.ProyectoInvestigacionDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orell
 */
public class IntegranteProyectoDAO {

    public ArrayList<ProyectoInvestigacionDTO> obtenerProyectos(String legajoDoc) {
        ArrayList<ProyectoInvestigacionDTO> list = new ArrayList<ProyectoInvestigacionDTO>();
        Conexion conec = new Conexion();
        String sql = "select codProyecto,tituloProy,rol from proyecto_investigacion natural join docente_proyecto_investigacion natural join docente where legajoDoc = '" + legajoDoc + "' and (rol = 'director' or rol = 'codirector') and estadoRegistro='activo';";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProyectoInvestigacionDTO vo = new ProyectoInvestigacionDTO();
                vo.setCodProyecto(rs.getString(1));
                vo.setTituloProy(rs.getString(2));
                vo.setRol(rs.getString(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }


    
     public ArrayList<IntegranteProyectoDTO> buscarIntegrantes(String codProyecto){
        ArrayList<IntegranteProyectoDTO> list = new ArrayList<IntegranteProyectoDTO>();
        
        Conexion conec = new Conexion();
        String sql1 = "select legajoEst,codProyecto,nomAlumno,apeAlumno,rol,descripAct,hsSemanales,fechaInscripcion,estadoRegistro from alumno natural join alumno_investigacion where codProyecto= '"+codProyecto+"' and rol <> 'director' and rol <> 'codirector' and estadoRegistro='activo'  ;";
        String sql2 = "select legajoDoc,codProyecto,nomDoc, apeDoc,rol,descripAct,hsSemanales,fechaInscripcion, estadoRegistro from docente natural join docente_proyecto_investigacion where codProyecto= '"+codProyecto+"' and rol <> 'director' and rol <> 'codirector'and estadoRegistro='activo'  ;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()){
                IntegranteProyectoDTO dto = new IntegranteProyectoDTO();
                dto.setLegajoEst(rs.getString(1));
                dto.setCodProyecto(rs.getString(2));
                dto.setNombre(rs.getString(3));
                dto.setApellido(rs.getString(4));
                dto.setRol(rs.getString(5));
                dto.setDescripAct(rs.getString(6));
                dto.setHsSemanales(rs.getInt(7));
                dto.setFechaInscripcion(rs.getString(8));
                dto.setEstadoRegistro(rs.getString(9));
                list.add(dto);
            }
            ps = conec.getConnection().prepareStatement(sql2);
            rs = ps.executeQuery();
            while(rs.next()){
                IntegranteProyectoDTO dto = new IntegranteProyectoDTO();
                dto.setLegajoEst(rs.getString(1));
                dto.setCodProyecto(rs.getString(2));
                dto.setNombre(rs.getString(3));
                dto.setApellido(rs.getString(4));
                dto.setRol(rs.getString(5));
                dto.setDescripAct(rs.getString(6));
                dto.setHsSemanales(rs.getInt(7));
                dto.setFechaInscripcion(rs.getString(8));
                dto.setEstadoRegistro(rs.getString(9));
                list.add(dto);
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
        return list;
    }
    

//
     
    public boolean incribir(IntegranteProyectoDTO vo, String tipo){
        
           /**
         * 1: Existente activo
         * 0: exitente inactivo
         * -1: inexistente
         * 2: implica que se agrego
         */
        
        
        Conexion conec = new Conexion();
        String sql_1 = "INSERT INTO alumno_investigacion (legajoEst, codProyecto, rol, fechaInscripcion, hsSemanales, descripAct, estadoRegistro) VALUES(?, ?, ?, ?, ?, ?, ?);";
        String sql_2 = "INSERT INTO docente_proyecto_investigacion (legajoDoc, codProyecto, rol, fechaInscripcion, hsSemanales, descripAct, estadoRegistro) VALUES(?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        
            try{
            
                if(tipo.equals("alumno")){
                
                    ps = conec.getConnection().prepareStatement(sql_1);
                
                }else{
                    ps = conec.getConnection().prepareStatement(sql_2);
                    }
                ps.setString(1, vo.getLegajoEst());
                ps.setString(2, vo.getCodProyecto());
                ps.setString(3, vo.getRol());
                ps.setString(4, vo.getFechaInscripcion());
                ps.setInt(5, vo.getHsSemanales());
                ps.setString(6, vo.getDescripAct());
                //Agregar Set
                ps.setString(7, "activo");
                ps.executeUpdate();            
                
                        return true ;

            }
                
            catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
          
        
    }
    
    
    
    
}

     
   
    
     
     
     //
     


    

