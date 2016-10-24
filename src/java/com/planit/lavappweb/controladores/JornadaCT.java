/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.JornadaDao;
import com.planit.lavappweb.modelo.dto.Jornada_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class JornadaCT implements Serializable{
    
    //Variables
    private Jornada_TO jornada;
    private List<Jornada_TO> jornadas;
   
    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar
    private String buscar;

    //Constructores
    public JornadaCT() {
        jornada = new Jornada_TO();
        jornadas = new ArrayList<>();
   
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        JornadaDao jornadaDao = new JornadaDao();
        jornadas = jornadaDao.consultarJornadas();
    }

    //Getter & Setter
    public Jornada_TO getJornada() {
        return jornada;
    }

    public void setJornada(Jornada_TO jornada) {
        this.jornada = jornada;
    }

    public List<Jornada_TO> getJornadas() {
        return jornadas;
    }

    public void setJornadas(List<Jornada_TO> jornadas) {
        this.jornadas = jornadas;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos
    public void registrar() {
        JornadaDao jornadaDao = new JornadaDao();
        jornada = jornadaDao.registraJornada(jornada);
        jornadas = jornadaDao.consultarJornadas();
    }

    public void modificar() {
        JornadaDao jornadaDao = new JornadaDao();
        jornada = jornadaDao.editarJornada(jornada);
        jornadas = jornadaDao.consultarJornadas();
    }

    public void eliminar() {
        JornadaDao jornadaDao = new JornadaDao();
        jornada = jornadaDao.eliminarJornada(jornada);
        jornadas = jornadaDao.consultarJornadas();
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
        //reinicia los valores de la variables y vuelve a 0 la bandera operacion
        jornada = new Jornada_TO();
        //barrios = servicios.consultarBarrios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
    
    public void buscarJornadas(){
        //filtra la lista de barrios segun el valor que se consulte, si valor es vacio consulta todos los barrios
        JornadaDao jornadaDao = new JornadaDao();
        jornadas = new ArrayList<>();
        if(buscar.isEmpty()){
            jornadas = jornadaDao.consultarJornadas();
        }else{
            jornadas = jornadaDao.buscarJornadas(buscar);
        }
    }
}
