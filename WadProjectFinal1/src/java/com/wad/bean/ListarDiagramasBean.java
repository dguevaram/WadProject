package com.wad.bean;

import com.wad.dao.DiagramaDAO;
import com.wad.dao.UsuarioDAO;
import com.wad.model.Diagrama;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author carlo
 */
@Named(value = "listarDiagramasBean")
@Dependent
public class ListarDiagramasBean {

    private List<Diagrama> diagramas = new ArrayList<>();
    
    public ListarDiagramasBean() {
    }
    
    @PostConstruct
    public void init(){
        DiagramaDAO diagramaDAO= new DiagramaDAO();
        this.diagramas = diagramaDAO.listarDiagramas();
    }
    public List<Diagrama> getDiagramas() {
        return diagramas;
    }

    public void setDiagramas(List<Diagrama> diagramas) {
        this.diagramas = diagramas;
    }
    
    
}
