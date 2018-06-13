/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.dao;

import com.wad.model.Grupo;
import com.wad.model.Usuario;
import com.wad.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author danielguevara
 */
public class GrupoDAO {
    public void addGrupo(Grupo grupo){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(grupo);
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
    
    public List<Grupo> listarGrupos(){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List <Grupo> grupos = null;
        try{
            tx = session.beginTransaction();
           String hql = "from Grupo";
            grupos = (List<Grupo>) session.createQuery(hql).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }
        return grupos;
    }

    public void deleteGrupo(Grupo grupo) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Grupo grupoaux = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Grupo g where g.nombre = :Nombre";
            grupoaux = (Grupo) session.createQuery(hql)
                    .setParameter("Nombre", grupo.getNombre())
                    .uniqueResult();
            session.delete(grupoaux);
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
}
