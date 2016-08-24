/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.GenerarPassword;
import com.planit.lavappweb.metodos.MD5;
import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelos.Estado_TO;
import com.planit.lavappweb.modelos.Proveedor_TO;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosBarrios;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCiudad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosLocalidad;
import com.planit.lavappweb.webservices.implementaciones.ServiciosProveedor;
import com.planit.lavappweb.webservices.implementaciones.ServiciosRol;
import com.planit.lavappweb.webservices.implementaciones.ServiciosUsuario;
import com.planit.lavappweb.webservices.implementaciones.ServiciosZona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProveedorCT {

    private Proveedor_TO proveedor;
    private List<Proveedor_TO> proveedores;

    protected ServiciosProveedor servicios;
    protected ServiciosUsuario serviciosUsuario;

    private String nombreOperacion;
    private int operacion; //Controla la operacion a ejecutar
    private String buscar;

    public ProveedorCT() {
        proveedor = new Proveedor_TO();
        proveedores = new ArrayList<>();
        operacion = 0;
        nombreOperacion = "Registrar";

        servicios = new ServiciosProveedor();
        serviciosUsuario = new ServiciosUsuario();
        buscar = null;
    }

    @PostConstruct
    public void init() {
        proveedores = servicios.consultarProveedores();
    }

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
        ServiciosBarrios sb = new ServiciosBarrios();
        ServiciosLocalidad sl = new ServiciosLocalidad();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosRol sr = new ServiciosRol();

        //Registro de informacion de usuario
        proveedor.getUsuario().setBarrio(sb.consultarBarrio(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre()));
        proveedor.getUsuario().getBarrio().setLocalidad(sl.consultarLocalidad(proveedor.getUsuario().getBarrio().getLocalidad().getIdLocalidad(), ""));
        proveedor.getUsuario().setCiudad(sc.consultarCiudad(proveedor.getUsuario().getBarrio().getLocalidad().getCiudad().getIdCiudad(), ""));
        proveedor.getUsuario().setRol(sr.consultarRol(2, "Administrador Planta"));
        proveedor.getUsuario().setEstado(new Estado_TO(1, "Activo"));
        proveedor.getUsuario().setDireccion(proveedor.getDireccion());
        proveedor.getUsuario().setTelefono(proveedor.getTelefono());

        String password = GenerarPassword.generarPass(6);//Generamos contraseña automatica        
        String identificacion = proveedor.getUsuario().getIdentificacion();//Guardamos la identificacion del usuario para consultarlo despues de ser registrado

        proveedor.getUsuario().setRutaImagen(Upload.getPathDefaultUsuario());//Asignamos fotografia default
        //Se registra el usuario
        serviciosUsuario.registrarUsuario(proveedor.getUsuario().getNombre(),
                proveedor.getUsuario().getTelefono(),
                proveedor.getUsuario().getBarrio().getIdBarrios(),
                proveedor.getUsuario().getRol().getIdRol(),
                proveedor.getUsuario().getEstado().getIdEstado(),
                proveedor.getUsuario().getEmail(),
                MD5.getMD5(password),
                proveedor.getUsuario().getApellido(),
                proveedor.getUsuario().getGenero(),
                proveedor.getUsuario().getMovil(),
                proveedor.getUsuario().getDireccion(),
                proveedor.getUsuario().getCiudad().getIdCiudad(),
                proveedor.getUsuario().getIdentificacion(),
                proveedor.getUsuario().getRutaImagen());

        //Envio de correo de bienvenida
        //
        //
        //Registro informacion proveedor
        ServiciosZona sz = new ServiciosZona();
        proveedor.setUsuario(new Usuario_TO());
        proveedor.setUsuario(serviciosUsuario.consultarUsuarioSegunIdentificacion(identificacion)); //Consultamos el usuario recien registrado

        //Consultamos la informacion del barrio seleccionado y asi consultamos la zona a la que esta asociada
        proveedor.getUsuario().setBarrio(sb.consultarBarrio(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre()));
        proveedor.setZona(sz.consultarZona(proveedor.getUsuario().getBarrio().getZona().getIdZona(), proveedor.getUsuario().getBarrio().getZona().getNombre()));

        //Registramos la informacion de la planta
        proveedor = servicios.registrarProveedor(proveedor.getRazonSocial(),
                proveedor.getNit(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.getUsuario().getIdUsuario(),
                proveedor.getCupo(),
                proveedor.getZona().getIdZona());

        proveedores = servicios.consultarProveedores();//Actualizamos la lista de proveedores
    }

    public void modificar() {

        ServiciosBarrios sb = new ServiciosBarrios();
         ServiciosLocalidad sl = new ServiciosLocalidad();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosRol sr = new ServiciosRol();

        proveedor.getUsuario().setBarrio(sb.consultarBarrio(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre()));
        proveedor.getUsuario().getBarrio().setLocalidad(sl.consultarLocalidad(proveedor.getUsuario().getBarrio().getLocalidad().getIdLocalidad(), ""));
        proveedor.getUsuario().setCiudad(sc.consultarCiudad(proveedor.getUsuario().getBarrio().getLocalidad().getCiudad().getIdCiudad(), ""));
        
        serviciosUsuario.editarUsuario(proveedor.getUsuario().getIdUsuario(),
                proveedor.getUsuario().getNombre(),
                proveedor.getUsuario().getApellido(),
                proveedor.getUsuario().getGenero(),
                proveedor.getUsuario().getTelefono(),
                proveedor.getUsuario().getBarrio().getIdBarrios(),
                proveedor.getUsuario().getMovil(),
                proveedor.getUsuario().getDireccion(),
                proveedor.getUsuario().getCiudad().getIdCiudad(),
                proveedor.getUsuario().getIdentificacion(),
                proveedor.getUsuario().getRutaImagen());
        ServiciosZona sz = new ServiciosZona();
        //Consultamos la informacion del barrio seleccionado y asi consultamos la zona a la que esta asociada
        proveedor.getUsuario().setBarrio(sb.consultarBarrio(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre()));
        proveedor.setZona(sz.consultarZona(proveedor.getUsuario().getBarrio().getZona().getIdZona(), proveedor.getUsuario().getBarrio().getZona().getNombre()));

        proveedor = servicios.editarProveedor(proveedor.getIdProveedor(),
                proveedor.getRazonSocial(),
                proveedor.getNit(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.getUsuario().getIdUsuario(),
                proveedor.getCupo(),
                proveedor.getZona().getIdZona());

        proveedores = servicios.consultarProveedores();//Actualizamos la lista de proveedores
    }

    public void eliminar() {
        int usuario = proveedor.getUsuario().getIdUsuario();
        proveedor = servicios.eliminarProveedor(proveedor.getIdProveedor());
        serviciosUsuario.eliminarUsuario(usuario);
        proveedores = servicios.consultarProveedores();
    }

    //Metodos Propios
    public void metodo() {
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
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }

    public void cancelar() {
        proveedor = new Proveedor_TO();
        //proveedores = ;
        operacion = 0;
        nombreOperacion = "Registrar";
    }
    
    
    public void buscarProveedores(){
        proveedores = new ArrayList<>();
        if(buscar == null){
            proveedores = servicios.consultarProveedores();
        }else{
            proveedores = servicios.buscarProveedores(buscar);
        }
    }
}
