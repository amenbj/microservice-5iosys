 package com.Dossierclient.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping(value = "/api/projets")

public class ProjetRestApi {
	
	private String title = "Hello, I'm the Projet Microservice";
	@Autowired
	private ProjetService ProjetService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Projet> createAssuré(@RequestBody Projet Projet) {
		return new ResponseEntity<>(ProjetService.addAssuré(Projet), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projet> updateAssuré(@PathVariable(value = "id") int id,
    										@RequestBody Projet Projet){
		return new ResponseEntity<>(ProjetService.updateAssuré(id, Projet), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteAssuré(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(ProjetService.deleteAssuré(id), HttpStatus.OK);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Projet> getAllCandidats(){
		return ProjetService.GetCandidats();
	}

}
