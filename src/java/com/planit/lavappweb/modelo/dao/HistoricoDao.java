/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Historico_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHistorico;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHistoricoDescripcion;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarHistorico;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarHistorico;

/**
 *
 * @author Desarrollo_Planit
 */
public class HistoricoDao {

    public Historico_TO registrarHistorico(Historico_TO historico) {
        ClienteRegistrarHistorico cliente = new ClienteRegistrarHistorico();
        return cliente.registrarHistorico(Historico_TO.class, "" + historico.getDescripcionPedido().getIdDescripcionPedido(), "" + historico.getEstado().getIdEstado());
    }

    public Historico_TO eliminarHistorico(Historico_TO historico) {
        ClienteEliminarHistorico cliente = new ClienteEliminarHistorico();
        return cliente.eliminarHistorico(Historico_TO.class, "" + historico.getIdHistorico());
    }

    public Historico_TO consultarHistoricoDescripcion(DescripcionPedido_TO descripcionPedido) {
        ClienteConsultarHistoricoDescripcion cliente = new ClienteConsultarHistoricoDescripcion();
        return cliente.consultarHistoricoDescripcion(Historico_TO.class, "" + descripcionPedido.getIdDescripcionPedido());
    }

    public Historico_TO consultarHistorico(Historico_TO historico) {
        ClienteConsultarHistorico cliente = new ClienteConsultarHistorico();
        return cliente.consultarHistorico(Historico_TO.class, "" + historico.getIdHistorico());
    }

}
