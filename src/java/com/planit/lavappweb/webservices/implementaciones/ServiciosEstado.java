/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Estado_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadoID;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosEstado {
    
    public Estado_TO consultarEstadoID(int idEstado, String nombre) {
        ClienteConsultarEstadoID clienteModelo = new ClienteConsultarEstadoID();
        return clienteModelo.consultarEstado(Estado_TO.class, "" + idEstado, nombre);
    }
    
}
