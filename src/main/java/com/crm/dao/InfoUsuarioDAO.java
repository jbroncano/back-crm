package com.crm.dao;


import com.crm.model.InfoUsuario;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Stateless
public class InfoUsuarioDAO extends BasicPersistence<InfoUsuario> {


    public InfoUsuarioDAO() {
        super(InfoUsuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public InfoUsuario findByName(String name) {
        String jpql = "SELECT u FROM InfoUsuario  u WHERE u.usuario LIKE :name";
        TypedQuery<InfoUsuario> query = getEntityManager().createQuery(jpql, InfoUsuario.class);
        query.setParameter("name", "%" + name + "%");  // Búsqueda parcial del nombre
        query.setMaxResults(1);  // Limitar a un solo resultado
        return query.getResultList().stream().findFirst().orElse(null);  // Retorna el primer resultado o null si no existe
    }

}