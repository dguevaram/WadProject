/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;

import com.wad.dao.UsuarioDAO;
import com.wad.model.Usuario;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author danielguevara
 */
@ManagedBean(name= "listarUsuariosBean")
@SessionScoped
public class ListarUsuariosBean implements Serializable {

    private List<Usuario> usuarios = new ArrayList<>();

    /**
     * Creates a new instance of ListarUsuariosBean
     */
    public ListarUsuariosBean() {
    }
    
    @PostConstruct
    public void init(){
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        this.usuarios = usuarioDAO.listarUsuarios();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
