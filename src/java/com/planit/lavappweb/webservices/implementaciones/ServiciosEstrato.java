/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Estrato_TO;
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
public class ServiciosEstrato {

    public Estrato_TO registrarEstrato(String nombre) {
        ClienteRegistrarEstrato cliente = new ClienteRegistrarEstrato();
        return cliente.registrarEstrato(Estrato_TO.class, nombre);
    }

    public Estrato_TO editarEstrato(int idEstrato, String nombre) {
        ClienteEditarEstrato cliente = new ClienteEditarEstrato();
        return cliente.editarEstrato(Estrato_TO.class, "" + idEstrato, nombre);
    }

    public Estrato_TO eliminarEstrato(int idEstrato) {
        ClienteEliminarEstrato cliente = new ClienteEliminarEstrato();
        return cliente.eliminarEstrato(Estrato_TO.class, "" + idEstrato);
    }

    public List<Estrato_TO> consultarEstratos() {
        ClienteConsultarEstratos cliente = new ClienteConsultarEstratos();
        List<LinkedHashMap> datos = cliente.consultarEstratos(List.class);
        List<Estrato_TO> estratos = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            estratos.add(new Estrato_TO((int) datos.get(i).get("idEstrato"), (String) datos.get(i).get("nombre")));
        }
        return estratos;
    }
    
    public List<Estrato_TO> buscarEstratos(String valor){
        ClienteBuscarEstratos cliente = new ClienteBuscarEstratos();
        List<LinkedHashMap> datos = cliente.buscarEstratos(List.class, valor);
        List<Estrato_TO> estratos = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            estratos.add(new Estrato_TO((int) datos.get(i).get("idEstrato"), (String) datos.get(i).get("nombre")));
        }
        return estratos;
    }

    public Estrato_TO consultarEstrato(int idEstrato, String nombre) {
        ClienteConsultarEstrato cliente = new ClienteConsultarEstrato();
        return cliente.consultarEstrato(Estrato_TO.class, "" + idEstrato, nombre);
   }
}
