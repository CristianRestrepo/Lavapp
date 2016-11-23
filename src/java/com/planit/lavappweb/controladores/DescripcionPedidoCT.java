/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dao.PedidoDao;
import com.planit.lavappweb.modelo.dao.SubProductoDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
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

    //Variables
    private DescripcionPedido_TO productoPedido;
    private List<DescripcionPedido_TO> productosPedido;

    //constructores
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
    public void modificar(DescripcionPedido_TO descripcion) {
        DescripcionPedidoDao descripcionPedidoDao = new DescripcionPedidoDao();
        if (descripcion.getEstado().getIdEstado() < 5) {
            descripcion.setEstado(new Estado_TO(5));
        }
        descripcionPedidoDao.editarDescripcionPedido(descripcion);
    }
    

    public void editarEstadoDescripcion(DescripcionPedido_TO descripcion) {
        //Segun el estado actual de la prenda, actualiza su estado el siguiente estado
        switch (descripcion.getEstado().getIdEstado()) {
            case 4:
                descripcion.setEstado(new Estado_TO(5));
                break;
            case 5:
                descripcion.setEstado(new Estado_TO(6));
                break;
            case 6:
                descripcion.setEstado(new Estado_TO(7));
                break;
            case 7:
                descripcion.setEstado(new Estado_TO(8));
                break;
        }

        DescripcionPedidoDao descripcionPedidoDao = new DescripcionPedidoDao();
        descripcionPedidoDao.editarEstadoDescripcionPedido(descripcion);

        productosPedido = descripcionPedidoDao.consultarDescripcionesSinFotosSegunPedido(descripcion.getPedido());
        boolean valor = true;
        
        //Valida si todos las prendas de un pedido se encuentran en el mismo estado, si es asi, actualiza el estado actual del pedido}
        //al de la prendas
        for (int i = 0; i < productosPedido.size(); i++) {
            if (descripcion.getEstado().getIdEstado() != productosPedido.get(i).getEstado().getIdEstado()) {
                valor = false;
            }
        }

        if (valor) {
            PedidoDao pedidoDao = new PedidoDao();
            Pedido_TO pedido = descripcion.getPedido();
            pedido.setEstado(descripcion.getEstado());
            pedidoDao.editarEstadoPedido(pedido);
        }
    }

    //Consulta las prendas y su informacion en el pedido segun un pedido
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

    //consulta la informacion basica de la prendas asociadas a los items de un pedido
    public List<SubProductoCosto_TO> obtenerSubProductos(Pedido_TO pedido) {
        List<DescripcionPedido_TO> lista = consultarDescripcionesSinFotosSegunPedido(pedido);
        List<SubProductoCosto_TO> subproductos = new ArrayList<>();
        SubProductoDao subProductosDao = new SubProductoDao();
        for (int i = 0; i < lista.size(); i++) {
            subproductos.add((subProductosDao.consultarSubProductoConCosto(lista.get(i).getSubProducto())));
        }
        return subproductos;
    }
    
    public void prueba(){
       
    }

}
