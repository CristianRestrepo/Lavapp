/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.ServicioDao;
import com.planit.lavappweb.modelo.dto.Servicio_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServicioCT implements Serializable {

    //Variables
    private Servicio_TO servicio;
    private List<Servicio_TO> servicios;
    
    private String nombreOperacion;
    protected int operacion;
    private String buscar;

    //Constructores
    public ServicioCT() {
        servicio = new Servicio_TO();
        servicios = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        ServicioDao servicioDao = new ServicioDao();
        servicios = servicioDao.consultarServicios();
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
        ServicioDao servicioDao = new ServicioDao();
        servicio = servicioDao.registrarServicio(servicio);
        servicios = servicioDao.consultarServicios();
    }

    public void modificar() {
        ServicioDao servicioDao = new ServicioDao();
        servicio = servicioDao.editarServicio(servicio);
        servicios = servicioDao.consultarServicios();
    }

    public void eliminar() {
        ServicioDao servicioDao = new ServicioDao();
        servicio = servicioDao.eliminarServicio(servicio);
        servicios = servicioDao.consultarServicios();
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos Propios
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
        ServicioDao servicioDao = new ServicioDao();
        servicio = new Servicio_TO();
        servicios = servicioDao.consultarServicios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarServicios() {
        //filtra la lista de servicios segun el valor que se consulte, si valor es vacio consulta todos los servicios
        ServicioDao servicioDao = new ServicioDao();
        servicios = new ArrayList<>();
        if (buscar.isEmpty()) {
            servicios = servicioDao.consultarServicios();
        } else {
            servicios = servicioDao.BuscarServicios(buscar);
        }
    }
}
