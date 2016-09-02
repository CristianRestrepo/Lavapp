/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelo.dto.Producto_TO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import static com.planit.lavappweb.metodos.Upload.getMapPathFotosProducto;
import com.planit.lavappweb.modelo.dao.ProductoDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProductoCT implements Serializable {

    private Producto_TO producto;
    private List<Producto_TO> productos;

    private UploadedFile file;

    //Variables
    private String nombreOperacion;
    protected int operacion;
    private String imagen;
    private String buscar;

    private Upload archivo_CT;

    public ProductoCT() {
        producto = new Producto_TO();
        productos = new ArrayList<>();

        nombreOperacion = "Registrar";
        operacion = 0;
        imagen = "";
        buscar = null;

        archivo_CT = new Upload();
    }

    @PostConstruct
    public void init() {
        ProductoDao productoDao = new ProductoDao();
        productos = productoDao.consultarProductos();
    }

    //Getter & Setter
    public Producto_TO getProducto() {
        return producto;
    }

    public void setProducto(Producto_TO producto) {
        this.producto = producto;
    }

    public List<Producto_TO> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto_TO> productos) {
        this.productos = productos;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public Upload getArchivo_CT() {
        return archivo_CT;
    }

    public void setArchivo_CT(Upload archivo_CT) {
        this.archivo_CT = archivo_CT;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos
    public void registrar() {
        ProductoDao productoDao = new ProductoDao();
        producto = productoDao.registrarProducto(producto);
        productos = productoDao.consultarProductos();
    }

    public void modificar() {
        ProductoDao productoDao = new ProductoDao();
        producto = productoDao.modificarProducto(producto);
        productos = productoDao.consultarProductos();
    }

    public void eliminar() {
        ProductoDao productoDao = new ProductoDao();
        producto = productoDao.eliminarProducto(producto);
        productos = productoDao.consultarProductos();
    }

    //Metodos Propios
    public void metodo() throws IOException {
        if (operacion == 0) {
            if (!file.getFileName().isEmpty()) {
                uploadFoto();
            }
            registrar();
        } else if (operacion == 1) {
            if (!file.getFileName().isEmpty()) {
                uploadFoto();
            }
            modificar();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
            imagen = "";
        }
        file = null;
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
            if (producto.getRutaImagen() != null) {
                imagen = "El producto ya tiene imagen asignada";
            } else {
                imagen = "El producto no tiene imagen asignada";
            }
        }
        file = null;
    }

    public void cancelar() {
        ProductoDao productoDao = new ProductoDao();
        producto = new Producto_TO();
        productos = productoDao.consultarProductos();
        operacion = 0;
        nombreOperacion = "Registrar";
        imagen = "";
        file = null;
    }

    public void uploadFoto() throws IOException {
        try {
            String destino;
            HashMap<String, String> map = getMapPathFotosProducto();
            destino = map.get("path");

            if (null != file) {
                archivo_CT.uploadFile(IOUtils.toByteArray(file.getInputstream()), file.getFileName(), destino);
                producto.setRutaImagen(map.get("url") + file.getFileName());
            }
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Su foto (" + file.getFileName() + ")  se ha guardado con exito.", ""));
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void buscarProductos() {
        ProductoDao productoDao = new ProductoDao();
        productos = new ArrayList<>();
        if (buscar.isEmpty()) {
            productos = productoDao.consultarProductos();
        } else {
            productos = productoDao.BuscarProductos(buscar);
        }
    }
}
