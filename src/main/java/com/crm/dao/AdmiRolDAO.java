package com.crm.dao;

import com.crm.model.AdmiRol;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class AdmiRolDAO extends BasicPersistence<AdmiRol> {


    public AdmiRolDAO() {
        super(AdmiRol.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}