/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Estrato_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarEstratos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstrato;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarEstratos;
import com.planit.lavappweb.webservices.clientes.ClienteEditarEstrato;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarEstrato;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarEstrato;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class EstratoDao {
    
    public Estrato_TO registrarEstrato(Estrato_TO estrato) {
        ClienteRegistrarEstrato cliente = new ClienteRegistrarEstrato();
        return cliente.registrarEstrato(Estrato_TO.class, estrato.getNombre());
    }

    public Estrato_TO editarEstrato(Estrato_TO estrato) {
        ClienteEditarEstrato cliente = new ClienteEditarEstrato();
        return cliente.editarEstrato(Estrato_TO.class, "" + estrato.getIdEstrato(),
                estrato.getNombre());
    }

    public Estrato_TO eliminarEstrato(Estrato_TO estrato) {
        ClienteEliminarEstrato cliente = new ClienteEliminarEstrato();
        return cliente.eliminarEstrato(Estrato_TO.class, "" + estrato.getIdEstrato());
    }

    public List<Estrato_TO> consultarEstratos() {
        ClienteConsultarEstratos cliente = new ClienteConsultarEstratos();
        List<LinkedHashMap> datos = cliente.consultarEstratos(List.class);
        List<Estrato_TO> estratos = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            estratos.add(new Estrato_TO((int) datos.get(i).get("idEstrato"),
                    (String) datos.get(i).get("nombre")));
        }
        return estratos;
    }
    
    public List<Estrato_TO> buscarEstratos(String valor){
        ClienteBuscarEstratos cliente = new ClienteBuscarEstratos();
        List<LinkedHashMap> datos = cliente.buscarEstratos(List.class, valor);
        List<Estrato_TO> estratos = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            estratos.add(new Estrato_TO((int) datos.get(i).get("idEstrato"),
                    (String) datos.get(i).get("nombre")));
        }
        return estratos;
    }

    public Estrato_TO consultarEstrato(Estrato_TO estrato) {
        ClienteConsultarEstrato cliente = new ClienteConsultarEstrato();
        return cliente.consultarEstrato(Estrato_TO.class, "" + estrato.getIdEstrato(),
                estrato.getNombre());
   }
}
