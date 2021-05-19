package net.javaguidance.springboot.service;

import java.util.List;

import net.javaguidance.springboot.model.Usluga;

public interface UslugaService {

	List<Usluga> getAllUsluga();
	void saveUsluga(Usluga usluga);
	Usluga getUslugaById(long id);
	void deleteUslugaById(long id);
}
