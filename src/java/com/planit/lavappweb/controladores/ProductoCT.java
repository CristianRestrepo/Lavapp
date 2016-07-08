/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosProducto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import static com.planit.lavappweb.metodos.Upload.getMapPathFotosProducto;
import com.planit.lavappweb.webservices.implementaciones.ServiciosSubServicio;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProductoCT {

    private Producto_TO producto;
    private List<Producto_TO> productos;
    protected ServiciosProducto serviciosProducto;
    private UploadedFile file;

    //Variables
    private String nombreOperacion;
    protected int operacion;
    private String imagen;

    /**
     * Relacion con clases
     */
    private Upload archivo_CT;

    public ProductoCT() {
        producto = new Producto_TO();
        productos = new ArrayList<>();
        serviciosProducto = new ServiciosProducto();
        nombreOperacion = "Registrar";
        operacion = 0;
        archivo_CT = new Upload();        
        imagen = "";        
    }

    @PostConstruct
    public void init() {
        productos = serviciosProducto.consultarProductos();
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

    public ServiciosProducto getServiciosProducto() {
        return serviciosProducto;
    }

    public void setServiciosProducto(ServiciosProducto serviciosProducto) {
        this.serviciosProducto = serviciosProducto;
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
    
    //Metodos
    public void registrar() {
        ServiciosSubServicio ss = new ServiciosSubServicio();
        producto.setSubServicio(ss.consultarSubServicio(producto.getSubServicio().getIdSubServicio(), producto.getSubServicio().getNombre()));
        producto = serviciosProducto.registrarProducto(producto.getNombre(), producto.getDescripcion(), producto.getSubServicio().getIdSubServicio(), producto.getRutaImagen());
        productos = serviciosProducto.consultarProductos();
    }

    public void modificar() {
        ServiciosSubServicio ss = new ServiciosSubServicio();
        producto.setSubServicio(ss.consultarSubServicio(0, producto.getSubServicio().getNombre()));
        producto = serviciosProducto.modificarProducto(producto.getIdProducto(), producto.getNombre(), producto.getDescripcion(), producto.getSubServicio().getIdSubServicio(), producto.getRutaImagen());
        productos = serviciosProducto.consultarProductos();
    }

    public void eliminar() {
        producto = serviciosProducto.eliminar(producto.getIdProducto());
        productos = serviciosProducto.consultarProductos();
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
            if(!producto.getRutaImagen().equalsIgnoreCase("null")){
                imagen = "El producto ya tiene imagen asignada";
            }else{
                imagen = "El producto no tiene imagen asignada";
            }
        }
        file = null;
    }

    public void cancelar() {
        producto = new Producto_TO();
        productos = serviciosProducto.consultarProductos();
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
}
