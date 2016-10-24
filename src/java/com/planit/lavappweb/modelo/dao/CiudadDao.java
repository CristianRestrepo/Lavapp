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
        //Instancia del cliente del web service consultar ciudades
        ClienteConsultarCiudades cliente = new ClienteConsultarCiudades();

        //Variables, objetos y dao
        List<LinkedHashMap> datos = cliente.consultarCiudades(List.class);//Guardamos en la lista datos el resultado del metodo consultar ciudades
        List<Ciudad_TO> ciudades = new ArrayList<>();
        DepartamentoDao dd = new DepartamentoDao();

        //Rearmamos las ciudades extrayendo cada elemento que compone al objeto de la lista datos
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("departamento");
            Departamento_TO departamento = dd.consultarDepartamento(new Departamento_TO((int) map.get("idDepartamento"), ""));
            ciudades.add(new Ciudad_TO((int) datos.get(i).get("idCiudad"), (String) datos.get(i).get("nombre"), departamento));
        }
        return ciudades;
    }

    public List<Ciudad_TO> buscarCiudades(String valor) {
        //Instancia del cliente del metodo buscar ciudades
        ClienteBuscarCiudades cliente = new ClienteBuscarCiudades();

        //objetos, variables y dao
        List<LinkedHashMap> datos = cliente.buscarCiudades(List.class, valor);//Guardamos en la lista datos el resultado del metodo buscar ciudades
        List<Ciudad_TO> ciudades = new ArrayList<>();
        DepartamentoDao dd = new DepartamentoDao();

        //Rearmamos la lista de ciudades extrayendo cada elemento que compone al objeto de la lista datos
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("departamento");
            Departamento_TO departamento = dd.consultarDepartamento(new Departamento_TO((int) map.get("idDepartamento"), ""));
            ciudades.add(new Ciudad_TO((int) datos.get(i).get("idCiudad"), (String) datos.get(i).get("nombre"), departamento));
        }
        return ciudades;
    }

    public Ciudad_TO consultarCiudad(Ciudad_TO ciudad) {
        //Instancia del cliente del web service consultar ciudad
        ClienteConsultarCiudad cliente = new ClienteConsultarCiudad();
        //Retornamos el resultado del metodo consultar ciudad
        return cliente.consultarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad(),
                ciudad.getNombre());
    }

    public Ciudad_TO registrarCiudad(Ciudad_TO ciudad) {

        DepartamentoDao dd = new DepartamentoDao();
        //consultamos la informacion completa del departamento al que pertenece la ciudad 
        ciudad.setDepartamento(dd.consultarDepartamento(ciudad.getDepartamento()));

        //Instancia del cliente del web service registrar ciudad
        ClienteRegistrarCiudad cliente = new ClienteRegistrarCiudad();
        //retornamos el resultado del metodo registrar ciudad
        return cliente.registrarCiudad(Ciudad_TO.class, ciudad.getNombre(),
                "" + ciudad.getDepartamento().getIdDepartamento());
    }

    public Ciudad_TO editarCiudad(Ciudad_TO ciudad) {
        DepartamentoDao dd = new DepartamentoDao();
        ciudad.getDepartamento().setIdDepartamento(0);
        //consultamos la informacion completa del departamento al que pertenece la ciudad 
        ciudad.setDepartamento(dd.consultarDepartamento(ciudad.getDepartamento()));

        //Instancia del cliente del web service editar ciudad
        ClienteEditarCiudad cliente = new ClienteEditarCiudad();
        //retornamos el resultado del metodo registrar ciudad
        return cliente.editarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad(),
                ciudad.getNombre(), "" + ciudad.getDepartamento().getIdDepartamento());
    }

    public Ciudad_TO eliminarCiudad(Ciudad_TO ciudad) {
        //Instancia del cliente del web service eliminar ciudad
        ClienteEliminarCiudad cliente = new ClienteEliminarCiudad();
        //retornamos el resultado del metodo eliminar ciudad
        return cliente.eliminarCiudad(Ciudad_TO.class, "" + ciudad.getIdCiudad());
    }

}
