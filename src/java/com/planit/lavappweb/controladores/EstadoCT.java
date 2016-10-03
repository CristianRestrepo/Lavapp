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
   
    public EstadoCT() {
    }
    
    public List<Estado_TO> estadosProductos(){
        EstadoDao estadoDao = new EstadoDao();
        return estadoDao.consultarEstadosProductos();
    }   
    
    public List<Estado_TO> estadosPlanta(){
        EstadoDao estadoDao = new EstadoDao();
        return estadoDao.consultarEstadosPlanta();
    } 
}
