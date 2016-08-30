/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Servicio_TO;
import com.planit.lavappweb.modelo.dto.SubServicio_TO;
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
 * @author Desarrollo_Planit
 */
public class SubServicioDao {
    
     public SubServicio_TO consultarSubServicio(SubServicio_TO subServicio){
        ClienteConsultarSubServicio cliente = new ClienteConsultarSubServicio();
        return cliente.consultarSubServicio(SubServicio_TO.class,
                "" + subServicio.getIdSubServicio(),
                subServicio.getNombre());
    }   

    public List<SubServicio_TO> consultarSubServicios() {
        List<SubServicio_TO> subServicios = new ArrayList<>();
        ClienteConsultarSubServicios Cliente = new ClienteConsultarSubServicios();
        ServicioDao sd = new ServicioDao();
        List<LinkedHashMap> datos = Cliente.consultarSubServicios(List.class);
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("servicio");
            Servicio_TO servicio = sd.consultarServicio(new Servicio_TO((int)map.get("idServicio"), ""));
            subServicios.add(new SubServicio_TO((int) datos.get(i).get("idSubServicio"), (String) datos.get(i).get("nombre"), servicio));
        }
        return subServicios;
    }
    
    public List<SubServicio_TO> buscarSubServicios(String valor) {
        List<SubServicio_TO> subServicios = new ArrayList<>();
        ClienteBuscarSubServicios Cliente = new ClienteBuscarSubServicios();
        ServicioDao sd = new ServicioDao();     
        List<LinkedHashMap> datos = Cliente.buscarSubServicio(List.class, valor);
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("servicio");
            Servicio_TO servicio = sd.consultarServicio(new Servicio_TO((int)map.get("idServicio"), ""));
            subServicios.add(new SubServicio_TO((int) datos.get(i).get("idSubServicio"), (String) datos.get(i).get("nombre"), servicio));
        }
        return subServicios;
    }

    public SubServicio_TO registrarSubServicio(SubServicio_TO subServicio) {
        ServicioDao sd = new ServicioDao();
        subServicio.setServicio(sd.consultarServicio(subServicio.getServicio()));
        
        ClienteRegistarSubServicio clieSubServicio = new ClienteRegistarSubServicio();
        return clieSubServicio.registrarSubServicio(SubServicio_TO.class, 
                "" + subServicio.getNombre(),
                "" + subServicio.getServicio().getIdServicio());
    }

    public SubServicio_TO editarSubServicio(SubServicio_TO subServicio) {
        ServicioDao sd = new ServicioDao();
        subServicio.getServicio().setIdServicio(0);
        subServicio.setServicio(sd.consultarServicio(subServicio.getServicio()));
        
        ClienteEditarSubServicio cliente = new ClienteEditarSubServicio();
        return cliente.modificarSubServicio(SubServicio_TO.class, 
                "" + subServicio.getIdSubServicio(), 
                "" + subServicio.getNombre(),
                "" + subServicio.getServicio().getIdServicio());
    }

    public SubServicio_TO eliminarSubServicio(SubServicio_TO subServicio) {
        ClienteEliminarSubServicio cliente = new ClienteEliminarSubServicio();
        return cliente.eliminarSubServicio(SubServicio_TO.class, "" + subServicio.getIdSubServicio());
                
    }
}
