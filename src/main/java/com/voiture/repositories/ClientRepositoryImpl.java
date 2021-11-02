package com.voiture.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.voiture.entities.Client;

public class ClientRepositoryImpl {

	@PersistenceContext
	EntityManager em; 
	
	public Client getClientByName(String nom) {
		Query query = em.createNativeQuery("select c from Client c where "
				+ "c.name LIKE ?", Client.class);
		query.setParameter(1, nom + "%");
	
		return (Client) query.getSingleResult();
	}
	
}
