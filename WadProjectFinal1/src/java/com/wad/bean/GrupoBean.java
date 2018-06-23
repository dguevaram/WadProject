package com.wad.bean;

import com.wad.dao.GrupoDAO;
import com.wad.model.Grupo;
import com.wad.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author danielguevara
 */
@ManagedBean(name = "grupoBean")
@SessionScoped
public class GrupoBean implements Serializable{
    
    private Integer idGrupo;
    private String nombre;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);
    private List<Grupo> grupo = new ArrayList<>();
    public GrupoBean() {
    }
    
    public String addGroup(){
        Grupo grupo = new Grupo(getNombre());
        GrupoDAO grupoDAOverificador = new GrupoDAO();
        Grupo aux = grupoDAOverificador.verificarGrupo(grupo);
        if(aux != null){
            return "agregarGrupo";
        }
        else{
            GrupoDAO grupoDAO = new GrupoDAO();
            grupoDAO.addGrupo(grupo);
            this.grupo=grupoDAO.listarGrupos();
            return "bienvenido";
        }
    }
    
    public String deleteGroup(){
        Grupo grupo = new Grupo(getNombre());
        GrupoDAO grupoDAO = new GrupoDAO();
        grupoDAO.deleteGrupo(grupo);
        this.grupo=grupoDAO.listarGrupos();
        return "eliminarGrupo";
    }
    
    @PostConstruct
    public void listarGrupos(){
        GrupoDAO grupoDAO = new GrupoDAO();
        this.grupo=grupoDAO.listarGrupos();
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Grupo> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Grupo> grupo) {
        this.grupo = grupo;
    }
    
}
