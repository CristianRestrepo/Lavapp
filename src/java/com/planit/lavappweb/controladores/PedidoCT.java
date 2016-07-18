/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.modelos.SubProducto_TO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT {

    private Pedido_TO pedido;
    protected List<SubProducto_TO> subproductos;
    private int vista;
    private int cantidadProductos;

    private SubProducto_TO subproducto;

    private boolean botonatras;
    private boolean botonsiguiente;

    public PedidoCT() {
        pedido = new Pedido_TO();
        vista = 0;
        botonatras = false;
        botonsiguiente = true;
        subproductos = new ArrayList<>();
        cantidadProductos = 0;
        subproducto = new SubProducto_TO();
    }

    //Getter & Setter
    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    public int getVista() {
        return vista;
    }

    public void setVista(int vista) {
        this.vista = vista;
    }

    public boolean isBotonatras() {
        return botonatras;
    }

    public void setBotonatras(boolean botonatras) {
        this.botonatras = botonatras;
    }

    public boolean isBotonsiguiente() {
        return botonsiguiente;
    }

    public void setBotonsiguiente(boolean botonsiguiente) {
        this.botonsiguiente = botonsiguiente;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public SubProducto_TO getSubproducto() {
        return subproducto;
    }

    public void setSubproducto(SubProducto_TO subproducto) {
        this.subproducto = subproducto;
    }

    //Metodos para las vistas
    public String flujoPedido() {
        String ruta = "";
        switch (vista) {
            case 0:
                ruta = "pasos/prendas.xhtml";
                break;
            case 1:
                ruta = "pasos/tiempos.xhtml";
                break;
            case 2:
                ruta = "pasos/confirmacion.xhtml";
                break;
            case 3:
                ruta = "pasos/usuario-pago.xhtml";
                break;
        }
        return ruta;
    }

    public void atras() {
        if (vista > 0) {
            vista--;
            botonsiguiente = true;
        }
        if (vista == 0) {
            botonatras = false;
        }
    }

    public void siguiente() {
        if (vista < 3) {
            vista++;
            botonatras = true;
        }
        if (vista == 3) {
            botonsiguiente = false;
        }
    }

    public void agregarproductos() {
        subproductos.add(subproducto);
        cantidadProductos = subproductos.size();
    }

    public void eliminarproducto() {
        boolean bandera = false;
        int i = 0;
        while(!bandera){
            if(subproductos.get(i).getIdSubProducto() == subproducto.getIdSubProducto()){
                subproductos.remove(i);
                bandera = true;
            }
            i++;
        }        
    }
}
