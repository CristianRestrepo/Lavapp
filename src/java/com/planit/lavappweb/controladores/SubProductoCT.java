/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.SubProducto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosSubProductos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProductoCT implements Serializable {

    private SubProducto_TO subproducto;
    private List<SubProducto_TO> subproductos;
    protected ServiciosSubProductos serviciosSubProducto;

    //Variables    
    private String nombreOperacion;
    protected int operacion;
    
    public SubProductoCT() {
        subproducto = new SubProducto_TO();
        subproductos = new ArrayList<>();
        serviciosSubProducto = new ServiciosSubProductos();
        
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    @PostConstruct
    public void init() {
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    //Getter & Setter
    public SubProducto_TO getSubproducto() {
        return subproducto;
    }

    public void setSubproducto(SubProducto_TO subproducto) {
        this.subproducto = subproducto;
    }

    public List<SubProducto_TO> getSubproductos() {
        return subproductos;
    }

    public void setSubproductos(List<SubProducto_TO> subproductos) {
        this.subproductos = subproductos;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    
    //Metodos
    public void registrar() {
        subproducto = serviciosSubProducto.registrarSubproducto(subproducto.getNombre(), subproducto.getDescripcion(), subproducto.getProducto().getIdProducto());
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    public void modificar() {
        subproducto = serviciosSubProducto.editarSubProducto(subproducto.getIdSubProducto(), subproducto.getNombre(), subproducto.getDescripcion(), subproducto.getProducto().getIdProducto());
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    public void eliminar() {
        subproducto = serviciosSubProducto.eliminarSubProducto(subproducto.getIdSubProducto());
        subproductos = serviciosSubProducto.consultarSubProductos();
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
        subproducto = new SubProducto_TO();
        subproductos = serviciosSubProducto.consultarSubProductos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
