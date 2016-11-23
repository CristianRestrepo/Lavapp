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

    //Ruta para el acceso a los web services
    private static String rutas;

    public static String consultarRuta() {
        //Retorna la ruta de acceso de los web service
        rutas = "http://localhost:8084/LavappService/webresources/";
        //rutas = "http://xxxxxx:8084/LavappService/webresources/";

        return rutas;
    }

    //Getters & Setters
    public String getRutas() {
        return rutas;
    }

    public void setRutas(String rutas) {
        this.rutas = rutas;
    }
}
