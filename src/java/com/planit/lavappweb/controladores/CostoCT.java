/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.CostoDao;
import com.planit.lavappweb.modelo.dto.Costo_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Desarrollo_Planit
 */

public class CostoCT {

    private Costo_TO costo;
    
    public CostoCT() {
        costo = new Costo_TO();
    }

    public Costo_TO getCosto() {
        return costo;
    }

    public void setCosto(Costo_TO costo) {
        this.costo = costo;
    }
    
    public String consultarCostoPedido(Pedido_TO pedido){
        CostoDao costoDao = new CostoDao();
        return costoDao.ConsultarCostoPedido(pedido);
    }
    
    
    public String consultarCostoSubProducto(SubProducto_TO subproducto){
        CostoDao costoDao = new CostoDao();
        return "" + costoDao.consultarCostoSubProducto(subproducto).getValor();       
    }
    
    
    
}
