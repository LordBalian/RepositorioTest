package org.cibertec;

//la primera pregunta del examen es parte de la tarea de Git y GitHub -- NO OLVIDAAAR GIT Y GITHUB

//se colocan todas estas nuevas importaciones de depencias
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//si, son muchas

public class EscribirExcel {
	
	public static void crearAPartirDeArrayList() {
		ArrayList<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("Oliver Atom", "https://parzibyte.me", 60));
		personas.add(new Persona("Ramus Aram", "https://toy.lerdorf.com/", 53));
		personas.add(new Persona("Brian Kerrigan", "https://www.cs.princeton.edu/~bwk/", 80));
		
		Workbook libro = new XSSFWorkbook(); //con esto creamos un excel llamado libro
		final String nombreArchivo = "Personas.xlsx";
		Sheet hoja = libro.createSheet("Personas"); //creamos una hoja del libro Personas
		
		String[] encabezados = {"Nombre", "Web", "Edad"}; //colocamos los encabezados de la tabla
		int indiceFila = 0;
		
		Row fila = hoja.createRow(indiceFila); //con esto llenamos cada fila con la informacion usada para llenar el array
		for(int i = 0; i<encabezados.length; i++) {
			String encabezado = encabezados[i];
			Cell celda = fila.createCell(i);
			celda.setCellValue(encabezado);
		}
		
		indiceFila++;
		for (int i = 0; i<personas.size();i++) {
			fila = hoja.createRow(indiceFila);
			Persona persona = personas.get(i);
			fila.createCell(0).setCellValue(persona.getNombre());
			fila.createCell(1).setCellValue(persona.getWeb());
			fila.createCell(2).setCellValue(persona.getEdad());
			indiceFila++;
		}
		
		//Guardamos
		File directorioActual = new File (".");
		String ubicacion = directorioActual.getAbsolutePath();
		String ubicacionArchivoSalida = ubicacion.substring(0, ubicacion.length()-1) + nombreArchivo;
		
		FileOutputStream outputStream;
		
		try {
			outputStream = new FileOutputStream(ubicacionArchivoSalida);
			libro.write(outputStream);
			libro.close();
			System.out.println("Libro de personas guardado correctamente");
		}catch (FileNotFoundException ex) {
			System.out.println("Error de filenotfound");
		}catch (IOException ex) {
			System.out.println("Error de IOException");
		}	
	}
	
	public static void main(String[] args) {
		crearAPartirDeArrayList();
	}
}

// Al ejecutar deberia aparecer: 2025-05-30T16:56:57.744055800Z main ERROR Log4j API could not find a logging provider.
//Libro de personas guardado correctamente
