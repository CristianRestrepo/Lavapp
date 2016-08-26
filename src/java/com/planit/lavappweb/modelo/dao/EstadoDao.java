/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadoID;

/**
 *
 * @author Desarrollo_Planit
 */
public class EstadoDao {
    
     public Estado_TO consultarEstadoID(Estado_TO estado) {
        ClienteConsultarEstadoID clienteModelo = new ClienteConsultarEstadoID();
        return clienteModelo.consultarEstado(Estado_TO.class, 
                "" + estado.getIdEstado(), 
                estado.getNombre());
    }
}
