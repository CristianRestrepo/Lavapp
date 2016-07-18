/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Costo_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteEditarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarCosto;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarCosto;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosCosto {
    
    public Costo_TO consultarCosto(int idCosto){
        ClienteConsultarCosto cliente = new ClienteConsultarCosto();
        return cliente.consultarCosto(Costo_TO.class, "" + idCosto);
    }
    
    public Costo_TO RegistrarCosto(int valor, int idSubProducto, int idZona){
        ClienteRegistrarCosto cliente = new ClienteRegistrarCosto();
        return cliente.registrarCosto(Costo_TO.class, "" + valor, "" + idSubProducto, "" + idZona);
    }
    
    public Costo_TO modificarCosto(int idCosto, int valor, int idSubProducto, int idZona){
        ClienteEditarCosto cliente = new ClienteEditarCosto();
        return cliente.editarCosto(Costo_TO.class, "" + idCosto, "" + valor, "" + idSubProducto, "" + idZona);
    }
    
    public Costo_TO eliminarCosto(int idCosto){
        ClienteEliminarCosto cliente = new ClienteEliminarCosto();
        return cliente.eliminarCosto(Costo_TO.class, "" + idCosto);
    }
}
