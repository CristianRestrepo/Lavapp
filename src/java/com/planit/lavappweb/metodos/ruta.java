/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;

/**
 *
 * @author Gustavo
 */
public class ruta {
    
    private static String rutas;
    
    public static String consultarRuta(){
     rutas = "http://localhost:8084/LavappService/webresources/";
//    
//    rutas = "http://xxxxxx:8084/LavappService/webresources/";
    
    return rutas;
    }

    public String getRutas() {
        return rutas;
    }

    public void setRutas(String rutas) {
        this.rutas = rutas;
    }
    
    
    
}