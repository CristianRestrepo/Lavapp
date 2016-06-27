/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Departamento_TO;
import com.planit.lavappweb.modelos.Pais_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarDepartamento;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarDepartamentos;
import com.planit.lavappweb.webservices.clientes.ClienteEditarDepartamento;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarDepartamento;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarDepartamento;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosDepartamento {

    public List<Departamento_TO> consultarDepartamentos() {
        ClienteConsultarDepartamentos cliente = new ClienteConsultarDepartamentos();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = cliente.consultarDepartamentos(List.class);
        List<Departamento_TO> departamentos = new ArrayList<>();
        Pais_TO pais = new Pais_TO();
        ServiciosPais serviciosPais = new ServiciosPais();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pais");
            pais = serviciosPais.consultarPais((int) map.get("idPais"));
            departamentos.add(new Departamento_TO((int) datos.get(i).get("idDepartamento"),
                    (String) datos.get(i).get("nombre"), pais));
        }
        return departamentos;
    }

    public Departamento_TO registrarDepartamento(String nombre , int idPais) {
        ClienteRegistrarDepartamento cliente = new ClienteRegistrarDepartamento();
        return cliente.registrarDepartamento(Departamento_TO.class, nombre, "" + idPais);
    }

    public Departamento_TO editarDepartamento(int idDepartamento, String nombre, int idPais) {
        ClienteEditarDepartamento cliente = new ClienteEditarDepartamento();
        return cliente.editarDepartamento(Departamento_TO.class,
                "" + idDepartamento, nombre,
                "" + idPais);
    }

    public Departamento_TO eliminarDepartamento(int idDepartamento) {
        ClienteEliminarDepartamento cliente = new ClienteEliminarDepartamento();
        return cliente.eliminarDepartamento(Departamento_TO.class, "" + idDepartamento);
    }
    
    public Departamento_TO consultarDepartamento(int idDepartemento) {
        ClienteConsultarDepartamento cliente = new ClienteConsultarDepartamento();
        return cliente.consultarDepartamento(Departamento_TO.class, "" + idDepartemento);
    }
}
