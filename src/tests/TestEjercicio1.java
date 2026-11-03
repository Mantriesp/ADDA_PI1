package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.ParEnteros;
import ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class TestEjercicio1 {

	// Sin argumentos ejecuta los tres bancos de pruebas (uso normal desde Eclipse).
	public static void main(String[] args) {
		if (args.length > 0) {
			testsEjercicio1(args[0]);
		} else {
			testsEjercicio1("PI1Ej1DatosEntrada.txt");
		}
	}
	
	public static void testsEjercicio1(String file) {
		
		Function<String, ParEnteros> parseParEnteros = s -> {
			String[] v = s.split(",");
			return ParEnteros.of(Integer.valueOf(v[0]), Integer.valueOf(v[1]));
		};
		List<ParEnteros> ls = Files2.streamFromFile("resources/datos/entrada/"+file).map(parseParEnteros).toList();

		System.out.println("================================");
		System.out.println("EJERCICIO 1. Fichero: " + file);
		System.out.println("================================");
		Ejercicio1.tests(ls);
		System.out.println();
		System.out.println(".............................................................................................................................");
	}

}
