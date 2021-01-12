package com.axsos.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.repositories.DojoRepository;
import com.axsos.dojosninjas.repositories.NinjaRepository;

@Service
public class AppService {
	 private final DojoRepository dojoRepository;
	 private final NinjaRepository ninjaRepository;
	public AppService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
		
	}
	public  Dojo createDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	public List<Dojo> allDojos(){
		return this.dojoRepository.findAll();
	}
	public Dojo getDojoById(Long id) {
		Optional<Dojo> dojo= this.dojoRepository.findById(id);
		if(dojo.isPresent())
			return dojo.get();
		return null;
	}
	public boolean isDojoExist(Long id) {
		return this.dojoRepository.existsById(id);
	}

}
