/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;

/**
 *
 * @author Desarrollo_Planit
 */
public class ServerRequests {

    private String ruta;

    public ServerRequests(String ruta) {
        this.ruta = ruta;
    }

    public ServerRequests() {
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "ServerRequests{"
                + "rServeuta='" + ruta + '\''
                + '}';
    }

    public String BuscarRuta() {

      //ruta = "http://192.168.0.128:8084/SMS_rentas_servicio/resources";
        //ruta = "http://192.168.0.133:8084/SMS_rentas_servicio/resources";
        ruta = "http://10.0.2.2:8084/LavappService/webresources";
      //ruta = "http://192.168.0.130:8084/SMS_rentas_servicio/resources";
        //  ruta = "http://www.app.smsrenta.com:8080/SMS_rentas_servicio/resources";
        return ruta;
    }
}
