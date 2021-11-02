package com.voiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom {

}
