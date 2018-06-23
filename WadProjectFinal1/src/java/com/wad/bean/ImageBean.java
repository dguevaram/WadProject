package com.wad.bean;

import com.wad.dao.ImagenDAO;
import com.wad.model.Imagen;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author carlo
 */
@ManagedBean(name = "imageBean")
@SessionScoped
public class ImageBean implements Serializable {
    
    private List<Imagen> imagenes;
    private List<Imagen> selectedImagenes;
    private Imagen imagen;
    private ImagenDAO imagenDAO;
    private String nombre;
    private int idImagen;
    /**
     * Creates a new instance of ImageBean
     */
    public ImageBean() {
    }
    
    @PostConstruct
    public void init() {
        imagen = new Imagen();
        imagenDAO = new ImagenDAO();
        imagenes = imagenDAO.listarImagenes();
        selectedImagenes = new ArrayList<>();
    }
    
    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String imageId = context.getExternalContext().getRequestParameterMap().get("imageId");
            imagen = (Imagen) imagenDAO.encontrarPorId(Integer.valueOf(imageId));
            return new DefaultStreamedContent(new ByteArrayInputStream(imagen.getImg()));
        }
    }
    
     public String addImage(){
        Imagen imagen = new Imagen(getIdImagen());
        ImagenDAO imagenDao = new ImagenDAO();
        Imagen aux = imagenDAO.verificarImagen(imagen);
        if(aux != null){
            return "agregarImagen";
        }
        else{
            ImagenDAO imagenDAO = new ImagenDAO();
            imagenDAO.addImagen(imagen);
            this.imagenes=imagenDAO.listarImagenes();
            return "agregarDiagrama";
        }
    }
    public void onImageDrop(DragDropEvent ddEvent) {
        Imagen img = ((Imagen) ddEvent.getData());
  
        selectedImagenes.add(img);
        System.out.println(">>>>>>" + selectedImagenes.size());
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public List<Imagen> getSelectedImagenes() {
        return selectedImagenes;
    }

    public void setSelectedImagenes(List<Imagen> selectedImagenes) {
        this.selectedImagenes = selectedImagenes;
    }

    public ImagenDAO getImagenDAO() {
        return imagenDAO;
    }

    public void setImagenDAO(ImagenDAO imagenDAO) {
        this.imagenDAO = imagenDAO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
    
    
    
}
