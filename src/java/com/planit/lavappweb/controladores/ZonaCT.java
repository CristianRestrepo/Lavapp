/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import static com.planit.lavappweb.metodos.Configuracion.operacion;
import com.planit.lavappweb.modelos.Zona_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosZona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class ZonaCT {

    private Zona_TO zona;
    private List<Zona_TO> zonas;
    protected ServiciosZona servicios;
    private String nombreOperacion;

    public ZonaCT() {
        zona = new Zona_TO();
        zonas = new ArrayList<>();
        nombreOperacion = "Registrar";
        servicios = new ServiciosZona();
    }

    @PostConstruct
    public void init() {
        zonas = servicios.consultarZonas();
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
        zona = servicios.registrarZona(zona.getNombre(), zona.getDescripcion());
        zonas = servicios.consultarZonas();
    }

    public void modificar() {
        zona = servicios.editarZona(zona.getIdZona(), zona.getNombre(), zona.getDescripcion());
        zonas = servicios.consultarZonas();
    }

    public void eliminar() {
        zona = servicios.eliminarZona(zona.getIdZona());
        zonas = servicios.consultarZonas();
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
    
    public void cancelar(){
        zona = new Zona_TO();
        zonas = servicios.consultarZonas();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
