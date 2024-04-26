/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DAO;

import Persistence.Conexion;
import Persistence.DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orell
 */
public class UsuarioDAO {
    public UsuarioDTO buscarUsuario(String usuario){
         Conexion conec = new Conexion();
            String sql = "SELECT * FROM cuentausuario where usuario = '"+usuario+"';";
            ResultSet rs = null;
            PreparedStatement ps = null;
            UsuarioDTO usuarioBD = new UsuarioDTO();
            
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
           while (rs.next())
           {
            usuarioBD.setUsuario(rs.getString(1));
            usuarioBD.setPassword(rs.getString(2));
            usuarioBD.setRol(rs.getString(3));
           }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

        try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
            
        }
        if (usuarioBD != null){
            return usuarioBD;
        }else{
            return null;
        }
            }
}
