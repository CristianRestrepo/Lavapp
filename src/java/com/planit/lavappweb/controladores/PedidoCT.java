/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Pedido;
import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelos.Pedido_TO;
import com.planit.lavappweb.modelos.SubProductoCosto_TO;
import com.planit.lavappweb.modelos.Usuario_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosBarrios;
import com.planit.lavappweb.webservices.implementaciones.ServiciosDescripcionPedido;
import com.planit.lavappweb.webservices.implementaciones.ServiciosHorario;
import com.planit.lavappweb.webservices.implementaciones.ServiciosPedido;
import com.planit.lavappweb.webservices.implementaciones.ServiciosSubProductos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT {

    private Pedido_TO pedido;
    private List<SubProductoCosto_TO> subproductos;
    private List<List<SubProductoCosto_TO>> subproductosOrdenados;
    private List<SubProductoCosto_TO> subproductosvista;
    private int vista;
    private int cantidadProductos;

    private SubProductoCosto_TO subproducto;

    private boolean botonatras;
    private boolean botonsiguiente;
    private boolean botonconfirmar;

    protected ServiciosPedido servicios;

    public PedidoCT() {

        vista = 0;
        pedido = new Pedido_TO();
        subproductos = new ArrayList<>();
        cantidadProductos = 0;
        botonatras = false;
        botonsiguiente = true;
        botonconfirmar = false;

        subproducto = new SubProductoCosto_TO();
        subproductosOrdenados = new ArrayList<>();
        subproductosvista = new ArrayList<>();
        servicios = new ServiciosPedido();
    }

    @PostConstruct
    public void init() {
        if (Sesion.obtenerSesion() != null) {
            vista = Pedido.vista;
            pedido = Pedido.pedidoUsuario;
            pedido.setUsuario((Usuario_TO) Sesion.obtenerSesion());
            subproductos = Pedido.subproductos;
            cantidadProductos = subproductos.size();
            if (vista != 0) {
                botonatras = true;
                botonsiguiente = false;
                botonconfirmar = false;
            } else {
                botonatras = false;
                botonsiguiente = true;
                botonconfirmar = false;
            }
        }
    }

    //Getter & Setter
    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    public int getVista() {
        return vista;
    }

    public void setVista(int vista) {
        this.vista = vista;
    }

    public boolean isBotonatras() {
        return botonatras;
    }

    public void setBotonatras(boolean botonatras) {
        this.botonatras = botonatras;
    }

    public boolean isBotonsiguiente() {
        return botonsiguiente;
    }

    public void setBotonsiguiente(boolean botonsiguiente) {
        this.botonsiguiente = botonsiguiente;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public List<SubProductoCosto_TO> getSubproductos() {
        return subproductos;
    }

    public void setSubproductos(List<SubProductoCosto_TO> subproductos) {
        this.subproductos = subproductos;
    }

    public List<List<SubProductoCosto_TO>> getSubproductosOrdenados() {
        return subproductosOrdenados;
    }

    public void setSubproductosOrdenados(List<List<SubProductoCosto_TO>> subproductosOrdenados) {
        this.subproductosOrdenados = subproductosOrdenados;
    }

    public List<SubProductoCosto_TO> getSubproductosvista() {
        return subproductosvista;
    }

    public void setSubproductosvista(List<SubProductoCosto_TO> subproductosvista) {
        this.subproductosvista = subproductosvista;
    }

    public SubProductoCosto_TO getSubproducto() {
        return subproducto;
    }

    public void setSubproducto(SubProductoCosto_TO subproducto) {
        this.subproducto = subproducto;
    }

    public boolean isBotonconfirmar() {
        return botonconfirmar;
    }

    public void setBotonconfirmar(boolean botonconfirmar) {
        this.botonconfirmar = botonconfirmar;
    }

    //Metodos para las vistas 
    public void atras() {
        if (vista > 0) {
            vista--;
            botonsiguiente = true;
        }
        if (vista == 1) {
            botonconfirmar = false;
        }
        if (vista == 2) {
            botonsiguiente = false;
            botonconfirmar = true;
        }
        if (vista == 0) {
            botonatras = false;
        }
    }

    public void siguiente() {
        if (vista < 3) {
            vista++;
            botonatras = true;
        }
        if (vista == 2) {
            botonsiguiente = false;
            botonconfirmar = true;
        }
        if (vista == 3) {
            botonsiguiente = false;
            botonconfirmar = false;
        }
    }

    public String confirmar() {
        String ruta = "";
        if (Sesion.obtenerSesion() == null) {
            Pedido.pedidoUsuario = pedido;
            Pedido.subproductos = subproductos;
            Pedido.vista = vista + 1;
            ruta = "Login";
        } else {
            vista++;
            botonatras = true;
            botonsiguiente = false;
            botonconfirmar = false;
        }
        return ruta;
    }

    public void agregarproductos(SubProductoCosto_TO subproducto) {
        subproductos.add(subproducto);
        cantidadProductos = subproductos.size();
    }

    public void eliminarproducto(SubProductoCosto_TO sp) {
        boolean bandera = false;
        int i = 0;
        while (!bandera) {
            if (subproductos.get(i).getIdSubProducto() == sp.getIdSubProducto()) {
                subproductos.remove(i);
                bandera = true;
            }
            i++;
        }
        cantidadProductos = subproductos.size();
        organizarSubProductosPedido();
    }

    public void insertionSortSubProductos() {
        SubProductoCosto_TO aux;
        int c1;
        int c2;

        for (c1 = 1; c1 < subproductos.size(); c1++) {
            aux = subproductos.get(c1);
            for (c2 = c1 - 1; c2 >= 0 && subproductos.get(c2).getIdSubProducto() > aux.getIdSubProducto(); c2--) {
                subproductos.set(c2 + 1, subproductos.get(c2));
                subproductos.set(c2, aux);
            }
        }
    }

    public void organizarSubProductosPedido() {
        subproductosOrdenados = new ArrayList<>();
        subproductosvista = new ArrayList<>();
        insertionSortSubProductos();
        int tipo;
        List<Integer> productosAgregados;
        productosAgregados = new ArrayList<>();
        boolean existe;
        //Agrupo productos del pedido
        for (int i = 0; i < subproductos.size(); i++) {
            existe = false;
            tipo = subproductos.get(i).getIdSubProducto();
            for (int h = 0; h < productosAgregados.size(); h++) {
                if (tipo == productosAgregados.get(h)) {
                    existe = true;
                }
            }
            if (!existe) {
                productosAgregados.add(tipo);
                List<SubProductoCosto_TO> aux = new ArrayList<>();
                for (int j = 0; j < subproductos.size(); j++) {
                    if (subproductos.get(i).getIdSubProducto() == subproductos.get(j).getIdSubProducto()) {
                        aux.add(subproductos.get(j));
                    }
                }
                subproductosOrdenados.add(aux);
            }
        }

        for (int i = 0; i < subproductosOrdenados.size(); i++) {
            subproductosvista.add(subproductosOrdenados.get(i).get(0));
        }
    }

    public String calcularCantidadPrendas(SubProductoCosto_TO subProducto) {
        int i = 0;
        int cantidad = 0;
        while (true) {
            if (subproductosOrdenados.get(i).get(0).getIdSubProducto() == subProducto.getIdSubProducto()) {
                cantidad = subproductosOrdenados.get(i).size();
                break;
            } else {
                i++;
            }
        }
        return "X" + cantidad;
    }

    //Metodos CRUD
    public void registrarPedido() {
        ServiciosBarrios sb = new ServiciosBarrios();
        ServiciosHorario sh = new ServiciosHorario();
        ServiciosDescripcionPedido sdp = new ServiciosDescripcionPedido();

        pedido.setBarrioEntrega(sb.consultarBarrio(pedido.getBarrioEntrega().getIdBarrios(), pedido.getBarrioEntrega().getNombre()));
        pedido.setBarrioRecogida(sb.consultarBarrio(pedido.getBarrioRecogida().getIdBarrios(), pedido.getBarrioRecogida().getNombre()));

        pedido.setHoraInicio(sh.consultarHorario(pedido.getHoraInicio().getIdHorario(), pedido.getHoraInicio().getHorario()));
        pedido.setHoraFinal(sh.consultarHorario(pedido.getHoraFinal().getIdHorario(), pedido.getHoraFinal().getHorario()));

        pedido.setUsuario((Usuario_TO) Sesion.obtenerSesion());
        servicios.registrarPedidoCompleto(pedido.getUsuario().getIdUsuario(),
                new Date().toString(),
                pedido.getHoraInicio().getIdHorario(),
                pedido.getHoraFinal().getIdHorario(),
                3, pedido.getFechaEntrega().toString(),
                pedido.getDireccionRecogida(),
                pedido.getDireccionEntrega(),
                pedido.getFechaRecogida().toString(),
                pedido.getQuienEntrega(),
                pedido.getQuienRecibe(),
                pedido.getBarrioRecogida().getIdBarrios(),
                pedido.getBarrioEntrega().getIdBarrios());
        pedido = servicios.consultarUltimoPedidoCliente(Sesion.obtenerSesion().getIdUsuario());
        for (int i = 0; i < subproductos.size(); i++) {
            sdp.registrarDescripcionPedido(3, pedido.getIdPedido(), subproductos.get(i).getIdSubProducto());
        }

        pedido = new Pedido_TO();
        subproductos = new ArrayList<>();
        vista = 0;
        botonatras = false;
        botonsiguiente = true;
        botonconfirmar = false;
        cantidadProductos = 0;
        Pedido.ReiniciarValores();
    }
}
