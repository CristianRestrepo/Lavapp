/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.GenerarPassword;
import com.planit.lavappweb.metodos.Upload;
import static com.planit.lavappweb.metodos.Upload.getPathDefaultUsuario;
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
    private String buscar;

    public UsuarioCT() {
        usuario = new Usuario_TO();
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();
        asesores = new ArrayList<>();
        servicioUser = new ServiciosUsuario();

        operacion = 0;
        nombreOperacion = "Registrar";
        buscar = null;
    }

    @PostConstruct
    public void init() {
        clientes = servicioUser.consultarUsuariosPorRol(4);
        asesores = servicioUser.consultarUsuariosPorRol(3);
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
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
        usuario.setRutaImagen(getPathDefaultUsuario());
        
        servicioUser.registrarUsuario(usuario.getNombre(), usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(), usuario.getRol().getIdRol(),
                usuario.getEstado().getIdEstado(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getApellido(),
                usuario.getGenero(), usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(), usuario.getIdentificacion(), usuario.getRutaImagen());
        clientes = servicioUser.consultarUsuariosPorRol(4);

        SesionCT ss = new SesionCT();
        ss.setUsuario(usuario);
        ss.iniciarSesion();

        usuario = new Usuario_TO();
        return "Principal";
    }

    public void modificarCliente() {

    }

    public void eliminarCliente() {
        servicioUser.eliminarUsuario(usuario.getIdUsuario());
        clientes = servicioUser.consultarUsuariosPorRol(4);
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
        usuario.setContrasena(GenerarPassword.generarPass(6));

        usuario = servicioUser.registrarUsuario(usuario.getNombre(), usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(), usuario.getRol().getIdRol(),
                usuario.getEstado().getIdEstado(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getApellido(),
                usuario.getGenero(), usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(), usuario.getIdentificacion(), usuario.getRutaImagen());
        asesores = servicioUser.consultarUsuariosPorRol(3);
    }

    public void modificarAsesor() {
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
     
        usuario = servicioUser.editarUsuario(usuario.getIdUsuario(), usuario.getNombre(), 
                usuario.getApellido(), usuario.getGenero(), usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(),
                usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(),
                usuario.getIdentificacion(), usuario.getRutaImagen());
        asesores = servicioUser.consultarUsuariosPorRol(3);
    }

    public void eliminarAsesor() {
        servicioUser.eliminarUsuario(usuario.getIdUsuario());
        asesores = servicioUser.consultarUsuariosPorRol(3);
    }
    
    //Metodos Asesor
    public void metodoAsesor() {
        if (operacion == 0) {
            registrarAsesor();
        } else if (operacion == 1) {
            modificarAsesor();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void metodoCliente() {
        if (operacion == 0) {
            registrarCliente();
        } else if (operacion == 1) {
            modificarCliente();
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

    public void cancelarAsesor() {
        usuario = new Usuario_TO();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    
    public void buscarAsesores(){
        asesores = new ArrayList<>();
        if(buscar == null){
            asesores = servicioUser.consultarUsuariosPorRol(3);
        }else {
            asesores = servicioUser.buscarAsesores(buscar);
        }
    }
    
    public void buscarClientes(){
        clientes = new ArrayList<>();
        if(buscar == null){
            clientes = servicioUser.consultarUsuariosPorRol(4);
        }else {
            clientes = servicioUser.buscarClientes(buscar);
        }
    }
}
