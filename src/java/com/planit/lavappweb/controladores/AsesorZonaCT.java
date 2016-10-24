/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.AsesorZonaDao;
import com.planit.lavappweb.modelo.dao.ZonaDao;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Desarrollo_Planit
 */
public class AsesorZonaCT implements Serializable {

    //Variables
    private Usuario_TO usuario;
    private Zona_TO zona;
    private List<Zona_TO> zonas;
    protected List<Zona_TO> zonasRespaldo;

    //constructor
    public AsesorZonaCT() {
        usuario = new Usuario_TO();
        zona = new Zona_TO();
        zonas = new ArrayList<>();
        zonasRespaldo = new ArrayList<>();
    }

    //Getters & Setters
    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public Zona_TO getZona() {
        return zona;
    }

    public void setZona(Zona_TO zona) {
        this.zona = zona;
    }

    public List<Zona_TO> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona_TO> zonas) {
        this.zonas = zonas;
    }

    //CRUD
    public void asociar() {
        AsesorZonaDao asesorZonaDao = new AsesorZonaDao();
        ZonaDao zonaDao = new ZonaDao();
        FacesMessage message = new FacesMessage();
        for (int i = 0; i < zonas.size(); i++) {//Asociamos el asesor seleccionado con las zonas seleccionadas 
            if (zonaDao.consultarZonaYaAsociada(usuario, zonas.get(i)) == 0) {
                asesorZonaDao.AsociarAsesorZona(usuario, zonas.get(i));
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zonas asociadas exitosamente", "");
            } 

            if (i == zonas.size() - 1) {
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        
        //Validamos las zonas deseleccionadad y eliminamos la asociacion
        eliminarAsociacion();
        zonas = new ArrayList<>();
        usuario = new Usuario_TO();
    }

    
    public void eliminarAsociacion() {
        ZonaDao zonaDao = new ZonaDao();
        boolean existe = false;
        //Valida que zonas fueron deseleccionadas con respecto a una lista de respaldo, y elimina las asociaciones ya no existentes
        for (int i = 0; i < zonasRespaldo.size(); i++) {
            for (int j = 0; j < zonas.size(); j++) {
                if(zonasRespaldo.get(i).getIdZona().equals(zonas.get(j).getIdZona())){
                    existe = true;
                }                
            }
            
            if(!existe){
                zonaDao.eliminarAsociacionZona(usuario, zonasRespaldo.get(i));
            }
        }
    }

    //Segun el asesor seleccionado se consultan las zonas asociadas
    public void consultarZonasAsesor(SelectEvent e) {
        ZonaDao zonaDao = new ZonaDao();
        zonas = zonaDao.consultarZonasAsesor(usuario);
        zonasRespaldo = zonas;
    }

    //Limpia el array de zonas
    public void LimpiarZonas(UnselectEvent e) {
        zonas = new ArrayList<>();
    }

}
