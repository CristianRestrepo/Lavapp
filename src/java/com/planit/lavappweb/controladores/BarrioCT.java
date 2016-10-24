/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.BarriosDao;
import com.planit.lavappweb.modelo.dto.Barrio_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class BarrioCT implements Serializable{

    
    //variables
    private Barrio_TO barrio;
    private List<Barrio_TO> barrios;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar
    private String buscar;

    //constructor
    public BarrioCT() {
        barrio = new Barrio_TO();
        barrios = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        BarriosDao barrioDao = new BarriosDao();
        barrios = barrioDao.consultarBarrios();
    }

    //Getters & Setters
    public Barrio_TO getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio_TO barrio) {
        this.barrio = barrio;
    }

    public List<Barrio_TO> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio_TO> barrios) {
        this.barrios = barrios;
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

    //Crud
    public void registrar() {
        BarriosDao barrioDao = new BarriosDao();
        barrio = barrioDao.registrarBarrio(barrio);
        barrios = barrioDao.consultarBarrios();
    }

    public void modificar() {
        BarriosDao barrioDao = new BarriosDao();
        barrio = barrioDao.modificarBarrio(barrio);
        barrios = barrioDao.consultarBarrios();
    }

    public void eliminar() {
        BarriosDao barrioDao = new BarriosDao();
        barrio = barrioDao.eliminarBarrio(barrio);
        barrios = barrioDao.consultarBarrios();
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
        BarriosDao barrioDao = new BarriosDao();
        barrio = new Barrio_TO();
        barrios = barrioDao.consultarBarrios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarBarrios() {
        //filtra la lista de barrios segun el valor que se consulte, si valor es vacio consulta todos los barrios
        BarriosDao barrioDao = new BarriosDao();
        barrios = new ArrayList<>();
        if (buscar.isEmpty()) {
            barrios = barrioDao.consultarBarrios();
        } else {
            barrios = barrioDao.buscarBarrio(buscar);
        }
    }
}
