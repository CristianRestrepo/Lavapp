/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Costo_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCostoSubProducto;
import com.planit.lavappweb.webservices.clientes.ClienteEditarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCostoPedido;

/**
 *
 * @author Desarrollo_Planit
 */
public class CostoDao {

    public Costo_TO consultarCosto(Costo_TO costo) {
        ClienteConsultarCosto cliente = new ClienteConsultarCosto();
        return cliente.consultarCosto(Costo_TO.class,
                "" + costo.getIdCosto());
    }
    
    public String ConsultarCostoPedido(Pedido_TO pedido){
        ClienteConsultarCostoPedido cliente = new ClienteConsultarCostoPedido();
        return cliente.consultarCostoPedido(String.class, "" + pedido.getIdPedido());
    } 

    public Costo_TO consultarCostoSubProducto(SubProducto_TO subproducto) {
        ClienteConsultarCostoSubProducto cliente = new ClienteConsultarCostoSubProducto();
        return cliente.consultarCostoSubProducto(Costo_TO.class,
                "" + subproducto.getIdSubProducto());
    }

    public Costo_TO RegistrarCosto(Costo_TO costo) {
        SubProductoDao spd = new SubProductoDao();
        ZonaDao zd = new ZonaDao();
        costo.setSubProducto(spd.consultarSubProducto(costo.getSubProducto()));
        costo.setZona(zd.consultarZona(costo.getZona()));

        ClienteRegistrarCosto cliente = new ClienteRegistrarCosto();
        return cliente.registrarCosto(Costo_TO.class, "" + costo.getValor(),
                "" + costo.getSubProducto().getIdSubProducto(),
                "" + costo.getZona().getIdZona());
    }

    public Costo_TO modificarCosto(Costo_TO costo) {
        SubProductoDao spd = new SubProductoDao();
        ZonaDao zd = new ZonaDao();
        costo.setSubProducto(spd.consultarSubProducto(costo.getSubProducto()));
        costo.setZona(zd.consultarZona(costo.getZona()));

        ClienteEditarCosto cliente = new ClienteEditarCosto();
        return cliente.editarCosto(Costo_TO.class,
                "" + costo.getIdCosto(),
                "" + costo.getValor(),
                "" + costo.getSubProducto().getIdSubProducto(),
                "" + costo.getZona().getIdZona());
    }

    public Costo_TO eliminarCosto(Costo_TO costo) {
        ClienteEliminarCosto cliente = new ClienteEliminarCosto();
        return cliente.eliminarCosto(Costo_TO.class,
                "" + costo.getIdCosto());
    }
}
