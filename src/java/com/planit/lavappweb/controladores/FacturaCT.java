/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.FacturaDao;
import com.planit.lavappweb.modelo.dto.Factura_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class FacturaCT implements Serializable {

    private Factura_TO factura;
    private List<Factura_TO> facturas;

    public FacturaCT() {
        factura = new Factura_TO();
        facturas = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        FacturaDao facturaDao = new FacturaDao();
        facturas = facturaDao.consultarFacturas();
    }

    //Getter & Setter
    public Factura_TO getFactura() {
        return factura;
    }

    public void setFactura(Factura_TO factura) {
        this.factura = factura;
    }

    public List<Factura_TO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura_TO> facturas) {
        this.facturas = facturas;
    }

    //Metodos
    public void registrar() {
        FacturaDao facturaDao = new FacturaDao();
        factura = facturaDao.registrarFactura(factura);
        facturas = facturaDao.consultarFacturas();
    }

    public void eliminar() {
        FacturaDao facturaDao = new FacturaDao();
        factura = facturaDao.eliminarFactura(factura);
        facturas = facturaDao.consultarFacturas();
    }

}
