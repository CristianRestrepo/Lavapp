/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosServicios;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServicioCT {

    private Servicio_TO servicio;
    private List<Servicio_TO> servicios;
    protected ServiciosServicios clienteServicio;

    //Variables
    private String nombreOperacion;
    protected int operacion;

    public ServicioCT() {
        servicio = new Servicio_TO();
        servicios = new ArrayList<>();
        clienteServicio = new ServiciosServicios();

        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        servicios = clienteServicio.consultarServicios();
    }

    //Getter & Setter
    public Servicio_TO getServicio() {
        return servicio;
    }

    public void setServicio(Servicio_TO servicio) {
        this.servicio = servicio;
    }

    public List<Servicio_TO> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio_TO> servicios) {
        this.servicios = servicios;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos   
    public void registrar() {
        servicio = clienteServicio.registrarServicio(servicio.getNombre());
        servicios = clienteServicio.consultarServicios();
    }

    public void modificar() {
        servicio = clienteServicio.editarServicio(servicio.getIdServicio(), servicio.getNombre());
        servicios = clienteServicio.consultarServicios();
    }

    public void eliminar() {
        servicio = clienteServicio.eliminarServicio(servicio.getIdServicio());
        servicios = clienteServicio.consultarServicios();
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
        servicio = new Servicio_TO();
        servicios = clienteServicio.consultarServicios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
