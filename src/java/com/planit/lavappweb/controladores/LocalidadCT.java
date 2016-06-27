/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Localidad_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosLocalidad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class LocalidadCT {

    private Localidad_TO localidad;
    private List<Localidad_TO> localidades;
    protected ServiciosLocalidad servicios;
    
    private String nombreOperacion;
    private int operacion;

    public LocalidadCT() {
        localidad = new Localidad_TO();
        localidades = new ArrayList<>();
        servicios = new ServiciosLocalidad();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        localidades = servicios.consultarLocalidades();
    }

    //Getter & Setter
    public Localidad_TO getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad_TO localidad) {
        this.localidad = localidad;
    }

    public List<Localidad_TO> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad_TO> localidades) {
        this.localidades = localidades;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }    
    

    //CRUD
    public void registrar() {
        localidad = servicios.registrarLocalidad(localidad.getNombre(), localidad.getCiudad().getIdCiudad());
        localidades = servicios.consultarLocalidades();
    }

    public void modificar() {
        localidad = servicios.editarLocalidad(localidad.getIdLocalidad(), localidad.getNombre(), localidad.getCiudad().getIdCiudad());
        localidades = servicios.consultarLocalidades();
    }

    public void eliminar() {
        localidad = servicios.eliminarLocalidad(localidad.getIdLocalidad());
        localidades = servicios.consultarLocalidades();
    }
    
    //Metodos
    //Metodos Propios
    public void metodo() {
        if (operacion == 0) {
            registrar();
        } else if (operacion == 1) {
            modificar();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion  = 0;
        }
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {            
            nombreOperacion = "Modificar";
        }
    }
    
    public void cancelar(){
        localidad = new Localidad_TO();
        localidades = servicios.consultarLocalidades();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
