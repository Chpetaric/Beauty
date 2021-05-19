package net.javaguidance.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguidance.springboot.model.Profesional;
import net.javaguidance.springboot.service.CustomerService;
import net.javaguidance.springboot.service.EmployeeService;
import net.javaguidance.springboot.service.ProfesionalService;
import net.javaguidance.springboot.service.UslugaService;

@Controller
public class ProfesionalController {

	@Autowired
	private ProfesionalService profesionalService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UslugaService uslugaService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomeProfesional(Model model) {
		model.addAttribute("listProfesionals", profesionalService.getAllProfesionals());
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		model.addAttribute("listUsluga", uslugaService.getAllUsluga());
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		//model.addAttribute("user", new User());
		return "index";		
	}
	
	@GetMapping("/showProfesional")
	public String viewHomePage(Model model) {
		model.addAttribute("listProfesionals", profesionalService.getAllProfesionals());
		return "index_profesional";
	}
	
	@GetMapping("/showNewProfesionalForm")
	public String showNewProfesionalForm(Model model) {
		Profesional profesional = new Profesional();
		model.addAttribute("profesional",profesional);
		return "new_profesional";
		
	}
	
	
	@PostMapping("/saveProfesional")
	public String saveProfesional(@ModelAttribute("profesional") Profesional profesional) {
		profesionalService.saveProfesional(profesional);
		return "redirect:/showProfesional";
	}
	
	@GetMapping("/showFormForUpdateProfesional/{id}")
	public String showFormForUpdateProfesional(@PathVariable(value = "id") long id, Model model) {
		Profesional profesional = profesionalService.getProfesionalById(id);
		model.addAttribute("profesional",profesional);
		return "update_profesional";
		
	}
	
	@GetMapping("/deleteProfesional/{id}")
	public String deleteProfesional(@PathVariable(value = "id") long id, Model model) {
		this.profesionalService.deleteProfesionalById(id);
		return "redirect:/showProfesional";
	}

}
