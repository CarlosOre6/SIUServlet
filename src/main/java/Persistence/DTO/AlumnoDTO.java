/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence.DTO;

/**
 *
 * @author orell
 */
public class AlumnoDTO {
    
/*Todo los atributos*/
    String legajoEst;
    String apeAlumno;
    String nomAlumno;
    String DNI;
    String correo;

public AlumnoDTO(){}

/*Todo los codigos get*/
    public String getLegajoEst(){
        return legajoEst;
    }
    public String getApeAlumno(){
        return apeAlumno;
    }
    public String getNomAlumno(){
        return nomAlumno;
    }
    public String getDNI(){
        return DNI;
    }
    public String getCorreo(){
        return correo;
    }


/*Todo los codigos set*/
    public void setLegajoEst(String legajoEst){
        this.legajoEst = legajoEst;
    }
    public void setApeAlumno(String apeAlumno){
        this.apeAlumno = apeAlumno;
    }
    public void setNomAlumno(String nomAlumno){
        this.nomAlumno = nomAlumno;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
}
