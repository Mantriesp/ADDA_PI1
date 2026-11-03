package ejercicios;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	
/*
	 *	En principio tampoco hay una  
*/
	
	public static void tests(List<ParEnteros> ls) {
		ls.forEach(t -> {
			System.out.println();
			System.out.println("1) Solucion Funcional: " + funcional(t.a(), t.b()));
			System.out.println("2) Solucion Iterativo: " + iterativo(t.a(), t.b()));
			System.out.println("3) Solucion Rec. Final: " + solucionRecursivaFinal(t.a(), t.b()));
		});
		
	}
	
	
	public static String funcional(Integer varA, Integer varB) {	
		UnaryOperator<EnteroCadena> nx = elem ->  
		{ 
			return EnteroCadena.of(elem.a()+3, 
						elem.a()%2==0? 
						elem.a()+"*": 
						elem.a()+"!"); 
		}; 
		return Stream.iterate(EnteroCadena.of(varA,"A"), elem -> elem.a() < varB, nx) 
					.filter(elem -> elem.a()%10 != 0) 
					.map(elem -> elem.s())  
					.collect(Collectors.joining("-"));
	} 


	public static String iterativo(Integer varA, Integer varB) { 
		EnteroCadena e = EnteroCadena.of(varA, "A");
		String ac = "";
		Boolean b2 = true;
		while (e.a() < varB) {
			if (e.a()%10!= 0)
				if (b2) {
					ac = e.s();
					b2 = false;
				} else 
					ac = ac + "-" + e.s();
				
				e =  EnteroCadena.of(e.a() + 3, e.a()%2==0? e.a()+"*":e.a()+"!");
				}
		return ac;		
		}

	
	public static String solucionRecursivaFinal(Integer varA, Integer varB) {
		return recFinal(EnteroCadena.of(varA, "A"), "", true, varA, varB);
	}
	
	public static String recFinal(EnteroCadena e, String ac, boolean b2, Integer varA, Integer varB) {
		String r = ac;
		if (e.a() < varB) {
			if (e.a()%10!= 0) {
				if (b2) {
					ac = e.s();
					b2 = false;
				} else 
					ac = ac + "-" + e.s();

			}
			e = EnteroCadena.of(e.a() + 3, e.a()%2==0? e.a()+"*":e.a()+"!");
			r = recFinal(e, ac, b2, varA, varB);
		}
		return r;
	}
}
