/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelo.dao.PedidoDao;
import com.planit.lavappweb.modelo.dao.ProveedorDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VaioDevelopment
 */
public class PedidosCT {

    private Pedido_TO pedido;
    private DescripcionPedido_TO descripcionPedido;
    private List<Pedido_TO> pedidos;

    private String buscar;
    private Boolean descripcionPrenda;
    private int vista;

    public PedidosCT() {
        pedido = new Pedido_TO();
        descripcionPedido = new DescripcionPedido_TO();
        buscar = null;

        PedidoDao pedidoDao = new PedidoDao();
        if (Sesion.obtenerSesion() != null) {
            if (Sesion.obtenerSesion().getRol().getIdRol() == 1) {
                pedidos = pedidoDao.consultarPedidos();
                descripcionPrenda = false;
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 2) {
                ProveedorDao proveedorDao = new ProveedorDao();
                try {
                    pedidos = pedidoDao.consultarPedidosSegunPlanta(proveedorDao.consultarProveedorSegunUsuario(Sesion.obtenerSesion()));
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
                descripcionPrenda = false;
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 4) {
                try {
                    pedidos = pedidoDao.consultarPedidosCliente(Sesion.obtenerSesion());
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
                descripcionPrenda = true;
            }
        }
    }

    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    public DescripcionPedido_TO getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public List<Pedido_TO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido_TO> pedidos) {
        this.pedidos = pedidos;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Boolean getDescripcionPrenda() {
        return descripcionPrenda;
    }

    public void setDescripcionPrenda(Boolean descripcionPrenda) {
        this.descripcionPrenda = descripcionPrenda;
    }

    public int getVista() {
        return vista;
    }

    public void setVista(int vista) {
        this.vista = vista;
    }
    
    

    //Metodos para el control de vista pedido en dashboard
   
    
    public String verPedido(Pedido_TO pedido){
        this.pedido = pedido;
        vista = 0;
        return "Pedido";
    }

    public void verPrenda(DescripcionPedido_TO prenda) {
        this.descripcionPedido = prenda;
        vista = 1;
    }

    public String volverPedidos() {
        return "Pedidos";
    }

    public void volverPedido() {
        vista = 0;
    }    

    public void buscarPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidos = new ArrayList<>();
        if (buscar.isEmpty()) {
            if (Sesion.obtenerSesion().getRol().getIdRol() == 1) {
                pedidos = pedidoDao.consultarPedidos();
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 2) {
                ProveedorDao proveedorDao = new ProveedorDao();
                try {
                    pedidos = pedidoDao.consultarPedidosSegunPlanta(proveedorDao.consultarProveedorSegunUsuario(Sesion.obtenerSesion()));
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 4) {
                try {
                    pedidos = pedidoDao.consultarPedidosCliente(Sesion.obtenerSesion());
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            pedidos = pedidoDao.BuscarPedidos(buscar, Sesion.obtenerSesion());
        }
    }

    public List<Pedido_TO> consultarPedidosDiaEntrega() {
        List<Pedido_TO> pedidosDia = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosDia = pedidoDao.consultarPedidosDiaEntrega();
        return pedidosDia;
    }

    public List<Pedido_TO> consultarPedidosDiaRecogida() {
        List<Pedido_TO> pedidosDia = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosDia = pedidoDao.consultarPedidosDiaRecogida();
        return pedidosDia;
    }

    public List<Pedido_TO> consultarPedidosEnplantaSegunCliente() {
        List<Pedido_TO> pedidosEntrega = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosEntrega = pedidoDao.consultarPedidosEnPlantaSegunCliente(Sesion.obtenerSesion());
        return pedidosEntrega;
    }

    public List<Pedido_TO> consultarPedidosPorRecibirSegunCliente() {
        List<Pedido_TO> pedidosRecibir = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosRecibir = pedidoDao.consultarPedidosPorRecibirSegunCliente(Sesion.obtenerSesion());
        return pedidosRecibir;
    }
    
    public void editarEstadoPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.editarEstadoPedido(pedido);
    }
}
