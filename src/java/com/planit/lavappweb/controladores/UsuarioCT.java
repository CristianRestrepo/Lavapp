/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Usuario_TO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


public class UsuarioCT {

    private Usuario_TO usuario;
    private List<Usuario_TO> usuarios;

    public UsuarioCT() {
        usuario = new Usuario_TO();
        usuarios = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
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

    //Metodos
    public void registrar() {
    }

    public void modificar() {
    }

    public void eliminar() {
    }
}
