package ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ejercicios.Ejercicio3.Tupla;


public class Ejercicio3 {
	public static record Tupla(Integer a, Integer b, Integer c) {
		public static Tupla of(Integer a, Integer b, Integer c) {
			return new Tupla(a, b, c);
		}
	}
	
	public static Set<Integer> ejercicio3RecursivoSinMemoria(Integer a, Integer b, Integer c) { 
		Set<Integer> r = new HashSet<>();
		if (a <= 5 || b <= 3 || c <= 2) {
			r.add(a + 2);
			r.add(b * 3);
			r.add(c);
		} else if (a <= 8 || b <= 6 || c <= 4) {
			r.add(a);
			r.add(b + 2);
			r.add(c * 3);
		} else {
			r.addAll(ejercicio3RecursivoSinMemoria(a/2, b - 3, c/4));
			r.addAll(ejercicio3RecursivoSinMemoria(a - 3, b/3, c - 2));
		}
		
		return r;
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, Integer c) {
		return ejercicio3RecursivoConMemoria(a, b, c, new HashMap<>());	
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, Integer c, Map<Tupla, Set<Integer>> m) {
			Set<Integer> r = new HashSet<>();
			Tupla key = Tupla.of(a, b, c);
			if(m.containsKey(key)) {
				r= m.get(key);
			} else {
				if (a <= 5 || b <= 3 || c <= 2) {
					r.add(a + 2);
					r.add(b * 3);
					r.add(c);
				} else if (a <= 8 || b <= 6 || c <= 4) {
					r.add(a);
					r.add(b + 2);
					r.add(c * 3);
				} else {
					r.addAll(ejercicio3RecursivoConMemoria(a/2, b - 3, c/4, m));
					r.addAll(ejercicio3RecursivoConMemoria(a - 3, b/3, c - 2, m));
				}
				m.put(Tupla.of(a, b, c), r);
			}
			return r;
	}
	
	public static Set<Integer> ejercicio3Iterativo(Integer a, Integer b, Integer c) {
		Map<Tupla, Set<Integer>> m = new HashMap<>();
		Set<Integer> v = new HashSet<>();
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					v = new HashSet<>();
					if (i <= 5 || j <= 3 || k <= 2) {
						v.add(i + 2);
						v.add(j * 3);
						v.add(k);
					} else if (i <= 8 || j <= 6 || k <= 4) {
						v.add(i);
						v.add(j + 2);
						v.add(k * 3);
					} else {
						v.addAll(m.get(Tupla.of(i/2, j - 3, k/4)));
						v.addAll(m.get(Tupla.of(i - 3, j/3, k - 2)));
					}
					m.put(Tupla.of(i, j, k), v);
				}
			}
		}
		return m.get(Tupla.of(a, b, c));
	}
}
