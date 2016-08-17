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
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuariosPorRol;
import com.planit.lavappweb.webservices.clientes.ClienteEditarContrasenaSesion;
import com.planit.lavappweb.webservices.clientes.ClienteEditarCorreoSesion;
import com.planit.lavappweb.webservices.clientes.ClienteEditarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarUsuario;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

    public Usuario_TO registrarUsuario(String nombre, String telefono, int idBarrios, int idRol, int idestado, String email, String contrasena, String apellido, String genero, String movil, String direccion, int idCiudad, String identificacion, String rutaImagen) {
        ClienteRegistrarUsuario cliente = new ClienteRegistrarUsuario();
        return cliente.registrarUsuarios(Usuario_TO.class, nombre, telefono, "" + idBarrios, "" + idRol, "" + idestado, email, contrasena, apellido, genero, movil, direccion, "" + idCiudad, identificacion, rutaImagen);
    }

    public Usuario_TO editarUsuario(int idUsuario, String nombre, String apellido, String genero, String telefono, int idBarrios, String movil, String direccion, int idCiudad, String identificacion, String rutaImagen) {
        ClienteEditarUsuario cliente = new ClienteEditarUsuario();
        return cliente.editarUsuario(Usuario_TO.class, "" + idUsuario, nombre, apellido, genero, telefono, "" + idBarrios, movil, direccion, "" + idCiudad, identificacion, rutaImagen);
    }

    public Usuario_TO editarContrasenaSesion(int idUsuario, String contrasena) {
        ClienteEditarContrasenaSesion cliente = new ClienteEditarContrasenaSesion();
        return cliente.editarContrasenaSesion(Usuario_TO.class, "" + idUsuario, contrasena);
    }

    public Usuario_TO editarCorreoSesion(int idUsuario, String correo) {
        ClienteEditarCorreoSesion cliente = new ClienteEditarCorreoSesion();
        return cliente.editarCorreoSesion(Usuario_TO.class, "" + idUsuario ,correo);
    }

    public Usuario_TO eliminarUsuario(int idUsuario) {
        ClienteEliminarUsuario cliente = new ClienteEliminarUsuario();
        return cliente.eliminarUsuario(Usuario_TO.class, "" + idUsuario);
    }

    public List<Usuario_TO> consultarUsuariosPorRol(int idRol) {
        ClienteConsultarUsuariosPorRol clienteModelo = new ClienteConsultarUsuariosPorRol();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = clienteModelo.consultarUsuariosPorRol(List.class, "" + idRol);
        List<Usuario_TO> usuarios = new ArrayList<>();

//        SERVICIOS
        ServiciosBarrios sB = new ServiciosBarrios();
        ServiciosRol sR = new ServiciosRol();
        ServiciosEstado sE = new ServiciosEstado();
        ServiciosCiudad sC = new ServiciosCiudad();
        try {
            for (int i = 0; i < datos.size(); i++) {

                LinkedHashMap barrio = (LinkedHashMap) datos.get(i).get("barrio");
                LinkedHashMap rol = (LinkedHashMap) datos.get(i).get("rol");
                LinkedHashMap estado = (LinkedHashMap) datos.get(i).get("estado");
                LinkedHashMap ciudad = (LinkedHashMap) datos.get(i).get("ciudad");

                usuarios.add(new Usuario_TO((int) datos.get(i).get("idUsuario"),
                        (String) datos.get(i).get("nombre"),
                        (String) datos.get(i).get("telefono"),
                        sB.consultarBarrio((int) barrio.get("idBarrios"), ""),
                        sR.consultarRol((int) rol.get("idRol"), ""),
                        sE.consultarEstadoID((int) estado.get("idEstado"), ""),
                        (String) datos.get(i).get("email"),
                        (String) datos.get(i).get("contrasena"),
                        (String) datos.get(i).get("apellido"),
                        (String) datos.get(i).get("genero"),
                        (String) datos.get(i).get("movil"),
                        (String) datos.get(i).get("direccion"),
                        sC.consultarCiudad((int) ciudad.get("idCiudad"), ""),
                        (String) datos.get(i).get("identificacion"),
                        (String) datos.get(i).get("rutaImagen")));

            }

        } catch (Exception e) {
            throw e;
        }

        return usuarios;
    }
}
