/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Costo_TO;
import com.planit.lavappweb.modelo.dto.Producto_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarSubProductos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProductos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProductosConCosto;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProductosSegunProducto;
import com.planit.lavappweb.webservices.clientes.ClienteEditarSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarSubProducto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProductoDao {

    public List<SubProducto_TO> consultarSubProductos() {
        ClienteConsultarSubProductos cliente = new ClienteConsultarSubProductos();
        List<SubProducto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.consultarSubProductos(List.class);
        ProductoDao pd = new ProductoDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("producto");
            Producto_TO producto = pd.consultarProducto(new Producto_TO((int) map.get("idProducto"), (String) map.get("nombre")));
            subproductos.add(new SubProducto_TO((int) datos.get(i).get("idSubProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    producto,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return subproductos;
    }

    public List<SubProducto_TO> buscarSubProductos(String valor) {
        ClienteBuscarSubProductos cliente = new ClienteBuscarSubProductos();
        List<SubProducto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.buscarSubProductos(List.class, valor);
        ProductoDao pd = new ProductoDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("producto");
            Producto_TO producto = pd.consultarProducto(new Producto_TO((int) map.get("idProducto"), (String) map.get("nombre")));
            subproductos.add(new SubProducto_TO((int) datos.get(i).get("idSubProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    producto,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return subproductos;
    }

    public List<SubProducto_TO> consultarSubProductosSegunProducto(Producto_TO prod) {
        ClienteConsultarSubProductosSegunProducto cliente = new ClienteConsultarSubProductosSegunProducto();
        List<SubProducto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.consultarSubProductosSegunProducto(List.class, "" + prod.getIdProducto());
        ProductoDao pd = new ProductoDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("producto");
            Producto_TO producto = pd.consultarProducto(new Producto_TO((int) map.get("idProducto"), (String) map.get("nombre")));
            subproductos.add(new SubProducto_TO((int) datos.get(i).get("idSubProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    producto,
                    (String) datos.get(i).get("rutaImagen")));
        }
        return subproductos;
    }

    public List<SubProductoCosto_TO> consultarSubProductosConCostoSegunProducto(Producto_TO prod) {
        ClienteConsultarSubProductosConCosto cliente = new ClienteConsultarSubProductosConCosto();
        List<SubProductoCosto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.consultarSubProductosMasCosto(List.class, "" + prod.getIdProducto());
        ProductoDao pd = new ProductoDao();
        CostoDao cd = new CostoDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("producto");
            Producto_TO producto = pd.consultarProducto(new Producto_TO((int) map.get("idProducto"), (String) map.get("nombre")));
            map = (LinkedHashMap) datos.get(i).get("costo");
            Costo_TO costo = cd.consultarCosto(new Costo_TO((int) map.get("idCosto")));
            subproductos.add(new SubProductoCosto_TO((int) datos.get(i).get("idSubProducto"),
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion"),
                    producto,
                    (String) datos.get(i).get("rutaImagen"),
                    costo));
        }
        return subproductos;
    }

    public SubProducto_TO registrarSubproducto(SubProducto_TO subProducto) {
        
        ProductoDao pd = new ProductoDao();
        subProducto.setProducto(pd.consultarProducto(subProducto.getProducto()));
        ClienteRegistrarSubProducto cliente = new ClienteRegistrarSubProducto();
        return cliente.registrarSubProducto(SubProducto_TO.class, 
                subProducto.getNombre(), 
                subProducto.getDescripcion()
                , "" + subProducto.getProducto().getIdProducto(),
                subProducto.getRutaImagen());
    }

    public SubProducto_TO editarSubProducto(SubProducto_TO subProducto) {
        ProductoDao pd = new ProductoDao();
        subProducto.setProducto(pd.consultarProducto(subProducto.getProducto()));
        ClienteEditarSubProducto cliente = new ClienteEditarSubProducto();
        return cliente.modificarSubProductos(SubProducto_TO.class,
                "" + subProducto.getIdSubProducto(),
                subProducto.getNombre(), 
                subProducto.getDescripcion()
                , "" + subProducto.getProducto().getIdProducto(),
                subProducto.getRutaImagen());
    }

    public SubProducto_TO eliminarSubProducto(SubProducto_TO subProducto) {
        ClienteEliminarSubProducto cliente = new ClienteEliminarSubProducto();
        return cliente.eliminarSubProductos(SubProducto_TO.class, "" + subProducto.getIdSubProducto());
    }

    public SubProducto_TO consultarSubProducto(SubProducto_TO subProducto) {
        ClienteConsultarSubProducto cliente = new ClienteConsultarSubProducto();
        return cliente.consultarSubProducto(SubProducto_TO.class, 
                "" + subProducto.getIdSubProducto(),
                subProducto.getNombre());
    }
}
