package tests;

import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio3;
import ejercicios.Ejercicio3.Tupla;
import us.lsi.streams.Stream2;

public class TestEjercicio3 {
	
	// Sin argumentos ejecuta los tres bancos de pruebas (uso normal desde Eclipse).
	public static void main(String[] args) {
		if (args.length > 0) {
			testsEjercicio3(args[0]);
		} else {
			testsEjercicio3("PI1Ej3DatosEntrada.txt");
		}
	}
	
	public static void testsEjercicio3(String file) {
		Function<String, Tupla> parseTupla = s -> {
			String[] v = s.split(",");
			return Tupla.of(Integer.valueOf(v[0]), Integer.valueOf(v[1]), Integer.valueOf(v[2]));
		};
		
		List<Tupla> ls = Stream2.file("resources/datos/entrada/"+file)
				.map(parseTupla)
				.toList();
		
		System.out.println("================================");
		System.out.println("EJERCICIO 3. Fichero: " + file);
		System.out.println("================================");
		ls.forEach(p -> {
			System.out.println("1) Solucion R. Sin Mem.: " + Ejercicio3.ejercicio3RecursivoSinMemoria(p.a(), p.b(),p.c()));
			System.out.println("2) Solucion R. Con Mem.: " + Ejercicio3.ejercicio3RecursivoConMemoria(p.a(), p.b(),p.c()));
			System.out.println("3) Solucion Iterativa:   " + Ejercicio3.ejercicio3Iterativo(p.a(), p.b(),p.c()));
			System.out.println("________________________________");
		});
		System.out.println(".............................................................................................................................");
	}

}
