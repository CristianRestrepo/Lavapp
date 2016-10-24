/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.ZonaDao;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ZonaCT implements Serializable {

     //Variables y objetos
    private Zona_TO zona;
    private List<Zona_TO> zonas;
   
    private String nombreOperacion;
    private int operacion;
    private String buscar;

    //Constructores
    public ZonaCT() {
        zona = new Zona_TO();
        zonas = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        ZonaDao zonadao = new ZonaDao();
        zonas = zonadao.consultarZonas();
    }

    //Getter & Setter
    public Zona_TO getZona() {
        return zona;
    }

    public void setZona(Zona_TO zona) {
        this.zona = zona;
    }

    public List<Zona_TO> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona_TO> zonas) {
        this.zonas = zonas;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos
    public void registrar() {
        ZonaDao zonadao = new ZonaDao();
        zona = zonadao.registrarZona(zona);
        zonas = zonadao.consultarZonas();
    }

    public void modificar() {
        ZonaDao zonadao = new ZonaDao();
        zona = zonadao.editarZona(zona);
        zonas = zonadao.consultarZonas();
    }

    public void eliminar() {
        ZonaDao zonadao = new ZonaDao();
        zona = zonadao.eliminarZona(zona);
        zonas = zonadao.consultarZonas();
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
        ZonaDao zonadao = new ZonaDao();
        zona = new Zona_TO();
        zonas = zonadao.consultarZonas();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarZonas() {
        //filtra la lista de zonas segun el valor que se consulte, si valor es vacio consulta todos los zonas
        ZonaDao zonadao = new ZonaDao();
        zonas = new ArrayList<>();
        if (buscar.isEmpty()) {
            zonas = zonadao.consultarZonas();
        } else {
            zonas = zonadao.buscarZonas(buscar);
        }
    }
}
