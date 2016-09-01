/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dto.Color_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class ColorCT implements Serializable {

    private Color_TO color;
    private List<Color_TO> colores;

    public ColorCT() {
        color = new Color_TO();
        colores = new ArrayList<>();
    }

    @PostConstruct
    public void init() {

    }

    //Getters & Setter
    public Color_TO getColor() {
        return color;
    }

    public void setColor(Color_TO color) {
        this.color = color;
    }

    public List<Color_TO> getColores() {
        return colores;
    }

    public void setColores(List<Color_TO> colores) {
        this.colores = colores;
    }

    //Metodos
    public void registrar() {
    }

    public void modificar() {
    }

    public void eliminar() {
    }
}
