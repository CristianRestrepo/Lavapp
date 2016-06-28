/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Ciudad_TO;
import com.planit.lavappweb.modelos.Departamento_TO;
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
public class ServiciosCiudad {

    public List<Ciudad_TO> consultarCiudades() {
        ClienteConsultarCiudades cliente = new ClienteConsultarCiudades();
        List<LinkedHashMap> datos = cliente.consultarCiudades(List.class);
        List<Ciudad_TO> ciudades = new ArrayList<>();
        ServiciosDepartamento servDepartamento = new ServiciosDepartamento();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("departamento");
            Departamento_TO departamento = servDepartamento.consultarDepartamento((int) map.get("idDepartamento"), "");
            ciudades.add(new Ciudad_TO((int) datos.get(i).get("idCiudad"), (String) datos.get(i).get("nombre"), departamento));
        }
        return ciudades;
    }
    
    public Ciudad_TO consultarCiudad(int idCiudad, String nombre){
        ClienteConsultarCiudad cliente = new ClienteConsultarCiudad();
        return cliente.consultarCiudad(Ciudad_TO.class, "" + idCiudad, nombre);
    }

    public Ciudad_TO registrarCiudad(String nombre, int idDepartamento) {
        ClienteRegistrarCiudad cliente = new ClienteRegistrarCiudad();
        return cliente.registrarCiudad(Ciudad_TO.class, nombre, "" + idDepartamento);
    }
    
    public Ciudad_TO editarCiudad(int idCiudad, String nombre, int idDepartamento) {
        ClienteEditarCiudad cliente = new ClienteEditarCiudad();
        return cliente.editarCiudad(Ciudad_TO.class, "" + idCiudad, nombre, "" + idDepartamento);
    }
    
    public Ciudad_TO eliminarCiudad(int idCiudad) {
        ClienteEliminarCiudad cliente = new ClienteEliminarCiudad();
        return cliente.eliminarCiudad(Ciudad_TO.class, "" + idCiudad);
    }
}
