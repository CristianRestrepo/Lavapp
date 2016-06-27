/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuarioPorLogin;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosUsuario {

    public ServiciosUsuario() {
    }        
    
    public Usuario_TO consultarUsuarioPorLogin(String email){
        ClienteConsultarUsuarioPorLogin cliente = new ClienteConsultarUsuarioPorLogin();
        return cliente.consultarUsuarioPorLogin(Usuario_TO.class, email);
    }
    
    
    
}
