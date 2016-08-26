/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Barrio_TO;
import com.planit.lavappweb.modelo.dto.Ciudad_TO;
import com.planit.lavappweb.modelo.dto.Proveedor_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarProveedores;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarProveedor;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarProveedores;
import com.planit.lavappweb.webservices.clientes.ClienteEditarProveedor;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarProveedor;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarProveedor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProveedorDao {

    public List<Proveedor_TO> consultarProveedores() {
        ClienteConsultarProveedores cliente = new ClienteConsultarProveedores();
        List<LinkedHashMap> datos = cliente.consultarProveedores(List.class);
        List<Proveedor_TO> proveedores = new ArrayList<>();

        UsuarioDao ud = new UsuarioDao();
        ZonaDao zd = new ZonaDao();
        CiudadDao cd = new CiudadDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap mapUsuario = (LinkedHashMap) datos.get(i).get("usuario");
            Usuario_TO usuario = ud.consultarUsuario(new Usuario_TO((int) mapUsuario.get("idUsuario")));
            usuario.setCiudad(cd.consultarCiudad(new Ciudad_TO(usuario.getCiudad().getIdCiudad(), "")));
            usuario.setBarrio(bd.consultarBarrio(new Barrio_TO(usuario.getBarrio().getIdBarrios(), "")));
            LinkedHashMap mapZona = (LinkedHashMap) datos.get(i).get("zona");
            proveedores.add(new Proveedor_TO((int) datos.get(i).get("idProveedor"),
                    (String) datos.get(i).get("razonSocial"),
                    (String) datos.get(i).get("nit"),
                    (String) datos.get(i).get("telefono"),
                    (String) datos.get(i).get("direccion"),
                    usuario,
                    (int) datos.get(i).get("cupo"),
                    zd.consultarZona(new Zona_TO((int) mapZona.get("idZona"), ""))));
        }
        return proveedores;
    }

    public List<Proveedor_TO> buscarProveedores(String valor) {
        ClienteBuscarProveedores cliente = new ClienteBuscarProveedores();
        List<LinkedHashMap> datos = cliente.buscarProveedores(List.class, valor);
        List<Proveedor_TO> proveedores = new ArrayList<>();

        UsuarioDao ud = new UsuarioDao();
        ZonaDao zd = new ZonaDao();
        CiudadDao cd = new CiudadDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap mapUsuario = (LinkedHashMap) datos.get(i).get("usuario");
            Usuario_TO usuario = ud.consultarUsuario(new Usuario_TO((int) mapUsuario.get("idUsuario")));
            usuario.setCiudad(cd.consultarCiudad(new Ciudad_TO(usuario.getCiudad().getIdCiudad(), "")));
            usuario.setBarrio(bd.consultarBarrio(new Barrio_TO(usuario.getBarrio().getIdBarrios(), "")));
            LinkedHashMap mapZona = (LinkedHashMap) datos.get(i).get("zona");
            proveedores.add(new Proveedor_TO((int) datos.get(i).get("idProveedor"),
                    (String) datos.get(i).get("razonSocial"),
                    (String) datos.get(i).get("nit"),
                    (String) datos.get(i).get("telefono"),
                    (String) datos.get(i).get("direccion"),
                    usuario,
                    (int) datos.get(i).get("cupo"),
                    zd.consultarZona(new Zona_TO((int) mapZona.get("idZona"), ""))));
        }
        return proveedores;
    }

    public Proveedor_TO consultarProveedor(Proveedor_TO proveedor) {
        ClienteConsultarProveedor cliente = new ClienteConsultarProveedor();
        return cliente.consultarProveedor(Proveedor_TO.class, "" + proveedor.getIdProveedor());
    }

    public Proveedor_TO registrarProveedor(Proveedor_TO proveedor) {

        ZonaDao zd = new ZonaDao();
        BarriosDao bd = new BarriosDao();

        proveedor.getUsuario().setBarrio(bd.consultarBarrio(new Barrio_TO(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre())));
        proveedor.setZona(zd.consultarZona(new Zona_TO(proveedor.getUsuario().getBarrio().getZona().getIdZona(), proveedor.getUsuario().getBarrio().getZona().getNombre())));

        ClienteRegistrarProveedor cliente = new ClienteRegistrarProveedor();
        return cliente.registrarProveedor(Proveedor_TO.class,
                proveedor.getRazonSocial(),
                proveedor.getNit(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                "" + proveedor.getUsuario().getIdUsuario(),
                "" + proveedor.getCupo(),
                "" + proveedor.getZona().getIdZona());
    }

    public Proveedor_TO editarProveedor(Proveedor_TO proveedor) {

        ZonaDao zd = new ZonaDao();
        BarriosDao bd = new BarriosDao();

        proveedor.getUsuario().setBarrio(bd.consultarBarrio(new Barrio_TO(proveedor.getUsuario().getBarrio().getIdBarrios(), proveedor.getUsuario().getBarrio().getNombre())));
        proveedor.setZona(zd.consultarZona(new Zona_TO(proveedor.getUsuario().getBarrio().getZona().getIdZona(), proveedor.getUsuario().getBarrio().getZona().getNombre())));

        ClienteEditarProveedor cliente = new ClienteEditarProveedor();
        return cliente.editarProveedor(Proveedor_TO.class, 
                "" + proveedor.getIdProveedor(),
                proveedor.getRazonSocial(),
                proveedor.getNit(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                "" + proveedor.getUsuario().getIdUsuario(),
                "" + proveedor.getCupo(), 
                "" + proveedor.getZona().getIdZona());
    }

    public Proveedor_TO eliminarProveedor(Proveedor_TO proveedor) {
        ClienteEliminarProveedor cliente = new ClienteEliminarProveedor();
        return cliente.eliminarProveedor(Proveedor_TO.class, "" + proveedor.getIdProveedor());
    }
}
