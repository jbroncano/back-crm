package com.crm.dao;

import com.crm.model.InfoPersona;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class InfoPersonaDAO extends BasicPersistence<InfoPersona> {


    public InfoPersonaDAO() {
        super(InfoPersona.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}