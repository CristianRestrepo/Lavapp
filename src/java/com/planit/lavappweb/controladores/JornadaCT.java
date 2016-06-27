/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Jornada_TO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class JornadaCT {

    private Jornada_TO jornada;
    private List<Jornada_TO> jornadas;

    public JornadaCT() {
        jornada = new Jornada_TO();
        jornadas = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
    }

    //Getter & Setter
    public Jornada_TO getJornada() {
        return jornada;
    }

    public void setJornada(Jornada_TO jornada) {
        this.jornada = jornada;
    }

    public List<Jornada_TO> getJornadas() {
        return jornadas;
    }

    public void setJornadas(List<Jornada_TO> jornadas) {
        this.jornadas = jornadas;
    }

    //Metodos
    public void registrar(){
    }

    public void modificar(){
    }
    
    public void eliminar(){
    }
}

