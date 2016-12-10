/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadoID;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadosPlanta;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstadosProducto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class EstadoDao {

    public Estado_TO consultarEstadoID(Estado_TO estado) {
        ClienteConsultarEstadoID clienteModelo = new ClienteConsultarEstadoID();
        return clienteModelo.consultarEstado(Estado_TO.class,
                "" + estado.getIdEstado(),
                estado.getNombre());
    }

    public List<Estado_TO> consultarEstadosProductos() {
        List<Estado_TO> estadosProducto = new ArrayList<>();
        ClienteConsultarEstadosProducto cliente = new ClienteConsultarEstadosProducto();
        List<HashMap> datos = cliente.consultarEstadoProducto(List.class);
        
        for (int i = 0; i < datos.size(); i++) {
            estadosProducto.add(new Estado_TO((int) datos.get(i).get("idEstado"), (String) datos.get(i).get("nombre")));
        }
        
        return estadosProducto;
    }
    
    public List<Estado_TO> consultarEstadosPlanta() {
        List<Estado_TO> estadosProducto = new ArrayList<>();
        ClienteConsultarEstadosPlanta cliente = new ClienteConsultarEstadosPlanta();
        List<HashMap> datos = cliente.consultarEstadosPlanta(List.class);
        
        for (int i = 0; i < datos.size(); i++) {
            estadosProducto.add(new Estado_TO((int) datos.get(i).get("idEstado"), (String) datos.get(i).get("nombre")));
        }
        
        return estadosProducto;
    }
}
