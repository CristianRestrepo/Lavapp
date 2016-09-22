/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteMensajeBienvenida;

/**
 *
 * @author VaioDevelopment
 */

public class CorreoDao {    
   
    public int enviarMensajeBienvenida(Usuario_TO usuario){
        ClienteMensajeBienvenida cliente = new ClienteMensajeBienvenida();
        return cliente.enviarMensajeBienvenido(int.class, usuario.getEmail());
    }
    
}
