/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuarioPorLogin;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuarioSegunIdentificacion;
import com.planit.lavappweb.webservices.clientes.ClienteEditarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarUsuario;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServiciosUsuario {
    
    public Usuario_TO consultarUsuarioPorLogin(String email) {
        ClienteConsultarUsuarioPorLogin cliente = new ClienteConsultarUsuarioPorLogin();
        return cliente.consultarUsuarioPorLogin(Usuario_TO.class, email);
    }
    
    public Usuario_TO consultarUsuario(int idUsuario) {
        ClienteConsultarUsuario cliente = new ClienteConsultarUsuario();
        return cliente.consultarUsuario(Usuario_TO.class, "" + idUsuario);
    }
    
    public Usuario_TO consultarUsuarioSegunIdentificacion(String identificacion) {
        ClienteConsultarUsuarioSegunIdentificacion cliente = new ClienteConsultarUsuarioSegunIdentificacion();
        return cliente.consultarUsuarioSegunIdentificacion(Usuario_TO.class, identificacion);
    }
    
    public Usuario_TO registrarUsuario(String nombre, String telefono, int idBarrios, int idRol, int idestado, String email, String contrasena, String apellido, String genero, String movil, String direccion, int idCiudad, String identificacion) {
        ClienteRegistrarUsuario cliente = new ClienteRegistrarUsuario();
        return cliente.registrarUsuarios(Usuario_TO.class, nombre, telefono, "" + idBarrios, "" + idRol, "" + idestado, genero, contrasena, apellido, genero, movil, direccion, "" + idCiudad, identificacion);
    }
    
    public Usuario_TO editarUsuario(int idUsuario, String nombre, String apellido, String telefono, int idBarrios, String movil, String direccion, int idCiudad, String identificacion) {
        ClienteEditarUsuario cliente = new ClienteEditarUsuario();
        return cliente.editarUsuario(Usuario_TO.class, "" + idUsuario, nombre, apellido, telefono, "" + idBarrios, movil, direccion, "" + idCiudad, identificacion);
    }
    
    public Usuario_TO eliminarUsuario(int idUsuario) {
        ClienteEliminarUsuario cliente = new ClienteEliminarUsuario();
        return cliente.eliminarUsuario(Usuario_TO.class, "" + idUsuario);
    }
}
