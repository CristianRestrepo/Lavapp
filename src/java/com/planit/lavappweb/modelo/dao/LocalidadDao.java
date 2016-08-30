/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Ciudad_TO;
import com.planit.lavappweb.modelo.dto.Localidad_TO;
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
public class LocalidadDao {

    public Localidad_TO registrarLocalidad(Localidad_TO localidad) {
        CiudadDao cd = new CiudadDao();
        localidad.setCiudad(cd.consultarCiudad(localidad.getCiudad()));

        ClienteRegistrarLocalidad cliente = new ClienteRegistrarLocalidad();
        return cliente.registrarLocalidad(Localidad_TO.class,
                localidad.getNombre(),
                "" + localidad.getCiudad().getIdCiudad());
    }

    public Localidad_TO modificarLocalidad(Localidad_TO localidad) {
        CiudadDao cd = new CiudadDao();
        localidad.getCiudad().setIdCiudad(0);
        localidad.setCiudad(cd.consultarCiudad(localidad.getCiudad()));

        ClienteEditarLocalidad cliente = new ClienteEditarLocalidad();
        return cliente.editarLocalidad(Localidad_TO.class,
                "" + localidad.getIdLocalidad(),
                localidad.getNombre(),
                "" + localidad.getCiudad().getIdCiudad());
    }

    public Localidad_TO eliminarLocalidad(Localidad_TO localidad) {
        ClienteEliminarLocalidad cliente = new ClienteEliminarLocalidad();
        return cliente.eliminarLocalidad(Localidad_TO.class,
                "" + localidad.getIdLocalidad());
    }

    public List<Localidad_TO> consultarLocalidades() {
        ClienteConsultarLocalidades cliente = new ClienteConsultarLocalidades();
        List<LinkedHashMap> datos = cliente.consultarLocalidades(List.class);
        List<Localidad_TO> localidades = new ArrayList<>();
        CiudadDao cd = new CiudadDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("ciudad");
            localidades.add(new Localidad_TO((int) datos.get(i).get("idLocalidad"),
                    (String) datos.get(i).get("nombre"),
                    cd.consultarCiudad(new Ciudad_TO((int) map.get("idCiudad"), ""))));
        }
        return localidades;
    }

    public List<Localidad_TO> BuscarLocalidades(String valor) {
        ClienteBuscarLocalidades cliente = new ClienteBuscarLocalidades();
        List<LinkedHashMap> datos = cliente.buscarLocalidades(List.class, valor);
        List<Localidad_TO> localidades = new ArrayList<>();
        CiudadDao cd = new CiudadDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("ciudad");
            localidades.add(new Localidad_TO((int) datos.get(i).get("idLocalidad"),
                    (String) datos.get(i).get("nombre"),
                    cd.consultarCiudad(new Ciudad_TO((int) map.get("idCiudad"), ""))));
        }
        return localidades;
    }

    public Localidad_TO consultarLocalidad(Localidad_TO localidad) {
        ClienteConsultarLocalidad cliente = new ClienteConsultarLocalidad();
        return cliente.consultarLocalidad(Localidad_TO.class,
                "" + localidad.getIdLocalidad(),
                localidad.getNombre());
    }
}
