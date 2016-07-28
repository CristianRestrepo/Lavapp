/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.webservices.implementaciones;

import com.planit.lavappweb.modelos.Barrio_TO;
import com.planit.lavappweb.modelos.Estado_TO;
import com.planit.lavappweb.modelos.Horario_TO;
import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.modelos.Proveedor_TO;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosCliente;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUltimoPedidoCliente;
import com.planit.lavappweb.webservices.clientes.ClienteEditarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPedidoCompleto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class ServiciosPedido {

    public Pedido_TO modificaPedido(int idPedido, int idUsuario, String fechaInicio,
            int horarioInicio, int horarioFinal, int idEstado, int idProveedor, String fechaEntrega, String direccionRecogida, String direccionEntrega, String fechaRecogida, String quienEntrega, String quienRecibe, int idBarrioRecogida, int idBarrioEntrega) {
        ClienteEditarPedido clienteModelo = new ClienteEditarPedido();
        return clienteModelo.modificarPedido(Pedido_TO.class, "" + idUsuario, "" + idUsuario, "" + fechaInicio, "" + horarioInicio, "" + horarioFinal, "" + idEstado, "" + idProveedor, fechaEntrega, direccionEntrega, direccionRecogida, fechaRecogida, quienEntrega, quienRecibe, "" + idBarrioRecogida, "" + idBarrioEntrega);
    }

    public Pedido_TO eliminarPedido(int idPedido) {
        ClienteEliminarPedido clienteModelo = new ClienteEliminarPedido();
        return clienteModelo.eliminarPedido(Pedido_TO.class, "" + idPedido);
    }

    public Pedido_TO registrarPedido(String fechaIn, int idHoraIn, int idHoraFin, int idEstado) {
        ClienteRegistrarPedido clienteModelo = new ClienteRegistrarPedido();
        return clienteModelo.registrarPedido(Pedido_TO.class, fechaIn, "" + idHoraIn, "" + idHoraFin, "" + idEstado);
    }

    public Pedido_TO consultarPedido(int idPedido) {
        ClienteConsultarPedido cliente = new ClienteConsultarPedido();
        return cliente.consultarPedido(Pedido_TO.class, "" + idPedido);
    }
    
    public Pedido_TO consultarUltimoPedidoCliente(int idUsuario) {
        ClienteConsultarUltimoPedidoCliente cliente = new ClienteConsultarUltimoPedidoCliente();
        return cliente.consultarUltimoPedido(Pedido_TO.class, "" + idUsuario);
    }

    public Pedido_TO registrarPedidoCompleto(int idUsuario, String fechaInicio, int horarioInicio, int horarioFinal, int idEstado, String fechaEntrega, String direccionRecogida, String direccionEntrega, String fechaRecogida, String quienEntrega, String quienRecibe, int idBarrioRecogida, int idBarrioEntrega) {
        ClienteRegistrarPedidoCompleto cliente = new ClienteRegistrarPedidoCompleto();
        return cliente.registrarPedidoWeb(Pedido_TO.class, "" + idUsuario, "" + fechaInicio, "" + horarioInicio, "" + horarioFinal, "" + idEstado, fechaEntrega, direccionEntrega, direccionRecogida, fechaRecogida, quienEntrega, quienRecibe, "" + idBarrioRecogida, "" + idBarrioEntrega);
    }

    public List<Pedido_TO> consultarPedidos() throws ParseException {

        ClienteConsultarPedidos cliente = new ClienteConsultarPedidos();
        List<LinkedHashMap> datos = cliente.consultarPedidos(List.class);
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();

//      SERVICIOS DE CADA MODELO
        ServiciosUsuario su = new ServiciosUsuario();
        ServiciosHorario sh = new ServiciosHorario();
        ServiciosEstado se = new ServiciosEstado();
        ServiciosProveedor sp = new ServiciosProveedor();
        ServiciosBarrios sb = new ServiciosBarrios();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = su.consultarUsuario((int) mapUS.get("idUsuario"));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = sh.consultarHorario((int) mapHI.get("horaInicio"), "");
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = sh.consultarHorario((int) mapHF.get("horaFinal"), "");
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = se.consultarEstadoID((int) mapES.get("idEstado"), "");
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = sp.consultarProveedor((int) mapPR.get("idProveedor"));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = sb.consultarBarrio((int) mapBR.get("idBarrios"), "");

            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = sb.consultarBarrio((int) mapBR.get("idBarrios"), "");
//          BARRIO ENTREGA
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechainicio")),
                        horarioInicio,
                        horarioFinal,
                        estado,
                        proveedor,
                        formato.parse((String) datos.get(i).get("fechaEntrega")),
                        (String) datos.get(i).get("direccionRecogida"),
                        (String) datos.get(i).get("direccionEntrega"),
                        formato.parse((String) datos.get(i).get("fechaRecogida")),
                        (String) datos.get(i).get("quienEntrega"),
                        (String) datos.get(i).get("quienRecibe"),
                        barrioRecogida,
                        barrioEntrega));
            } catch (ParseException e) {
                throw e;
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosCliente(int idUsuario) throws ParseException {

        ClienteConsultarPedidosCliente cliente = new ClienteConsultarPedidosCliente();

        List<LinkedHashMap> datos = cliente.consultarPedidosCliente(List.class, "" + idUsuario);
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();

//      SERVICIOS DE CADA MODELO
        ServiciosUsuario su = new ServiciosUsuario();
        ServiciosHorario sh = new ServiciosHorario();
        ServiciosEstado se = new ServiciosEstado();
        ServiciosProveedor sp = new ServiciosProveedor();
        ServiciosBarrios sb = new ServiciosBarrios();

        for (int i = 0; i < datos.size(); i++) {
//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = su.consultarUsuario((int) mapUS.get("idUsuario"));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = sh.consultarHorario((int) mapHI.get("horaInicio"), "");
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = sh.consultarHorario((int) mapHF.get("horaFinal"), "");
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = se.consultarEstadoID((int) mapES.get("idEstado"), "");
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = sp.consultarProveedor((int) mapPR.get("idProveedor"));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = sb.consultarBarrio((int) mapBR.get("idBarrios"), "");

            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = sb.consultarBarrio((int) mapBR.get("idBarrios"), "");
//          BARRIO ENTREGA
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechainicio")),
                        horarioInicio,
                        horarioFinal,
                        estado,
                        proveedor,
                        formato.parse((String) datos.get(i).get("fechaEntrega")),
                        (String) datos.get(i).get("direccionRecogida"),
                        (String) datos.get(i).get("direccionEntrega"),
                        formato.parse((String) datos.get(i).get("fechaRecogida")),
                        (String) datos.get(i).get("quienEntrega"),
                        (String) datos.get(i).get("quienRecibe"),
                        barrioRecogida,
                        barrioEntrega));
            } catch (ParseException e) {
                throw e;
            }
        }
        return pedidos;
    }

}
