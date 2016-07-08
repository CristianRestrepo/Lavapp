/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarProducto;
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

    public Producto_TO consultarProducto(int idProducto, String nombre){
        ClienteConsultarProducto cliente = new ClienteConsultarProducto();
        return cliente.consultarProducto(Producto_TO.class, "" + idProducto, nombre);
    }
    
    public List<Producto_TO> consultarProductos() {
        ClienteConsultarProductos cliente = new ClienteConsultarProductos();
        List<LinkedHashMap> datos = cliente.consultarProductos(List.class);
        List<Producto_TO> productos = new ArrayList<>();
        ServiciosSubServicio ss = new ServiciosSubServicio();
                
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("subServicio");
            SubServicio_TO subServicio = ss.consultarSubServicio((int) map.get("idSubServicio"), (String) map.get("nombre"));
            productos.add(new Producto_TO((int) datos.get(i).get("idProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    subServicio,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return productos;
    }

    public Producto_TO registrarProducto(String nombre, String descripcion, int idSubServicio, String rutaImagen) {
        ClienteRegistrarProducto cliente = new ClienteRegistrarProducto();
        return cliente.registrarProducto(Producto_TO.class, nombre, descripcion, "" + idSubServicio, rutaImagen);
    }

    public Producto_TO modificarProducto(int idProducto, String nombre, String descripcion, int idSubServicio, String rutaImagen) {
        ClienteEditarProducto cliente = new ClienteEditarProducto();
        return cliente.modificarProducto(Producto_TO.class, "" + idProducto, nombre, descripcion, "" + idSubServicio, rutaImagen);
    }

    public Producto_TO eliminar(int idProducto) {
        ClienteEliminarProducto cliente = new ClienteEliminarProducto();
        return cliente.eliminarProducto(Producto_TO.class, "" + idProducto);
    }

}
