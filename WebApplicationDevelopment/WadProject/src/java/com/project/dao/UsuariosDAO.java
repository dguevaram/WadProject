/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.model.Usuarios;
import com.project.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author danielguevara
 */
public class UsuariosDAO {

    public UsuariosDAO() {
    }
    
    public void addUsuario(Usuarios usuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }/*finally{
            session.flush();
            session.close();
        } */    
    }
    
    public void deleteUsuario(Usuarios usuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.delete(usuario);
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
    
    public void updateUsuario(Usuarios usuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.update(usuario);
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
    
    public Usuarios getUsuarioByID(int idUsuarios){
        return null;
    }



}
