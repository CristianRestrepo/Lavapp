/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Proveedor_TO;
import com.planit.lavappweb.modelos.Usuario_TO;
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
public class ServiciosProveedor {

    public List<Proveedor_TO> consultarProveedores() {
        ClienteConsultarProveedores cliente = new ClienteConsultarProveedores();
        List<LinkedHashMap> datos = cliente.consultarProveedores(List.class);
        List<Proveedor_TO> proveedores = new ArrayList<>();

        ServiciosUsuario su = new ServiciosUsuario();
        ServiciosZona sz = new ServiciosZona();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosBarrios sb = new ServiciosBarrios();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap mapUsuario = (LinkedHashMap) datos.get(i).get("usuario");
            Usuario_TO usuario = su.consultarUsuario((int) mapUsuario.get("idUsuario"));
            usuario.setCiudad(sc.consultarCiudad(usuario.getCiudad().getIdCiudad(), ""));
            usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), ""));
            LinkedHashMap mapZona = (LinkedHashMap) datos.get(i).get("zona");
            proveedores.add(new Proveedor_TO((int) datos.get(i).get("idProveedor"),
                    (String) datos.get(i).get("razonSocial"),
                    (String) datos.get(i).get("nit"),
                    (String) datos.get(i).get("telefono"),
                    (String) datos.get(i).get("direccion"),
                    usuario,
                    (int) datos.get(i).get("cupo"),
                    sz.consultarZona((int) mapZona.get("idZona"), "")));
        }
        return proveedores;
    }

    public List<Proveedor_TO> buscarProveedores(String valor) {
        ClienteBuscarProveedores cliente = new ClienteBuscarProveedores();
        List<LinkedHashMap> datos = cliente.buscarProveedores(List.class, valor);
        List<Proveedor_TO> proveedores = new ArrayList<>();

        ServiciosUsuario su = new ServiciosUsuario();
        ServiciosZona sz = new ServiciosZona();
        ServiciosCiudad sc = new ServiciosCiudad();
        ServiciosBarrios sb = new ServiciosBarrios();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap mapUsuario = (LinkedHashMap) datos.get(i).get("usuario");
            Usuario_TO usuario = su.consultarUsuario((int) mapUsuario.get("idUsuario"));
            usuario.setCiudad(sc.consultarCiudad(usuario.getCiudad().getIdCiudad(), ""));
            usuario.setBarrio(sb.consultarBarrio(usuario.getBarrio().getIdBarrios(), ""));
            LinkedHashMap mapZona = (LinkedHashMap) datos.get(i).get("zona");
            proveedores.add(new Proveedor_TO((int) datos.get(i).get("idProveedor"),
                    (String) datos.get(i).get("razonSocial"),
                    (String) datos.get(i).get("nit"),
                    (String) datos.get(i).get("telefono"),
                    (String) datos.get(i).get("direccion"),
                    usuario,
                    (int) datos.get(i).get("cupo"),
                    sz.consultarZona((int) mapZona.get("idZona"), "")));
        }
        return proveedores;
    }

    public Proveedor_TO consultarProveedor(int idProveedor) {
        ClienteConsultarProveedor cliente = new ClienteConsultarProveedor();
        return cliente.consultarProveedor(Proveedor_TO.class, "" + idProveedor);
    }

    public Proveedor_TO registrarProveedor(String razonSocial, String nit, String telefono, String direccion, int idUsuario, int cupo, int idZona) {
        ClienteRegistrarProveedor cliente = new ClienteRegistrarProveedor();
        return cliente.registrarProveedor(Proveedor_TO.class, razonSocial, nit, telefono, direccion, "" + idUsuario, "" + cupo, "" + idZona);
    }

    public Proveedor_TO editarProveedor(int idProveedor, String razonSocial, String nit, String telefono, String direccion, int idUsuario, int cupo, int idZona) {
        ClienteEditarProveedor cliente = new ClienteEditarProveedor();
        return cliente.editarProveedor(Proveedor_TO.class, "" + idProveedor, razonSocial, nit, telefono, direccion, "" + idUsuario, "" + cupo, "" + idZona);
    }

    public Proveedor_TO eliminarProveedor(int idProveedor) {
        ClienteEliminarProveedor cliente = new ClienteEliminarProveedor();
        return cliente.eliminarProveedor(Proveedor_TO.class, "" + idProveedor);
    }
}
