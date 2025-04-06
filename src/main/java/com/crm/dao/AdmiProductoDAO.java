package com.crm.dao;

import com.crm.model.AdmiProducto;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;

@Stateless
public class AdmiProductoDAO  extends BasicPersistence<AdmiProducto> {


    public AdmiProductoDAO() {
        super(AdmiProducto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}