/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosSubServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author SISTEMAS
 */
public class SubServicioCT implements Serializable {

    private SubServicio_TO subServicio;
    private List<SubServicio_TO> subServicios;
    protected ServiciosSubServicio serviceSubServicio;

    //Variables 
    private String nombreOperacion;
    protected int operacion;

    public SubServicioCT() {
        subServicio = new SubServicio_TO();
        subServicios = new ArrayList<SubServicio_TO>();
        serviceSubServicio = new ServiciosSubServicio();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        subServicios = serviceSubServicio.consultarSubServicios();

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

    //Metodos
    public void registrar() {
        subServicio = serviceSubServicio.registrarSubServicio(subServicio.getNombre(), subServicio.getServicio().getIdServicio());
        subServicios = serviceSubServicio.consultarSubServicios();
    }

    public void modificar() {
        subServicio = serviceSubServicio.editarSubServicio(subServicio.getIdSubServicio(), subServicio.getNombre(), subServicio.getServicio().getIdServicio());
        subServicios = serviceSubServicio.consultarSubServicios();
    }

    public void eliminar() {
        subServicio = serviceSubServicio.eliminarSubServicio(subServicio.getIdSubServicio());
        subServicios = serviceSubServicio.consultarSubServicios();
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
        subServicio = new SubServicio_TO();
        subServicios = serviceSubServicio.consultarSubServicios();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

}
