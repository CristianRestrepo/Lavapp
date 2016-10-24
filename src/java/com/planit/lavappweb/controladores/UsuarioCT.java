/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.GenerarPassword;
import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.metodos.Upload;
import static com.planit.lavappweb.metodos.Upload.getPathDefaultUsuario;
import com.planit.lavappweb.modelo.dao.CorreoDao;
import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.Rol_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

public class UsuarioCT implements Serializable {
    
    //Variables y objetos
    private Usuario_TO usuario;
    private List<Usuario_TO> usuarios;
    private List<Usuario_TO> clientes;
    private List<Usuario_TO> asesores;
 

    private String nombreOperacion;
    private int operacion; //Controla la operacion a ejecutar
    private String buscar;

    //Constructores
    public UsuarioCT() {
        usuario = new Usuario_TO();
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();
        asesores = new ArrayList<>();
        
        operacion = 0;
        nombreOperacion = "Registrar";
        buscar = null;
    }

    @PostConstruct
    public void init() {
        UsuarioDao usuarioDao = new UsuarioDao();
        clientes = usuarioDao.consultarUsuariosPorRol(new Rol_TO(4));
        asesores = usuarioDao.consultarUsuariosPorRol(new Rol_TO(3));
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
        UsuarioDao usuarioDao = new UsuarioDao();

        usuario.setRol(new Rol_TO(4, ""));
        usuario.setRutaImagen(getPathDefaultUsuario());//Seteo de imagen default

        usuarioDao.registrarUsuario(usuario);//Registro de usuario en la BD

        SesionCT ss = new SesionCT();
        ss.setUsuario(usuario);
        ss.iniciarSesion();//Inicio de sesion de usuario
        
        //Envio de correo de bienvenida
        CorreoDao correoDao = new CorreoDao();
        correoDao.enviarMensajeBienvenida(Sesion.obtenerSesion());
        
        usuario = new Usuario_TO();
        return "Principal"; // retornamos a vista principal
    }

    public void eliminarCliente() {

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.eliminarUsuario(usuario);
        clientes = usuarioDao.consultarUsuariosPorRol(new Rol_TO(4));
    }

    public void registrarAsesor() {

        UsuarioDao usuarioDao = new UsuarioDao();

        usuario.setRol(new Rol_TO(3, ""));
        usuario.setRutaImagen(Upload.getPathDefaultUsuario());
        usuario.setContrasena(GenerarPassword.generarPass(6));

        usuario = usuarioDao.registrarUsuario(usuario);
        asesores = usuarioDao.consultarUsuariosPorRol(new Rol_TO(3));
    }

    public void modificarAsesor() {

        UsuarioDao usuarioDao = new UsuarioDao();
        usuario = usuarioDao.editarUsuario(usuario);
        asesores = usuarioDao.consultarUsuariosPorRol(new Rol_TO(3));
    }

    public void eliminarAsesor() {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario = usuarioDao.eliminarUsuario(usuario);
        asesores = usuarioDao.consultarUsuariosPorRol(new Rol_TO(3));
    }

    //Metodos Asesor
    public void metodoAsesor() {
        //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro en la vista de asesor
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
        //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro en la vista de cliente
        if (operacion == 0) {
            registrarCliente();
        } else if (operacion == 1) {
//            modificarCliente();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) {
         //Setea un valor en la variable operacion para determinar que funcion realizara proximamente
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }

    public void cancelarAsesor() {
         //reinicia los valores de la variables y vuelve a 0 la bandera operacion
        usuario = new Usuario_TO();
        nombreOperacion = "Registrar";
        operacion = 0;
    }

    public void buscarAsesores() {
        //filtra la lista de asesores segun el valor que se consulte, si valor es vacio consulta todos los asesores
          UsuarioDao usuarioDao = new UsuarioDao();
        asesores = new ArrayList<>();
        if (buscar == null) {
            asesores = usuarioDao.consultarUsuariosPorRol(new Rol_TO(3));
        } else {
            asesores = usuarioDao.buscarAsesores(buscar);
        }
    }

    public void buscarClientes() {
        //filtra la lista de clientes segun el valor que se consulte, si valor es vacio consulta todos los clientes
          UsuarioDao usuarioDao = new UsuarioDao();
        clientes = new ArrayList<>();
        if (buscar.isEmpty()) {
            clientes = usuarioDao.consultarUsuariosPorRol(new Rol_TO(4));
        } else {
            clientes = usuarioDao.buscarClientes(buscar);
        }
    }
    
}
