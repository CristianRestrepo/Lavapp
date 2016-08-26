/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Jornada_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarJornadas;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarJornada;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarJornadas;
import com.planit.lavappweb.webservices.clientes.ClienteEditarJornada;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarJornada;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarJornada;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class JornadaDao {
    
     public List<Jornada_TO> consultarJornadas() {
      ClienteConsultarJornadas cliente = new ClienteConsultarJornadas();
        List<LinkedHashMap> datos = cliente.consultarJornadas(List.class);
        List<Jornada_TO> jornadas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            jornadas.add(new Jornada_TO((int) datos.get(i).get("idJornada"), 
                    (String) datos.get(i).get("nombre")));
        }
        return jornadas;
    }

    public List<Jornada_TO> buscarJornadas(String valor) {
        ClienteBuscarJornadas cliente = new ClienteBuscarJornadas();
        List<LinkedHashMap> datos = cliente.buscarJornadas(List.class, valor);
        List<Jornada_TO> jornadas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            jornadas.add(new Jornada_TO((int) datos.get(i).get("idJornada"), 
                    (String) datos.get(i).get("nombre")));
        }
        return jornadas;
    }

    public Jornada_TO consultarJornada(Jornada_TO jornada) {
        ClienteConsultarJornada cliente = new ClienteConsultarJornada();
        return cliente.consultarJornada(Jornada_TO.class, 
                "" + jornada.getIdJornada()
                , jornada.getNombre());
    }

    public Jornada_TO registraJornada(Jornada_TO jornada) {
        ClienteRegistrarJornada cliente = new ClienteRegistrarJornada();
        return cliente.registrarJornada(Jornada_TO.class, jornada.getNombre());
    }

    public Jornada_TO editarJornada(Jornada_TO jornada) {
        ClienteEditarJornada cliente = new ClienteEditarJornada();
        return cliente.editarJornada(Jornada_TO.class, "" + jornada.getIdJornada(),
                jornada.getNombre());
    }

    public Jornada_TO eliminarJornada(Jornada_TO jornada) {
        ClienteEliminarJornada cliente = new ClienteEliminarJornada();
        return cliente.eliminarJornada(Jornada_TO.class, "" + jornada.getIdJornada());
    }
}
