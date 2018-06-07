/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.bean;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author danielguevara
 */
@ManagedBean(name= "cerrarSessionBean")
@SessionScoped
public class CerrarSessionBean implements Serializable {

    private String id;
    private HttpServletRequest request;
    private FacesContext fc;
    
    public CerrarSessionBean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest)fc.getExternalContext().getRequest();
        
        if(request.getSession().getAttribute("sesionusuario")!=null){
            id = (String) request.getSession().getAttribute("sesionusuario");
        }
    }
    
    public String cerrarSession(){
        request.getSession().removeAttribute("sesionusuario");
        return "index";
    }
    
}
