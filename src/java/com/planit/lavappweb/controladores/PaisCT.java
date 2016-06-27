/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Pais_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosPais;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class PaisCT {

    private Pais_TO pais;
    private List<Pais_TO> paises;
    private ServiciosPais servicios;
    private List<String> nombrepaises;

    //Variables   
    private String nombreOperacion;
    private int operacion;
        
    public PaisCT() {
        pais = new Pais_TO();
        paises = new ArrayList<>();
        servicios = new ServiciosPais();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        paises = servicios.consultarPaises();
    }

    //Getters & Setter
    public Pais_TO getPais() {
        return pais;
    }

    public void setPais(Pais_TO pais) {
        this.pais = pais;
    }

    public List<Pais_TO> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais_TO> paises) {
        this.paises = paises;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public List<String> getNombrepaises() {
        nombrepaises = new ArrayList<>();
        for (int i = 0; i < paises.size(); i++) {
            nombrepaises.add(paises.get(i).getNombre());
        }
        return nombrepaises;
    }

    public void setNombrepaises(List<String> nombrepaises) {
        this.nombrepaises = nombrepaises;
    }

    //CRUD
    public void registrar() {
        pais = servicios.registrarPais(pais.getNombre());
        paises = servicios.consultarPaises();
    }

    public void modificar() {
        pais = servicios.modificarPais(pais.getIdPais(), pais.getNombre());
        paises = servicios.consultarPaises();
    }

    public void eliminar() {
        pais = servicios.eliminarPais(pais.getIdPais());
        paises = servicios.consultarPaises();
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
        pais = new Pais_TO();
        paises = servicios.consultarPaises();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
