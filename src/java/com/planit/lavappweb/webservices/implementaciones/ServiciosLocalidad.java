/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Localidad_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarLocalidades;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarLocalidad;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarLocalidades;
import com.planit.lavappweb.webservices.clientes.ClienteEditarLocalidad;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarLocalidad;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarLocalidad;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosLocalidad {

    public List<Localidad_TO> consultarLocalidades() {
        ClienteConsultarLocalidades cliente = new ClienteConsultarLocalidades();
        List<LinkedHashMap> datos = cliente.consultarLocalidades(List.class);
        List<Localidad_TO> localidades = new ArrayList<>();
        ServiciosCiudad servCiudad = new ServiciosCiudad();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("ciudad");
            localidades.add(new Localidad_TO((int) datos.get(i).get("idLocalidad"),
                    (String) datos.get(i).get("nombre"),
                    servCiudad.consultarCiudad((int) map.get("idCiudad"), "")));
        }
        return localidades;
    }

    public List<Localidad_TO> BuscarLocalidades(String valor) {
        ClienteBuscarLocalidades cliente = new ClienteBuscarLocalidades();
        List<LinkedHashMap> datos = cliente.buscarLocalidades(List.class, valor);
        List<Localidad_TO> localidades = new ArrayList<>();
        ServiciosCiudad servCiudad = new ServiciosCiudad();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("ciudad");
            localidades.add(new Localidad_TO((int) datos.get(i).get("idLocalidad"),
                    (String) datos.get(i).get("nombre"),
                    servCiudad.consultarCiudad((int) map.get("idCiudad"), "")));
        }
        return localidades;
    }

    public Localidad_TO consultarLocalidad(int idLocalidad, String nombre) {
        ClienteConsultarLocalidad cliente = new ClienteConsultarLocalidad();
        return cliente.consultarLocalidad(Localidad_TO.class, "" + idLocalidad, nombre);
    }

    public Localidad_TO registrarLocalidad(String nombre, int idCiudad) {
        ClienteRegistrarLocalidad cliente = new ClienteRegistrarLocalidad();
        return cliente.registrarLocalidad(Localidad_TO.class, nombre, "" + idCiudad);
    }

    public Localidad_TO editarLocalidad(int idLocalidad, String nombre, int idCiudad) {
        ClienteEditarLocalidad cliente = new ClienteEditarLocalidad();
        return cliente.editarLocalidad(Localidad_TO.class, "" + idLocalidad, nombre, "" + idCiudad);
    }

    public Localidad_TO eliminarLocalidad(int idLocalidad) {
        ClienteEliminarLocalidad cliente = new ClienteEliminarLocalidad();
        return cliente.eliminarLocalidad(Localidad_TO.class, "" + idLocalidad);
    }
}
