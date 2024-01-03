	package com.Dossierclient.projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





public interface ProjetRepository extends JpaRepository<Projet, Integer>{
	
	@Query("select c from Projet c where c.nom like :nom")
	public Page<Projet> candidatByNom(@Param("nom") String n, Pageable pageable);

}
