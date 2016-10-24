/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.GenerarPassword;
import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelo.dao.ProveedorDao;
import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Proveedor_TO;
import com.planit.lavappweb.modelo.dto.Rol_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProveedorCT implements Serializable {

    //Variables
    private Proveedor_TO proveedor;
    private List<Proveedor_TO> proveedores;

    private String nombreOperacion;
    private int operacion; //Controla la operacion a ejecutar
    private String buscar;

    //constructores
    public ProveedorCT() {
        proveedor = new Proveedor_TO();
        proveedores = new ArrayList<>();
        operacion = 0;
        nombreOperacion = "Registrar";

        buscar = null;
    }

    @PostConstruct
    public void init() {
        ProveedorDao proveedorDao = new ProveedorDao();
        proveedores = proveedorDao.consultarProveedores();
    }
    
    //Getters & setters
    public Proveedor_TO getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor_TO proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor_TO> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor_TO> proveedores) {
        this.proveedores = proveedores;
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos CRUD    
    public void registrar() {

        UsuarioDao usuarioDao = new UsuarioDao();
        ProveedorDao proveedorDao = new ProveedorDao();

        //Registro de informacion de usuario
        proveedor.getUsuario().setRol(new Rol_TO(2, "Administrador Planta"));
        proveedor.getUsuario().setEstado(new Estado_TO(1, "Activo"));

        String password = GenerarPassword.generarPass(6);//Generamos contraseña automatica        
        String identificacion = proveedor.getUsuario().getIdentificacion();//Guardamos la identificacion del usuario para consultarlo despues de ser registrado

        proveedor.getUsuario().setRutaImagen(Upload.getPathDefaultUsuario());//Asignamos fotografia default
        proveedor.getUsuario().setContrasena(password);
        proveedor.getUsuario().setDireccion(proveedor.getDireccion());
        proveedor.getUsuario().setTelefono(proveedor.getTelefono());

        //Se registra el usuario
        usuarioDao.registrarUsuario(proveedor.getUsuario());
        //Envio de correo de bienvenida
        //
        //
        //Registro informacion proveedor     
        proveedor.setUsuario(usuarioDao.consultarUsuarioSegunIdentificacion(identificacion)); //Consultamos el usuario recien registrado

        //Registramos la informacion de la planta
        proveedor = proveedorDao.registrarProveedor(proveedor);
        proveedores = proveedorDao.consultarProveedores();//Actualizamos la lista de proveedores
    }

    public void modificar() {

        UsuarioDao usuarioDao = new UsuarioDao();
        ProveedorDao proveedorDao = new ProveedorDao();

        usuarioDao.editarUsuario(proveedor.getUsuario());
        proveedor = proveedorDao.editarProveedor(proveedor);
        proveedores = proveedorDao.consultarProveedores();//Actualizamos la lista de proveedores
    }

    public void eliminar() {
        
        UsuarioDao usuarioDao = new UsuarioDao();
        ProveedorDao proveedorDao = new ProveedorDao();
        
        int usuario = proveedor.getUsuario().getIdUsuario();
        proveedor = proveedorDao.eliminarProveedor(proveedor);
        usuarioDao.eliminarUsuario(new Usuario_TO(usuario));
        proveedores = proveedorDao.consultarProveedores();
    }

    //Metodos Propios
    public void metodo() {
         //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro
        if (operacion == 0) {
            registrar();
        } else if (operacion == 1) {
            modificar();
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

    public void cancelar() {
        //reinicia los valores de la variables y vuelve a 0 la bandera operacion
        proveedor = new Proveedor_TO();
        //proveedores = ;
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarProveedores() {
        //filtra la lista de proveedores segun el valor que se consulte, si valor es vacio consulta todos los proveedores
        ProveedorDao proveedorDao = new ProveedorDao();
        proveedores = new ArrayList<>();
        if (buscar.isEmpty()) {
            proveedores = proveedorDao.consultarProveedores();
        } else {
            proveedores = proveedorDao.buscarProveedores(buscar);
        }
    }
}
