package net.javaguidance.springboot.service;

import java.util.List;


import net.javaguidance.springboot.model.Profesional;

public interface ProfesionalService {

	List<Profesional> getAllProfesionals();
	void saveProfesional(Profesional profesional);
	Profesional getProfesionalById(long id);
	void deleteProfesionalById(long id);
}
