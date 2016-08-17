/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.MD5;
import com.planit.lavappweb.metodos.Sesion;
import static com.planit.lavappweb.metodos.Sesion.cerrarHttpSesion;
import static com.planit.lavappweb.metodos.Sesion.iniciarHttpSesion;
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
import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Desarrollo_Planit
 */
public class SesionCT implements Serializable {

    //variables
    private Usuario_TO usuario;
    protected ServiciosUsuario serviciosUsuario;
    protected Upload ControladorArchivos;
    private String estadoFoto;
    private String nuevaContrasena;

    //Constructores
    public SesionCT() {
        this.serviciosUsuario = new ServiciosUsuario();
        usuario = new Usuario_TO();
        ControladorArchivos = new Upload();
        estadoFoto = "";
        nuevaContrasena = "";
    }

    //Getter & Setter
    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public String getEstadoFoto() {
        return estadoFoto;
    }

    public void setEstadoFoto(String estadoFoto) {
        this.estadoFoto = estadoFoto;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }

    //Metodos
    public String iniciarSesion() {
        FacesMessage message = new FacesMessage();
        String ruta = "";
        MD5 md = new MD5();
        String pass = md.getMD5(usuario.getContrasena());
        usuario = serviciosUsuario.consultarUsuarioPorLogin(usuario.getEmail());

        if (usuario.getIdUsuario() != 0) {
            if (usuario.getContrasena().equalsIgnoreCase(pass)) {
                if (usuario.getEstado().getIdEstado() != 0) {
                    ServiciosBarrios sb = new ServiciosBarrios();
                    usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), ""));
                    iniciarHttpSesion(usuario);
                    switch (usuario.getRol().getIdRol()) {
                        case 1:
                            ruta = "Dashboard";
                            break;
                        case 2:
                            ruta = "Dashboard";
                            break;
                        case 4:
                            ruta = "Principal";
                            break;
                    }

                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "" + usuario.getNombre());
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "La cuenta de usuario esta desactivada", "Imposible iniciar sesion");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Contraseña incorrecta", "Digite de nuevo su contraseña");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario no existente", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return ruta;
    }

    public String cerrarSesion() {
        usuario = (Usuario_TO) Sesion.obtenerSesion();
        String ruta = "";
        switch (usuario.getRol().getIdRol()) {
            case 1:
                ruta = "Login";
                break;
            case 2:
                ruta = "Login";
                break;
            case 4:
                ruta = "Principal";
                break;
        }
        cerrarHttpSesion();
        return ruta;
    }
    
    public Usuario_TO obtenerSesion(){
       return (Usuario_TO) Sesion.obtenerSesion();
    }

    //Metodo para edicion de perfil
    public String irPanelEdicion() {
        return "EditarPerfil";
    }

    public void editarPerfil() {

        ServiciosBarrios sb = new ServiciosBarrios();
        ServiciosRol sr = new ServiciosRol();
        ServiciosEstado se = new ServiciosEstado();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosLocalidad sl = new ServiciosLocalidad();

        usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), usuario.getBarrio().getNombre()));
        usuario.setEstado(se.consultarEstadoID(1, ""));
        usuario.setRol(sr.consultarRol(usuario.getRol().getIdRol(), usuario.getRol().getNombre()));
        usuario.getBarrio().setLocalidad(sl.consultarLocalidad(usuario.getBarrio().getLocalidad().getIdLocalidad(), ""));
        usuario.setCiudad(sc.consultarCiudad(usuario.getBarrio().getLocalidad().getCiudad().getIdCiudad(), ""));

        serviciosUsuario.editarUsuario(usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getGenero(),
                usuario.getTelefono(),
                usuario.getBarrio().getIdBarrios(),
                usuario.getMovil(),
                usuario.getDireccion(),
                usuario.getCiudad().getIdCiudad(),
                usuario.getIdentificacion(),
                usuario.getRutaImagen());
    }

    public void editarDatosSesion() {
        if (!nuevaContrasena.isEmpty()) {
            serviciosUsuario.editarCorreoSesion(usuario.getIdUsuario(),usuario.getEmail());
            serviciosUsuario.editarContrasenaSesion(usuario.getIdUsuario(),nuevaContrasena);
        } else {
            serviciosUsuario.editarCorreoSesion(usuario.getIdUsuario(),usuario.getEmail());
        }
        
        nuevaContrasena = "";
    }

    //Subida de archivos
    public void upload(FileUploadEvent e) throws IOException {

        try {
            UploadedFile uploadedPhoto = e.getFile();
            String destination;

            HashMap<String, String> map = Upload.getMapPathFotosUsuarios();
            destination = map.get("path");
            if (null != uploadedPhoto) {
                ControladorArchivos.uploadFile(IOUtils.toByteArray(uploadedPhoto.getInputstream()), uploadedPhoto.getFileName(), destination);
                usuario.setRutaImagen(map.get("url") + uploadedPhoto.getFileName());
                estadoFoto = "Foto actualizada con exito";
            }
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Su foto (" + uploadedPhoto.getFileName() + ")  se ha guardado con exito.", ""));
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
