/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.PromocionSubproductoDao;
import com.planit.lavappweb.modelo.dto.Promocion_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionSubProductoCT {

    private Promocion_TO promocion;
    private List<SubProducto_TO> prendas;
    private List<SubProducto_TO> prendasRespaldo;

    public PromocionSubProductoCT() {
        promocion = new Promocion_TO();
        prendas = new ArrayList<>();
    }

    public Promocion_TO getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion_TO promocion) {
        this.promocion = promocion;
    }

    public List<SubProducto_TO> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<SubProducto_TO> prendas) {
        this.prendas = prendas;
    }

    public List<SubProducto_TO> getPrendasRespaldo() {
        return prendasRespaldo;
    }

    public void setPrendasRespaldo(List<SubProducto_TO> prendasRespaldo) {
        this.prendasRespaldo = prendasRespaldo;
    }   
    
     //CRUD
    public void asociar() {        
        PromocionSubproductoDao promocionSubproductoDao = new PromocionSubproductoDao();
        FacesMessage message = new FacesMessage();
        for (int i = 0; i < prendas.size(); i++) {//Asociamos el asesor seleccionado con las zonas seleccionadas 
            if (promocionSubproductoDao.consultarPromocionSubProductoYaAsociada(promocion, prendas.get(i)) == 0) {
                promocionSubproductoDao.asociarPromocionSubProducto(promocion, prendas.get(i));
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "prendas asociadas exitosamente", "");
            } 

            if (i == prendas.size() - 1) {
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        
        //Validamos las zonas deseleccionadad y eliminamos la asociacion
        eliminarAsociacion();
        prendas = new ArrayList<>();
        promocion = new Promocion_TO();
    }

    
    public void eliminarAsociacion() {
        PromocionSubproductoDao promocionSubproductoDao = new PromocionSubproductoDao();
        boolean existe = false;
        //Valida que zonas fueron deseleccionadas con respecto a una lista de respaldo, y elimina las asociaciones ya no existentes
        for (int i = 0; i < prendasRespaldo.size(); i++) {
            for (int j = 0; j < prendas.size(); j++) {
                if(prendasRespaldo.get(i).getIdSubProducto() == prendas.get(j).getIdSubProducto()){
                    existe = true;
                }                
            }
            
            if(!existe){
                promocionSubproductoDao.eliminarAsociarPromocionSubProducto(promocion, prendasRespaldo.get(i));
            }
        }
    }
    
    //Segun el asesor seleccionado se consultan las zonas asociadas
    public void consultarPrendasPromocion(SelectEvent e) {
        PromocionSubproductoDao promocionSubproductoDao = new PromocionSubproductoDao();
        prendas = promocionSubproductoDao.consultarSubProductosSegunPromocion(promocion);
        prendasRespaldo = prendas;
    }

    //Limpia el array de zonas
    public void LimpiarPrendas(UnselectEvent e) {
        prendas = new ArrayList<>();
    }
}
