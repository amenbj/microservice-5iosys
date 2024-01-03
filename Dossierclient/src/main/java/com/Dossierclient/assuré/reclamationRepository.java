package com.Dossierclient.assuré;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





public interface reclamationRepository extends JpaRepository<reclamation, Integer>{
	
	@Query("select c from reclamation c where c.nom like :nom")
	public Page<reclamation> candidatByNom(@Param("nom") String n, Pageable pageable);

}
