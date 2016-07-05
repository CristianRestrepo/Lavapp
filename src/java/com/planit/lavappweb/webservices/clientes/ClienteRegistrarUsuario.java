/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.clientes;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 * Jersey REST client generated for REST resource:we [registrarUsuarios]<br>
 * USAGE:
 * <pre>
 *        ClienteRegistrarUsuario client = new ClienteRegistrarUsuario();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Desarrollo_Planit
 */
public class ClienteRegistrarUsuario {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084/LavappService/webresources/";

    public ClienteRegistrarUsuario() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("registrarUsuarios");
    }

    /**
     * @param responseType Class representing the response
     * @param nombre query parameter
     * @param telefono query parameter
     * @param idbarrios query parameter
     * @param idrol query parameter
     * @param idestado query parameter
     * @param usuario query parameter
     * @param contrasena query parameter
     * @param apellido query parameter
     * @param genero query parameter
     * @param movil query parameter
     * @param direccion query parameter
     * @param idCiudad query parameter
     * @param identificacion query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T registrarUsuarios(Class<T> responseType, String nombre, String telefono, String idbarrios, String idrol, String idestado, String usuario, String contrasena, String apellido, String genero, String movil, String direccion, String idCiudad, String identificacion) throws ClientErrorException {
        String[] queryParamNames = new String[]{"nombre", "telefono", "idbarrios", "idrol", "idestado", "usuario", "contrasena", "apellido", "genero", "movil", "direccion", "idCiudad", "identificacion"};
        String[] queryParamValues = new String[]{nombre, telefono, idbarrios, idrol, idestado, usuario, contrasena, apellido, genero, movil, direccion, idCiudad, identificacion};
        ;
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }
    
}
