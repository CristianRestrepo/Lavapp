/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Barrio_TO;
import com.planit.lavappweb.modelo.dto.Ciudad_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Localidad_TO;
import com.planit.lavappweb.modelo.dto.Rol_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarAdministradores;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarAsesores;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarClientes;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarAsesorZona;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuarioPorLogin;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuarioSegunIdentificacion;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUsuariosPorRol;
import com.planit.lavappweb.webservices.clientes.ClienteEditarContrasenaSesion;
import com.planit.lavappweb.webservices.clientes.ClienteEditarCorreoSesion;
import com.planit.lavappweb.webservices.clientes.ClienteEditarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarUsuario;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarUsuario;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class UsuarioDao {

    public Usuario_TO consultarUsuarioPorLogin(String email) {
        ClienteConsultarUsuarioPorLogin cliente = new ClienteConsultarUsuarioPorLogin();
        return cliente.consultarUsuarioPorLogin(Usuario_TO.class, email);
    }
    
    public Usuario_TO consultarAsesorZona(Zona_TO zona) {
        ClienteConsultarAsesorZona cliente = new ClienteConsultarAsesorZona();
        return cliente.consultarAsesorZona(Usuario_TO.class, "" + zona.getIdZona());
    }

    public Usuario_TO consultarUsuario(Usuario_TO usuario) {
        ClienteConsultarUsuario cliente = new ClienteConsultarUsuario();
        return cliente.consultarUsuario(Usuario_TO.class, "" + usuario.getIdUsuario());
    }

    public Usuario_TO consultarUsuarioSegunIdentificacion(String identificacion) {
        ClienteConsultarUsuarioSegunIdentificacion cliente = new ClienteConsultarUsuarioSegunIdentificacion();
        return cliente.consultarUsuarioSegunIdentificacion(Usuario_TO.class, identificacion);
    }

    public Usuario_TO registrarUsuario(Usuario_TO usuario) {

        CiudadDao cd = new CiudadDao();
        BarriosDao bd = new BarriosDao();
        LocalidadDao ld = new LocalidadDao();
        RolDao rd = new RolDao();

        usuario.setBarrio(bd.consultarBarrio(new Barrio_TO(usuario.getBarrio().getIdBarrios(), usuario.getBarrio().getNombre())));
        usuario.getBarrio().setLocalidad(ld.consultarLocalidad(new Localidad_TO(usuario.getBarrio().getLocalidad().getIdLocalidad(), usuario.getBarrio().getLocalidad().getNombre())));
        usuario.setCiudad(cd.consultarCiudad(new Ciudad_TO(usuario.getBarrio().getLocalidad().getCiudad().getIdCiudad(), usuario.getBarrio().getLocalidad().getCiudad().getNombre())));
        usuario.setRol(rd.consultarRol(new Rol_TO(usuario.getRol().getIdRol(), usuario.getRol().getNombre())));
        usuario.setEstado(new Estado_TO(1, "Activo"));

        ClienteRegistrarUsuario cliente = new ClienteRegistrarUsuario();
        return cliente.registrarUsuarios(Usuario_TO.class,
                usuario.getNombre(),
                usuario.getTelefono(),
                "" + usuario.getBarrio().getIdBarrios(),
                "" + usuario.getRol().getIdRol(),
                "" + usuario.getEstado().getIdEstado(),
                usuario.getEmail(),
                usuario.getContrasena(),
                usuario.getApellido(),
                usuario.getGenero(),
                usuario.getMovil(),
                usuario.getDireccion(),
                "" + usuario.getCiudad().getIdCiudad(),
                usuario.getIdentificacion(),
                usuario.getRutaImagen());
    }

    public Usuario_TO editarUsuario(Usuario_TO usuario) {
        CiudadDao cd = new CiudadDao();
        BarriosDao bd = new BarriosDao();
        LocalidadDao ld = new LocalidadDao();

        usuario.getBarrio().setIdBarrios(0);
        usuario.setBarrio(bd.consultarBarrio(new Barrio_TO(usuario.getBarrio().getIdBarrios(), usuario.getBarrio().getNombre())));
        usuario.getBarrio().setLocalidad(ld.consultarLocalidad(new Localidad_TO(usuario.getBarrio().getLocalidad().getIdLocalidad(), usuario.getBarrio().getLocalidad().getNombre())));
        usuario.setCiudad(cd.consultarCiudad(new Ciudad_TO(usuario.getBarrio().getLocalidad().getCiudad().getIdCiudad(), usuario.getBarrio().getLocalidad().getCiudad().getNombre())));

        ClienteEditarUsuario cliente = new ClienteEditarUsuario();
        return cliente.editarUsuario(Usuario_TO.class,
                "" + usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getGenero(),
                usuario.getTelefono(),
                "" + usuario.getBarrio().getIdBarrios(),
                usuario.getEmail(),
                usuario.getDireccion(),
                "" + usuario.getCiudad().getIdCiudad(),
                usuario.getIdentificacion(),
                usuario.getRutaImagen());
    }

    public Usuario_TO editarContrasenaSesion(Usuario_TO usuario) {
        ClienteEditarContrasenaSesion cliente = new ClienteEditarContrasenaSesion();
        return cliente.editarContrasenaSesion(Usuario_TO.class,
                "" + usuario.getIdUsuario(),
                usuario.getContrasena());
    }

    public Usuario_TO editarCorreoSesion(Usuario_TO usuario) {
        ClienteEditarCorreoSesion cliente = new ClienteEditarCorreoSesion();
        return cliente.editarCorreoSesion(Usuario_TO.class,
                "" + usuario.getIdUsuario(),
                usuario.getEmail());
    }

    public Usuario_TO eliminarUsuario(Usuario_TO usuario) {
        ClienteEliminarUsuario cliente = new ClienteEliminarUsuario();
        return cliente.eliminarUsuario(Usuario_TO.class, "" + usuario.getIdUsuario());
    }

    public List<Usuario_TO> consultarUsuariosPorRol(Rol_TO r) {
        ClienteConsultarUsuariosPorRol clienteModelo = new ClienteConsultarUsuariosPorRol();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = clienteModelo.consultarUsuariosPorRol(List.class, "" + r.getIdRol());
        List<Usuario_TO> usuarios = new ArrayList<>();

        //SERVICIOS
        BarriosDao bd = new BarriosDao();
        RolDao rd = new RolDao();
        EstadoDao ed = new EstadoDao();
        CiudadDao cd = new CiudadDao();
        try {
            for (int i = 0; i < datos.size(); i++) {

                LinkedHashMap barrio = (LinkedHashMap) datos.get(i).get("barrio");
                LinkedHashMap rol = (LinkedHashMap) datos.get(i).get("rol");
                LinkedHashMap estado = (LinkedHashMap) datos.get(i).get("estado");
                LinkedHashMap ciudad = (LinkedHashMap) datos.get(i).get("ciudad");

                usuarios.add(new Usuario_TO((int) datos.get(i).get("idUsuario"),
                        (String) datos.get(i).get("nombre"),
                        (String) datos.get(i).get("telefono"),
                        bd.consultarBarrio(new Barrio_TO((int) barrio.get("idBarrios"), "")),
                        rd.consultarRol(new Rol_TO((int) rol.get("idRol"), "")),
                        ed.consultarEstadoID(new Estado_TO((int) estado.get("idEstado"), "")),
                        (String) datos.get(i).get("email"),
                        (String) datos.get(i).get("contrasena"),
                        (String) datos.get(i).get("apellido"),
                        (String) datos.get(i).get("genero"),
                        (String) datos.get(i).get("movil"),
                        (String) datos.get(i).get("direccion"),
                        cd.consultarCiudad(new Ciudad_TO((int) ciudad.get("idCiudad"), "")),
                        (String) datos.get(i).get("identificacion"),
                        (String) datos.get(i).get("rutaImagen")));
            }
        } catch (Exception e) {
            throw e;
        }
        return usuarios;
    }

    public List<Usuario_TO> buscarAsesores(String valor) {

        ClienteBuscarAsesores clienteModelo = new ClienteBuscarAsesores();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = clienteModelo.buscarAsesores(List.class, valor);
        List<Usuario_TO> usuarios = new ArrayList<>();

        //SERVICIOS
        BarriosDao bd = new BarriosDao();
        RolDao rd = new RolDao();
        EstadoDao ed = new EstadoDao();
        CiudadDao cd = new CiudadDao();
        try {
            for (int i = 0; i < datos.size(); i++) {

                LinkedHashMap barrio = (LinkedHashMap) datos.get(i).get("barrio");
                LinkedHashMap rol = (LinkedHashMap) datos.get(i).get("rol");
                LinkedHashMap estado = (LinkedHashMap) datos.get(i).get("estado");
                LinkedHashMap ciudad = (LinkedHashMap) datos.get(i).get("ciudad");

                usuarios.add(new Usuario_TO((int) datos.get(i).get("idUsuario"),
                        (String) datos.get(i).get("nombre"),
                        (String) datos.get(i).get("telefono"),
                        bd.consultarBarrio(new Barrio_TO((int) barrio.get("idBarrios"), "")),
                        rd.consultarRol(new Rol_TO((int) rol.get("idRol"), "")),
                        ed.consultarEstadoID(new Estado_TO((int) estado.get("idEstado"), "")),
                        (String) datos.get(i).get("email"),
                        (String) datos.get(i).get("contrasena"),
                        (String) datos.get(i).get("apellido"),
                        (String) datos.get(i).get("genero"),
                        (String) datos.get(i).get("movil"),
                        (String) datos.get(i).get("direccion"),
                        cd.consultarCiudad(new Ciudad_TO((int) ciudad.get("idCiudad"), "")),
                        (String) datos.get(i).get("identificacion"),
                        (String) datos.get(i).get("rutaImagen")));
            }
        } catch (Exception e) {
            throw e;
        }

        return usuarios;
    }

    public List<Usuario_TO> buscarClientes(String valor) {

        ClienteBuscarClientes clienteModelo = new ClienteBuscarClientes();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = clienteModelo.buscarClientes(List.class, valor);
        List<Usuario_TO> usuarios = new ArrayList<>();

        //SERVICIOS
        BarriosDao bd = new BarriosDao();
        RolDao rd = new RolDao();
        EstadoDao ed = new EstadoDao();
        CiudadDao cd = new CiudadDao();
        try {
            for (int i = 0; i < datos.size(); i++) {

                LinkedHashMap barrio = (LinkedHashMap) datos.get(i).get("barrio");
                LinkedHashMap rol = (LinkedHashMap) datos.get(i).get("rol");
                LinkedHashMap estado = (LinkedHashMap) datos.get(i).get("estado");
                LinkedHashMap ciudad = (LinkedHashMap) datos.get(i).get("ciudad");

                usuarios.add(new Usuario_TO((int) datos.get(i).get("idUsuario"),
                        (String) datos.get(i).get("nombre"),
                        (String) datos.get(i).get("telefono"),
                        bd.consultarBarrio(new Barrio_TO((int) barrio.get("idBarrios"), "")),
                        rd.consultarRol(new Rol_TO((int) rol.get("idRol"), "")),
                        ed.consultarEstadoID(new Estado_TO((int) estado.get("idEstado"), "")),
                        (String) datos.get(i).get("email"),
                        (String) datos.get(i).get("contrasena"),
                        (String) datos.get(i).get("apellido"),
                        (String) datos.get(i).get("genero"),
                        (String) datos.get(i).get("movil"),
                        (String) datos.get(i).get("direccion"),
                        cd.consultarCiudad(new Ciudad_TO((int) ciudad.get("idCiudad"), "")),
                        (String) datos.get(i).get("identificacion"),
                        (String) datos.get(i).get("rutaImagen")));
            }
        } catch (Exception e) {
            throw e;
        }
        return usuarios;
    }

    public List<Usuario_TO> buscarAdministradores(String valor) {

        ClienteBuscarAdministradores clienteModelo = new ClienteBuscarAdministradores();
        List<LinkedHashMap> datos = new ArrayList<>();
        datos = clienteModelo.buscarAdministradores(List.class, valor);
        List<Usuario_TO> usuarios = new ArrayList<>();

        //SERVICIOS
        BarriosDao bd = new BarriosDao();
        RolDao rd = new RolDao();
        EstadoDao ed = new EstadoDao();
        CiudadDao cd = new CiudadDao();
        try {
            for (int i = 0; i < datos.size(); i++) {
                LinkedHashMap barrio = (LinkedHashMap) datos.get(i).get("barrio");
                LinkedHashMap rol = (LinkedHashMap) datos.get(i).get("rol");
                LinkedHashMap estado = (LinkedHashMap) datos.get(i).get("estado");
                LinkedHashMap ciudad = (LinkedHashMap) datos.get(i).get("ciudad");

                usuarios.add(new Usuario_TO((int) datos.get(i).get("idUsuario"),
                        (String) datos.get(i).get("nombre"),
                        (String) datos.get(i).get("telefono"),
                        bd.consultarBarrio(new Barrio_TO((int) barrio.get("idBarrios"), "")),
                        rd.consultarRol(new Rol_TO((int) rol.get("idRol"), "")),
                        ed.consultarEstadoID(new Estado_TO((int) estado.get("idEstado"), "")),
                        (String) datos.get(i).get("email"),
                        (String) datos.get(i).get("contrasena"),
                        (String) datos.get(i).get("apellido"),
                        (String) datos.get(i).get("genero"),
                        (String) datos.get(i).get("movil"),
                        (String) datos.get(i).get("direccion"),
                        cd.consultarCiudad(new Ciudad_TO((int) ciudad.get("idCiudad"), "")),
                        (String) datos.get(i).get("identificacion"),
                        (String) datos.get(i).get("rutaImagen")));
            }
        } catch (Exception e) {
            throw e;
        }

        return usuarios;
    }

}
