/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;

import com.wad.dao.UsuarioDAO;
import com.wad.model.Diagrama;
import com.wad.model.Grupo;
import com.wad.model.TipoUsuario;
import com.wad.model.Usuario;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
    private Grupo grupo;
    private String idgrupo;
    private TipoUsuario tipoUsuario;
    private String idtipousuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String username;
    private String password;
    private Set<Diagrama> diagramas = new HashSet<Diagrama>(0);
    
    public UsuarioBean() {
    }
    
    public String loginUsuario(){
        Usuario usuario= new Usuario(getUsername(), getPassword());
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        Usuario aux = usuarioDAO.loginUsuario(usuario);
        if(aux!=null){
            HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("sesionusuario", aux.getUsername());
            TipoUsuario tipo = aux.getTipoUsuario();
            //Administrador =1, Alumno = 2, Profesor = 3
            if(tipo.getIdTipo()==1){
                return "bienvenido";
            }
            if(tipo.getIdTipo()==2){
                return "bienvenidoAlumno";
            }
            if(tipo.getIdTipo()==3){
                return "bienvenidoProfesor";
            }  
        }
        else
            return "index";
        return "index";
    }

    
    public String addUsuario(){
        TipoUsuario tipo = new TipoUsuario(Integer.parseInt(idtipousuario));   
        this.tipoUsuario=tipo;
        Grupo grupo = new Grupo(Integer.parseInt(idgrupo));
        this.grupo = grupo;
        Usuario usuario= new Usuario(getGrupo(), getTipoUsuario(), getNombre(), getPrimerApellido(), getSegundoApellido(), getUsername(), getPassword());
        UsuarioDAO usuarioDAOaux = new UsuarioDAO();
        Usuario aux = usuarioDAOaux.verificarUsuario(usuario);
        if(aux != null){
            return "agregarUsuario";
        }
        else{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.addUsuario(usuario);
            return "bienvenido";
        }
    }
    
    public void deleteUsuario(){
        Usuario usuario = new Usuario(getUsername(), getPassword());
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        usuarioDAO.deleteUsuarioDAO(usuario);
    }
    
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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

    public Set<Diagrama> getDiagramas() {
        return diagramas;
    }

    public void setDiagramas(Set<Diagrama> diagramas) {
        this.diagramas = diagramas;
    }

    public String getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(String idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(String idtipousuario) {
        this.idtipousuario = idtipousuario;
    }
    
}
