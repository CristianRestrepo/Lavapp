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
 * Jersey REST client generated for REST resource:we
 * [registrarPedidoCompleto]<br>
 * USAGE:
 * <pre>
 *        ClienteRegistraPedidoCompleto client = new ClienteRegistraPedidoCompleto();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author VaioDevelopment
 */
public class ClienteRegistrarPedidoCompleto {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = ruta.consultarRuta();

    public ClienteRegistrarPedidoCompleto() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("registrarPedidoCompleto");
    }

    /**
     * @param responseType Class representing the response
     * @param idUsuario query parameter
     * @param idHoraInicio query parameter
     * @param idHoraFinal query parameter
     * @param idEstado query parameter
     * @param fechaEntrega query parameter
     * @param direccionEntrega query parameter
     * @param direccionRecogida query parameter
     * @param fechaRecogida query parameter
     * @param quienEntrega query parameter
     * @param quienRecibe query parameter
     * @param idBarrioRecogida query parameter
     * @param idBarrioEntrega query parameter
     * @param idFormaPago query parameter
     * @param idEstadoPago query parameter
     * @param costo query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T registrarPedidoCompleto(Class<T> responseType, String idUsuario, String idHoraInicio, String idHoraFinal, String idEstado, String fechaEntrega, String direccionEntrega, String direccionRecogida, String fechaRecogida, String quienEntrega, String quienRecibe, String idBarrioRecogida, String idBarrioEntrega, String idFormaPago, String idEstadoPago, String costo) throws ClientErrorException {
        String[] queryParamNames = new String[]{"idUsuario", "idHoraInicio", "idHoraFinal", "idEstado", "fechaEntrega", "direccionEntrega", "direccionRecogida", "fechaRecogida", "quienEntrega", "quienRecibe", "idBarrioRecogida", "idBarrioEntrega", "idFormaPago", "idEstadoPago", "costo"};
        String[] queryParamValues = new String[]{idUsuario, idHoraInicio, idHoraFinal, idEstado, fechaEntrega, direccionEntrega, direccionRecogida, fechaRecogida, quienEntrega, quienRecibe, idBarrioRecogida, idBarrioEntrega, idFormaPago, idEstadoPago, costo};
        ;
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        return webTarget.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
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
