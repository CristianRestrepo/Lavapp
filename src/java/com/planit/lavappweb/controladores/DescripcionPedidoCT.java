/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dao.SubProductoDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoCT implements Serializable {

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
        List<DescripcionPedido_TO> lista = descripcionDao.consultarDescripcionPedidoSegunPedido(pedido);
        return lista;
    }

    public List<DescripcionPedido_TO> consultarDescripcionesSinFotosSegunPedido(Pedido_TO pedido) {
        DescripcionPedidoDao descripcionDao = new DescripcionPedidoDao();
        List<DescripcionPedido_TO> lista = descripcionDao.consultarDescripcionesSinFotosSegunPedido(pedido);
        return lista;
    }
        
    public List<SubProductoCosto_TO> obtenerSubProductos(Pedido_TO pedido){
        List<DescripcionPedido_TO> lista = consultarDescripcionesSinFotosSegunPedido(pedido);
        List<SubProductoCosto_TO> subproductos = new ArrayList<>();
        SubProductoDao subProductosDao = new SubProductoDao();
        for (int i = 0; i < lista.size(); i++) {
            subproductos.add((subProductosDao.consultarSubProductoConCosto(lista.get(i).getSubProducto())));
        }
        return subproductos;
    }

}
