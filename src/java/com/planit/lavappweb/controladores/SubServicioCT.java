/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.implementaciones.ServicioSubServicio;
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
    private ServicioSubServicio serviceSubServicio;

    public SubServicioCT() {
        subServicio = new SubServicio_TO();
        subServicios = new ArrayList<SubServicio_TO>();
        serviceSubServicio = new ServicioSubServicio();
    }

    @PostConstruct
    public void init() {
        subServicio = new SubServicio_TO();
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

    public ServicioSubServicio getServiceSubServicio() {
        return serviceSubServicio;
    }

    public void setServiceSubServicio(ServicioSubServicio serviceSubServicio) {
        this.serviceSubServicio = serviceSubServicio;
    }

    //Metodos
    public void registrar() {
        try {
//            subServicio = 
            serviceSubServicio.registrarSubServicio(subServicio.getNombre(), subServicio.getServicio().getIdServicio());

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
    }

    public void eliminar() {
    }

}
