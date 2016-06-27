/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Descuento_TO;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class DescuentoCT {

    private Descuento_TO descuento;
    private List<Descuento_TO> descuentos;
    
    public DescuentoCT() {
    }
    
    @PostConstruct
    public void init() {
    }
    
    //Getter & Setter
    public Descuento_TO getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento_TO descuento) {
        this.descuento = descuento;
    }

    public List<Descuento_TO> getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(List<Descuento_TO> descuentos) {
        this.descuentos = descuentos;
    }
    
    //Metodos
    public void registrar(){
    }
    
    public void modificar(){
    }
    
    public void eliminar(){
    }
    
}
