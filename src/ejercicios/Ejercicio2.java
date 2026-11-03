package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
	
	public static List<String> ejercicio2RecursivoNoFinal(Integer a, String s){
		List<String> r = new ArrayList<>();
		if (a<=2 || s.length()<=2) {
			r.add(Integer.toString(a) + s);
		} else if (a%2==0) {
			r = ejercicio2RecursivoNoFinal(a/2, s.substring(0, s.length() - 2));
			r.add(Integer.toString(a));
		} else {
			r = ejercicio2RecursivoNoFinal(a/3, s.substring(0, s.length() - 1));
			r.add(Integer.toString(a) + s.substring(0, a%s.length()));
		}
		return r;
	}
	
	public static List<String> ejercicio2Iterativo(Integer a, String s){
		List<String> ac = new ArrayList<>();
		while (!(a <= 2 || s.length()<= 2)) {
			if (a%2==0) {
				ac.add(0, Integer.toString(a));
				a /= 2;
				s = s.substring(0, s.length() - 2);
			} else {
				ac.add(0, Integer.toString(a) + s.substring(0, a%s.length()));
				a /= 3;
				s = s.substring(0, s.length() - 1);
			}
		}
		ac.add(0, Integer.toString(a) + s);
		return ac;
	}
	
	
	public static List<String> ejercicio2RecursivoFinal(Integer a, String s) {
		return ejercicio2RecursivoFinal(a, s, new ArrayList<>());
	}
	
	public static List<String> ejercicio2RecursivoFinal(Integer a, String s, List<String> ac) {
		if (a <= 2 || s.length()<= 2) {
			ac.add(0, Integer.toString(a) + s);
		} else if (a%2==0) {
			ac.add(0, Integer.toString(a));
			ejercicio2RecursivoFinal(a/2, s.substring(0, s.length() - 2), ac);
		} else {
			ac.add(0, Integer.toString(a) + s.substring(0, a%s.length()));
			ejercicio2RecursivoFinal(a/3, s.substring(0, s.length() - 1), ac);
		}
		return ac;
	}
	
	private static record Tupla(Integer a, String s, List<String> ac) {
		public static Tupla of(Integer a, String s, List<String> ac) {
			return new Tupla(a, s, ac);
		}
		
		public static Tupla first(Integer a, String s) {
			return of(a, s, new ArrayList<>());
		}
		
		public Tupla next() {
			return null;
			//return of()
		}

	public static List<String> ejercicio2NotacionFuncional(Integer a, String s){
			return null;
		}
		
		
		
		
	}
	
}
