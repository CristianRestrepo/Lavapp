/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Producto_TO;
import com.planit.lavappweb.modelo.dto.Promocion_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import com.planit.lavappweb.webservices.clientes.ClienteAsociarPromocionSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPromocionSubProductoYaAsociada;


import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubProductosSegunPromocion;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarAsociacionPromocionSubProducto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionSubproductoDao {

    public int asociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) {
        ClienteAsociarPromocionSubProducto cliente = new ClienteAsociarPromocionSubProducto();
        return cliente.asociarPromocionSubProducto(int.class, "" + promocion.getIdPromocion(), "" + subProducto.getIdSubProducto());
    }

    public int eliminarAsociarPromocionSubProducto(Promocion_TO promocion, SubProducto_TO subProducto) {
        ClienteEliminarAsociacionPromocionSubProducto cliente = new ClienteEliminarAsociacionPromocionSubProducto();
        return cliente.eliminarAsociacionPromocionSubProducto(int.class, "" + promocion.getIdPromocion(), "" + subProducto.getIdSubProducto());
    }

    public int consultarSubProductoAsociado(Promocion_TO promocion, SubProducto_TO subProducto) {
        ClienteConsultarPromocionSubProductoYaAsociada cliente = new ClienteConsultarPromocionSubProductoYaAsociada();
        return cliente.consultarPromocionSubProductoYaAsociada(int.class, "" + promocion.getIdPromocion(), "" + subProducto.getIdSubProducto());
    }
    
    public List<SubProducto_TO> consultarSubProductosSegunPromocion(Promocion_TO promocion){
        ClienteConsultarSubProductosSegunPromocion cliente = new ClienteConsultarSubProductosSegunPromocion();
        List<SubProducto_TO> subproductos = new ArrayList<>();
        List<LinkedHashMap> datos = cliente.consultarSubProductosSegunPromocion(List.class, "" + promocion.getIdPromocion());
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
}
