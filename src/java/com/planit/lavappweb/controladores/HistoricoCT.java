/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.HistoricoDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Historico_TO;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo_Planit
 */
public class HistoricoCT implements Serializable {

    private Historico_TO historico;
    private List<Historico_TO> historicos;

    public HistoricoCT() {
        historico = new Historico_TO();
        historicos = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
    }

    //Getter & Setter
    public Historico_TO getHistorico() {
        return historico;
    }

    public void setHistorico(Historico_TO historico) {
        this.historico = historico;
    }

    public List<Historico_TO> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico_TO> historicos) {
        this.historicos = historicos;
    }

    //Metodos
    public void registrar() {
        HistoricoDao historicoDao = new HistoricoDao();
        historico = historicoDao.registrarHistorico(historico);
    }

    public void eliminar() {
        HistoricoDao historicoDao = new HistoricoDao();
        historico = historicoDao.eliminarHistorico(historico);
    }

    public String verHistoricoPrenda(DescripcionPedido_TO descripcionPedido){
        HistoricoDao historicoDao = new HistoricoDao();
        historico.setDescripcionPedido(descripcionPedido);
        historicos = historicoDao.consultarHistoricoDescripcion(descripcionPedido);
        return "Historico";
    }
}
