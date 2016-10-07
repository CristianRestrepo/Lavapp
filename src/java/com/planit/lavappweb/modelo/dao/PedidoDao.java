/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelo.dto.Barrio_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Horario_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.Proveedor_TO;
import com.planit.lavappweb.modelo.dto.Usuario_TO;
import com.planit.lavappweb.webservices.clientes.ClienteAsignarAsesorPedido;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidoWeb;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidos;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosCliente;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosDiaEntrega;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosDiaRecogida;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosEnPlantaSegunCliente;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosPorRecibirSegunCliente;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPedidosSegunPlanta;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarUltimoPedidoCliente;
import com.planit.lavappweb.webservices.clientes.ClienteEditarEstadoPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEditarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPedido;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPedidoCompleto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoDao {
    
    public Pedido_TO asignarAsesorPedido(Pedido_TO pedido, Usuario_TO asesor){
        ClienteAsignarAsesorPedido cliente = new ClienteAsignarAsesorPedido();
        return cliente.asignarAsesorPedido(Pedido_TO.class, "" + asesor.getIdUsuario() , "" + pedido.getIdPedido());
    }

    public Pedido_TO editarEstadoPedido(Pedido_TO pedido) {
        ClienteEditarEstadoPedido cliente = new ClienteEditarEstadoPedido();
        return cliente.editarEstadoPedido(Pedido_TO.class, "" + pedido.getIdPedido(), "" + pedido.getEstado().getIdEstado());
    }

    public Pedido_TO modificaPedido(Pedido_TO pedido) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ClienteEditarPedido clienteModelo = new ClienteEditarPedido();
        return clienteModelo.modificarPedido(Pedido_TO.class,
                "" + pedido.getIdPedido(),
                "" + pedido.getUsuario().getIdUsuario(),
                "" + formato.format(pedido.getFechaInicio()),
                "" + pedido.getHoraInicio(),
                "" + pedido.getHoraFinal(),
                "" + pedido.getEstado().getIdEstado(),
                "" + pedido.getProveedor().getIdProveedor(),
                "" + formato.format(pedido.getFechaEntrega()),
                pedido.getDireccionRecogida(),
                pedido.getDireccionEntrega(),
                "" + formato.format(pedido.getFechaRecogida()),
                pedido.getQuienEntrega(),
                pedido.getQuienRecibe(),
                "" + pedido.getBarrioRecogida().getIdBarrios(),
                "" + pedido.getBarrioEntrega().getIdBarrios());
    }

    public Pedido_TO eliminarPedido(Pedido_TO pedido) {
        ClienteEliminarPedido clienteModelo = new ClienteEliminarPedido();
        return clienteModelo.eliminarPedido(Pedido_TO.class, "" + pedido.getIdPedido());
    }

    public Pedido_TO consultarPedido(Pedido_TO pedido) {
        ClienteConsultarPedido cliente = new ClienteConsultarPedido();
        return cliente.consultarPedido(Pedido_TO.class, "" + pedido.getIdPedido());
    }

    public Pedido_TO consultarPedidoWeb(Pedido_TO pedido) {
        ClienteConsultarPedidoWeb cliente = new ClienteConsultarPedidoWeb();
        return cliente.consultarPedidoWeb(Pedido_TO.class, "" + pedido.getIdPedido());
    }

    public Pedido_TO consultarUltimoPedidoCliente(Usuario_TO usuario) {
        ClienteConsultarUltimoPedidoCliente cliente = new ClienteConsultarUltimoPedidoCliente();
        return cliente.consultarUltimoPedido(Pedido_TO.class, "" + usuario.getIdUsuario());
    }

    public Pedido_TO registrarPedidoCompleto(Pedido_TO pedido) {
        HorarioDao hd = new HorarioDao();
        BarriosDao bd = new BarriosDao();
        EstadoDao ed = new EstadoDao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        pedido.setEstado(ed.consultarEstadoID(new Estado_TO(3)));
        pedido.setBarrioEntrega(bd.consultarBarrio(pedido.getBarrioEntrega()));
        pedido.setBarrioRecogida(bd.consultarBarrio(pedido.getBarrioRecogida()));

        pedido.setHoraInicio(hd.consultarHorario(pedido.getHoraInicio()));
        pedido.setHoraFinal(hd.consultarHorario(pedido.getHoraFinal()));

        pedido.setUsuario((Usuario_TO) Sesion.obtenerSesion());
        ClienteRegistrarPedidoCompleto cliente = new ClienteRegistrarPedidoCompleto();
        return cliente.registrarPedidoCompleto(Pedido_TO.class,
                "" + pedido.getUsuario().getIdUsuario(),
                "" + pedido.getHoraInicio().getIdHorario(),
                "" + pedido.getHoraFinal().getIdHorario(),
                "" + pedido.getEstado().getIdEstado(),
                formato.format(pedido.getFechaEntrega()),
                pedido.getDireccionEntrega(),
                pedido.getDireccionRecogida(),
                formato.format(pedido.getFechaRecogida()),
                pedido.getQuienEntrega(),
                pedido.getQuienRecibe(),
                "" + pedido.getBarrioRecogida().getIdBarrios(),
                "" + pedido.getBarrioEntrega().getIdBarrios());
    }

    public List<Pedido_TO> consultarPedidos() {

        ClienteConsultarPedidos cliente = new ClienteConsultarPedidos();
        List<LinkedHashMap> datos = cliente.consultarPedidos(List.class);
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Usuario_TO asesor = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));

//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> BuscarPedidos(String valor, Usuario_TO us) {

        ClienteBuscarPedido cliente = new ClienteBuscarPedido();
        List<LinkedHashMap> datos = cliente.buscarPedido(List.class, valor, "" + us.getIdUsuario());
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));

