/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Historico_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHistorico;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarHistoricoDescripcion;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarHistorico;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarHistorico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<Historico_TO> consultarHistoricoDescripcion(DescripcionPedido_TO descripcionPedido) {
        ClienteConsultarHistoricoDescripcion cliente = new ClienteConsultarHistoricoDescripcion();
        List<HashMap> datos = cliente.consultarHistoricoDescripcion(List.class, "" + descripcionPedido.getIdDescripcionPedido());
        List<Historico_TO> historico = new ArrayList<>();

        DescripcionPedidoDao descripcionPedidoDao = new DescripcionPedidoDao();
        EstadoDao estadoDao = new EstadoDao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < datos.size(); i++) {
            HashMap estado = (HashMap) datos.get(i).get("estado");

            try {
                historico.add(new Historico_TO((int) datos.get(i).get("idHistorico"),
                        descripcionPedidoDao.consultarDescripcionPedido(descripcionPedido),
                        estadoDao.consultarEstadoID(new Estado_TO((int) estado.get("idEstado"))),
                        formato.parse((String) datos.get(i).get("fechaString"))));
            } catch (ParseException e) {
                e.getMessage();
            }
           
        }
        return historico;
    }

    public Historico_TO consultarHistorico(Historico_TO historico) {
        ClienteConsultarHistorico cliente = new ClienteConsultarHistorico();
        return cliente.consultarHistorico(Historico_TO.class, "" + historico.getIdHistorico());
    }

}
