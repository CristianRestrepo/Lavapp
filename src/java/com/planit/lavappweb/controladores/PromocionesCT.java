/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.PromocionDao;
import com.planit.lavappweb.modelo.dto.Promocion_TO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionesCT {

    private Promocion_TO promocion = new Promocion_TO();
    private List<Promocion_TO> promociones = new ArrayList<>();
    
    private int operacion;
    private int nombreOperacion;
            
    public PromocionesCT() {
        promocion = new Promocion_TO();
        promociones = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        PromocionDao promocionDao = new PromocionDao();
        
    }
        
    public Promocion_TO getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion_TO promocion) {
        this.promocion = promocion;
    }

    public List<Promocion_TO> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion_TO> promociones) {
        this.promociones = promociones;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public int getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(int nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }
    
    
    
}
