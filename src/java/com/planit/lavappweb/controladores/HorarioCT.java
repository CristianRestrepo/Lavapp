/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Horario_TO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class HorarioCT {

    private Horario_TO horario;
    private List<Horario_TO> horarios;

    public HorarioCT() {
        horario = new Horario_TO();
        horarios = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
    }

    //Getter & Setter
    public Horario_TO getHorario() {
        return horario;
    }

    public void setHorario(Horario_TO horario) {
        this.horario = horario;
    }

    public List<Horario_TO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario_TO> horarios) {
        this.horarios = horarios;
    }

    //Metodos
    public void registrar(){
    }
    
    public void modificar(){
    }
    
    public void eliminar(){
    }
}
