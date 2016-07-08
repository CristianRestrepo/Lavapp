/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Horario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteEditarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarHorario;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarHorario;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosHorario {

    public Horario_TO consultarHorario(int idHorario, String horario) {
        ClienteConsultarHorario cliente = new ClienteConsultarHorario();
        return cliente.consultarHorario(Horario_TO.class, "" + idHorario, horario);
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
