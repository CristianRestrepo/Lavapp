/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Calificacion_TO;
import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCalificacion;
import com.planit.lavappweb.webservices.implementaciones.ServiciosPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author SISTEMAS
 */

public class CalificacionCT implements Serializable{

    private Calificacion_TO calificacionModelo;
    private List<Calificacion_TO> calificaciones;
    private ServiciosCalificacion servicioModelo;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar

//    EJEMPLOS PARA RAITING
    private Integer rating;
    
    public CalificacionCT() {
        calificacionModelo = new Calificacion_TO();
        calificaciones = new ArrayList<>();
        servicioModelo = new ServiciosCalificacion();
        operacion = 0;
        nombreOperacion = "Registrar";
        rating = 5;
    }

    @PostConstruct
    public void init() {
        calificaciones = servicioModelo.consultarCalificaciones();
    }

    public Calificacion_TO getCalificacionModelo() {
        return calificacionModelo;
    }

    public void setCalificacionModelo(Calificacion_TO calificacionModelo) {
        this.calificacionModelo = calificacionModelo;
    }

    public List<Calificacion_TO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion_TO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public ServiciosCalificacion getServicioModelo() {
        return servicioModelo;
    }

    public void setServicioModelo(ServiciosCalificacion servicioModelo) {
        this.servicioModelo = servicioModelo;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    
//    METODOS CRUD
    public void registrar() {
        ServiciosPedido sP = new ServiciosPedido();
//        calificacionModelo.setPedido(sP.consultarPedido(
//                calificacionModelo.getPedido().getUsuario().getIdUsuario()));

        calificacionModelo = servicioModelo.registrarCalificacion(calificacionModelo.getCalificacion(),
                calificacionModelo.getObservacion(),
                calificacionModelo.getPedido().getIdPedido());
        calificaciones = servicioModelo.consultarCalificaciones();
    }

    public void modificar() {
        ServiciosPedido sP = new ServiciosPedido();
//        calificacionModelo.setPedido(sP.consultarPedido(calificacionModelo.getPedido().getUsuario().getIdUsuario()));

        calificacionModelo = servicioModelo.modificarCalificacion(calificacionModelo.getIdCalificacion(),
                calificacionModelo.getCalificacion(),
                calificacionModelo.getObservacion(),
                calificacionModelo.getPedido().getIdPedido());
        calificaciones = servicioModelo.consultarCalificaciones();

    }

    public void eliminar() {
        calificacionModelo = servicioModelo.eliminarCalificacion(calificacionModelo.getIdCalificacion());
        calificaciones = servicioModelo.consultarCalificaciones();

    }

//    METODOS
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
        calificacionModelo = new Calificacion_TO();
        calificaciones = servicioModelo.consultarCalificaciones();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

}
