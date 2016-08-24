/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Estrato_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosEstrato;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class EstratoCT {

    private Estrato_TO estrato;
    private List<Estrato_TO> estratos;
    protected ServiciosEstrato servicios;
    
    //variables
    private String nombreOperacion;
    private int operacion;
    private String buscar;
    
    public EstratoCT() {
        estrato = new Estrato_TO();
        estratos = new ArrayList<>();
        servicios = new ServiciosEstrato();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        estratos = servicios.consultarEstratos();
    }

    //Getter & Setter
    public Estrato_TO getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato_TO estrato) {
        this.estrato = estrato;
    }

    public List<Estrato_TO> getEstratos() {
        return estratos;
    }

    public void setEstratos(List<Estrato_TO> estratos) {
        this.estratos = estratos;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos
    public void registrar() {
        estrato = servicios.registrarEstrato(estrato.getNombre());
        estratos = servicios.consultarEstratos();
    }

    public void modificar() {
        estrato = servicios.editarEstrato(estrato.getIdEstrato(), estrato.getNombre());
        estratos = servicios.consultarEstratos();
    }

    public void eliminar() {
        estrato = servicios.eliminarEstrato(estrato.getIdEstrato());
        estratos = servicios.consultarEstratos();
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
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
    
    public void cancelar(){
        estrato = new Estrato_TO();
        estratos = servicios.consultarEstratos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
    
    public void buscarEstratos(){
        estratos = new ArrayList<>();
        if(buscar == null){
            estratos = servicios.consultarEstratos();
        }else{
            estratos = servicios.buscarEstratos(buscar);
        }
    }

}
