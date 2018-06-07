/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.dao;

import com.wad.model.TipoUsuario;
import com.wad.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TipoUsuarioDAO {
    public void addTipoUsuario(TipoUsuario tipousuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(tipousuario);
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
    
    public TipoUsuario obtenerTipoUsuarioDAO(TipoUsuario tipousuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        TipoUsuario tipoaux = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM TipoUsuario t WHERE t.nb_tipo = :num";
            System.out.println("LLego aqui");
            tipoaux = (TipoUsuario) session.createQuery(hql)
                    .setParameter("num", tipousuario.getNbTipo())
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
        return tipoaux;
    }
    
    public void deleteTipoUsuario(int idUsuario){
        
    }
    public void updateTipoUsuario(TipoUsuario tipousuario){
        
    }
    public void getTipoUsuario(TipoUsuario tipousuario){
        
    }
}
