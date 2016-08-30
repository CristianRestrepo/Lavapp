/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Producto_TO;
import com.planit.lavappweb.modelo.dto.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarProductos;
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
 * @author Desarrollo_Planit
 */
public class ProductoDao {

    public Producto_TO consultarProducto(Producto_TO producto) {
        ClienteConsultarProducto cliente = new ClienteConsultarProducto();
        return cliente.consultarProducto(Producto_TO.class, "" + producto.getIdProducto(),
                producto.getNombre());
    }

    public List<Producto_TO> consultarProductos() {
        ClienteConsultarProductos cliente = new ClienteConsultarProductos();
        List<LinkedHashMap> datos = cliente.consultarProductos(List.class);
        List<Producto_TO> productos = new ArrayList<>();
        SubServicioDao ssd = new SubServicioDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("subServicio");
            SubServicio_TO subServicio = ssd.consultarSubServicio(new SubServicio_TO((int) map.get("idSubServicio"), (String) map.get("nombre")));
            productos.add(new Producto_TO((int) datos.get(i).get("idProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    subServicio,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return productos;
    }

    public List<Producto_TO> BuscarProductos(String valor) {
        ClienteBuscarProductos cliente = new ClienteBuscarProductos();
        List<LinkedHashMap> datos = cliente.buscarProductos(List.class, valor);
        List<Producto_TO> productos = new ArrayList<>();
        SubServicioDao ssd = new SubServicioDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("subServicio");
            SubServicio_TO subServicio = ssd.consultarSubServicio(new SubServicio_TO((int) map.get("idSubServicio"), (String) map.get("nombre")));
            productos.add(new Producto_TO((int) datos.get(i).get("idProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    subServicio,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return productos;
    }

    public Producto_TO registrarProducto(Producto_TO producto) {
        SubServicioDao ssd = new SubServicioDao();
        producto.setSubServicio(ssd.consultarSubServicio(producto.getSubServicio()));
        
        ClienteRegistrarProducto cliente = new ClienteRegistrarProducto();
        return cliente.registrarProducto(Producto_TO.class,
                producto.getNombre(),
                producto.getDescripcion(), 
                "" + producto.getSubServicio(), 
                producto.getRutaImagen());
    }

    public Producto_TO modificarProducto(Producto_TO producto) {
        
        SubServicioDao ssd = new SubServicioDao();
        producto.getSubServicio().setIdSubServicio(0);
        producto.setSubServicio(ssd.consultarSubServicio(producto.getSubServicio()));
        
        ClienteEditarProducto cliente = new ClienteEditarProducto();
        return cliente.modificarProducto(Producto_TO.class, 
                "" + producto.getIdProducto(), 
                producto.getNombre(), 
                producto.getDescripcion(),
                "" + producto.getSubServicio().getIdSubServicio(),
                producto.getRutaImagen());
    }

    public Producto_TO eliminarProducto(Producto_TO producto) {
        ClienteEliminarProducto cliente = new ClienteEliminarProducto();
        return cliente.eliminarProducto(Producto_TO.class, "" + producto.getIdProducto());
    }

}
