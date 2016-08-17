/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Calificacion_TO;
import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCalificacionPorPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarCalificaciones;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarCalificacion;
import com.planit.lavappweb.webservices.clientes.ClienteModificarCalificaion;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarCalificacion;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosCalificacion {

    public Calificacion_TO registrarCalificacion(int idcalificacion, String observacion, int idPedido) {

        ClienteRegistrarCalificacion clieModelo = new ClienteRegistrarCalificacion();
        return clieModelo.registrarCalificacion(Calificacion_TO.class, "" + idcalificacion, observacion, "" + idPedido);
    }

    public Calificacion_TO modificarCalificacion(int idCalificacion, int calificacion, String observacion, int idPedido) {

        ClienteModificarCalificaion clienModelo = new ClienteModificarCalificaion();
        return clienModelo.modificarCalificacion(Calificacion_TO.class, "" + idCalificacion, "" + calificacion, observacion, "" + idPedido);
    }

    public Calificacion_TO eliminarCalificacion(int idCalificacion) {

        ClienteEliminarCalificacion clieModelo = new ClienteEliminarCalificacion();
        return clieModelo.eliminarCalificacion(Calificacion_TO.class, "" + idCalificacion);
    }

    public Calificacion_TO consultarCalificacionPorPedido(int idPedido) {

        ClienteConsultarCalificacionPorPedido cliente = new ClienteConsultarCalificacionPorPedido();
        return cliente.consultarCalificacionPorPedido(Calificacion_TO.class, "" + idPedido);
    }

    public List<Calificacion_TO> consultarCalificaciones() {

        ClienteConsultarCalificaciones clienteModelo = new ClienteConsultarCalificaciones();
        List<LinkedHashMap> datos = clienteModelo.consultarCalificaciones(List.class);
        List<Calificacion_TO> calificaciones = new ArrayList<>();
        ServiciosPedido servicioPedido = new ServiciosPedido();
        Pedido_TO pedidoModelo = new Pedido_TO();

        //INSERCION DE DATOS EN LISTA DE CALIFICACIONES
        try {
            for (int i = 0; i < datos.size(); i++) {
                LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pedido");
                pedidoModelo = servicioPedido.consultarPedido((int) map.get("idPedido"));

                try {
                    calificaciones.add(new Calificacion_TO((int) datos.get(i).get("idCalificacion"),
                            (int) datos.get(i).get("calificacion"),
                            (String) datos.get(i).get("observacion"),
                            pedidoModelo));

                } catch (Exception e) {
                    System.out.println("Error en incesrcion de lista Calificaciones: " + e.getMessage());
                }
            }

        } catch (Exception ex) {
            System.out.println("Error en el cico FOR : " + ex.getMessage());
            throw ex;
        }

        return calificaciones;
    }

}
