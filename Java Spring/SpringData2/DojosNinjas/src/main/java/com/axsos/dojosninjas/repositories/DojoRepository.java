package com.axsos.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojosninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{
	
	
	List<Dojo> findAll() ;
	Optional<Dojo> findById(Long id) ;
	
}
