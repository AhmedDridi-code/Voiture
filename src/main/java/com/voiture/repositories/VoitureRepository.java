package com.voiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {

}
