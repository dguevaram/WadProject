/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wad.dao;

import com.wad.model.Usuario;
import com.wad.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    public void addUsuario(Usuario usuario){
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
        }finally{
            session.flush();
            session.close();
        }    
    }
    
    public Usuario loginUsuarioDAO(Usuario usuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Usuario usuarioaux = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Usuario u WHERE u.username = :userName and u.password = :password";
            System.out.println("LLego aqui");
            usuarioaux = (Usuario) session.createQuery(hql)
                    .setParameter("userName", usuario.getUsername())
                    .setParameter("password", usuario.getPassword())
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
        return usuarioaux;
    }
    public void deleteUsuario(int idUsuario){
        
    }
    public void updateUsuario(Usuario usuario){
        
    }
    public void getUsuario(Usuario usuario){
        
    }
}
