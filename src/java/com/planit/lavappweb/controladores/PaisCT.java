/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.PaisDao;
import com.planit.lavappweb.modelo.dto.Pais_TO;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class PaisCT {

    private Pais_TO pais;
    private List<Pais_TO> paises;
    
    public PaisCT() {
        PaisDao paisDao = new PaisDao();
        paises = paisDao.consultarPaises();
    }

    public Pais_TO getPais() {
        return pais;
    }

    public void setPais(Pais_TO pais) {
        this.pais = pais;
    }

    public List<Pais_TO> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais_TO> paises) {
        this.paises = paises;
    }
    
    
    
}
