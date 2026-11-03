package ejercicios;

import java.math.BigInteger;

public class Ejercicio5 {

	public static Double ejercicio5ItDouble(Integer n) {
		Double r = 1.;
		while(!(n <= 6)) {
			r = 1 + r * log2(n - 1);
			n -=1;
		}
		return r;
	}
	
	public static Double ejercicio5RecDouble(Integer n) {
		Double r = 0.;
		if(n <= 6) {
			r = 1.;
		} else {
			r = 1 + ejercicio5RecDouble(n -1) * log2(n - 1);
		}
		return r;
	}
	
	public static BigInteger ejercicio5ItBigInteger(Integer n) {
		BigInteger r = BigInteger.valueOf(1);
		while(!(n <= 6)) {
			r = r.add(BigInteger.valueOf(1).multiply(BigInteger.valueOf(log2(n - 1)))); // Resto el 1 a n en el log2 o con decrementarlo despues ya me vale?
			n -= 1;
		}
		return r;
	}
	
	public static BigInteger ejercicio5RecBigInteger(Integer n) {
		BigInteger r = BigInteger.valueOf(0);
		if(n <= 6) {
			r = BigInteger.valueOf(1);
		} else {
			r = BigInteger.valueOf(1).add(ejercicio5RecBigInteger(n - 1)).multiply(BigInteger.valueOf(log2(n - 1)));
		}
		return r;
	}

	public static int log2(int n){
	    if(n <= 0) throw new IllegalArgumentException();
	    return 31 - Integer.numberOfLeadingZeros(n);
	}
}