/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;


import com.wad.dao.DiagramaDAO;
import com.wad.model.Diagrama;
import com.wad.model.Imagen;
import com.wad.model.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danielguevara
 */
@ManagedBean(name = "diagramaBean")
@SessionScoped
public class DiagramaBean {
    
    private int idDiagrama;
    private Usuario usuario;
    private String clave;
    private String pregunta;
    private Set<Imagen> imagens = new HashSet<Imagen>(0);

    public DiagramaBean() {
    }
    
    public void agregarDiagrama(){
        HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuario = new Usuario(s.getAttribute("sesionusuario"));
        this.usuario=usuario;
        DiagramaDAO diagramaDAO = new DiagramaDAO();
        Diagrama diagrama = new Diagrama(getUsuario(), getClave(), getPregunta(), getImagens());
        diagramaDAO.addDiagrama(diagrama);
    }
    
     public void deleteDiagrama(){
        Diagrama diagrama = new Diagrama(getIdDiagrama());
        DiagramaDAO diagramaDAO= new DiagramaDAO();
        diagramaDAO.deleteDiagramaDAO(diagrama);
    }
    

    public int getIdDiagrama() {
        return idDiagrama;
    }

    public void setIdDiagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Set<Imagen> getImagens() {
        return imagens;
    }

    public void setImagens(Set<Imagen> imagens) {
        this.imagens = imagens;
    }
    
    
}
