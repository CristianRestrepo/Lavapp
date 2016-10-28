/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteEnviarMensajeAgendamiento;
import com.planit.lavappweb.webservices.clientes.ClienteEnviarMensajeNuevaContrasena;
import com.planit.lavappweb.webservices.clientes.ClienteMensajeBienvenida;

/**
 *
 * @author VaioDevelopment
 */
public class CorreoDao {

    
    public int enviarMensajeBienvenida(Usuario_TO usuario) {
        //Instancia del cliente del web service enviar mensaje bienvenida
        ClienteMensajeBienvenida cliente = new ClienteMensajeBienvenida();
        //retornamos el resultado del metodo enviar mensaje bienvenida
        return cliente.enviarMensajeBienvenido(int.class, usuario.getEmail());
    }

    public int enviarMensajeNuevaContrasena(Usuario_TO usuario) {
        //Instancia del cliente del web service enviar mensaje nueva contraseña
        ClienteEnviarMensajeNuevaContrasena cliente = new ClienteEnviarMensajeNuevaContrasena();
        //retornamos el resultado del metodo enviar mensaje nueva contraseña
        return cliente.enviarMensajeNuevaContraseÃ_a(int.class, usuario.getEmail(), usuario.getContrasena());
    }
    
    public int enviarMensajeAgendamiento(Usuario_TO usuario){
        //Instancia del cliente del web service enviar mensaje agendamiento
        ClienteEnviarMensajeAgendamiento cliente = new ClienteEnviarMensajeAgendamiento();
        //retornamos el resultado del metodo enviar mensaje agendamiento
        return cliente.enviarMensajeAgendamiento(int.class, usuario.getEmail());
    }
}
