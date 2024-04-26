/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DTO;

/**
 *
 * @author orell
 */
public class UsuarioDTO {
    
    private String usuario;
    private String password;
    private String rol;
    private String legajo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String usuario, String password, String rol, String legajo) {
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.legajo = legajo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    
    
    
}
