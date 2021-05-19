package net.javaguidance.springboot.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

//@Entity
public class Termin {
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date dateAppointment;
	 
	 
	 
	 
	 

}
