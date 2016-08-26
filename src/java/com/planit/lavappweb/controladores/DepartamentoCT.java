/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.DepartamentoDao;
import com.planit.lavappweb.modelo.dto.Departamento_TO;
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
   
    //Variables   
    private String nombreOperacion;
    private int operacion;
    private String buscar;

    public DepartamentoCT() {
        departamento = new Departamento_TO();
        departamentos = new ArrayList<>();       
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamentos = departamentoDao.consultarDepartamentos();
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //CRUD    
    public void registrar() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamento = departamentoDao.registrarDepartamento(departamento);
        departamentos = departamentoDao.consultarDepartamentos();
    }

    public void modificar() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamento = departamentoDao.editarDepartamento(departamento);
        departamentos = departamentoDao.consultarDepartamentos();
    }

    public void eliminar() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamento = departamentoDao.eliminarDepartamento(departamento);
        departamentos = departamentoDao.consultarDepartamentos();
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
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamento = new Departamento_TO();
        departamentos = departamentoDao.consultarDepartamentos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarDepartamentos() {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        departamentos = new ArrayList<>();
        if (buscar == null) {
            departamentos = departamentoDao.consultarDepartamentos();
        } else {
            departamentos = departamentoDao.buscarDepartamentos(buscar);
        }
    }
}
