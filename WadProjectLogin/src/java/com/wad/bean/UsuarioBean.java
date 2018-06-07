/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;
 
import com.wad.dao.TipoUsuarioDAO;
import com.wad.dao.UsuarioDAO;
import com.wad.model.TipoUsuario;
import com.wad.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danielguevara
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Integer idUsuario;
    private String idTipo;
    private TipoUsuario tipoUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String username;
    private String password;
    
    public UsuarioBean() {
        
    }
    
    public String addUsuario(){
        Usuario usuario= new Usuario(getNombre(), getPrimerApellido(), getSegundoApellido(), getUsername(), getPassword());
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        usuarioDAO.addUsuario(usuario);
        return "iniciarSesion";
    }
    
    public String loginUsuario(){
        Usuario usuario= new Usuario(getUsername(), getPassword());
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        Usuario aux = usuarioDAO.loginUsuarioDAO(usuario);
        if(aux!=null){
            System.out.println(">>>>>>VIVA<<<<<<<<");
            HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("sesionusuario", aux.getUsername());
            return "bienvenido";
        }
        else
            return "iniciarSesion";
    }
    
    public void addUsuarioPrueba(){
        TipoUsuario tipo = new TipoUsuario(Integer.parseInt(idTipo));   
        this.tipoUsuario=tipo;
        Usuario usuario= new Usuario(getTipoUsuario(), getNombre(), getPrimerApellido(), getSegundoApellido(), getUsername(), getPassword());
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        usuarioDAO.addUsuario(usuario);
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    
}
