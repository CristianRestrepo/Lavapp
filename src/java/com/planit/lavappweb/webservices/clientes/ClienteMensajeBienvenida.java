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
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 * Jersey REST client generated for REST resource:EnviarMensajeBienvenidaImpl
 * [/enviarMensajeBienvenida]<br>
 * USAGE:
 * <pre>
 *        ClienteMensajeBienvenida client = new ClienteMensajeBienvenida();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author VaioDevelopment
 */
public class ClienteMensajeBienvenida {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = ruta.consultarRuta();

    public ClienteMensajeBienvenida() {
        client = ResteasyClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("enviarMensajeBienvenida");
    }

    public <T> T enviarMensajeBienvenido(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (email != null) {
            resource = resource.queryParam("email", email);
        }
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
