/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.SubServicioDao;
import com.planit.lavappweb.modelo.dto.SubServicio_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author SISTEMAS
 */
public class SubServicioCT implements Serializable {

    //Variables y objetos
    private SubServicio_TO subServicio;
    private List<SubServicio_TO> subServicios;
   
    private String nombreOperacion;
    protected int operacion;
    private String buscar;

    //Constructores
    public SubServicioCT() {
        subServicio = new SubServicio_TO();
        subServicios = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicios = subServicioDao.consultarSubServicios();

    }

    //Getter & Setter
    public SubServicio_TO getSubServicio() {
        return subServicio;
    }

    public void setSubServicio(SubServicio_TO subServicio) {
        this.subServicio = subServicio;
    }

    public List<SubServicio_TO> getSubServicios() {
        return subServicios;
    }

    public void setSubServicios(List<SubServicio_TO> subServicios) {
        this.subServicios = subServicios;
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

    //Metodos
    public void registrar() {
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicio = subServicioDao.registrarSubServicio(subServicio);
        subServicios = subServicioDao.consultarSubServicios();
    }

    public void modificar() {
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicio = subServicioDao.editarSubServicio(subServicio);
        subServicios = subServicioDao.consultarSubServicios();
    }

    public void eliminar() {
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicio = subServicioDao.eliminarSubServicio(subServicio);
        subServicios = subServicioDao.consultarSubServicios();
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
        //reinicia los valores de la variables y vuelve a 0 la bandera operacion
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicio = new SubServicio_TO();
        subServicios = subServicioDao.consultarSubServicios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarSubServicios() {
        //filtra la lista de subservicios segun el valor que se consulte, si valor es vacio consulta todos los subservicios
        SubServicioDao subServicioDao = new SubServicioDao();
        subServicios = new ArrayList<>();
        if (buscar.isEmpty()) {
            subServicios = subServicioDao.consultarSubServicios();
        } else {
            subServicios = subServicioDao.buscarSubServicios(buscar);
        }
    }

}
