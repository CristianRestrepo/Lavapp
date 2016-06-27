/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import static com.planit.lavappweb.metodos.Configuracion.operacion;
import com.planit.lavappweb.modelos.Ciudad_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCiudad;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class CiudadCT {

    private Ciudad_TO ciudad;
    private List<Ciudad_TO> ciudades;
    protected ServiciosCiudad servicios;

    private String nombreOperacion;

    public CiudadCT() {
        ciudad = new Ciudad_TO();
        ciudades = new ArrayList<>();
        servicios = new ServiciosCiudad();
        nombreOperacion = "Registrar";
    }

    @PostConstruct
    public void init() {
        ciudades = servicios.consultarCiudades();
    }

    //Getters & Setters
    public Ciudad_TO getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad_TO ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudad_TO> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad_TO> ciudades) {
        this.ciudades = ciudades;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //CRUD   
    public void registrar() {
        ciudad = servicios.registrarCiudad(ciudad.getNombre(), ciudad.getDepartamento().getIdDepartamento());
        ciudades = servicios.consultarCiudades();
    }

    public void modificar() {
        ciudad = servicios.editarCiudad(ciudad.getIdCiudad(), ciudad.getNombre(), ciudad.getDepartamento().getIdDepartamento());
        ciudades = servicios.consultarCiudades();
    }

    public void eliminar() {
        ciudad = servicios.eliminarCiudad(ciudad.getIdCiudad());
        ciudades = servicios.consultarCiudades();
    }

    //Metodos 
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
        ciudad = new Ciudad_TO();
        ciudades = servicios.consultarCiudades();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
