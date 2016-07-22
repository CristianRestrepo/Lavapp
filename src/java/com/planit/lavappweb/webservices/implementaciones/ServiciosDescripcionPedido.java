/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.DescripcionPedido_TO;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionesSegunPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarDescripcionPedido;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosDescripcionPedido {

    public DescripcionPedido_TO registrarDescripcionPedido(int idEstado, int idPedido, int idSubProducto) {
        ClienteRegistrarDescripcionPedido cliente = new ClienteRegistrarDescripcionPedido();
        return cliente.registrarDescripcionPedido(DescripcionPedido_TO.class, "" + idEstado, "" + idPedido, "" + idSubProducto);
    }

    public DescripcionPedido_TO eliminarDescripcionPedido(int idDescripcionPedido) {
        ClienteEliminarDescripcionPedido cliente = new ClienteEliminarDescripcionPedido();
        return cliente.eliminarDescripcionPedido(DescripcionPedido_TO.class, "" + idDescripcionPedido);
    }

    public DescripcionPedido_TO eliminarDescripcionesSegunPedido(int idPedido) {
        ClienteEliminarDescripcionesSegunPedido cliente = new ClienteEliminarDescripcionesSegunPedido();
        return cliente.eliminarDescripcionesSegunPedido(DescripcionPedido_TO.class, "" + idPedido);
    }
}
