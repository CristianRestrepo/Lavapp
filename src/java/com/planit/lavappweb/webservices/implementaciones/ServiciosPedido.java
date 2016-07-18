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
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosCliente;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteModificarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public Pedido_TO registrarPedido(String fechaIn, int idHoraIn, int idHoraFin, int idEstado) {

        ClienteRegistrarPedido clienteModelo = new ClienteRegistrarPedido();

        return clienteModelo.registrarPedido(Pedido_TO.class, fechaIn, "" + idHoraIn, "" + idHoraFin, "" + idEstado);
    }

    public List<Pedido_TO> consultarPedidos() {

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
        ServiciosProveedor serviProve = new ServiciosProveedor();

        for (int i = 0; i < datos.size(); i++) {
            try {
//          USUARIO
                LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
                usuarioModelo = serviUsuario.consultarUsuario((int) mapUS.get("idUsuario"));
//          HORARIO INICIO
                LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
                horarioIniModel = serviHorarioIn.consultarHorario((int) mapHI.get("horaInicio"), "");
//          HORARIO FINAL
                LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
                horarioFinModel = serviHorarioFn.consultarHorario((int) mapHF.get("horaFinal"), "");
//          ESTADO
                LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
                estadoModelo = serviEstado.consultarEstadoID((int) mapES.get("idEstado"), "");
//          PROVEEDOR
                LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
                proveeModelo = serviProve.consultarProveedor((int) mapPR.get("idProveedor"));
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
                try {
                    pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                            usuarioModelo,
                            //                          DUDA DE FUNSION CORRECTA POR SER TIPO DATE
                            (Date) datos.get(i).get("fechainicio"),
                            horarioIniModel,
                            horarioFinModel,
                            estadoModelo,
                            proveeModelo));

                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception ex) {
                throw ex;
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosCliente(int idUsuario) {

        ClienteConsultarPedidosCliente cliente = new ClienteConsultarPedidosCliente();

        List<LinkedHashMap> datos = cliente.consultarPedidosCliente(List.class, "" + idUsuario);
        List<Pedido_TO> pedidosC = new ArrayList<>();

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
        ServiciosProveedor serviProve = new ServiciosProveedor();

        for (int i = 0; i < datos.size(); i++) {
            try {
//          USUARIO
                LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
                usuarioModelo = serviUsuario.consultarUsuario((int) mapUS.get("idUsuario"));
//          HORARIO INICIO
                LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
                horarioIniModel = serviHorarioIn.consultarHorario((int) mapHI.get("idHorario"), "");
//          HORARIO FINAL
                LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
                horarioFinModel = serviHorarioFn.consultarHorario((int) mapHF.get("idHorario"), "");
//          ESTADO
                LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
                estadoModelo = serviEstado.consultarEstadoID((int) mapES.get("idEstado"), "");
//          PROVEEDOR
                LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
                proveeModelo = serviProve.consultarProveedor((int) mapPR.get("idProveedor"));
//          CAMBIO DE STRING A DATE

//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
                try {
                    pedidosC.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                            usuarioModelo,
//                          DUDA DE FUNSION CORRECTA POR SER TIPO DATE
                            deStringToDate((String) datos.get(i).get("fechainicio")),
                            horarioIniModel,
                            horarioFinModel,
                            estadoModelo,
                            proveeModelo));

                } catch (Exception e) {
//                    System.out.println("impresion de error en consola: " + (String) datos.get(i).get("fechainicio"));
                    throw e;
                }

            } catch (Exception ex) {
                throw ex;
            }

        }

        return pedidosC;
    }

    public static Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
