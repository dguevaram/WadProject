package com.wad.model;
// Generated 12/06/2018 08:59:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Diagrama generated by hbm2java
 */
public class Diagrama  implements java.io.Serializable {


     private int idDiagrama;
     private Usuario usuario;
     private String clave;
     private String pregunta;
     private Set<Imagen> imagens = new HashSet<Imagen>(0);

    public Diagrama() {
    }

	
    public Diagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    public Diagrama(int idDiagrama, Usuario usuario, String clave, String pregunta, Set<Imagen> imagens) {
       this.idDiagrama = idDiagrama;
       this.usuario = usuario;
       this.clave = clave;
       this.pregunta = pregunta;
       this.imagens = imagens;
    }
   
    public int getIdDiagrama() {
        return this.idDiagrama;
    }
    
    public void setIdDiagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public Set<Imagen> getImagens() {
        return this.imagens;
    }
    
    public void setImagens(Set<Imagen> imagens) {
        this.imagens = imagens;
    }




}


