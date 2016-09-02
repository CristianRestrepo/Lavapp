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

    private Zona_TO zona;
    private List<Zona_TO> zonas;

    //Variables
    private String nombreOperacion;
    private int operacion;
    private String buscar;

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
        ZonaDao zonadao = new ZonaDao();
        zona = new Zona_TO();
        zonas = zonadao.consultarZonas();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarZonas() {
        ZonaDao zonadao = new ZonaDao();
        zonas = new ArrayList<>();
        if (buscar.isEmpty()) {
            zonas = zonadao.consultarZonas();
        } else {
            zonas = zonadao.buscarZonas(buscar);
        }
    }
}
