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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Desarrollo_Planit
 */
public class AsesorZonaCT implements Serializable {

    Usuario_TO usuario = new Usuario_TO();
    Zona_TO zona = new Zona_TO();
    List<Zona_TO> zonas = new ArrayList<>();

    public AsesorZonaCT() {
        usuario = new Usuario_TO();
        zona = new Zona_TO();
        zonas = new ArrayList<>();
    }

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
        for (int i = 0; i < zonas.size(); i++) {
            AsesorZonaDao asesorZonaDao = new AsesorZonaDao();
            asesorZonaDao.AsociarAsesorZona(usuario, zonas.get(i));
        }        
        zonas = new ArrayList<>();
        usuario = new Usuario_TO();
    }
    
    public void consultarZonasAsesor(SelectEvent e){
        ZonaDao zonaDao = new ZonaDao();
        zonas = zonaDao.consultarZonasAsesor(usuario);        
    }
    
    public void LimpiarZonas(UnselectEvent e){
        zonas = new ArrayList<>();
    }

}
