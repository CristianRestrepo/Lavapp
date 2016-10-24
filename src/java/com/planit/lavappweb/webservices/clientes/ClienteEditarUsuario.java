/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.clientes;

import com.planit.lavappweb.metodos.ruta;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 * Jersey REST client generated for REST resource:we [editarUsuario]<br>
 * USAGE:
 * <pre>
 *        ClienteEditarUsuario client = new ClienteEditarUsuario();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Desarrollo_Planit
 */
public class ClienteEditarUsuario {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = ruta.consultarRuta();

    public ClienteEditarUsuario() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("editarUsuario");
    }

    /**
     * @param responseType Class representing the response
     * @param idUsuario query parameter
     * @param nombre query parameter
     * @param apellido query parameter
     * @param genero query parameter
     * @param telefono query parameter
     * @param idbarrios query parameter
     * @param movil query parameter
     * @param direccion query parameter
     * @param idciudad query parameter
     * @param identificacion query parameter
     * @param rutaImagen query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T editarUsuario(Class<T> responseType, String idUsuario, String nombre, String apellido, String genero, String telefono, String idbarrios, String movil, String direccion, String idciudad, String identificacion, String rutaImagen) throws ClientErrorException {
        String[] queryParamNames = new String[]{"idUsuario", "nombre", "apellido", "genero", "telefono", "idbarrios", "movil", "direccion", "idciudad", "identificacion", "rutaImagen"};
        String[] queryParamValues = new String[]{idUsuario, nombre, apellido, genero, telefono, idbarrios, movil, direccion, idciudad, identificacion, rutaImagen};
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
