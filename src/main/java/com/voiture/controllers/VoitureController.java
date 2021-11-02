package com.voiture.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voiture.entities.Modele;
import com.voiture.entities.Voiture;
import com.voiture.services.ModelService;
import com.voiture.services.VoitureService;

@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	
	@Autowired
	private ModelService modelService;
	
	//Ajouter une voiture 
	
	//1- Retourner un forumlaire d'ajout
	
	@RequestMapping("/addVoiture")
	public String addVoiture(Model model) {
		
		Voiture voiture = new Voiture();
		List<Modele> listModel = modelService.listModel();
		
		model.addAttribute("VoitureForm", voiture);
		model.addAttribute("modelList", listModel);
		return "new_voiture";
	}
	
	//2- Ajout + redirection vers la liste des voitures
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture) {
		voitureService.saveVoiture(voiture);
		return "redirect:/";
	}
	
	//Liste des voitures
	
	@RequestMapping("/")
	public String listVoitures(Model model) {
	    List<Voiture> listVoitures = voitureService.listVoiture();
	    model.addAttribute("listVoitures", listVoitures);
	     
	    return "liste_voitures";
	}
	
	@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Voiture voiture = voitureService.getVoiture(id);
        model.addAttribute("voiture", voiture);
        return "update_voiture";
    }

    @PostMapping("update/{id}")
    public String updateVoiture(@PathVariable("id") long id, @Valid Voiture voiture, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            voiture.setId(id);
            return "update_voiture";
        }

        voitureService.saveVoiture(voiture);
        model.addAttribute("listVoitures", voitureService.listVoiture());
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteVoiture(@PathVariable("id") long id, Model model) {
     
    	voitureService.deleteVoiture(id);
        model.addAttribute("listVoitures", voitureService.listVoiture());
        return "redirect:/";
    }
}
