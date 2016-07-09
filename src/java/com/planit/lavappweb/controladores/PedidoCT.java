/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Pedido_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT {

    private Pedido_TO pedido;

    public PedidoCT() {
        pedido = new Pedido_TO();
    }

    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

}
