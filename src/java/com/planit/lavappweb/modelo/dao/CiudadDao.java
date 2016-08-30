/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Ciudad_TO;
import com.planit.lavappweb.modelo.dto.Departamento_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarCiudades;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCiudad;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCiudades;
import com.planit.lavappweb.webservices.clientes.ClienteEditarCiudad;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarCiudad;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarCiudad;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class CiudadDao {

    public List<Ciudad_TO> consultarCiudades() {
        ClienteConsultarCiudades cliente = new ClienteConsultarCiudades();
        List<LinkedHashMap> datos = cliente.consultarCiudades(List.class);
        List<Ciudad_TO> ciudades = new ArrayList<>();
        DepartamentoDao dd = new DepartamentoDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("departamento");
            Departamento_TO departamento = dd.consultarDepartamento(new Departamento_TO((int) map.get("idDepartamento"), ""));
            ciudades.add(new Ciudad_TO((int) datos.get(i).get("idCiudad"), (String) datos.get(i).get("nombre"), departamento));
        }
        return ciudades;
    }

    public List<Ciudad_TO> buscarCiudades(String valor) {
        ClienteBuscarCiudades cliente = new ClienteBuscarCiudades();
        List<LinkedHashMap> datos = cliente.buscarCiudades(List.class, valor);
        List<Ciudad_TO> ciudades = new ArrayList<>();
        DepartamentoDao dd = new DepartamentoDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("departamento");
            Departamento_TO departamento = dd.consultarDepartamento(new Departamento_TO((int) map.get("idDepartamento"), ""));
            ciudades.add(new Ciudad_TO((int) datos.get(i).get("idCiudad"), (String) datos.get(i).get("nombre"), departamento));
        }
        return ciudades;
    }

    public Ciudad_TO consultarCiudad(Ciudad_TO ciudad) {
        ClienteConsultarCiudad cliente = new ClienteConsultarCiudad();
        return cliente.consultarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad(),
                ciudad.getNombre());
    }

    public Ciudad_TO registrarCiudad(Ciudad_TO ciudad) {
        DepartamentoDao dd = new DepartamentoDao();
        ciudad.setDepartamento(dd.consultarDepartamento(ciudad.getDepartamento()));

        ClienteRegistrarCiudad cliente = new ClienteRegistrarCiudad();
        return cliente.registrarCiudad(Ciudad_TO.class, ciudad.getNombre(),
                "" + ciudad.getDepartamento().getIdDepartamento());
    }

    public Ciudad_TO editarCiudad(Ciudad_TO ciudad) {
        DepartamentoDao dd = new DepartamentoDao();
        ciudad.getDepartamento().setIdDepartamento(0);
        ciudad.setDepartamento(dd.consultarDepartamento(ciudad.getDepartamento()));
        
        ClienteEditarCiudad cliente = new ClienteEditarCiudad();
        return cliente.editarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad(),
                ciudad.getNombre(), "" + ciudad.getDepartamento().getIdDepartamento());
    }

    public Ciudad_TO eliminarCiudad(Ciudad_TO ciudad) {
        ClienteEliminarCiudad cliente = new ClienteEliminarCiudad();
        return cliente.eliminarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad());
    }

}
