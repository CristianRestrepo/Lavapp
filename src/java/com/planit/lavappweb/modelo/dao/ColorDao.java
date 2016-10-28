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
        //instancia del cliente del web service consultar color
        ClienteConsultarColor cliente = new ClienteConsultarColor();
        //retornamos el resultado del metodo consultar color
        return cliente.consultarColor(Color_TO.class, "" + color.getIdColor(), color.getNombre());
    }
    
    public List<Color_TO> consultarColores(){
         //instancia del cliente del web service consultar colores
        ClienteConsultarColores cliente = new ClienteConsultarColores();
        //Listas hashmap y colores
        List<HashMap> datos = cliente.consultarColores(List.class);
        List<Color_TO> colores = new ArrayList<>();
        //rearmamos la lista de colores extrayendo cada componente que la lista datos que compone un objeto color
        for (int i = 0; i < datos.size(); i++) {
            colores.add(new Color_TO((int) datos.get(i).get("idColor"), (String) datos.get(i).get("nombre")));
        }
        return colores;
    }   
        
}
