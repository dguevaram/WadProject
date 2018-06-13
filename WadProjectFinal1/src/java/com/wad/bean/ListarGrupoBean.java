/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;

import com.wad.dao.GrupoDAO;
import com.wad.model.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author danielguevara
 */
@ManagedBean(name = "listarGrupoBean")
@SessionScoped
public class ListarGrupoBean {
    private List<Grupo> grupo = new ArrayList<>();
    
    public ListarGrupoBean() {
    }
    
    @PostConstruct
    public void init(){
        GrupoDAO grupoDAO = new GrupoDAO();
        this.grupo=grupoDAO.listarGrupos();
    }

    public List<Grupo> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Grupo> grupo) {
        this.grupo = grupo;
    }
    
    
}
