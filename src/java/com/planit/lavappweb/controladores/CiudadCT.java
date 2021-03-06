/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.CiudadDao;
import com.planit.lavappweb.modelo.dto.Ciudad_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class CiudadCT implements Serializable {

    //Variables
    private Ciudad_TO ciudad;
    private List<Ciudad_TO> ciudades;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar
    private String buscar;

    //Constructores
    public CiudadCT() {
        ciudad = new Ciudad_TO();
        ciudades = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        //Se carga la lista ciudades con las ciudades registradas
        CiudadDao ciudadDao = new CiudadDao();
        ciudades = ciudadDao.consultarCiudades();
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //CRUD   
    public void registrar() {
        CiudadDao ciudadDao = new CiudadDao();
        ciudad = ciudadDao.registrarCiudad(ciudad);
        ciudades = ciudadDao.consultarCiudades();
    }

    public void modificar() {
        CiudadDao ciudadDao = new CiudadDao();
        ciudad = ciudadDao.editarCiudad(ciudad);
        ciudades = ciudadDao.consultarCiudades();
    }

    public void eliminar() {
        CiudadDao ciudadDao = new CiudadDao();
        ciudad = ciudadDao.eliminarCiudad(ciudad);
        ciudades = ciudadDao.consultarCiudades();
    }

    //Metodos 
    public void metodo() {
        //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro
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
        //Setea un valor en la variable operacion para determinar que funcion realizara proximamente
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }

    public void cancelar() {
        //reinicia los valores de las variables y vuelve a 0 la bandera operacion
        CiudadDao ciudadDao = new CiudadDao();
        ciudad = new Ciudad_TO();
        ciudades = ciudadDao.consultarCiudades();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarCiudades() {
        //filtra la lista de ciudades segun el valor que se consulte, si valor es vacio consulta todos los barrios
        CiudadDao ciudadDao = new CiudadDao();
        ciudades = new ArrayList<>();
        if (buscar.isEmpty()) {
            ciudades = ciudadDao.consultarCiudades();
        } else {
            ciudades = ciudadDao.buscarCiudades(buscar);
        }
    }
}
