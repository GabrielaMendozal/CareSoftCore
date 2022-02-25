package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//... importa definición de clase...
public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA{


    
    // Dentro de la clase:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
	
    // PARA HACER: Implementar un constructor que tome un ID y un rol  ??????why
    public UsuarioAdmin( Integer id, String role) {
		super(id);
		this.employeeID = id;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
 

    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    @Override
    public boolean assignPin(int pin) {
    	if (String.valueOf(pin).length() >= 6) {
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
    		this.authIncident();
    		return false; 
    	}
    }
    		
     // PARA HACER: ¡Implementar AdminCompatibleConHIPAA
    @Override
	public ArrayList<String> reportSecurityIncidents(){
    	return this.getSecurityIncidents();
    }
    public void newIncident(String notes) {
        String report = String.format(
            "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
	public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }


	public Integer getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}


	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
        // PARA HACER: Setters y Getters
	
}

