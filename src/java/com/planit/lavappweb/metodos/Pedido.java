/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;

import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class Pedido {

    //Variables y objetos
    public static Pedido_TO pedidoUsuario = new Pedido_TO();
    public static List<SubProductoCosto_TO> subproductos = new ArrayList<>();
    public static int vista = 0;

    //Constructores
    public Pedido() {
    }

    //Getters & Setters
    public static Pedido_TO getPedidoUsuario() {
        return pedidoUsuario;
    }

    public static void setPedidoUsuario(Pedido_TO pedidoUsuario) {
        Pedido.pedidoUsuario = pedidoUsuario;
    }

    public static List<SubProductoCosto_TO> getSubproductos() {
        return subproductos;
    }

    public static void setSubproductos(List<SubProductoCosto_TO> subproductos) {
        Pedido.subproductos = subproductos;
    }

    public static int getVista() {
        return vista;
    }

    public static void setVista(int vista) {
        Pedido.vista = vista;
    }

    //Metodos
    public static void ReiniciarValores() {
        //Reiniciar valores de las variables y objetos
        pedidoUsuario = new Pedido_TO();
        subproductos = new ArrayList<>();
        vista = 0;
    }

}
