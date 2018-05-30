package com.usuarios.bean;

import com.project.dao.UsuariosDAO;
import com.project.model.Usuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author danielguevara
 */
@ManagedBean( name = "usuariosBean")
@SessionScoped
public class UsuariosBean implements Serializable {

    private  Integer id;
    private  String username;
    private  String mail;
    private  String password;
    
    public UsuariosBean() {
        id=0;
        username= new String();
        mail = new String();
        password = new String();
    }
    
    public void addUsuarios(){
        Usuarios usuario = new Usuarios(getUsername(), getMail(), getPassword());
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        usuarioDAO.addUsuario(usuario);
    }
    
    public void deleteUsuarios(){
        Usuarios usuario = new Usuarios(getUsername(), getMail(), getPassword());
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        usuarioDAO.deleteUsuario(usuario);
    }
    
    public void updateUsuarios(){
        Usuarios usuario = new Usuarios(getUsername(), getMail(), getPassword());
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        usuarioDAO.updateUsuario(usuario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
