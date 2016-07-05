/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Rol_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarRol;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarRoles;
import com.planit.lavappweb.webservices.clientes.ClienteEditarRol;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarRol;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarRol;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosRol {

    public List<Rol_TO> consultarRoles() {
        ClienteConsultarRoles cliente = new ClienteConsultarRoles();
        List<LinkedHashMap> datos = cliente.consultarRoles(List.class);
        List<Rol_TO> roles = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            roles.add(new Rol_TO((int) datos.get(i).get("idRol"), (String) datos.get(i).get("nombre")));
        }
        return roles;
    }

    public Rol_TO consultarRol(int idRol, String nombre) {
        ClienteConsultarRol cliente = new ClienteConsultarRol();
        return cliente.consultarRol(Rol_TO.class, "" + idRol, nombre);
    }   

    public Rol_TO registrarRol(String nombre) {
        ClienteRegistrarRol cliente = new ClienteRegistrarRol();
        return cliente.registrarRol(Rol_TO.class, nombre);
    }

    public Rol_TO editarRol(int idRol, String nombre) {
        ClienteEditarRol cliente = new ClienteEditarRol();
        return cliente.editarRol(Rol_TO.class, "" + idRol, nombre);
    }

    public Rol_TO eliminarRol(int idRol) {
        ClienteEliminarRol Cliente = new ClienteEliminarRol();
        return Cliente.eliminarRol(Rol_TO.class, "" + idRol);
    }
}
