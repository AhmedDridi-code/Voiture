package com.voiture.repositories;

import com.voiture.entities.Client;

public interface ClientRepositoryCustom {

	Client getClientByName(String nom);
}
