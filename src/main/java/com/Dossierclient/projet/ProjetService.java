package com.Dossierclient.projet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









@Service
public class ProjetService {
	@Autowired
	private ProjetRepository ProjetRepository;
	
	
	
	//ajouter un assurée
	
	public Projet addAssuré(Projet Projet) {
		return ProjetRepository.save(Projet);
	}
	
	//mise a jour un assureé
	
	public Projet updateAssuré(int id, Projet newAssuré) {
		if (ProjetRepository.findById(id).isPresent()) {
			Projet existingCandidat = ProjetRepository.findById(id).get();
			existingCandidat.setNom(newAssuré.getNom());
			existingCandidat.setPrenom(newAssuré.getPrenom());
			existingCandidat.setadresse(newAssuré.getadresse());

			return ProjetRepository.save(existingCandidat);
		} else
			return null;
	}
	
	
	//supprimer un assuré
	public String deleteAssuré(int id) {
		if (ProjetRepository.findById(id).isPresent()) {
			ProjetRepository.deleteById(id);
			return "Projet supprimé";
		} else
			return "Projet non supprimé";
	}
	
	//Obtenir tous les candidats
		public  List<Projet> GetCandidats() {
			return ProjetRepository.findAll();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
