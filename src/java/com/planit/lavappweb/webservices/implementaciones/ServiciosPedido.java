/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Estado_TO;
import com.planit.lavappweb.modelos.Horario_TO;
import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.modelos.Proveedor_TO;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidos;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteModificarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPedido;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosPedido {

    public Pedido_TO modificaPedido(int idPedido, int idUsuario, String fechaInicio,
            int horaInicionId, int horaFinalId, int idEstado, int idProveedor) {

        ClienteModificarPedido clienteModelo = new ClienteModificarPedido();
        return clienteModelo.modificarPedido(Pedido_TO.class, "" + idPedido, "" + idUsuario, fechaInicio,
                "" + horaInicionId, "" + horaFinalId, "" + idEstado, "" + idProveedor);

    }

    public Pedido_TO eliminarPedido(int idPedido) {

        ClienteEliminarPedido clienteModelo = new ClienteEliminarPedido();
        return clienteModelo.eliminarPedido(Pedido_TO.class, "" + idPedido);

    }
    
    public Pedido_TO registrarPedido(String fechaIn, int idHoraIn, int idHoraFin, int idEstado){
        
        ClienteRegistrarPedido clienteModelo = new ClienteRegistrarPedido();
        
        return clienteModelo.registrarPedido(Pedido_TO.class, fechaIn, "" + idHoraIn, "" + idHoraFin, "" + idEstado);
    }
    
    public List<Pedido_TO> consultarPedidos(){
        ClienteConsultarPedidos cliente = new ClienteConsultarPedidos();
        List<LinkedHashMap> datos = cliente.consultarPedidos(List.class);
        List<Pedido_TO> pedidos = new ArrayList<>();
        
//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuarioModelo = new Usuario_TO();
        Horario_TO horarioIniModel = new Horario_TO();
        Horario_TO horarioFinModel = new Horario_TO();
        Estado_TO estadoModelo = new Estado_TO();
        Proveedor_TO proveeModelo = new Proveedor_TO();
        
//      SERVICIOS DE CADA MODELO
        ServiciosUsuario serviUsuario = new ServiciosUsuario();
        ServiciosHorario serviHorarioIn = new ServiciosHorario();
        ServiciosHorario serviHorarioFn = new ServiciosHorario();
        ServiciosEstado serviEstado = new ServiciosEstado();
        
        
        
        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap map = (LinkedHashMap) datos.get(i).get(i)
            
            
        }
        
    }

}
