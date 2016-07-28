/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.MD5;
import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosBarrios;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCiudad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosEstado;
import com.planit.lavappweb.webservices.implementaciones.ServiciosLocalidad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosRol;
import com.planit.lavappweb.webservices.implementaciones.ServiciosUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

public class UsuarioCT implements Serializable {

    private Usuario_TO usuario;
    private List<Usuario_TO> usuarios;
    private List<Usuario_TO> clientes;
    private ServiciosUsuario servicioUser;
    
    protected Upload ControladorArchivos;

    public UsuarioCT() {
        usuario = new Usuario_TO();
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();
        servicioUser = new ServiciosUsuario();
        
        ControladorArchivos = new Upload();
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
                usuario.getGenero(), usuario.getMovil(), "", usuario.getCiudad().getIdCiudad(), usuario.getIdentificacion());
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
    }

    public void modificarAsesor() {
    }

    public void eliminarAsesor() {
    }

    //Metodo para edicion de perfil
    public void editarPerfil() {
    }

    public void editarDatosSesion() {
    }
    
    //Subida de archivos
    public void upload(FileUploadEvent e) throws IOException {
        try {
            UploadedFile uploadedPhoto = e.getFile();
            String destination;

            HashMap<String, String> map = Upload.getMapPathFotosSubProducto();
            destination = map.get("path");
            if (null != uploadedPhoto) {
                ControladorArchivos.uploadFile(IOUtils.toByteArray(uploadedPhoto.getInputstream()), uploadedPhoto.getFileName(), destination);
//                Usuario.setUsuarioFotoNombre(uploadedPhoto.getFileName());
//                Usuario.setUsuarioFotoRuta(map.get("url") + uploadedPhoto.getFileName());
//                estadoFoto = "Foto actualizada con exito";
            }
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Su foto (" + uploadedPhoto.getFileName() + ")  se ha guardado con exito.", ""));
        } catch (Exception ex) {
            ex.getMessage();
        }
    }   
}