//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosCliente(Usuario_TO user) throws ParseException {

        ClienteConsultarPedidosCliente cliente = new ClienteConsultarPedidosCliente();

        List<LinkedHashMap> datos = cliente.consultarPedidosCliente(List.class, "" + user.getIdUsuario());
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGRESO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicioString")),
                        horarioInicio,
                        horarioFinal,
                        estado,
                        proveedor,
                        formato.parse((String) datos.get(i).get("fechaEntregaString")),
                        (String) datos.get(i).get("direccionRecogida"),
                        (String) datos.get(i).get("direccionEntrega"),
                        formato.parse((String) datos.get(i).get("fechaRecogidaString")),
                        (String) datos.get(i).get("quienEntrega"),
                        (String) datos.get(i).get("quienRecibe"),
                        barrioRecogida,
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                throw e;
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosSegunPlanta(Proveedor_TO prov) throws ParseException {

        ClienteConsultarPedidosSegunPlanta cliente = new ClienteConsultarPedidosSegunPlanta();
        List<LinkedHashMap> datos = cliente.consultarPedidosSegunPlanta(List.class, "" + prov.getIdProveedor());
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGRESO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                throw e;
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosDiaEntrega() {
        ClienteConsultarPedidosDiaEntrega cliente = new ClienteConsultarPedidosDiaEntrega();
        List<LinkedHashMap> datos = cliente.consultarPedidosDiaEntrega(List.class);
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosDiaRecogida() {
        ClienteConsultarPedidosDiaRecogida cliente = new ClienteConsultarPedidosDiaRecogida();
        List<LinkedHashMap> datos = cliente.consultarPedidosDiaRecogida(List.class);
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();
//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosEnPlantaSegunCliente(Usuario_TO u) {
        ClienteConsultarPedidosEnPlantaSegunCliente cliente = new ClienteConsultarPedidosEnPlantaSegunCliente();
        List<LinkedHashMap> datos = cliente.consultarPedidosEnPlantaSegunCliente(List.class, "" + u.getIdUsuario());
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }

    public List<Pedido_TO> consultarPedidosPorRecibirSegunCliente(Usuario_TO u) {
        ClienteConsultarPedidosPorRecibirSegunCliente cliente = new ClienteConsultarPedidosPorRecibirSegunCliente();
        List<LinkedHashMap> datos = cliente.consultarPedidosPorRecibirSegunCliente(List.class, "" + u.getIdUsuario());
        List<Pedido_TO> pedidos = new ArrayList<>();

//      MODELOS PARA PASO ED PARAMETROS EN CICLO FOR
        Usuario_TO usuario = new Usuario_TO();
        Horario_TO horarioInicio = new Horario_TO();
        Horario_TO horarioFinal = new Horario_TO();
        Estado_TO estado = new Estado_TO();
        Proveedor_TO proveedor = new Proveedor_TO();
        Barrio_TO barrioRecogida = new Barrio_TO();
        Barrio_TO barrioEntrega = new Barrio_TO();
        Usuario_TO asesor = new Usuario_TO();

//      SERVICIOS DE CADA MODELO
        UsuarioDao ud = new UsuarioDao();
        HorarioDao hd = new HorarioDao();
        EstadoDao ed = new EstadoDao();
        ProveedorDao pd = new ProveedorDao();
        BarriosDao bd = new BarriosDao();

        for (int i = 0; i < datos.size(); i++) {

//          USUARIO
            LinkedHashMap mapUS = (LinkedHashMap) datos.get(i).get("usuario");
            usuario = ud.consultarUsuario(new Usuario_TO((int) mapUS.get("idUsuario")));
//          HORARIO INICIO
            LinkedHashMap mapHI = (LinkedHashMap) datos.get(i).get("horaInicio");
            horarioInicio = hd.consultarHorario(new Horario_TO((int) mapHI.get("idHorario"), (String) mapHI.get("horario")));
//          HORARIO FINAL
            LinkedHashMap mapHF = (LinkedHashMap) datos.get(i).get("horaFinal");
            horarioFinal = hd.consultarHorario(new Horario_TO((int) mapHF.get("idHorario"), (String) mapHF.get("horario")));
//          ESTADO
            LinkedHashMap mapES = (LinkedHashMap) datos.get(i).get("estado");
            estado = ed.consultarEstadoID(new Estado_TO((int) mapES.get("idEstado"), ""));
//          PROVEEDOR
            LinkedHashMap mapPR = (LinkedHashMap) datos.get(i).get("proveedor");
            proveedor = pd.consultarProveedor(new Proveedor_TO((int) mapPR.get("idProveedor")));
//          BARRIO RECOGIDA
            LinkedHashMap mapBR = (LinkedHashMap) datos.get(i).get("barrioRecogida");
            barrioRecogida = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          BARRIO ENTREGA
            mapBR = (LinkedHashMap) datos.get(i).get("barrioEntrega");
            barrioEntrega = bd.consultarBarrio(new Barrio_TO((int) mapBR.get("idBarrios"), ""));
//          ASESOR
            LinkedHashMap mapAS = (LinkedHashMap) datos.get(i).get("asesor");
            asesor = ud.consultarUsuario(new Usuario_TO((int) mapAS.get("idUsuario")));
//          INGERSO DE DATOS A LISTA DE OBJETO PEDIDO
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pedidos.add(new Pedido_TO((int) datos.get(i).get("idPedido"),
                        usuario,
                        formato.parse((String) datos.get(i).get("fechaInicio")),
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
                        barrioEntrega,
                        asesor));
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        return pedidos;
    }
}
