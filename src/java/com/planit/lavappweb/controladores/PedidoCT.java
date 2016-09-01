/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Pedido;
import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dao.PedidoDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT implements Serializable {

    private Pedido_TO pedido;
    private List<Pedido_TO> pedidos;

    private List<SubProductoCosto_TO> subproductos;

    private int vista;
    private int cantidadProductos;

    private boolean botonatras;
    private boolean botonsiguiente;
    private boolean botonconfirmar;

    public PedidoCT() {

        vista = 0;
        pedido = new Pedido_TO();
        subproductos = new ArrayList<>();
        cantidadProductos = 0;
        botonatras = false;
        botonsiguiente = true;
        botonconfirmar = false;

        pedidos = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidos = pedidoDao.consultarPedidos();
    }

    @PostConstruct
    public void init() {
        if (Sesion.obtenerSesion() != null) {
            vista = Pedido.vista;
            pedido = Pedido.pedidoUsuario;
            pedido.setUsuario(Sesion.obtenerSesion());
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
        //Carga de pedidos
    }

    //Getter & Setter
    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    public List<Pedido_TO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido_TO> pedidos) {
        this.pedidos = pedidos;
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

    //Metodos CRUD
    public void registrarPedido() {
        PedidoDao pedidoDao = new PedidoDao();

        pedidoDao.registrarPedidoCompleto(pedido);
        pedido = pedidoDao.consultarUltimoPedidoCliente(Sesion.obtenerSesion());

        DescripcionPedidoDao dpd = new DescripcionPedidoDao();
        for (int i = 0; i < subproductos.size(); i++) {
            DescripcionPedido_TO dp = new DescripcionPedido_TO();
            dp.setEstado(new Estado_TO(3));
            dp.setPedido(pedido);
            dp.setSubProducto(new SubProducto_TO(subproductos.get(i).getIdSubProducto()));
            dpd.registrarDescripcionPedido(dp);
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
    }

    //Metodos para el manejo de los productos del pedido
    public List<SubProductoCosto_TO> insertionSortSubProductos(List<SubProductoCosto_TO> lista) {
        SubProductoCosto_TO aux;
        int c1;
        int c2;

        for (c1 = 1; c1 < lista.size(); c1++) {
            aux = lista.get(c1);
            for (c2 = c1 - 1; c2 >= 0 && lista.get(c2).getIdSubProducto() > aux.getIdSubProducto(); c2--) {
                lista.set(c2 + 1, lista.get(c2));
                lista.set(c2, aux);
            }
        }

        return lista;
    }

    public List<List<SubProductoCosto_TO>> organizarSubProductos(List<SubProductoCosto_TO> lista) {
        List<List<SubProductoCosto_TO>> subproductosOrdenados = new ArrayList<>();
        lista = insertionSortSubProductos(lista);
        int tipo;
        List<Integer> productosAgregados;
        productosAgregados = new ArrayList<>();
        boolean existe;
        //Agrupo productos del pedido
        for (int i = 0; i < lista.size(); i++) {
            existe = false;
            tipo = lista.get(i).getIdSubProducto();
            for (int h = 0; h < productosAgregados.size(); h++) {
                if (tipo == productosAgregados.get(h)) {
                    existe = true;
                }
            }
            if (!existe) {
                productosAgregados.add(tipo);
                List<SubProductoCosto_TO> aux = new ArrayList<>();
                for (int j = 0; j < lista.size(); j++) {
                    if (lista.get(i).getIdSubProducto() == lista.get(j).getIdSubProducto()) {
                        aux.add(lista.get(j));
                    }
                }
                subproductosOrdenados.add(aux);
            }
        }
        return subproductosOrdenados;
    }

    public List<SubProductoCosto_TO> obtenerSubProductosPedidoOrdenados(List<SubProductoCosto_TO> lista) {
        List<List<SubProductoCosto_TO>> subproductosOrdenados = new ArrayList<>();
        List<SubProductoCosto_TO> subproductosvista = new ArrayList<>();
        subproductosOrdenados = organizarSubProductos(lista);
        for (int i = 0; i < subproductosOrdenados.size(); i++) {
            subproductosvista.add(subproductosOrdenados.get(i).get(0));
        }
        return subproductosvista;
    }

    public String calcularCantidadPrendas(List<List<SubProductoCosto_TO>> subproductosOrdenados, SubProductoCosto_TO subProducto) {
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

    //Otros
    public void verPedido(Pedido_TO pedido) {
        this.pedido = pedido;
        vista = 1;
    }
}
