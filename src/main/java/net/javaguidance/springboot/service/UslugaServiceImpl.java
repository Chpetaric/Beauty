package net.javaguidance.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.javaguidance.springboot.model.Usluga;
import net.javaguidance.springboot.repository.UslugaRepository;

@Service
public class UslugaServiceImpl implements UslugaService{

	@Autowired
	private UslugaRepository uslugaRepository;
	
	
	
	@Override
	public List<Usluga> getAllUsluga() {
		return uslugaRepository.findAll();
	}

	@Override
	public void saveUsluga(Usluga usluga) {
		this.uslugaRepository.save(usluga);
	}

	@Override
	public Usluga getUslugaById(long id) {
		 Optional<Usluga> optional = uslugaRepository.findById(id);
		    Usluga usluga = null;
		    if(optional.isPresent()) {
		    	usluga=optional.get();
		    }
		    else {
		    	throw new RuntimeException("Usluga not found"+id);
		    }
		    return usluga;
	}

	@Override
	public void deleteUslugaById(long id) {
		this.uslugaRepository.deleteById(id);
		
	}

}
