/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Color_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarColor;

/**
 *
 * @author Desarrollo_Planit
 */
public class ColorDao {
    
    public Color_TO consultarColor(Color_TO color){
        ClienteConsultarColor cliente = new ClienteConsultarColor();
        return cliente.consultarColor(Color_TO.class, "" + color.getIdColor(), color.getNombre());
    }
        
}
