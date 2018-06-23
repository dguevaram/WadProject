/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.dao;

import com.wad.model.Imagen;
import com.wad.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author danielguevara
 */
public class ImagenDAO {
    public List<Imagen> listarImagenes(){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Imagen> imagenes = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Imagen";
            imagenes = (List<Imagen>) session.createQuery(hql).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }  
        return imagenes;
    }
    
    public Imagen encontrarPorId(Integer id){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Imagen imagen = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Imagen im where im.idImagen=:id";
            imagen = (Imagen) session.createQuery(hql).
                    setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }  
        return imagen;
    }
    
    public void eliminarPorId(Integer id){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        ImagenDAO imagendao = new ImagenDAO();
        Imagen imagen = imagendao.encontrarPorId(id);
        try{
            tx = session.beginTransaction();
            session.delete(imagen);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }
    }
    
    public void addImagen(Imagen imagen){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(imagen);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }    
    }
    public Imagen verificarImagen(Imagen imagen) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Imagen imagenaux = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Imagen i where i.idImagen = :IdImagen";
            imagenaux = (Imagen) session.createQuery(hql)
                    .setParameter("IdImagen", imagen.getIdImagen())
                    .uniqueResult();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }
        return imagenaux;
    }
}
