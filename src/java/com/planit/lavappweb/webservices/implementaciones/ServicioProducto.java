/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarProductos;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServicioProducto {

    public List<Producto_TO> consultarProductos() {
        List<Producto_TO> listModelo = new ArrayList<>();
        ClienteConsultarProductos clienteProd = new ClienteConsultarProductos();
        try {
            listModelo = clienteProd.consultarProductos(List.class);
        } catch (Exception e) {
            throw e;
        }
        return listModelo;
    }

    public Producto_TO registrarProducto(String nombre, String desc, int idSubServi) {

        Producto_TO producModelo = new Producto_TO();
        ClienteRegistrarProducto clienteProducto = new ClienteRegistrarProducto();
        try {
            clienteProducto.registrarProducto(Producto_TO.class, nombre, desc, desc);
            producModelo = new Producto_TO();
        } catch (Exception e) {
            producModelo = new Producto_TO();
            throw e;
        }
        return producModelo;
    }

}
