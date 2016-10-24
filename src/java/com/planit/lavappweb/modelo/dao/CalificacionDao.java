/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Calificacion_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
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
 * @author Desarrollo_Planit
 */
public class CalificacionDao {

    public Calificacion_TO registrarCalificacion(Calificacion_TO calificacion) {
        //Instancia para el cliente del web service registrar calificacion
        ClienteRegistrarCalificacion clieModelo = new ClienteRegistrarCalificacion();
        //Retornamos el resultado del metodo registrar calificacion
        return clieModelo.registrarCalificacion(Calificacion_TO.class,
                "" + calificacion.getCalificacion(),
                calificacion.getObservacion(),
                "" + calificacion.getPedido().getIdPedido());
    }

    public Calificacion_TO modificarCalificacion(Calificacion_TO calificacion) {
        //Instancia para el cliente del web service modificar calificacion
        ClienteModificarCalificaion clienModelo = new ClienteModificarCalificaion();
        //Retornamos el resultado del metodo modificar calificacion
        return clienModelo.modificarCalificacion(Calificacion_TO.class,
                "" + calificacion.getIdCalificacion(),
                "" + calificacion.getCalificacion(),
                calificacion.getObservacion(), 
                "" + calificacion.getPedido().getIdPedido()
        );
    }

    public Calificacion_TO eliminarCalificacion(Calificacion_TO calificacion) {
        //Instancia para el cliente del web service eliminar calificacion
        ClienteEliminarCalificacion clieModelo = new ClienteEliminarCalificacion();
        //Retornamos el resultado del metodo eliminar calificacion
        return clieModelo.eliminarCalificacion(Calificacion_TO.class, 
                "" + calificacion.getIdCalificacion());
    }

    public Calificacion_TO consultarCalificacionPorPedido(Pedido_TO pedido) {
        //Instancia del cliente del web service consultar calificacion de un pedido
        ClienteConsultarCalificacionPorPedido cliente = new ClienteConsultarCalificacionPorPedido();
        //Retornamos el resultado del metodo consultar calificacion
        return cliente.consultarCalificacionPorPedido(Calificacion_TO.class, 
                "" + pedido.getIdPedido());
    }

    public List<Calificacion_TO> consultarCalificaciones() {
        //intancia del cliente del web service consultar calificaciones
        ClienteConsultarCalificaciones clienteModelo = new ClienteConsultarCalificaciones();
        //instancias de listas de tipo calificacion y haspmap 
        List<LinkedHashMap> datos = clienteModelo.consultarCalificaciones(List.class);
        List<Calificacion_TO> calificaciones = new ArrayList<>();
        //Instancia de los dao necesarios para rearmar un objeto calificacion
        PedidoDao pd = new PedidoDao();
        Pedido_TO pedidoModelo = new Pedido_TO();

        //INSERCION DE DATOS EN LISTA DE CALIFICACIONES
        try {
            for (int i = 0; i < datos.size(); i++) {
                LinkedHashMap map = (LinkedHashMap) datos.get(i).get("pedido");
                pedidoModelo = pd.consultarPedidoWeb(new Pedido_TO((int) map.get("idPedido")));

                try {
                    calificaciones.add(new Calificacion_TO((int) datos.get(i).get("idCalificacion"),
                            (int) datos.get(i).get("calificacion"),
                            (String) datos.get(i).get("observacion"),
                            pedidoModelo));

                } catch (Exception e) {
                    System.out.println("Error en insercion de lista Calificaciones: " + e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error en el cico FOR : " + ex.getMessage());
            throw ex;
        }
        return calificaciones;
    }
}
