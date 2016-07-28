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
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosUsuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo_Planit
 */
public class SesionCT implements Serializable {

    //variables
    private Usuario_TO usuario;
    protected ServiciosUsuario serviciosUsuario;

    //Constructores
    public SesionCT() {
        this.serviciosUsuario = new ServiciosUsuario();
        usuario = new Usuario_TO();
    }

    //Getter & Setter
    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
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
}
