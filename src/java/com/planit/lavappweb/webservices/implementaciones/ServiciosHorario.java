/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Horario_TO;
import com.planit.lavappweb.modelos.Jornada_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHorarios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarHorario;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosHorario {

    public Horario_TO consultarHorario(int idHorario, String horario) {
        ClienteConsultarHorario cliente = new ClienteConsultarHorario();
        return cliente.consultarHorario(Horario_TO.class, "" + idHorario, horario);
    }

    public List<Horario_TO> consultarHorarios() {
        ClienteConsultarHorarios cliente = new ClienteConsultarHorarios();
        List<LinkedHashMap> datos = cliente.consultarHorarios(List.class);
        List<Horario_TO> horarios = new ArrayList<>();
        ServiciosJornadas sj = new ServiciosJornadas();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("jornada");
            Jornada_TO jornada = new Jornada_TO();
            jornada = sj.consultarJornada((int) map.get("idJornada"), "");
            horarios.add(new Horario_TO(
                    (int) datos.get(i).get("idHorario"),
                    (String) datos.get(i).get("horaInicio"),
                    (String) datos.get(i).get("horaFinal"),
                    jornada,
                    (String) datos.get(i).get("horario")
            ));
        }
        return horarios;
    }

    public Horario_TO registrarHorario(String horaInicio, String horaFinal, int idJornada, String horario) {
        ClienteRegistrarHorario cliente = new ClienteRegistrarHorario();
        return cliente.registrarHorario(Horario_TO.class, horaInicio, horaFinal, "" + idJornada, horario);
    }

    public Horario_TO editarHorario(int idHorario, String horaInicio, String horaFinal, int idJornada, String horario) {
        ClienteEditarHorario cliente = new ClienteEditarHorario();
        return cliente.editarHorario(Horario_TO.class, "" + idHorario, horaInicio, horaFinal, "" + idJornada, horario);
    }

    public Horario_TO eliminarHorario(int idHorario) {
        ClienteEliminarHorario cliente = new ClienteEliminarHorario();
        return cliente.eliminarHorario(Horario_TO.class, "" + idHorario);
    }
}
