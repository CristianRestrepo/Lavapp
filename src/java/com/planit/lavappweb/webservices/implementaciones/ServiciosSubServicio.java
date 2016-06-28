/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicio_SP;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarSubServicio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarServicio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarSubServicio;
import com.planit.lavappweb.webservices.clientes.ClienteRegistarSubServicio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosSubServicio {

    public List<SubServicio_TO> consultarSubServiciosPorId(int idServicio) {
        ClienteConsultarSubServicio_SP subServiCliente = new ClienteConsultarSubServicio_SP();
        return subServiCliente.consultarSubServicios(List.class, "" + idServicio);
    }

    public List<SubServicio_TO> consultarSubServicios() {
        List<SubServicio_TO> subServicios = new ArrayList<>();
        ClienteConsultarSubServicios Cliente = new ClienteConsultarSubServicios();
        List<LinkedHashMap> datos = Cliente.consultarSubServicios(List.class);
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("servicio");
            Servicio_TO servicio = new Servicio_TO((int)map.get("idServicio"));
            subServicios.add(new SubServicio_TO((int) datos.get(i).get("idSubServicio"), (String) datos.get(i).get("nombre"), servicio));
        }
        return subServicios;
    }

    public SubServicio_TO registrarSubServicio(String nombre, int idServicio) {
        ClienteRegistarSubServicio clieSubServicio = new ClienteRegistarSubServicio();
        return clieSubServicio.registrarSubServicio(SubServicio_TO.class, "" + nombre, "" + idServicio);
    }

    public SubServicio_TO editarSubServicio(int idSubServicio, String nombre, int idServicio) {
        ClienteEditarSubServicio cliente = new ClienteEditarSubServicio();
        return cliente.modificarSubServicio(SubServicio_TO.class, "" + idSubServicio, nombre, "" + idServicio);
    }

    public SubServicio_TO eliminarSubServicio(int idSubServicio) {
        ClienteEliminarSubServicio cliente = new ClienteEliminarSubServicio();
        return cliente.eliminarSubServicio(SubServicio_TO.class, "" + idSubServicio);
                
    }
}
