/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarProductos;
import com.planit.lavappweb.webservices.clientes.ClienteEditarProducto;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarProducto;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarProducto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosProducto {

//    public List<Producto_TO> consultarProductos() {
//        List<Producto_TO> listModelo = new ArrayList<>();
//        ClienteConsultarProductos clienteProd = new ClienteConsultarProductos();
//        try {
//            listModelo = clienteProd.consultarProductos(List.class);
//        } catch (Exception e) {
//            throw e;
//        }
//        return listModelo;
//    }
    public List<Producto_TO> consultarProductos() {
        ClienteConsultarProductos cliente = new ClienteConsultarProductos();
        List<LinkedHashMap> datos = cliente.consultarProductos(List.class);
        List<Producto_TO> productos = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("subServicio");
            SubServicio_TO subServicio = new SubServicio_TO((int) map.get("idSubServicio"));
            productos.add(new Producto_TO((int) datos.get(i).get("idProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    subServicio,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return productos;
    }

    public Producto_TO registrarProducto(String nombre, String desc, int idSubServi) {
        ClienteRegistrarProducto cliente = new ClienteRegistrarProducto();
        return cliente.registrarProducto(Producto_TO.class, nombre, desc, "" + idSubServi);
    }

    public Producto_TO modificarProducto(int idProducto, String nombre, String descripcion, int idSubServicio) {
        ClienteEditarProducto cliente = new ClienteEditarProducto();
        return cliente.modificarProducto(Producto_TO.class, "" + idProducto, nombre, descripcion, "" + idSubServicio);
    }

    public Producto_TO eliminar(int idProducto) {
        ClienteEliminarProducto cliente = new ClienteEliminarProducto();
        return cliente.eliminarProducto(Producto_TO.class, "" + idProducto);
    }

}
