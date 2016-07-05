/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Jornada_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosJornadas;
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
    protected ServiciosJornadas servicios;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar

    public JornadaCT() {
        jornada = new Jornada_TO();
        jornadas = new ArrayList<>();
        servicios = new ServiciosJornadas();

        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        jornadas = servicios.consultarJornadas();
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

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos
    public void registrar() {
        jornada = servicios.registraJornada(jornada.getNombre());
        jornadas = servicios.consultarJornadas();
    }

    public void modificar() {
        jornada = servicios.editarJornada(jornada.getIdJornada(), jornada.getNombre());
        jornadas = servicios.consultarJornadas();
    }

    public void eliminar() {
        jornada = servicios.eliminarJornada(jornada.getIdJornada());
        jornadas = servicios.consultarJornadas();
    }

    //Metodos Propios
    public void metodo() {
        if (operacion == 0) {
            registrar();
        } else if (operacion == 1) {
            modificar();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }

    public void cancelar() {
        jornada = new Jornada_TO();
        //barrios = servicios.consultarBarrios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
