package org.cibertec;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Persona {
	private String nombre, web; //modificador private es opcional debido a la clase lombok
	private int edad; 
	
	public Persona (String nombre, String web, int edad) {
		this.nombre = nombre;
		this.web = web;
		this.edad = edad;
	}
}
