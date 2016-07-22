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
 * Jersey REST client generated for REST resource:we
 * [modificarPedidoCompleto]<br>
 * USAGE:
 * <pre>
 *        ClienteEditarPedido client = new ClienteEditarPedido();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Desarrollo_Planit
 */
public class ClienteEditarPedido {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084/LavappService/webresources/";

    public ClienteEditarPedido() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("modificarPedidoCompleto");
    }

    /**
     * @param responseType Class representing the response
     * @param idPedido query parameter
     * @param idUsuario query parameter
     * @param fechaInicio query parameter
     * @param horainiIdhorario query parameter
     * @param horafinIdHorario query parameter
     * @param idEstado query parameter
     * @param idProveedor query parameter
     * @param fechaEntrega query parameter
     * @param direccionRecogida query parameter
     * @param direccionEntrega query parameter
     * @param fechaRecogida query parameter
     * @param quienEntrega query parameter
     * @param quienRecibe query parameter
     * @param idBarrios_recogida query parameter
     * @param idBarrios_entrega query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T modificarPedido(Class<T> responseType, String idPedido, String idUsuario, String fechaInicio, String horainiIdhorario, String horafinIdHorario, String idEstado, String idProveedor, String fechaEntrega, String direccionRecogida, String direccionEntrega, String fechaRecogida, String quienEntrega, String quienRecibe, String idBarrios_recogida, String idBarrios_entrega) throws ClientErrorException {
        String[] queryParamNames = new String[]{"idPedido", "idUsuario", "fechaInicio", "horainiIdhorario", "horafinIdHorario", "idEstado", "idProveedor", "fechaEntrega", "direccionRecogida", "direccionEntrega", "fechaRecogida", "quienEntrega", "quienRecibe", "idBarrios_recogida", "idBarrios_entrega"};
        String[] queryParamValues = new String[]{idPedido, idUsuario, fechaInicio, horainiIdhorario, horafinIdHorario, idEstado, idProveedor, fechaEntrega, direccionRecogida, direccionEntrega, fechaRecogida, quienEntrega, quienRecibe, idBarrios_recogida, idBarrios_entrega};
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
