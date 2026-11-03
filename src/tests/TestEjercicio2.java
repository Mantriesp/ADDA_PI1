package tests;

import java.util.List;

import ejercicios.Ejercicio2;
import us.lsi.common.Pair;
import us.lsi.streams.Stream2;

public class TestEjercicio2 {
	
	// Sin argumentos ejecuta los tres bancos de pruebas (uso normal desde Eclipse).
	public static void main(String[] args) {
		if (args.length > 0) {
			testsEjercicio2(args[0]);
		} else {
			testsEjercicio2("PI1Ej2DatosEntrada.txt");
		}
	}
	
	public static void testsEjercicio2(String file) {
		List<Pair<Integer,String>> ls = Stream2.file("resources/datos/entrada/"+file)
				.map(s -> Pair.parse(s,",",s1->Integer.parseInt(s1),s2->s2))
				.toList();
		// Explicar diferencia entre Stream2.file(_) y Files2.streamFromFile(_)
		System.out.println("================================");
		System.out.println("EJERCICIO 2. Fichero: " + file);
		System.out.println("================================");
		ls.forEach(p -> {
			System.out.println("1) Solucion R. NO Final: " + Ejercicio2.ejercicio2RecursivoNoFinal(p.first(), p.second()));
			System.out.println("2) Solucion R. Final:    " + Ejercicio2.ejercicio2RecursivoFinal(p.first(), p.second()));
			System.out.println("3) Solucion Iterativa:   " + Ejercicio2.ejercicio2Iterativo(p.first(), p.second()));
			//System.out.println("4) Solucion Funcional:   " + Ejercicio2.ejercicio2NotacionFuncional(p.first(), p.second()));
			System.out.println("____________________________________________________");
		});
		System.out.println(".............................................................................................................................");
	}
	
}
