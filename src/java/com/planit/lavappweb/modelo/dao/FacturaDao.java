/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Factura_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarFacturaPorPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarFacturas;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarFactura;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarFactura;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class FacturaDao {

    public Factura_TO registrarFactura(Factura_TO factura) {
        ClienteRegistrarFactura cliente = new ClienteRegistrarFactura();
        return cliente.registrarFactura(Factura_TO.class,
                "" + factura.getTotal(),
                "" + factura.getSubTotal(),
                "" + factura.getNeto(),
                "" + factura.getIva(),
                "" + factura.getDescuento(),
                "" + factura.getFecha(),
                "" + factura.getPedido().getIdPedido()
        );
    }

    public Factura_TO eliminarFactura(Factura_TO factura) {
        ClienteEliminarFactura cliente = new ClienteEliminarFactura();
        return cliente.eliminarFactura(Factura_TO.class, "" + factura.getIdFactura());
    }

    public Factura_TO consultarFactura(Pedido_TO pedido) {
        ClienteConsultarFacturaPorPedido cliente = new ClienteConsultarFacturaPorPedido();
        return cliente.consultarFacturaPedido(Factura_TO.class, "" + pedido.getIdPedido());
    }

    public List<Factura_TO> consultarFacturas() {
        ClienteConsultarFacturas cliente = new ClienteConsultarFacturas();
        List<LinkedHashMap> datos = cliente.consultarFacturas(List.class);
        List<Factura_TO> facturas = new ArrayList<>();
        PedidoDao pd = new PedidoDao();

        for (int i = 0; i <= datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pedido");
            Pedido_TO pedido = pd.consultarPedido(new Pedido_TO((int) map.get("idPedido")));
            facturas.add(new Factura_TO((int) datos.get(i).get("idFactura"),
                    (double) datos.get(i).get("total"),
                    (double) datos.get(i).get("subTotal"),
                    (double) datos.get(i).get("neto"),
                    (double) datos.get(i).get("iva"),
                    (double) datos.get(i).get("descuento"),
                    (Date) datos.get(i).get("fecha"), pedido));
        }

        return facturas;

    }

}
