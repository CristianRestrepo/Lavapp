/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarSubServicios;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicio;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarSubServicio;
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

    public SubServicio_TO consultarSubServicio(int idSubServicio, String nombre){
        ClienteConsultarSubServicio cliente = new ClienteConsultarSubServicio();
        return cliente.consultarSubServicio(SubServicio_TO.class, "" + idSubServicio, nombre);
    }   

    public List<SubServicio_TO> consultarSubServicios() {
        List<SubServicio_TO> subServicios = new ArrayList<>();
        ClienteConsultarSubServicios Cliente = new ClienteConsultarSubServicios();
        ServiciosServicios ss = new ServiciosServicios();        
        List<LinkedHashMap> datos = Cliente.consultarSubServicios(List.class);
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("servicio");
            Servicio_TO servicio = ss.consultarServicio((int)map.get("idServicio"), "");
            subServicios.add(new SubServicio_TO((int) datos.get(i).get("idSubServicio"), (String) datos.get(i).get("nombre"), servicio));
        }
        return subServicios;
    }
    
    public List<SubServicio_TO> buscarSubServicios(String valor) {
        List<SubServicio_TO> subServicios = new ArrayList<>();
        ClienteBuscarSubServicios Cliente = new ClienteBuscarSubServicios();
        ServiciosServicios ss = new ServiciosServicios();        
        List<LinkedHashMap> datos = Cliente.buscarSubServicio(List.class, valor);
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("servicio");
            Servicio_TO servicio = ss.consultarServicio((int)map.get("idServicio"), "");
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
