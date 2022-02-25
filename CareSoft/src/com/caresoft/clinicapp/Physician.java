package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA{

//... importa definición de clase...
    
    // Dentro de la clase:    
    private ArrayList<String> patientNotes;
	
    // PARA HACER: Constructor que tome un ID
    public Physician(Integer id) {
    	super(id);
    }
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
	
    @Override
    public boolean assignPin(int pin) {
    	if (String.valueOf(pin).length() == 4) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (this.id == confirmedAuthID) {
    		return true;
    	}
    	else {
    		return false; 
    	}
    }
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
    // PARA HACER: Setters y Getters
	
	
}
