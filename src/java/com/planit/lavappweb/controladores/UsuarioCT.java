/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosBarrios;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCiudad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosEstado;
import com.planit.lavappweb.webservices.implementaciones.ServiciosLocalidad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosRol;
import com.planit.lavappweb.webservices.implementaciones.ServiciosUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

public class UsuarioCT implements Serializable {

    private Usuario_TO usuario;
    private List<Usuario_TO> usuarios;
    private List<Usuario_TO> clientes;
    private List<Usuario_TO> asesores;
    private ServiciosUsuario servicioUser;

    private String nombreOperacion;
    private int operacion; //Controla la operacion a ejecutar

    public UsuarioCT() {
        usuario = new Usuario_TO();
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();
        asesores = new ArrayList<>();
        servicioUser = new ServiciosUsuario();

        operacion = 0;
        nombreOperacion = "Registrar";
    }

    @PostConstruct
    public void init() {
        clientes = servicioUser.consultarClientes();
    }

    //Getters & Setters
    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public List<Usuario_TO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario_TO> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario_TO> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario_TO> clientes) {
        this.clientes = clientes;
    }

    public ServiciosUsuario getServicioUser() {
        return servicioUser;
    }

    public void setServicioUser(ServiciosUsuario servicioUser) {
        this.servicioUser = servicioUser;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public List<Usuario_TO> getAsesores() {
        return asesores;
    }

    public void setAsesores(List<Usuario_TO> asesores) {
        this.asesores = asesores;
    }        
        
    //Metodos
    public String registrarCliente() {

        ServiciosBarrios sb = new ServiciosBarrios();
        ServiciosRol sr = new ServiciosRol();
        ServiciosEstado se = new ServiciosEstado();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosLocalidad sl = new ServiciosLocalidad();

        usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), usuario.getBarrio().getNombre()));
        usuario.setEstado(se.consultarEstadoID(1, ""));
        usuario.setRol(sr.consultarRol(4, ""));
        usuario.getBarrio().setLocalidad(sl.consultarLocalidad(usuario.getBarrio().getLocalidad().getIdLocalidad(), ""));
        usuario.setCiudad(sc.consultarCiudad(usuario.getBarrio().getLocalidad().getCiudad().getIdCiudad(), ""));

        servicioUser.registrarUsuario(usuario.getNombre(), usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(), usuario.getRol().getIdRol(),
                usuario.getEstado().getIdEstado(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getApellido(),
                usuario.getGenero(), usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(), usuario.getIdentificacion(), usuario.getRutaImagen());
        usuarios = servicioUser.consultarClientes();

        SesionCT ss = new SesionCT();
        ss.setUsuario(usuario);
        ss.iniciarSesion();

        usuario = new Usuario_TO();
        return "Principal";
    }

    public void modificarCliente() {
    }

    public void eliminarCliente() {
    }

    public void registrarAsesor() {
        ServiciosBarrios sb = new ServiciosBarrios();
        ServiciosRol sr = new ServiciosRol();
        ServiciosEstado se = new ServiciosEstado();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosLocalidad sl = new ServiciosLocalidad();

        usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), usuario.getBarrio().getNombre()));
        usuario.setEstado(se.consultarEstadoID(1, ""));
        usuario.setRol(sr.consultarRol(3, ""));
        usuario.getBarrio().setLocalidad(sl.consultarLocalidad(usuario.getBarrio().getLocalidad().getIdLocalidad(), ""));
        usuario.setCiudad(sc.consultarCiudad(usuario.getBarrio().getLocalidad().getCiudad().getIdCiudad(), ""));

        usuario.setRutaImagen(Upload.getPathDefaultUsuario());
        
        servicioUser.registrarUsuario(usuario.getNombre(), usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(), usuario.getRol().getIdRol(),
                usuario.getEstado().getIdEstado(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getApellido(),
                usuario.getGenero(), usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(), usuario.getIdentificacion(), usuario.getRutaImagen());
        usuarios = servicioUser.consultarClientes();
    }

    public void modificarAsesor() {
    }

    public void eliminarAsesor() {
        
        servicioUser.eliminarUsuario(usuario.getIdUsuario());        
    
    }

    //Metodos Asesor
    public void metodo() {
        if (operacion == 0) {
            registrarAsesor();
        } else if (operacion == 1) {
            modificarAsesor();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }
    
    public void cancelarAsesor(){
        usuario = new Usuario_TO();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

}
