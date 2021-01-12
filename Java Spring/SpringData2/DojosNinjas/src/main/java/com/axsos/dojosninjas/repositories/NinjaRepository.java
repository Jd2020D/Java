package com.axsos.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	
}
