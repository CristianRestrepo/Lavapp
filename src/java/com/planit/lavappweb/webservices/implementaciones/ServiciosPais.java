/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Pais_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPais;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPaises;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPais;
import com.planit.lavappweb.webservices.clientes.ClienteModificarPais;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPais;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosPais {

    Pais_TO pais = new Pais_TO();

    public Pais_TO registrarPais(String nombre) {
        ClienteRegistrarPais cliente = new ClienteRegistrarPais();
        return cliente.registrarPais(Pais_TO.class, nombre);
    }

    public Pais_TO modificarPais(int idPais, String nombre) {
        ClienteModificarPais cliente = new ClienteModificarPais();
        return cliente.modificarPais(Pais_TO.class, "" + idPais, nombre);
    }

    public Pais_TO eliminarPais(int idPais) {
        ClienteEliminarPais cliente = new ClienteEliminarPais();
        return cliente.eliminarPais(Pais_TO.class, "" + idPais);
    }

    public Pais_TO consultarPais(int idPais) {
        ClienteConsultarPais cliente = new ClienteConsultarPais();
        return cliente.consultarPais(Pais_TO.class, "" + idPais);
    }

    public List<Pais_TO> consultarPaises() {
        ClienteConsultarPaises cliente = new ClienteConsultarPaises();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = cliente.consultarPaises(List.class);
        List<Pais_TO> paises = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            paises.add(new Pais_TO((int) datos.get(i).get("idPais"), (String) datos.get(i).get("nombre")));
        }
        return paises;
    }
}
