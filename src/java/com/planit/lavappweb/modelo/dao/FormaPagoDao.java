/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.FormaPago_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarFormaPago;

/**
 *
 * @author VaioDevelopment
 */
public class FormaPagoDao {

    public FormaPago_TO consultarFormaPago(FormaPago_TO formaPago) {
        ClienteConsultarFormaPago cliente = new ClienteConsultarFormaPago();
        return cliente.consultarFormaPago(FormaPago_TO.class, "" + formaPago.getIdFormaPago(), "" + formaPago.getNombre());
    }

}
