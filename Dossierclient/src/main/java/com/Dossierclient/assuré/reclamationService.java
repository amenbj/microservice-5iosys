package com.Dossierclient.assuré;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









@Service
public class reclamationService {
	@Autowired
	private reclamationRepository reclamationRepository;
	
	
	
	//ajouter un assurée
	
	public reclamation addAssuré(reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}
	
	//mise a jour un assureé
	
	public reclamation updateAssuré(int id, reclamation newAssuré) {
		if (reclamationRepository.findById(id).isPresent()) {
			reclamation existingCandidat = reclamationRepository.findById(id).get();
			existingCandidat.setNom(newAssuré.getNom());
			existingCandidat.setPrenom(newAssuré.getPrenom());
			existingCandidat.setadresse(newAssuré.getadresse());

			return reclamationRepository.save(existingCandidat);
		} else
			return null;
	}
	
	
	//supprimer un assuré
	public String deleteAssuré(int id) {
		if (reclamationRepository.findById(id).isPresent()) {
			reclamationRepository.deleteById(id);
			return "reclamation supprimé";
		} else
			return "reclamation non supprimé";
	}
	
	//Obtenir tous les candidats
		public  List<reclamation> GetCandidats() {
			return reclamationRepository.findAll();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
