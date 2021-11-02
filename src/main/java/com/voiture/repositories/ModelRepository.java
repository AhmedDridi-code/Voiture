package com.voiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.entities.Modele;

public interface ModelRepository extends JpaRepository<Modele, Long>, ModelRepositoryCustom {

}
