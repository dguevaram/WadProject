/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.dao;

import com.wad.model.Diagrama;
import com.wad.model.Usuario;
import com.wad.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author danielguevara
 */
public class DiagramaDAO {
    public void addDiagrama(Diagrama diagrama){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(diagrama);
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
    
/*    public Integer getMaxId(){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Integer auxId = null;
        try{
            tx = session.beginTransaction();            
            String hql = "SELECT max(id_diagrama)FROM Diagrama d";
            //System.out.println("LLego aqui");
            auxId = (Integer) session.createQuery(hql).uniqueResult();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }
        return auxId;
    }
*/
    public void deleteDiagramaDAO(Diagrama diagrama) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Diagrama diagramaaux = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Diagrama d WHERE d.idDiagrama = :idDiagrama";
            diagramaaux = (Diagrama) session.createQuery(hql)
                    .setParameter("userName", diagrama.getIdDiagrama())
                    .uniqueResult();
            session.delete(diagramaaux);
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
    
    public List<Diagrama> listarDiagramas(){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Diagrama> diagramas = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Diagrama";
            diagramas = (List<Diagrama>) session.createQuery(hql).list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
        }finally{
            session.flush();
            session.close();
        }  
        return diagramas;
    }
}
