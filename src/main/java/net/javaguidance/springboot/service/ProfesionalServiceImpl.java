package net.javaguidance.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.javaguidance.springboot.model.Profesional;
import net.javaguidance.springboot.repository.ProfesionalRepository;


@Service
public class ProfesionalServiceImpl implements ProfesionalService{

	@Autowired
	private ProfesionalRepository profesionalRepository;
	
	@Override
	public List<Profesional> getAllProfesionals() {
		return profesionalRepository.findAll();
	}

	@Override
	public void saveProfesional(Profesional profesional) {
		this.profesionalRepository.save(profesional);
	}

	@Override
	public Profesional getProfesionalById(long id) {
	    Optional<Profesional> optional = profesionalRepository.findById(id);
	    Profesional profesional = null;
	    if(optional.isPresent()) {
	    	profesional=optional.get();
	    }
	    else {
	    	throw new RuntimeException("Profesional not found"+id);
	    }
	    return profesional;
	}

	@Override
	public void deleteProfesionalById(long id) {
		this.profesionalRepository.deleteById(id);
		
	}

	
	
}
