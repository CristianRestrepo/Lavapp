/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.GenerarPassword;
import com.planit.lavappweb.metodos.MD5;
import com.planit.lavappweb.metodos.Pedido;
import com.planit.lavappweb.metodos.Sesion;
import static com.planit.lavappweb.metodos.Sesion.cerrarHttpSesion;
import static com.planit.lavappweb.metodos.Sesion.iniciarHttpSesion;
import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelo.dao.BarriosDao;
import com.planit.lavappweb.modelo.dao.CorreoDao;
import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.Barrio_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
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
    protected Upload ControladorArchivos;
    private String estadoFoto;
    private String nuevaContrasena;

    //Constructores
    public SesionCT() {
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
        UsuarioDao usuarioDao = new UsuarioDao();
        FacesMessage message = new FacesMessage();
        String ruta = "";
        MD5 md = new MD5();
        String pass = md.getMD5(usuario.getContrasena());
        usuario = usuarioDao.consultarUsuarioPorLogin(usuario.getEmail());

        if (usuario.getIdUsuario() != 0) {
            if (usuario.getContrasena().equalsIgnoreCase(pass)) {
                if (usuario.getEstado().getIdEstado() != 0) {
                    BarriosDao bd = new BarriosDao();
                    usuario.setBarrio(bd.consultarBarrio(new Barrio_TO(usuario.getBarrio().getIdBarrios(), "")));
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
                usuario.setContrasena("");
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
        String ruta = "Principal";
        Pedido.ReiniciarValores();
        cerrarHttpSesion();
        return ruta;
    }

    public Usuario_TO obtenerSesion() {
        return (Usuario_TO) Sesion.obtenerSesion();
    }

    //Metodo para edicion de perfil
    public String irPanelEdicion() {
        return "EditarPerfil";
    }

    public void editarPerfil() {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.editarUsuario(usuario);
    }

    public void editarDatosSesion() {
        UsuarioDao usuarioDao = new UsuarioDao();
        if (!nuevaContrasena.isEmpty()) {
            try {
                usuarioDao.editarCorreoSesion(usuario);
                usuario.setContrasena(nuevaContrasena);
                usuarioDao.editarContrasenaSesion(usuario);
                usuarioDao.editarCorreoSesion(usuario);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Contraseña editada correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "" + e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } else {
            usuarioDao.editarCorreoSesion(usuario);
        }
        nuevaContrasena = "";
    }

    //Generar nueva contraseña
    public void generarNuevaContraseñaDeSesion() throws IOException {
        GenerarPassword gpassword = new GenerarPassword();
        CorreoDao correoDao = new CorreoDao();
        UsuarioDao usuarioDao = new UsuarioDao();

        String pass = gpassword.generarPass(6);
        usuario = usuarioDao.consultarUsuarioPorLogin(usuario.getEmail());
        usuario.setContrasena(pass);

        usuarioDao.editarContrasenaSesion(usuario);
        int respuesta = correoDao.enviarMensajeNuevaContrasena(usuario);
        usuario = new Usuario_TO();

        FacesMessage message = new FacesMessage();

        if (respuesta == 0) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fue imposible enviarle una nueva contraseña, intentelo de nuevo.", null);
        } else if (respuesta == 1) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "La nueva contraseña ha sido enviada, por favor revise su correo.", null);
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
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
