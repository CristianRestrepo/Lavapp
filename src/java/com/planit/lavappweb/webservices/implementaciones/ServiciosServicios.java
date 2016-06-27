/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarServicios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarServicio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosServicios {

    public List<Servicio_TO> consultarServicios() {
        ClienteConsultarServicios clienteServicio = new ClienteConsultarServicios();
        List<LinkedHashMap> datos = clienteServicio.consultarServicios(List.class);
        List<Servicio_TO> servicios = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            servicios.add(new Servicio_TO((int) datos.get(i).get("idServicio"), (String) datos.get(i).get("nombre")));
        }
        return servicios;
    }

    public Servicio_TO registrarServicio(String nombre) {
        ClienteRegistrarServicio regisServicio = new ClienteRegistrarServicio();
        return regisServicio.registrarServicio(Servicio_TO.class, nombre);
    }

    public Servicio_TO editarServicio(int idServicio, String nombre) {
        ClienteEditarServicio cliente = new ClienteEditarServicio();
        return cliente.modificarServicio(Servicio_TO.class, "" + idServicio, nombre);
    }

    public Servicio_TO eliminarServicio(int idServicio) {
        ClienteEliminarServicio cliente = new ClienteEliminarServicio();
        return cliente.eliminarServicio(Servicio_TO.class, "" + idServicio);
    }

}
