/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.modelos.SubProducto_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProductos;
import com.planit.lavappweb.webservices.clientes.ClienteEditarSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarSubProducto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosSubProductos {

    public List<SubProducto_TO> consultarSubProductos() {
        ClienteConsultarSubProductos cliente = new ClienteConsultarSubProductos();
        List<SubProducto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.consultarSubProductos(List.class);
        ServiciosProducto sp = new ServiciosProducto();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("producto");
            Producto_TO producto = sp.consultarProducto((int) map.get("idProducto"), (String) map.get("nombre"));
            subproductos.add(new SubProducto_TO((int) datos.get(i).get("idSubProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    producto,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return subproductos;
    }

    public SubProducto_TO registrarSubproducto(String nombre, String desc, int idPro, String rutaImagen) {
        ClienteRegistrarSubProducto cliente = new ClienteRegistrarSubProducto();
        return cliente.registrarSubProducto(SubProducto_TO.class, nombre, desc, "" + idPro, rutaImagen);
    }

    public SubProducto_TO editarSubProducto(int idSubProducto, String nombre, String desc, int idPro, String rutaImagen) {
        ClienteEditarSubProducto cliente = new ClienteEditarSubProducto();
        return cliente.modificarSubProductos(SubProducto_TO.class, "" + idSubProducto, nombre, desc, "" + idPro, rutaImagen);
    }
    
    public SubProducto_TO eliminarSubProducto(int idSubProducto){
        ClienteEliminarSubProducto cliente = new ClienteEliminarSubProducto();
        return cliente.eliminarSubProductos(SubProducto_TO.class, "" + idSubProducto);
    
    }
}
