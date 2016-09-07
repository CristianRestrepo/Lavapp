/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Color_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarColor;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarColores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ColorDao {
    
    public Color_TO consultarColor(Color_TO color){
        ClienteConsultarColor cliente = new ClienteConsultarColor();
        return cliente.consultarColor(Color_TO.class, "" + color.getIdColor(), color.getNombre());
    }
    
    public List<Color_TO> consultarColores(){
        ClienteConsultarColores cliente = new ClienteConsultarColores();
        List<HashMap> datos = cliente.consultarColores(List.class);
        List<Color_TO> colores = new ArrayList<>();
        for (int i = 0; i < datos.size(); i++) {
            colores.add(new Color_TO((int) datos.get(i).get("idColor"), (String) datos.get(i).get("nombre")));
        }
        return colores;
    }   
        
}
