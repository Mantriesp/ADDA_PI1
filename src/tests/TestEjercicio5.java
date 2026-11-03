package tests;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import ejercicios.Ejercicio4;
import ejercicios.Ejercicio5;
import us.lsi.common.Pair;
import us.lsi.common.String2;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio5 {

	// valores arbitrarios?
		private static Integer nMin = 100; // n mínimo para el cálculo de potencia
		private static Integer nMax = 20000; // n máximo para el cálculo de potencia
		private static Integer razon = 250; // incremento en los valores de n del cálculo de potencia
		private static Integer nIter = 300; // número de iteraciones para cada medición de tiempo
		private static Integer nIterWarmup = 10000; // número de iteraciones para warmup

		private static Integer n = 3; // valor arbitrario?
		
		public static void genData (Consumer<Integer> algorithm, String file) {
			Function<Integer,Long> f1 = GenData.time(algorithm);
			GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,razon,nIter,nIterWarmup);  // Aqui llamas a ejecucionAritmetica o ejecucionGeometrica dependiendo

		}
		
		public static void show(Fit pl, String file, String label) {
			List<WeightedObservedPoint> data = DataFile.points(file);
			pl.fit(data);
			MatPlotLib.show(file, pl.getFunction(), String.format("%s = %s",label,pl.getExpression()));
		}
		
		
		         
		public static void showCombined() {
			MatPlotLib.showCombined("Tiempos",
					List.of("C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecDouble.txt","C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecBig.txt",
							"C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItDouble.txt", "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItBig.txt"), 
					List.of("Recursiva Double", "Recursiva BigInteger", "Iterativa Double","Iterativa Big Integer"));
		}
		
		public static void main(String[] args) {
			genData(t -> Ejercicio5.ejercicio5RecDouble(n), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecDouble.txt"); // Ponemos el fichero ya creado o una ruta para crear uno?
			genData(t -> Ejercicio5.ejercicio5RecBigInteger(n), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecBig.txt");
			genData(t -> Ejercicio5.ejercicio5ItDouble(n), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItDouble.txt"); 
			genData(t -> Ejercicio5.ejercicio5ItBigInteger(n), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItBig.txt"); 
			
			
			show(PowerLog.of(List.of(Pair.of(1, 0.),Pair.of(2, 1.),Pair.of(3, 0.))), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecDouble.txt", "Recursiva Double");
			show(PowerLog.of(List.of(Pair.of(1, 0.),Pair.of(2, 1.),Pair.of(3, 0.))),"C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_RecBig.txt","Recursiva BigInteger");
			show(PowerLog.of(List.of(Pair.of(1, 0.),Pair.of(2, 1.),Pair.of(3, 0.))), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItDouble.txt", "Iterativa Double");
			show(PowerLog.of(List.of(Pair.of(1, 0.),Pair.of(2, 1.),Pair.of(3, 0.))), "C:\\Users\\Modo Empresario\\eclipse-workspace\\PI12627Base\\resources\\datos\\salida\\PI1Ejercicio5_ItBig.txt", "Iterativa BigInteger");
			
			showCombined();
			
	}

}