/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DTO;

/**
 *
 * @author orell
 */
public class ProyectoInvestigacionDTO {
    private String codProyecto;
    private String tituloProy;
    private String rol;

    public ProyectoInvestigacionDTO() {
    }

    public ProyectoInvestigacionDTO(String codProyecto, String tituloProy, String rol) {
        this.codProyecto = codProyecto;
        this.tituloProy = tituloProy;
        this.rol = rol;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getTituloProy() {
        return tituloProy;
    }

    public void setTituloProy(String tituloProy) {
        this.tituloProy = tituloProy;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
