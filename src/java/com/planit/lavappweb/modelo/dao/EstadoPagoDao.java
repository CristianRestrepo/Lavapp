/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.EstadoPago_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadoPago;

/**
 *
 * @author VaioDevelopment
 */
public class EstadoPagoDao {
    public EstadoPago_TO consultarEstadoPago(EstadoPago_TO estadoPago){
        ClienteConsultarEstadoPago cliente = new ClienteConsultarEstadoPago();
        return cliente.consultarEstadoPago(EstadoPago_TO.class, "" + estadoPago.getIdEstadoPago(), estadoPago.getNombre());
    }    
}
