package com.Dossierclient.assuré;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









@Service
public class planningService {
	@Autowired
	private planningRepository planningRepository;
	
	
	
	//ajouter un assurée
	
	public planning addAssuré(planning planning) {
		return planningRepository.save(planning);
	}
	
	//mise a jour un assureé
	
	public planning updateAssuré(int id, planning newAssuré) {
		if (planningRepository.findById(id).isPresent()) {
			planning existingCandidat = planningRepository.findById(id).get();
			existingCandidat.setNom(newAssuré.getNom());
			existingCandidat.setPrenom(newAssuré.getPrenom());
			existingCandidat.setadresse(newAssuré.getadresse());

			return planningRepository.save(existingCandidat);
		} else
			return null;
	}
	
	
	//supprimer un assuré
	public String deleteAssuré(int id) {
		if (planningRepository.findById(id).isPresent()) {
			planningRepository.deleteById(id);
			return "planning supprimé";
		} else
			return "planning non supprimé";
	}
	
	//Obtenir tous les candidats
		public  List<planning> GetCandidats() {
			return planningRepository.findAll();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
