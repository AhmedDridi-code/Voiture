package com.voiture.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

 
@Entity

public class Voiture {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @Column(name="serie")
    private String serie;
     
    @Column(name="date_mise_en_marche")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateMiseEnMarche;
     
    @ManyToOne
    @JoinColumn(name="model_id")
    private Modele model;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;
    
    
  //getters setters 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getDateMiseEnMarche() {
		return dateMiseEnMarche;
	}

	public void setDateMiseEnMarche(Date dateMiseEnMarche) {
		this.dateMiseEnMarche = dateMiseEnMarche;
	}

	public Modele getModel() {
		return model;
	}

	public void setModel(Modele model) {
		this.model = model;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	
    
 
}