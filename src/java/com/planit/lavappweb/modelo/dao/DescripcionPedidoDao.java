/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionesSegunPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarDescripcionPedido;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoDao {    
    
    public DescripcionPedido_TO registrarDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        ClienteRegistrarDescripcionPedido cliente = new ClienteRegistrarDescripcionPedido();
        return cliente.registrarDescripcionPedido(DescripcionPedido_TO.class, 
                "" + descripcionPedido.getEstado().getIdEstado(),
                "" + descripcionPedido.getPedido().getIdPedido(), 
                "" + descripcionPedido.getSubProducto().getIdSubProducto());
    }

    public DescripcionPedido_TO eliminarDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        ClienteEliminarDescripcionPedido cliente = new ClienteEliminarDescripcionPedido();
        return cliente.eliminarDescripcionPedido(DescripcionPedido_TO.class, "" + descripcionPedido.getIdDescripcionPedido());
    }

    public DescripcionPedido_TO eliminarDescripcionesSegunPedido(Pedido_TO pedido) {
        ClienteEliminarDescripcionesSegunPedido cliente = new ClienteEliminarDescripcionesSegunPedido();
        return cliente.eliminarDescripcionesSegunPedido(DescripcionPedido_TO.class, "" + pedido.getIdPedido());
    }
    
}
