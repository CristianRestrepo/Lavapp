/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import com.planit.lavappweb.webservices.clientes.ClienteAsociarAsesorZona;

/**
 *
 * @author Desarrollo_Planit
 */
public class AsesorZonaDao {
    
    //Consume el web service y asocia asesores con la zona enviada 
    public Usuario_TO AsociarAsesorZona(Usuario_TO usuario, Zona_TO zona) {
        ClienteAsociarAsesorZona cliente = new ClienteAsociarAsesorZona();
        return cliente.asociarAsesorZona(Usuario_TO.class, "" + usuario.getIdUsuario(), "" + zona.getIdZona());
    }
}
