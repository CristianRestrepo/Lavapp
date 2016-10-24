/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

/**
 *
 * @author VaioDevelopment
 */
public class RutaCT {

    //Variables
    private String rutaimagenes;

    //Constructor
    public RutaCT() {
        //La ruta tiene configurada la direccion donde estan guardadas las imagenes de las prendas y categorias del sistema
        rutaimagenes = "http://190.146.144.78/LavaApp";
    }
    
    //Getters & Setters
    public String getRutaimagenes() {
        return rutaimagenes;
    }

    public void setRutaimagenes(String rutaimagenes) {
        this.rutaimagenes = rutaimagenes;
    }
    
    

}
