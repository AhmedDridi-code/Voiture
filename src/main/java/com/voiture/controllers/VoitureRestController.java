package com.voiture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.services.VoitureService;
import com.voiture.entities.Voiture;

@RestController
public class VoitureRestController {

	@Autowired
	private VoitureService voitureService;
	
	@GetMapping("/voitures")
	public ResponseEntity<List<Voiture>> getAllVoitures(){
		try {
			List<Voiture> voitures = voitureService.listVoiture();
			
			if(voitures.isEmpty()) {
				return new ResponseEntity<List<Voiture>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Voiture>>(voitures, HttpStatus.OK);
		
		}
		catch (Exception e) {
			return new ResponseEntity<List<Voiture>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

	  @GetMapping("/voitures/{id}")
	  public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") long id) {
	    Voiture voiture = voitureService.getVoiture(id);

	    if (voiture != null) {
	      return new ResponseEntity<Voiture>(voiture, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<Voiture>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/addVoiture")
	  public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture) {
	    try {
	    	voitureService.saveVoiture(voiture);
	      return new ResponseEntity<Voiture>(voiture, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<Voiture>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  } 

	  @PutMapping("/voitures/{id}")
	  public ResponseEntity<Voiture> 
	  updateVoiture(@PathVariable("id") long id, @RequestBody Voiture voiture) {
		  Voiture _voiture = voitureService.getVoiture(id);
				  
	    if (_voiture != null) {
	      Voiture newvoiture = _voiture;
	      newvoiture.setSerie(voiture.getSerie());
	      newvoiture.setDateMiseEnMarche(voiture.getDateMiseEnMarche());
	      voitureService.saveVoiture(newvoiture);
	      return new ResponseEntity<Voiture>( HttpStatus.OK);
	    } else {
	      return new ResponseEntity<Voiture>(HttpStatus.NOT_FOUND);
	    }
	  } 

	  @DeleteMapping("/voitures/{id}")
	  public ResponseEntity<HttpStatus> deleteVoiture(@PathVariable("id") long id) {
	    try {
	    	voitureService.deleteVoiture(id);
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping("/Deletevoitures")
	  public ResponseEntity<HttpStatus> deleteAllVoitures() {
	    try {
	      voitureService.deleteAll();
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }
}
