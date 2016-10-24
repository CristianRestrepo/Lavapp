/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;


import com.planit.lavappweb.modelo.dto.Usuario_TO;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Desarrollo_Planit
 */
public class Sesion {

    //Variables de sesion
    private static HttpServletRequest httpServletRequest;
    private static FacesContext faceContext;

    //constructores
    public Sesion() {
    }

    //Metodos
    //sube el objeto usuario como variable de sesion
    public static void iniciarHttpSesion(Usuario_TO usuario) {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        httpServletRequest.getSession().setAttribute("Sesion", usuario);
    }

    //Invalida la sesion iniciada
    public static void cerrarHttpSesion() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        httpServletRequest.getSession().invalidate();
    }

    //consulta la informacion subida como variable de sesion y retorna esta informacion
    public static Usuario_TO obtenerSesion() {
        Usuario_TO usuarioLogueado = new Usuario_TO();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        usuarioLogueado = (Usuario_TO) httpServletRequest.getSession().getAttribute("Sesion");
        return usuarioLogueado;
    }
}
