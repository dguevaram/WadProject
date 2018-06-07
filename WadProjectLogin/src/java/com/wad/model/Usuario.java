package com.wad.model;

public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private TipoUsuario tipoUsuario;
     private String nombre;
     private String primerApellido;
     private String segundoApellido;
     private String username;
     private String password;

    public Usuario() {
    }

    public Usuario(TipoUsuario tipoUsuario, String nombre, String primerApellido, String segundoApellido, String username, String password) {
       this.tipoUsuario = tipoUsuario;
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.username = username;
       this.password = password;
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String username, String password) {
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.username = username;
       this.password = password;
    }
    
   public Usuario(String username, String password) {
       this.nombre = new String();
       this.primerApellido = new String();
       this.segundoApellido = new String();
       this.username = username;
       this.password = password;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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




}


