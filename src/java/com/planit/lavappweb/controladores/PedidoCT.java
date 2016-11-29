/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Pedido;
import com.planit.lavappweb.metodos.Sesion;
import com.planit.lavappweb.modelo.dao.CorreoDao;
import com.planit.lavappweb.modelo.dao.DescripcionPedidoDao;
import com.planit.lavappweb.modelo.dao.HistoricoDao;
import com.planit.lavappweb.modelo.dao.PedidoDao;
import com.planit.lavappweb.modelo.dao.PromocionDao;
import com.planit.lavappweb.modelo.dao.PromocionSubproductoDao;
import com.planit.lavappweb.modelo.dao.UsuarioDao;
import com.planit.lavappweb.modelo.dto.DescripcionPedido_TO;
import com.planit.lavappweb.modelo.dto.Estado_TO;
import com.planit.lavappweb.modelo.dto.Historico_TO;
import com.planit.lavappweb.modelo.dto.Pedido_TO;
import com.planit.lavappweb.modelo.dto.Promocion_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo_Planit
 */
public class PedidoCT implements Serializable {

    //Variables
    private Pedido_TO pedido;
    private List<SubProductoCosto_TO> subproductos;

    private int vista;
    private int cantidadProductos;

    private boolean botonatras;
    private boolean botonsiguiente;
    private boolean botonconfirmar;

    //Constructores
    public PedidoCT() {
        vista = 0;
        pedido = new Pedido_TO();
        subproductos = new ArrayList<>();
        cantidadProductos = 0;
        botonatras = false;
        botonsiguiente = true;
        botonconfirmar = false;
    }

    @PostConstruct
    public void init() {
        //si el cliente inicia sesion, cargara los datos de su pedido si es que tiene uno en proceso. 
        if (Sesion.obtenerSesion() != null) {
            //Desde la clase pedido en el paquete metodos carga los datos del pedido en proceso del cliente
            vista = Pedido.vista;
            pedido = Pedido.pedidoUsuario;
            pedido.setUsuario(Sesion.obtenerSesion());
            subproductos = Pedido.subproductos;
            cantidadProductos = subproductos.size();
            //Segun la vista habilita o deshabilita los botones de siguiente, atras y confirmar
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
        //Valida que botones habilitar o deshabilitar segun la vista donde se encuentre el cliente en el proceso de pedido
        if (vista > 0) {
            vista--;
            botonsiguiente = true;
            GuardarDatosPedido();//guarda las prendas de su pedido en la clase pedido, para llevar un respaldo de su pedido a la hora de iniciar sesion.
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
        //Valida que botones habilitar o deshabilitar segun la vista donde se encuentre el cliente en el proceso de pedido
        if (vista < 3) {
            if (!subproductos.isEmpty()) {
                vista++;
                botonatras = true;
            } else {
                //Si el cliente no ha agregado ninguna prenda, no le permite seguir con el proceso de pedido
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
            // si el usuario no ha iniciado sesion al momento de llegar a la vista de confirmacion
            // sera enviado a la vista de inicio de sesion y sus pedido sera respaldado
            Pedido.pedidoUsuario = pedido;
            Pedido.subproductos = subproductos;
            Pedido.vista = vista + 1;
            ruta = "Login";
        } else {
            //si ya inicio sesion continua con el proceso
            vista++;
            botonatras = true;
            botonsiguiente = false;
            botonconfirmar = false;
        }
        return ruta;
    }

    public void agregarproductos(SubProductoCosto_TO subproducto) {
        //se agrega la prenda seleccionada al array subproductos y se calcula la cantidad de prendas totales del pedido
        subproductos.add(subproducto);
        cantidadProductos = subproductos.size();
        calcularCostoPedido(); //Calculamos costo total del pedido
       
    }

    public void cargarDatosUsuario() {
        //Si el cliente inicio sesion carga los datos de usuario al pedido que se esta llevando a cabo
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
        //Respalda los datos del pedido que se esta llevando a cabo
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

            //Se envia correo a cliente confirmando su pedido
            CorreoDao correoDao = new CorreoDao();
            correoDao.enviarMensajeAgendamiento(Sesion.obtenerSesion());

            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido Registrado Exitosamente", "");
            FacesContext.getCurrentInstance().addMessage(null, fmsg);
        }

        //Reiniciamos variables
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
    public void calcularCostoPedido() {
        List<List<SubProductoCosto_TO>> subproductosOrdenados = organizarSubProductos(subproductos);        
        double costo = 0;
        PromocionDao promocionDao = new PromocionDao();
        PromocionSubproductoDao promocionSubproductoDao = new PromocionSubproductoDao();
        Promocion_TO promocion = new Promocion_TO();
        promocion = promocionDao.consultarPromocionActiva();
        for (int i = 0; i < subproductosOrdenados.size(); i++) {
            SubProducto_TO sp = new SubProducto_TO(subproductosOrdenados.get(i).get(0).getIdSubProducto());
            if (promocion.getIdPromocion() != 0) {
                int r = promocionSubproductoDao.consultarSubProductoAsociado(promocion, sp);
                if (r == 1) {
                    costo += subproductosOrdenados.get(i).size() * (subproductosOrdenados.get(i).get(0).getCosto().getValor() - ((subproductosOrdenados.get(i).get(0).getCosto().getValor() * promocion.getPorcentaje()) / 100));
                } else {
                    costo += subproductosOrdenados.get(i).size() * subproductosOrdenados.get(i).get(0).getCosto().getValor();
                }
            } else {
                costo += subproductosOrdenados.get(i).size() * subproductosOrdenados.get(i).get(0).getCosto().getValor();
            }
        }
        pedido.setCosto(costo);
    }   
}
