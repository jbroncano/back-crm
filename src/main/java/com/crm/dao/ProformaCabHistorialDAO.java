package com.crm.dao;

import com.crm.model.ProformaCabHistorial;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ProformaCabHistorialDAO extends BasicPersistence<ProformaCabHistorial> {


    public ProformaCabHistorialDAO() {
        super(ProformaCabHistorial.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}