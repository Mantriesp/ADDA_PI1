package ejercicios;

import java.math.BigInteger;

public class Ejercicio4 {
	
	public static Double funcRecDouble(Integer a) { 
        Double r = 0.;
        if (a < 10) {
        	r = 5.;
        } else {
        	r = funcRecDouble(a - 2) * Math.sqrt(3 * a);
        }
        return r;
	}
	
	public static BigInteger funcRecBig(Integer a) {
        BigInteger r = BigInteger.valueOf(0);
        BigInteger aux = BigInteger.valueOf(3 * a);
        if (a < 10) {
        	r = BigInteger.valueOf(5);
        } else {
        	r = funcRecBig(a - 2);
        	r = r.multiply(aux.sqrt());
        }
        return r;
	}
	
	public static Double funcItDouble(Integer a) {
        Double r = 5.;
        while(!(a < 10)) {
        	r = r * Math.sqrt(a * 3);
        	a -= 2;
        }
        return r;
	}
	
	public static BigInteger funcItBig(Integer a) {
        BigInteger r = BigInteger.valueOf(0);
        while(!(a < 10)) {
            BigInteger aux = BigInteger.valueOf(3 * a);
        	r = r.multiply(aux.sqrt());
        	a -= 2;
        }
        return r.add(BigInteger.valueOf(5));
	}

}