/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Servicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarServicios;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarServicios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarServicio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServicioDao {
 
    public List<Servicio_TO> consultarServicios() {
        ClienteConsultarServicios clienteServicio = new ClienteConsultarServicios();
        List<LinkedHashMap> datos = clienteServicio.consultarServicios(List.class);
        List<Servicio_TO> servicios = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            servicios.add(new Servicio_TO((int) datos.get(i).get("idServicio"), (String) datos.get(i).get("nombre")));
        }
        return servicios;
    }
    
    public List<Servicio_TO> BuscarServicios(String valor) {
        ClienteBuscarServicios cliente = new ClienteBuscarServicios();
        List<LinkedHashMap> datos = cliente.buscarServicios(List.class, valor);
        List<Servicio_TO> servicios = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            servicios.add(new Servicio_TO((int) datos.get(i).get("idServicio"), (String) datos.get(i).get("nombre")));
        }
        return servicios;
    }
    
    public Servicio_TO consultarServicio(Servicio_TO servicio){
        ClienteConsultarServicio cliente = new ClienteConsultarServicio();
        return cliente.consultarServicio(Servicio_TO.class, "" + servicio.getIdServicio(), 
                servicio.getNombre());
    }

    public Servicio_TO registrarServicio(Servicio_TO servicio) {
        ClienteRegistrarServicio regisServicio = new ClienteRegistrarServicio();
        return regisServicio.registrarServicio(Servicio_TO.class, servicio.getNombre());
    }

    public Servicio_TO editarServicio(Servicio_TO servicio) {
        ClienteEditarServicio cliente = new ClienteEditarServicio();
        return cliente.modificarServicio(Servicio_TO.class, "" + servicio.getIdServicio(),
                servicio.getNombre());
    }

    public Servicio_TO eliminarServicio(Servicio_TO servicio) {
        ClienteEliminarServicio cliente = new ClienteEliminarServicio();
        return cliente.eliminarServicio(Servicio_TO.class, "" + servicio.getIdServicio());
    }    
}
