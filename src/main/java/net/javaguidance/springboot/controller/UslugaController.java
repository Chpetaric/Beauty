package net.javaguidance.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguidance.springboot.model.Usluga;
import net.javaguidance.springboot.service.UslugaService;

@Controller
public class UslugaController {

	@Autowired
	private UslugaService uslugaService;
	
	
	//display list of usluga
		@GetMapping("/showUsluga")
		public String viewHomePage(Model model) {
			model.addAttribute("listUsluga", uslugaService.getAllUsluga());
			return "index_usluga";
			
		}
		@GetMapping("/showNewUslugaForm")
		public String showNewUslugaForm(Model model) {
			Usluga usluga = new Usluga();
			model.addAttribute("usluga",usluga);
			return "new_usluga";
			
		}
		@PostMapping("/saveUsluga")
		public String saveUsluga(@ModelAttribute("usluga") Usluga usluga) {
			uslugaService.saveUsluga(usluga);
			return "redirect:/showUsluga";
		}
		
		@GetMapping("/showFormForUpdateUsluga/{id}")
		public String showFormForUpdateUsluga(@PathVariable(value = "id") long id, Model model) {
			Usluga usluga = uslugaService.getUslugaById(id);
			model.addAttribute("usluga",usluga);
			return "update_usluga";
			
		}
		
		@GetMapping("/deleteUsluga/{id}")
		public String deleteUsluga(@PathVariable(value = "id") long id, Model model) {
			this.uslugaService.deleteUslugaById(id);
			return "redirect:/showUsluga";
		}

	
}
