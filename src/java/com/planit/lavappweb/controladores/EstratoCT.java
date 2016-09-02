/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.EstratoDao;
import com.planit.lavappweb.modelo.dto.Estrato_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class EstratoCT implements Serializable {

    private Estrato_TO estrato;
    private List<Estrato_TO> estratos;
  
    //variables
    private String nombreOperacion;
    private int operacion;
    private String buscar;
    
    public EstratoCT() {
        estrato = new Estrato_TO();
        estratos = new ArrayList<>();
        
        nombreOperacion = "Registrar";
        operacion = 0;
        buscar = null;
    }

    @PostConstruct
    public void init() {
        EstratoDao estratoDao = new EstratoDao();
        estratos = estratoDao.consultarEstratos();
    }

    //Getter & Setter
    public Estrato_TO getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato_TO estrato) {
        this.estrato = estrato;
    }

    public List<Estrato_TO> getEstratos() {
        return estratos;
    }

    public void setEstratos(List<Estrato_TO> estratos) {
        this.estratos = estratos;
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

    //Metodos
    public void registrar() {
        EstratoDao estratoDao = new EstratoDao();
        estrato = estratoDao.registrarEstrato(estrato);
        estratos = estratoDao.consultarEstratos();
    }

    public void modificar() {
        EstratoDao estratoDao = new EstratoDao();
        estrato = estratoDao.editarEstrato(estrato);
        estratos = estratoDao.consultarEstratos();
    }

    public void eliminar() {
        EstratoDao estratoDao = new EstratoDao();
        estrato = estratoDao.eliminarEstrato(estrato);
        estratos = estratoDao.consultarEstratos();
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
        EstratoDao estratoDao = new EstratoDao();
        estrato = new Estrato_TO();
        estratos = estratoDao.consultarEstratos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
    
    public void buscarEstratos(){
        EstratoDao estratoDao = new EstratoDao();
        estratos = new ArrayList<>();
        if(buscar.isEmpty()){
            estratos = estratoDao.consultarEstratos();
        }else{
            estratos = estratoDao.buscarEstratos(buscar);
        }
    }

}
