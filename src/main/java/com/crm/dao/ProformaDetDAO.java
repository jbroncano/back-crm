package com.crm.dao;

import java.util.List;

import com.crm.model.ProformaDet;
import com.crm.persistence.BasicPersistence;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ProformaDetDAO extends BasicPersistence<ProformaDet> {


    public ProformaDetDAO() {
        super(ProformaDet.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<ProformaDet> findEstadoByCabeceraId(Long cabeceraId,String estado) {
        String jpql = "SELECT d FROM ProformaDet d " +
                      "WHERE d.proformaCab.idProformaCab = :cabeceraId " +
                      "AND d.estado = :estado";

        return getEntityManager()
                .createQuery(jpql, ProformaDet.class)
                .setParameter("cabeceraId", cabeceraId)
                .setParameter("estado", estado)
                .getResultList();
    }
}