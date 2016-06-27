/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Departamento_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosDepartamento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class DepartamentoCT {

    private Departamento_TO departamento;
    private List<Departamento_TO> departamentos;
    protected ServiciosDepartamento servicios;

    //Variables   
    private String nombreOperacion;
    private int operacion;

    public DepartamentoCT() {
        departamento = new Departamento_TO();
        departamentos = new ArrayList<>();
        servicios = new ServiciosDepartamento();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        departamentos = servicios.consultarDepartamentos();
    }

    //Getter & Setter
    public Departamento_TO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento_TO departamento) {
        this.departamento = departamento;
    }

    public List<Departamento_TO> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento_TO> departamentos) {
        this.departamentos = departamentos;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //CRUD    
    public void registrar() {
        departamento = servicios.registrarDepartamento(departamento.getNombre(), departamento.getPais().getIdPais());
        departamentos = servicios.consultarDepartamentos();
    }

    public void modificar() {
        departamento = servicios.editarDepartamento(departamento.getIdDepartamento(), departamento.getNombre(), departamento.getPais().getIdPais());
        departamentos = servicios.consultarDepartamentos();
    }

    public void eliminar() {
        departamento = servicios.eliminarDepartamento(departamento.getIdDepartamento());
        departamentos = servicios.consultarDepartamentos();
    }

    //Metodos
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
        departamento = new Departamento_TO();
        departamentos = servicios.consultarDepartamentos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
