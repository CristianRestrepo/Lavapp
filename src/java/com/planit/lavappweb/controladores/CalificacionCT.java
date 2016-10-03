/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.CalificacionDao;
import com.planit.lavappweb.modelo.dto.Calificacion_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author SISTEMAS
 */
public class CalificacionCT implements Serializable {

    private Calificacion_TO calificacionModelo;
    private List<Calificacion_TO> calificaciones;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar
    private int vistaAnterior;

//    EJEMPLOS PARA RAITING
    private Integer rating;

    public CalificacionCT() {
        calificacionModelo = new Calificacion_TO();
        calificaciones = new ArrayList<>();
        operacion = 0;
        nombreOperacion = "Enviar Calificacion";
        rating = 5;
        vistaAnterior = 0;
    }

    @PostConstruct
    public void init() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificaciones = calificacionDao.consultarCalificaciones();
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public int getVistaAnterior() {
        return vistaAnterior;
    }

    public void setVistaAnterior(int vistaAnterior) {
        this.vistaAnterior = vistaAnterior;
    }

//    METODOS CRUD
    public void registrar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = calificacionDao.registrarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();

        operacion = 1;
        nombreOperacion = "Modificar Calificacion";
    }

    public void modificar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = calificacionDao.modificarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();

    }

    public void eliminar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = calificacionDao.eliminarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();
    }

//    METODOS
    public void metodo() {
        if (operacion == 0) {
            registrar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion Registrada", "Su Calificacion has sido guardada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (operacion == 1) {
            modificar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion Modificada", "Su Calificacion has sido modificada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
            //Reiniciamos banderas
            nombreOperacion = "Enviar Calificacion";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar Calificacion";
        }
    }

    public void cancelar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = new Calificacion_TO();
        calificacionDao.consultarCalificaciones();
        operacion = 0;
        nombreOperacion = "Enviar Calificacion";
    }

    //Otros
    public String verCalificacion(Pedido_TO pedido) {
        CalificacionDao calificacionDao = new CalificacionDao();
        if (calificacionDao.consultarCalificacionPorPedido(pedido).getIdCalificacion() != 0) {
            calificacionModelo = calificacionDao.consultarCalificacionPorPedido(pedido);
            nombreOperacion = "Modificar Calificacion";
            operacion = 1;
        } else {
            calificacionModelo.setPedido(pedido);
            operacion = 0;
            nombreOperacion = "Enviar Calificacion";
        }
        return "Calificacion";
    }

    public String regresar() {
        String ruta = "";
        if (vistaAnterior == 0) {
            ruta = "Pedido";
        } else if (vistaAnterior == 1) {
            ruta = "Calificaciones";
        }
        return ruta;
    }
}
