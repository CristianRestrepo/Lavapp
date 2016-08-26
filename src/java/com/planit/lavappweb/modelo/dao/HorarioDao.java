/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Horario_TO;
import com.planit.lavappweb.modelo.dto.Jornada_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarHorarios;
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
public class HorarioDao {

    public Horario_TO consultarHorario(Horario_TO horario) {
        ClienteConsultarHorario cliente = new ClienteConsultarHorario();
        return cliente.consultarHorario(Horario_TO.class, "" + horario.getIdHorario(), horario.getHorario());
    }

    public List<Horario_TO> consultarHorarios() {
        ClienteConsultarHorarios cliente = new ClienteConsultarHorarios();
        List<LinkedHashMap> datos = cliente.consultarHorarios(List.class);
        List<Horario_TO> horarios = new ArrayList<>();
        JornadaDao jd = new JornadaDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("jornada");
            Jornada_TO jornada = new Jornada_TO();
            jornada = jd.consultarJornada(new Jornada_TO((int) map.get("idJornada"), ""));
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

    public List<Horario_TO> buscarBarrios(String valor) {
        ClienteBuscarHorarios cliente = new ClienteBuscarHorarios();
        List<LinkedHashMap> datos = cliente.buscarHorarios(List.class, valor);
        List<Horario_TO> horarios = new ArrayList<>();
        JornadaDao jd = new JornadaDao();
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get("jornada");
            Jornada_TO jornada = new Jornada_TO();
            jornada = jd.consultarJornada(new Jornada_TO((int) map.get("idJornada"), ""));
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

    public Horario_TO registrarHorario(Horario_TO horario) {
        JornadaDao jd = new JornadaDao();
        horario.setJornada(jd.consultarJornada(horario.getJornada()));

        ClienteRegistrarHorario cliente = new ClienteRegistrarHorario();
        return cliente.registrarHorario(Horario_TO.class,
                horario.getHoraInicio(),
                horario.getHoraFinal(),
                "" + horario.getJornada().getIdJornada(),
                horario.getHorario());
    }

    public Horario_TO editarHorario(Horario_TO horario) {
        JornadaDao jd = new JornadaDao();
        horario.setJornada(jd.consultarJornada(horario.getJornada()));

        ClienteEditarHorario cliente = new ClienteEditarHorario();
        return cliente.editarHorario(Horario_TO.class, "" + horario.getIdHorario(),
                horario.getHoraInicio(),
                horario.getHoraFinal(),
                "" + horario.getJornada().getIdJornada(),
                horario.getHorario());
    }

    public Horario_TO eliminarHorario(Horario_TO horario) {
        ClienteEliminarHorario cliente = new ClienteEliminarHorario();
        return cliente.eliminarHorario(Horario_TO.class,
                "" + horario.getIdHorario());
    }
}
