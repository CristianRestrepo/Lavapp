
package com.planit.lavappweb.metodos;

import java.util.Random;

public class GenerarPassword {

    public static String generarPass(int longitud) {
        //Genera un cadena de la longitud enviada en el paremetro
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);//Obtiene un valor aleatorio
        int i = 0;
        while (i < longitud) {//Segun el valor obtenido en el random, lo traduce a un elemento del abecedario
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

}
