/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.clientes;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 * Jersey REST client generated for REST
 * resource:ConsultarCalificacionesSegunPlantaPedidosImpl
 * [/consultarCalificacionesSegunPlanta]<br>
 * USAGE:
 * <pre>
 *        ClienteConsultarCalificacionesSegunPlanta client = new ClienteConsultarCalificacionesSegunPlanta();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author VaioDevelopment
 */
public class ClienteConsultarCalificacionesSegunPlanta {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084/LavappService/webresources";

    public ClienteConsultarCalificacionesSegunPlanta() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("consultarCalificacionesSegunPlanta");
    }

    public <T> T consultarCalificacioneSegunPlantaPedidos(Class<T> responseType, String idProveedor) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (idProveedor != null) {
            resource = resource.queryParam("idProveedor", idProveedor);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
