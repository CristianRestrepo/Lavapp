/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Barrio_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosBarrios;
import com.planit.lavappweb.webservices.implementaciones.ServiciosEstrato;
import com.planit.lavappweb.webservices.implementaciones.ServiciosLocalidad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosZona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class BarrioCT {

    private Barrio_TO barrio;
    private List<Barrio_TO> barrios;
    protected ServiciosBarrios servicios;
    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar

    public BarrioCT() {
        barrio = new Barrio_TO();
        barrios = new ArrayList<>();
        servicios = new ServiciosBarrios();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        barrios = servicios.consultarBarrios();
    }

    //Getters & Setters
    public Barrio_TO getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio_TO barrio) {
        this.barrio = barrio;
    }

    public List<Barrio_TO> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio_TO> barrios) {
        this.barrios = barrios;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos    
    public void registrar() {
        ServiciosLocalidad Sl = new ServiciosLocalidad();
        ServiciosZona Sz = new ServiciosZona();
        ServiciosEstrato Se = new ServiciosEstrato();

        barrio.setEstrato(Se.consultarEstrato(barrio.getEstrato().getIdEstrato(), barrio.getEstrato().getNombre()));
        barrio.setLocalidad(Sl.consultarLocalidad(barrio.getLocalidad().getIdLocalidad(), barrio.getLocalidad().getNombre()));
        barrio.setZona(Sz.consultarZona(barrio.getZona().getIdZona(), barrio.getZona().getNombre()));

        barrio = servicios.registrarBarrio(barrio.getNombre(),
                barrio.getLocalidad().getIdLocalidad(),
                barrio.getZona().getIdZona(),
                barrio.getEstrato().getIdEstrato());
        barrios = servicios.consultarBarrios();
    }

    public void modificar() {

        ServiciosLocalidad Sl = new ServiciosLocalidad();
        ServiciosZona Sz = new ServiciosZona();
        ServiciosEstrato Se = new ServiciosEstrato();

        barrio.setEstrato(Se.consultarEstrato(barrio.getEstrato().getIdEstrato(), barrio.getEstrato().getNombre()));
        barrio.setLocalidad(Sl.consultarLocalidad(barrio.getLocalidad().getIdLocalidad(), barrio.getLocalidad().getNombre()));
        barrio.setZona(Sz.consultarZona(barrio.getZona().getIdZona(), barrio.getZona().getNombre()));

        barrio = servicios.editarBarrio(barrio.getIdBarrios(),
                barrio.getNombre(),
                barrio.getLocalidad().getIdLocalidad(),
                barrio.getZona().getIdZona(),
                barrio.getEstrato().getIdEstrato());
        barrios = servicios.consultarBarrios();
    }

    public void eliminar() {
        barrio = servicios.eliminarBarrio(barrio.getIdBarrios());
        barrios = servicios.consultarBarrios();
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
        barrio = new Barrio_TO();
        barrios = servicios.consultarBarrios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
