package com.crm.dao;

import com.crm.model.ProformaCab;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ProformaCabDAO extends BasicPersistence<ProformaCab> {


    public ProformaCabDAO() {
        super(ProformaCab.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}