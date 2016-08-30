/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoCT {

    private DescripcionPedido_TO productoPedido;
    private List<DescripcionPedido_TO> productosPedido;

    public DescripcionPedidoCT() {
        productoPedido = new DescripcionPedido_TO();
        productosPedido = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
    }

    //getter & Setter
    public DescripcionPedido_TO getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(DescripcionPedido_TO productoPedido) {
        this.productoPedido = productoPedido;
    }

    public List<DescripcionPedido_TO> getProductosPedido() {
        return productosPedido;
    }

    public void setProductosPedido(List<DescripcionPedido_TO> productosPedido) {
        this.productosPedido = productosPedido;
    }

    //Metodos       
    public void registrar() {
    }

    public void modificar() {
    }

    public void eliminar() {
    }

    public List<DescripcionPedido_TO> consultarDescripcionesSegunPedido(Pedido_TO pedido) {
        DescripcionPedidoDao descripcionDao = new DescripcionPedidoDao();
        return descripcionDao.consultarDescripcionPedidoSegunPedido(pedido);        
    }

    public List<DescripcionPedido_TO> consultarDescripcionesSinFotosSegunPedido(Pedido_TO pedido) {
        DescripcionPedidoDao descripcionDao = new DescripcionPedidoDao();
        return descripcionDao.consultarDescripcionesSinFotosSegunPedido(pedido);
    }

}
