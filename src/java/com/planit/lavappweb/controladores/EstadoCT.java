/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.EstadoDao;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class EstadoCT {
   
    //Constructores
    public EstadoCT() {
    }
    
    //Metodos
    
    //Consulta la lista de estados registrados en el sistema para las prendas
    public List<Estado_TO> estadosProductos(){
        EstadoDao estadoDao = new EstadoDao();
        return estadoDao.consultarEstadosProductos();
    }   
    
    //Consulta la lisat de estados disponibles desde la planta para el manejo de la prendas
    public List<Estado_TO> estadosPlanta(){
        EstadoDao estadoDao = new EstadoDao();
        return estadoDao.consultarEstadosPlanta();
    } 
}
