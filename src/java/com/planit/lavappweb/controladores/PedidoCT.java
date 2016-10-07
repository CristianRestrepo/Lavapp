/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Pedido;
import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dao.HistoricoDao;
import com.planit.lavappweb.modelo.dao.PedidoDao;
import com.planit.lavappweb.modelo.dao.ProveedorDao;
import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Historico_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT implements Serializable {

    private Pedido_TO pedido;
    private DescripcionPedido_TO descripcionPedido;
    private List<Pedido_TO> pedidos;

    private List<SubProductoCosto_TO> subproductos;

    private int vista;
    private int cantidadProductos;

    private boolean botonatras;
    private boolean botonsiguiente;
    private boolean botonconfirmar;

    private String buscar;
    private Boolean descripcionPrenda;

    public PedidoCT() {
        vista = 0;
        pedido = new Pedido_TO();
        descripcionPedido = new DescripcionPedido_TO();
        subproductos = new ArrayList<>();
        cantidadProductos = 0;
        botonatras = false;
        botonsiguiente = true;
        botonconfirmar = false;
        buscar = null;

        PedidoDao pedidoDao = new PedidoDao();
        if (Sesion.obtenerSesion() != null) {
            if (Sesion.obtenerSesion().getRol().getIdRol() == 1) {
                pedidos = pedidoDao.consultarPedidos();
                descripcionPrenda = false;
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 2) {
                ProveedorDao proveedorDao = new ProveedorDao();
                try {
                    pedidos = pedidoDao.consultarPedidosSegunPlanta(proveedorDao.consultarProveedorSegunUsuario(Sesion.obtenerSesion()));
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
                descripcionPrenda = false;
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 4) {
                try {
                    pedidos = pedidoDao.consultarPedidosCliente(Sesion.obtenerSesion());
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
                descripcionPrenda = true;
            }
        }
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
                if (vista == 1) {
                    cargarDatosUsuario();
                    botonsiguiente = true;
                }
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public DescripcionPedido_TO getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public Boolean getDescripcionPrenda() {
        return descripcionPrenda;
    }

    public void setDescripcionPrenda(Boolean descripcionPrenda) {
        this.descripcionPrenda = descripcionPrenda;
    }

    //Metodos para las vistas 
    public void atras() {
        if (vista > 0) {
            vista--;
            botonsiguiente = true;
            GuardarDatosPedido();
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
            if (!subproductos.isEmpty()) {
                vista++;
                botonatras = true;
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No ha agregado ningun producto", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            GuardarDatosPedido();
        }
        if (vista == 1) {
            cargarDatosUsuario();
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

    public void cargarDatosUsuario() {
        if (Sesion.obtenerSesion() != null) {
            if (Sesion.obtenerSesion().getDireccion() != null) {
                pedido.setDireccionRecogida(Sesion.obtenerSesion().getDireccion());
                pedido.setDireccionEntrega(Sesion.obtenerSesion().getDireccion());
            }
            pedido.setBarrioEntrega(Sesion.obtenerSesion().getBarrio());
            pedido.setBarrioRecogida(Sesion.obtenerSesion().getBarrio());
            pedido.setQuienEntrega(Sesion.obtenerSesion().getNombre() + " " + Sesion.obtenerSesion().getApellido());
            pedido.setQuienRecibe(Sesion.obtenerSesion().getNombre() + " " + Sesion.obtenerSesion().getApellido());
        }
    }

    public void GuardarDatosPedido() {
        Pedido.pedidoUsuario = pedido;
        Pedido.subproductos = subproductos;
        Pedido.vista = vista;
    }

    //Metodos CRUD
    public void registrarPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.registrarPedidoCompleto(pedido);//Se registra pedido
        pedido = pedidoDao.consultarUltimoPedidoCliente(Sesion.obtenerSesion());

        DescripcionPedidoDao dpd = new DescripcionPedidoDao();
        HistoricoDao hd = new HistoricoDao();
        Historico_TO historico = new Historico_TO();

        //Valida que el pedido haya sido registrado para despues registrar los productos agregados al pedido
        if (pedido.getIdPedido() != 0) {
            for (int i = 0; i < subproductos.size(); i++) {
                DescripcionPedido_TO dp = new DescripcionPedido_TO();
                dp.setEstado(new Estado_TO(3));
                dp.setPedido(pedido);
                dp.setSubProducto(new SubProducto_TO(subproductos.get(i).getIdSubProducto()));
                dpd.registrarDescripcionPedido(dp);

            }

            //Despues de registrados los productos del pedido, registra el historico de estas
            List<DescripcionPedido_TO> descripciones = new ArrayList<>();
            descripciones = dpd.consultarDescripcionesSinFotosSegunPedido(pedido);///Cambiar funcion cuando traigamos fotos
            for (int i = 0; i < descripciones.size(); i++) {
                historico = new Historico_TO();
                historico.setDescripcionPedido(descripciones.get(i));
                historico.setEstado(new Estado_TO(3));
                hd.registrarHistorico(historico);
            }

            //Se asigna asesor al pedido
            UsuarioDao usuarioDao = new UsuarioDao();
            pedidoDao.asignarAsesorPedido(pedido, usuarioDao.consultarAsesorZona(pedido.getBarrioRecogida().getZona()));

            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido Registrado Exitosamente", "");
            FacesContext.getCurrentInstance().addMessage(null, fmsg);
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

    public void modificarPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.modificaPedido(pedido);
    }

    public void editarEstadoPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.editarEstadoPedido(pedido);
    }

    //Metodos para el manejo de los productos del pedido
    //Ordena ascendentemente los productos en la lista basado en su id
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

    //Agrupa los productos en una lista de listas de productos del mismo tipo
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

    //Obtiene una lista de productos deferenciados segun el tipo, obtiene 1 producto por tipo
    public List<SubProductoCosto_TO> obtenerSubProductosPedidoOrdenados(List<SubProductoCosto_TO> lista) {
        List<List<SubProductoCosto_TO>> subproductosOrdenados = new ArrayList<>();
        List<SubProductoCosto_TO> subproductosvista = new ArrayList<>();
        subproductosOrdenados = organizarSubProductos(lista);
        for (int i = 0; i < subproductosOrdenados.size(); i++) {
            subproductosvista.add(subproductosOrdenados.get(i).get(0));
        }
        return subproductosvista;
    }

    //Obtiene la cantidad de prendas del mismo tipo que se han seleccionado
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

    //Obtiene la sumatoria del valor de las prendas que se estan escogiendo en el pedido
    public int calcularCostoPedido(List<List<SubProductoCosto_TO>> subproductosOrdenados) {
        int costo = 0;
        for (int i = 0; i < subproductosOrdenados.size(); i++) {
            costo += subproductosOrdenados.get(i).size() * subproductosOrdenados.get(i).get(0).getCosto().getValor();
        }
        return costo;
    }

    //Metodos para el control de vista pedido en dashboard
    public void verPedido(Pedido_TO pedido) {
        this.pedido = pedido;
        vista = 1;
    }

    public void verPrenda(DescripcionPedido_TO prenda) {
        this.descripcionPedido = prenda;
        vista = 2;
    }

    public void volverPedidos() {
        vista = 0;
    }

    public void volverPedido() {
        vista = 1;
    }

    public void buscarPedido() {
        PedidoDao pedidoDao = new PedidoDao();
        pedidos = new ArrayList<>();
        if (buscar.isEmpty()) {
            if (Sesion.obtenerSesion().getRol().getIdRol() == 1) {
                pedidos = pedidoDao.consultarPedidos();
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 2) {
                ProveedorDao proveedorDao = new ProveedorDao();
                try {
                    pedidos = pedidoDao.consultarPedidosSegunPlanta(proveedorDao.consultarProveedorSegunUsuario(Sesion.obtenerSesion()));
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Sesion.obtenerSesion().getRol().getIdRol() == 4) {
                try {
                    pedidos = pedidoDao.consultarPedidosCliente(Sesion.obtenerSesion());
                } catch (ParseException ex) {
                    Logger.getLogger(PedidoCT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            pedidos = pedidoDao.BuscarPedidos(buscar, Sesion.obtenerSesion());
        }
    }

    public List<Pedido_TO> consultarPedidosDiaEntrega() {
        List<Pedido_TO> pedidosDia = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosDia = pedidoDao.consultarPedidosDiaEntrega();
        return pedidosDia;
    }

    public List<Pedido_TO> consultarPedidosDiaRecogida() {
        List<Pedido_TO> pedidosDia = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosDia = pedidoDao.consultarPedidosDiaRecogida();
        return pedidosDia;
    }

    public List<Pedido_TO> consultarPedidosEnplantaSegunCliente() {
        List<Pedido_TO> pedidosEntrega = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosEntrega = pedidoDao.consultarPedidosEnPlantaSegunCliente(Sesion.obtenerSesion());
        return pedidosEntrega;
    }

    public List<Pedido_TO> consultarPedidosPorRecibirSegunCliente() {
        List<Pedido_TO> pedidosRecibir = new ArrayList<>();
        PedidoDao pedidoDao = new PedidoDao();
        pedidosRecibir = pedidoDao.consultarPedidosPorRecibirSegunCliente(Sesion.obtenerSesion());
        return pedidosRecibir;
    }

}
