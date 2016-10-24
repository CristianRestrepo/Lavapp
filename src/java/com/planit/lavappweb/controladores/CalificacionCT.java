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

    //Variables
    private Calificacion_TO calificacionModelo;
    private List<Calificacion_TO> calificaciones;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar
    private int vistaAnterior;

    //EJEMPLOS PARA RAITING
    private Integer rating;

    //Constructor
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

    //Getters & setters
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
        calificacionDao.registrarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();

        operacion = 1;
        nombreOperacion = "Modificar Calificacion";
    }

    public void modificar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionDao.modificarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();

    }

    public void eliminar() {
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = calificacionDao.eliminarCalificacion(calificacionModelo);
        calificaciones = calificacionDao.consultarCalificaciones();
    }

//    METODOS
    public void metodo() {
        //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro
        if (operacion == 0) {
            registrar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion Registrada", "Su Calificacion has sido guardada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (operacion == 1) {
            modificar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion Modificada", "Su Calificacion has sido modificada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, message);           
        }
    }

    public void seleccionarCRUD(int i) {
        //Setea un valor en la variable operacion para determinar que funcion realizara proximamente
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar Calificacion";
        }
    }

    public void cancelar() {
        //reinicia los valores de las variables y vuelve a 0 la bandera operacion
        CalificacionDao calificacionDao = new CalificacionDao();
        calificacionModelo = new Calificacion_TO();
        calificacionDao.consultarCalificaciones();
        operacion = 0;
        nombreOperacion = "Enviar Calificacion";
    }

    //Otros
    public String verCalificacion(Pedido_TO pedido) {
        //Muestra la informacion respectiva de la calificacion de un pedido, si existe una calificacion
        //habilita la opcion de modificarla, si no existe, habilita la opcion de registrarla
        calificacionModelo = new Calificacion_TO();
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

    //regresa a la vista anterior segun una bandera que indica desde que vista se accedio a la vista calificacion
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
