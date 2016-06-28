/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Barrio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarBarrios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarBarrio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosBarrios {

    public Barrio_TO registrarBarrio(String nombre, int idLocalidad, int idZona, int idEstrato) {
        ClienteRegistrarBarrio cliente = new ClienteRegistrarBarrio();
        return cliente.registrarBarrio(Barrio_TO.class, nombre, "" + idLocalidad, "" + idZona, "" + idEstrato);
    }

    public Barrio_TO editarBarrio(int idBarrios, String nombre, int idLocalidad, int idZona, int idEstrato) {
        ClienteEditarBarrio cliente = new ClienteEditarBarrio();
        return cliente.modificarBarrio(Barrio_TO.class, "" + idBarrios, nombre, "" + idLocalidad, "" + idZona, "" + idEstrato);
    }

    public Barrio_TO eliminarBarrio(int idBarrios) {
        ClienteEliminarBarrio cliente = new ClienteEliminarBarrio();
        return cliente.eliminarBarrio(Barrio_TO.class, "" + idBarrios);
    }

    public Barrio_TO consultarBarrio(int idBarrios, String nombre) {
        ClienteConsultarBarrio cliente = new ClienteConsultarBarrio();
        return cliente.consultarBarrio(Barrio_TO.class, "" + idBarrios, nombre);
    }

    public List<Barrio_TO> consultarBarrios() {
        ClienteConsultarBarrios cliente = new ClienteConsultarBarrios();
        List<LinkedHashMap> datos = cliente.consultarBarrios(List.class);
        List<Barrio_TO> barrios = new ArrayList<>();

        ServiciosLocalidad sl = new ServiciosLocalidad();
        ServiciosZona sz = new ServiciosZona();
        ServiciosEstrato se = new ServiciosEstrato();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap localidad = (LinkedHashMap) datos.get(i).get("localidad");
            LinkedHashMap zona = (LinkedHashMap) datos.get(i).get("zona");
            LinkedHashMap estrato = (LinkedHashMap) datos.get(i).get("estrato");
            barrios.add(new Barrio_TO((int) datos.get(i).get("idBarrios"),
                    (String) datos.get(i).get("nombre"),
                    sl.consultarLocalidad((int) localidad.get("idLocalidad"), ""),
                    sz.consultarZona((int) zona.get("idZona"), ""), 
                    se.consultarEstrato((int) estrato.get("idEstrato"), "")));
        }
        return barrios;
    }
}
