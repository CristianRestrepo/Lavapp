/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarServicios;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarServicio;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosServicios {
    
    
    public List<Servicio_TO> consultarServicios (){
        ClienteConsultarServicios clienteServicio = new ClienteConsultarServicios();
        return clienteServicio.consultarServicios(List.class);
    } 
    
    public Servicio_TO registrarServicio(String nombre){        
        ClienteRegistrarServicio regisServicio = new ClienteRegistrarServicio();
        return regisServicio.registrarServicio(Servicio_TO.class, nombre);
    }
}
