package com.wad.model;
// Generated 12/06/2018 08:59:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private Grupo grupo;
     private TipoUsuario tipoUsuario;
     private String nombre;
     private String primerApellido;
     private String segundoApellido;
     private String username;
     private String password;
     private Set<Diagrama> diagramas = new HashSet<Diagrama>(0);

    public Usuario() {
    }

    public Usuario(Grupo grupo, TipoUsuario tipoUsuario, String nombre, String primerApellido, String segundoApellido, String username, String password, Set<Diagrama> diagramas) {
       this.grupo = grupo;
       this.tipoUsuario = tipoUsuario;
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.username = username;
       this.password = password;
       this.diagramas = diagramas;
    }
    public Usuario(String username, String password) {
       this.username = username;
       this.password = password;
    }

    public Usuario(Grupo grupo, TipoUsuario tipoUsuario, String nombre, String primerApellido, String segundoApellido, String username, String password) {
       this.grupo = grupo;
       this.tipoUsuario = tipoUsuario;
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.username = username;
       this.password = password;
    }

   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Diagrama> getDiagramas() {
        return this.diagramas;
    }
    
    public void setDiagramas(Set<Diagrama> diagramas) {
        this.diagramas = diagramas;
    }




}


