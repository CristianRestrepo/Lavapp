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
        //Instancia del cliente del web service consultar costo
        ClienteConsultarCosto cliente = new ClienteConsultarCosto();
        //Retornamos el resultado del metodo consultar costo
        return cliente.consultarCosto(Costo_TO.class,
                "" + costo.getIdCosto());
    }
    
    public String ConsultarCostoPedido(Pedido_TO pedido){
        //Instancia del cliente del web service consultar costo pedido
        ClienteConsultarCostoPedido cliente = new ClienteConsultarCostoPedido();
        //Retornamo el resultado del metodo consultar costo pedido
        return cliente.consultarCostoPedido(String.class, "" + pedido.getIdPedido());
    } 

    public Costo_TO consultarCostoSubProducto(SubProducto_TO subproducto) {
        //Instancia del cliente del web service consultar costo sub producto
        ClienteConsultarCostoSubProducto cliente = new ClienteConsultarCostoSubProducto();
        return cliente.consultarCostoSubProducto(Costo_TO.class,
                "" + subproducto.getIdSubProducto());
    }

    public Costo_TO RegistrarCosto(Costo_TO costo) {        
        //instancias de los daos necesarios para rearmar los objetos costo
        SubProductoDao spd = new SubProductoDao();
        ZonaDao zd = new ZonaDao();
        //consultamos la informacion completa del subproducto al que se le esta consultando el costo
        costo.setSubProducto(spd.consultarSubProducto(costo.getSubProducto()));
        costo.setZona(zd.consultarZona(costo.getZona()));

        //Instancia del cliente del web service registrar costo
        ClienteRegistrarCosto cliente = new ClienteRegistrarCosto();
        return cliente.registrarCosto(Costo_TO.class, "" + costo.getValor(),
                "" + costo.getSubProducto().getIdSubProducto(),
                "" + costo.getZona().getIdZona());
    }

    public Costo_TO modificarCosto(Costo_TO costo) {
        //Instancias de los dao necesarios para reconstruir un objeto costo
        SubProductoDao spd = new SubProductoDao();
        ZonaDao zd = new ZonaDao();
        //consultamos la informacion completa del subproducto al que se le esta consultando el costo
        costo.setSubProducto(spd.consultarSubProducto(costo.getSubProducto()));
        costo.setZona(zd.consultarZona(costo.getZona()));

        //Instancia del cliente del web service editar costo
        ClienteEditarCosto cliente = new ClienteEditarCosto();
        return cliente.editarCosto(Costo_TO.class,
                "" + costo.getIdCosto(),
                "" + costo.getValor(),
                "" + costo.getSubProducto().getIdSubProducto(),
                "" + costo.getZona().getIdZona());
    }

    public Costo_TO eliminarCosto(Costo_TO costo) {
        //instancia del cliente del web service eliminarCosto
        ClienteEliminarCosto cliente = new ClienteEliminarCosto();
        return cliente.eliminarCosto(Costo_TO.class,
                "" + costo.getIdCosto());
    }
}
