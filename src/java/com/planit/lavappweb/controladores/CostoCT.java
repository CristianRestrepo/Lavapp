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
import java.io.Serializable;

/**
 *
 * @author Desarrollo_Planit
 */
public class CostoCT implements Serializable {

    //Variables
    private Costo_TO costo;

    //Constructores
    public CostoCT() {
        costo = new Costo_TO();
    }

    //Gettters & Setters
    public Costo_TO getCosto() {
        return costo;
    }

    public void setCosto(Costo_TO costo) {
        this.costo = costo;
    }

    //Metodos
    public String consultarCostoPedido(Pedido_TO pedido) {
        //Consulta el costo total de un pedido
        CostoDao costoDao = new CostoDao();
        return costoDao.ConsultarCostoPedido(pedido);
    }

    public String consultarCostoSubProducto(SubProducto_TO subproducto) {
        //consulta el costo de un subproducto
        CostoDao costoDao = new CostoDao();
        return "" + costoDao.consultarCostoSubProducto(subproducto).getValor();
    }

}
