/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Color_TO;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarDescripcionPedidoSegunPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDescripcionesSegunPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarDescripcionPedido;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class DescripcionPedidoDao {

    public List<DescripcionPedido_TO> consultarDescripcionPedidoSegunPedido(Pedido_TO pedido) {
        ClienteConsultarDescripcionPedidoSegunPedido cliente = new ClienteConsultarDescripcionPedidoSegunPedido();
        List<LinkedHashMap> datos = cliente.consultarDescripcionPedidoSegunPedido(List.class, "" + pedido.getIdPedido());
        List<DescripcionPedido_TO> lista = new ArrayList<>();

        EstadoDao ed = new EstadoDao();
        SubProductoDao sp = new SubProductoDao();
        ColorDao cd = new ColorDao();

        for (int i = 0; i < datos.size(); i++) {

            LinkedHashMap mapEstado = (LinkedHashMap) datos.get(i).get("estado");
            LinkedHashMap mapSubProducto = (LinkedHashMap) datos.get(i).get("subProducto");
            LinkedHashMap mapColor = (LinkedHashMap) datos.get(i).get("color");

            lista.add(new DescripcionPedido_TO((int) datos.get(i).get("idDescripcionPedido"),
                    ed.consultarEstadoID(new Estado_TO((int) mapEstado.get("idEstado"), (String) mapEstado.get("nombre"))),
                    sp.consultarSubProducto(new SubProducto_TO((int) mapSubProducto.get("idSubProducto"), (String) mapSubProducto.get("nombre"))),
                    (String) datos.get(i).get("descripcion"),
                    (String) datos.get(i).get("observacionAsesor"),
                    (String) datos.get(i).get("observacionAdministrador"),
                    (Byte) datos.get(i).get("foto1"),
                    (Byte) datos.get(i).get("foto2"),
                    (Byte) datos.get(i).get("foto3"),
                    cd.consultarColor(new Color_TO((int) mapColor.get("idColor"), (String) mapColor.get("nombre"))),
                    pedido,
                    (String) datos.get(i).get("codigo")));
        }
        return lista;
    }

    public List<DescripcionPedido_TO> consultarDescripcionesSinFotosSegunPedido(Pedido_TO pedido) {

        ClienteConsultarDescripcionPedidoSegunPedido cliente = new ClienteConsultarDescripcionPedidoSegunPedido();
        List<LinkedHashMap> datos = cliente.consultarDescripcionPedidoSegunPedido(List.class, "" + pedido.getIdPedido());
        List<DescripcionPedido_TO> lista = new ArrayList<>();

        EstadoDao ed = new EstadoDao();
        SubProductoDao sp = new SubProductoDao();
        ColorDao cd = new ColorDao();

        for (int i = 0; i < datos.size(); i++) {

            LinkedHashMap mapEstado = (LinkedHashMap) datos.get(i).get("estado");
            LinkedHashMap mapSubProducto = (LinkedHashMap) datos.get(i).get("subProducto");
            LinkedHashMap mapColor = (LinkedHashMap) datos.get(i).get("color");

            lista.add(new DescripcionPedido_TO((int) datos.get(i).get("idDescripcionPedido"),
                    ed.consultarEstadoID(new Estado_TO((int) mapEstado.get("idEstado"), (String) mapEstado.get("nombre"))),
                    sp.consultarSubProducto(new SubProducto_TO((int) mapSubProducto.get("idSubProducto"), (String) mapSubProducto.get("nombre"))),
                    (String) datos.get(i).get("descripcion"),
                    (String) datos.get(i).get("observacionAsesor"),
                    (String) datos.get(i).get("observacionAdministrador"),
                    cd.consultarColor(new Color_TO((int) mapColor.get("idColor"), (String) mapColor.get("nombre"))),
                    pedido,
                    (String) datos.get(i).get("codigo")));
        }
        return lista;
    }

    public DescripcionPedido_TO registrarDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        ClienteRegistrarDescripcionPedido cliente = new ClienteRegistrarDescripcionPedido();
        return cliente.registrarDescripcionPedido(DescripcionPedido_TO.class,
                "" + descripcionPedido.getEstado().getIdEstado(),
                "" + descripcionPedido.getPedido().getIdPedido(),
                "" + descripcionPedido.getSubProducto().getIdSubProducto());
    }

    public DescripcionPedido_TO eliminarDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        ClienteEliminarDescripcionPedido cliente = new ClienteEliminarDescripcionPedido();
        return cliente.eliminarDescripcionPedido(DescripcionPedido_TO.class, "" + descripcionPedido.getIdDescripcionPedido());
    }

    public DescripcionPedido_TO eliminarDescripcionesSegunPedido(Pedido_TO pedido) {
        ClienteEliminarDescripcionesSegunPedido cliente = new ClienteEliminarDescripcionesSegunPedido();
        return cliente.eliminarDescripcionesSegunPedido(DescripcionPedido_TO.class, "" + pedido.getIdPedido());
    }

}