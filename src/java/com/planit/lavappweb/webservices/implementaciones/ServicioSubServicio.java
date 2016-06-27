/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Servicio_TO;
import com.planit.lavappweb.modelos.SubServicio_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicios;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarSubServicio_SP;
import com.planit.lavappweb.webservices.clientes.ClienteRegistarSubServicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServicioSubServicio {
    
     public List<SubServicio_TO> consultarSubServiciosPorId(int idServicio) {        
        ClienteConsultarSubServicio_SP subServiCliente = new ClienteConsultarSubServicio_SP();
        return subServiCliente.consultarSubServicios(List.class, "" + idServicio);
        
    }   
    
    public List<SubServicio_TO> consultarSubServicios() {
        List<SubServicio_TO>listaModelo = new ArrayList<>();
        ClienteConsultarSubServicio_SP subServiCliente = new ClienteConsultarSubServicio_SP();        
        try {
            listaModelo = subServiCliente.consultarSubServicios(List.class);
        } catch (Exception e) {
            throw e;
        }
        return listaModelo;
    }
    
    public SubServicio_TO registrarSubServicio(String nombre , int idServicio ){
        ClienteRegistarSubServicio clieSubServicio = new ClienteRegistarSubServicio();
        return clieSubServicio.registrarSubServicio(SubServicio_TO.class, "" + nombre, "" + idServicio);
    }
}
