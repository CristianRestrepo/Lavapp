/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Departamento_TO;
import com.planit.lavappweb.modelo.dto.Pais_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarDepartamentos;
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
public class DepartamentoDao {

    public List<Departamento_TO> consultarDepartamentos() {

        ClienteConsultarDepartamentos cliente = new ClienteConsultarDepartamentos();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = cliente.consultarDepartamentos(List.class);

        List<Departamento_TO> departamentos = new ArrayList<>();

        Pais_TO pais = new Pais_TO();
        PaisDao pd = new PaisDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pais");
            pais = pd.consultarPais(new Pais_TO((int) map.get("idPais"), ""));
            departamentos.add(new Departamento_TO((int) datos.get(i).get("idDepartamento"),
                    (String) datos.get(i).get("nombre"), pais));
        }
        return departamentos;
    }

    public List<Departamento_TO> buscarDepartamentos(String valor) {
        ClienteBuscarDepartamentos cliente = new ClienteBuscarDepartamentos();
        List<LinkedHashMap> datos = cliente.buscarDepartamentos(List.class, valor);

        List<Departamento_TO> departamentos = new ArrayList<>();
        Pais_TO pais = new Pais_TO();
        PaisDao pd = new PaisDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pais");
            pais = pd.consultarPais(new Pais_TO((int) map.get("idPais"), ""));
            departamentos.add(new Departamento_TO((int) datos.get(i).get("idDepartamento"),
                    (String) datos.get(i).get("nombre"), pais));
        }
        return departamentos;
    }

    public Departamento_TO registrarDepartamento(Departamento_TO departamento) {
        PaisDao pd = new PaisDao();
        departamento.setPais(pd.consultarPais(departamento.getPais()));

        ClienteRegistrarDepartamento cliente = new ClienteRegistrarDepartamento();
        return cliente.registrarDepartamento(Departamento_TO.class,
                departamento.getNombre(),
                "" + departamento.getPais().getIdPais());
    }

    public Departamento_TO editarDepartamento(Departamento_TO departamento) {
        PaisDao pd = new PaisDao();
        departamento.setPais(pd.consultarPais(departamento.getPais()));

        ClienteEditarDepartamento cliente = new ClienteEditarDepartamento();
        return cliente.editarDepartamento(Departamento_TO.class,
                "" + departamento.getIdDepartamento(),
                departamento.getNombre(),
                "" + departamento.getPais().getIdPais());
    }

    public Departamento_TO eliminarDepartamento(Departamento_TO departamento) {
        ClienteEliminarDepartamento cliente = new ClienteEliminarDepartamento();
        return cliente.eliminarDepartamento(Departamento_TO.class, "" + departamento.getIdDepartamento());
    }

    public Departamento_TO consultarDepartamento(Departamento_TO departamento) {
        ClienteConsultarDepartamento cliente = new ClienteConsultarDepartamento();
        return cliente.consultarDepartamento(Departamento_TO.class, "" + departamento.getIdDepartamento(),
                departamento.getNombre());
    }
}
