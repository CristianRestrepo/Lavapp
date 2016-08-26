/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.LocalidadDao;
import com.planit.lavappweb.modelo.dto.Localidad_TO;
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
    
    private String nombreOperacion;
    private int operacion;
    private String buscar;

    public LocalidadCT() {
        localidad = new Localidad_TO();
        localidades = new ArrayList<>();        
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        LocalidadDao localidadDao = new LocalidadDao();
        localidades = localidadDao.consultarLocalidades();
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
    
    

    //CRUD
    public void registrar() {
        LocalidadDao localidadDao = new LocalidadDao();
        localidad = localidadDao.registrarLocalidad(localidad);
        localidades = localidadDao.consultarLocalidades();
    }

    public void modificar() {
        LocalidadDao localidadDao = new LocalidadDao();
        localidad = localidadDao.modificarLocalidad(localidad);
        localidades = localidadDao.consultarLocalidades();
    }

    public void eliminar() {
        LocalidadDao localidadDao = new LocalidadDao();
        localidad = localidadDao.eliminarLocalidad(localidad);
        localidades = localidadDao.consultarLocalidades();
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
        LocalidadDao localidadDao = new LocalidadDao();
        localidad = new Localidad_TO();
        localidades = localidadDao.consultarLocalidades();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
    
    public void buscarLocalidades(){
        LocalidadDao localidadDao = new LocalidadDao();
        localidades = new ArrayList<>();
        if(buscar == null){
            localidades = localidadDao.consultarLocalidades();
        }else{
            localidades = localidadDao.BuscarLocalidades(buscar);
        }       
        
    }
}
