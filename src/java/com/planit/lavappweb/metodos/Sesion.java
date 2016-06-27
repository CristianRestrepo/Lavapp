/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;


import com.planit.lavappweb.modelos.Usuario_TO;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Desarrollo_Planit
 */
public class Sesion {

    private static HttpServletRequest httpServletRequest;
    private static FacesContext faceContext;

    public Sesion() {
    }

    public static void iniciarHttpSesion(Usuario_TO usuario) {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        httpServletRequest.getSession().setAttribute("Sesion", usuario);
    }

    public static void cerrarHttpSesion() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        httpServletRequest.getSession().invalidate();
    }

    public static Usuario_TO obtenerSesion() {
        Usuario_TO usuarioLogueado = new Usuario_TO();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        usuarioLogueado = (Usuario_TO) httpServletRequest.getSession().getAttribute("Sesion");
        return usuarioLogueado;
    }
}
