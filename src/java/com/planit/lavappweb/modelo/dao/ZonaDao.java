/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Zona_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarZonas;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarZona;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarZonas;
import com.planit.lavappweb.webservices.clientes.ClienteEditarZona;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarZona;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarZona;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ZonaDao {
    
    public List<Zona_TO> consultarZonas() {
        ClienteConsultarZonas cliente = new ClienteConsultarZonas();
        List<LinkedHashMap> datos = cliente.consultarZonas(List.class);
        List<Zona_TO> zonas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            zonas.add(new Zona_TO((int) datos.get(i).get("idZona"), 
                    (String) datos.get(i).get("nombre"),
                    (String) datos.get(i).get("descripcion")));
        }
        return zonas;
    }
    
    public List<Zona_TO> buscarZonas(String valor){ 
        ClienteBuscarZonas cliente = new ClienteBuscarZonas();
        List<LinkedHashMap> datos = cliente.buscarZonas(List.class, valor);
        List<Zona_TO> zonas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            zonas.add(new Zona_TO((int) datos.get(i).get("idZona"), 
                    (String) datos.get(i).get("nombre"), 
                    (String) datos.get(i).get("descripcion")));
        }
        return zonas;
    }

    public Zona_TO consultarZona(Zona_TO zona) {
        ClienteConsultarZona cliente = new ClienteConsultarZona();
        return cliente.consultarZona(Zona_TO.class,
                "" + zona.getIdZona(),
                zona.getNombre());
    }

    public Zona_TO registrarZona(Zona_TO zona) {
        ClienteRegistrarZona cliente = new ClienteRegistrarZona();
        return cliente.registrarZona(Zona_TO.class,
                zona.getNombre(),
                zona.getDescripcion());
    }

    public Zona_TO editarZona(Zona_TO zona) {
        ClienteEditarZona cliente = new ClienteEditarZona();
        return cliente.editarZona(Zona_TO.class, 
                "" + zona.getIdZona(), 
                zona.getNombre(), 
                zona.getDescripcion());
    }

    public Zona_TO eliminarZona(Zona_TO zona) {
        ClienteEliminarZona cliente = new ClienteEliminarZona();
        return cliente.eliminarZona(Zona_TO.class, "" + zona.getIdZona());
    }
}
