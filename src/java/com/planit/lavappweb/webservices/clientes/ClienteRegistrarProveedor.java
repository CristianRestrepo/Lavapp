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
 * Jersey REST client generated for REST resource:we [registrarProveedor]<br>
 * USAGE:
 * <pre>
 *        ClienteRegistrarProveedor client = new ClienteRegistrarProveedor();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Desarrollo_Planit
 */
public class ClienteRegistrarProveedor {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = ruta.consultarRuta();

    public ClienteRegistrarProveedor() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("registrarProveedor");
    }

    /**
     * @param responseType Class representing the response
     * @param razonSocial query parameter
     * @param nit query parameter
     * @param telefono query parameter
     * @param direccion query parameter
     * @param idUsuario query parameter
     * @param cupo query parameter
     * @param idZona query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T registrarProveedor(Class<T> responseType, String razonSocial, String nit, String telefono, String direccion, String idUsuario, String cupo, String idZona) throws ClientErrorException {
        String[] queryParamNames = new String[]{"razonSocial", "nit", "telefono", "direccion", "idUsuario", "cupo", "idZona"};
        String[] queryParamValues = new String[]{razonSocial, nit, telefono, direccion, idUsuario, cupo, idZona};
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
