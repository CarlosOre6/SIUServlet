/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DTO;

/**
 *
 * @author orell
 */
public class IntegranteProyectoDTO {

    private String legajoEst;
    private String codProyecto;
    private String nombre;
    private String apellido;
    private String rol;
    private String descripAct;//actividades que desarrolla el integrante
    private int hsSemanales;
    private String fechaInscripcion;
    private String estadoRegistro;
    private String tituloProy;

    public String getLegajoEst() {
        return legajoEst;
    }

    public void setLegajoEst(String legajoEst) {
        this.legajoEst = legajoEst;
    }

    public String getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(String codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripAct() {
        return descripAct;
    }

    public void setDescripAct(String descripAct) {
        this.descripAct = descripAct;
    }

    public int getHsSemanales() {
        return hsSemanales;
    }

    public void setHsSemanales(int hsSemanales) {
        this.hsSemanales = hsSemanales;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getTituloProy() {
        return tituloProy;
    }

    public void setTituloProy(String tituloProy) {
        this.tituloProy = tituloProy;
    }
    
    
}
