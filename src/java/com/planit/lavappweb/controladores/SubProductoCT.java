/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelo.dao.CostoDao;
import com.planit.lavappweb.modelo.dao.SubProductoDao;
import com.planit.lavappweb.modelo.dao.ZonaDao;
import com.planit.lavappweb.modelo.dto.Costo_TO;
import com.planit.lavappweb.modelo.dto.Producto_TO;
import com.planit.lavappweb.modelo.dto.SubProductoCosto_TO;
import com.planit.lavappweb.modelo.dto.SubProducto_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProductoCT implements Serializable {

    private SubProducto_TO subproducto;
    private List<SubProducto_TO> subproductos;
    private List<SubProducto_TO> subProductosClasificados;
    private List<SubProductoCosto_TO> subProductosConCosto;

    private Costo_TO costo;
    private UploadedFile file;
    protected Upload ControladorArchivos;

    //Variables    
    private String nombreOperacion;
    protected int operacion;
    private String imagen;
    private String buscar;

    public SubProductoCT() {
        subproducto = new SubProducto_TO();
        subproductos = new ArrayList<>();
        subProductosConCosto = new ArrayList<>();
        subProductosClasificados = new ArrayList<>();

        costo = new Costo_TO();

        imagen = "";
        operacion = 0;
        nombreOperacion = "Registrar";
        ControladorArchivos = new Upload();
        buscar = null;
    }

    @PostConstruct
    public void init() {
        SubProductoDao subProductoDao = new SubProductoDao();
        subproductos = subProductoDao.consultarSubProductos();
    }

    //Getter & Setter
    public SubProducto_TO getSubproducto() {
        return subproducto;
    }

    public void setSubproducto(SubProducto_TO subproducto) {
        this.subproducto = subproducto;
    }

    public List<SubProducto_TO> getSubproductos() {
        return subproductos;
    }

    public void setSubproductos(List<SubProducto_TO> subproductos) {
        this.subproductos = subproductos;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
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

    public List<SubProducto_TO> getSubProductosClasificados() {
        return subProductosClasificados;
    }

    public void setSubProductosClasificados(List<SubProducto_TO> subProductosClasificados) {
        this.subProductosClasificados = subProductosClasificados;
    }

    public List<SubProductoCosto_TO> getSubProductosConCosto() {
        return subProductosConCosto;
    }

    public void setSubProductosConCosto(List<SubProductoCosto_TO> subProductosConCosto) {
        this.subProductosConCosto = subProductosConCosto;
    }

    public Costo_TO getCosto() {
        return costo;
    }

    public void setCosto(Costo_TO costo) {
        this.costo = costo;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos
    public void registrar() {

        SubProductoDao subProductoDao = new SubProductoDao();
        ZonaDao zonaDao = new ZonaDao();
        CostoDao costoDao = new CostoDao();

        subProductoDao.registrarSubproducto(subproducto);
        costo.setSubProducto(subProductoDao.consultarSubProducto(subproducto));
        costo.setZona(zonaDao.consultarZona(new Zona_TO(0, "Zona General")));

        costo = costoDao.RegistrarCosto(costo);

        subproducto = new SubProducto_TO();
        subproductos = subProductoDao.consultarSubProductos();
    }

    public void modificar() {
        SubProductoDao subProductoDao = new SubProductoDao();
        ZonaDao zonaDao = new ZonaDao();
        CostoDao costoDao = new CostoDao();

        subProductoDao.editarSubProducto(subproducto);

        costo.setSubProducto(subproducto);
        costo.setZona(zonaDao.consultarZona(costo.getZona()));
        costo = costoDao.modificarCosto(costo);
        subproductos = subProductoDao.consultarSubProductos();
    }

    public void eliminar() {
        SubProductoDao subProductoDao = new SubProductoDao();
        CostoDao costoDao = new CostoDao();

        costo = costoDao.consultarCostoSubProducto(subproducto);
        costo = costoDao.eliminarCosto(costo);
        subproducto = subProductoDao.eliminarSubProducto(subproducto);
        subproductos = subProductoDao.consultarSubProductos();
    }

    public void consultarProductosSegunProducto(Producto_TO producto) {
        SubProductoDao subProductoDao = new SubProductoDao();
        subProductosClasificados = new ArrayList<>();
        subProductosClasificados = subProductoDao.consultarSubProductosSegunProducto(producto);
        subProductosConCosto = subProductoDao.consultarSubProductosConCostoSegunProducto(producto);
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
        CostoDao costoDao = new CostoDao();
        operacion = i;
        if (operacion == 1) {
            costo = costoDao.consultarCostoSubProducto(subproducto);
            nombreOperacion = "Modificar";
            if (subproducto.getRutaImagen() != null) {
                imagen = "El producto ya tiene imagen asignada";
            } else {
                imagen = "El producto no tiene imagen asignada";
            }
        }
        file = null;
    }

    public void cancelar() {
        SubProductoDao subProductoDao = new SubProductoDao();
        subproducto = new SubProducto_TO();
        subproductos = subProductoDao.consultarSubProductos();
        operacion = 0;
        nombreOperacion = "Registrar";
        imagen = "";
        file = null;
        costo = new Costo_TO();
    }

    public void uploadFoto() throws IOException {
        try {
            String destino;
            HashMap<String, String> map = Upload.getMapPathFotosSubProducto();
            destino = map.get("path");

            if (null != file) {
                ControladorArchivos.uploadFile(IOUtils.toByteArray(file.getInputstream()), file.getFileName(), destino);
                subproducto.setRutaImagen(map.get("url") + file.getFileName());
            }
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Su foto (" + file.getFileName() + ")  se ha guardado con exito.", ""));
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void buscarSubProductos() {
        SubProductoDao subProductoDao = new SubProductoDao();
        subproductos = new ArrayList<>();
        if (buscar == null) {
            subproductos = subProductoDao.consultarSubProductos();
        } else {
            subproductos = subProductoDao.buscarSubProductos(buscar);
        }
    }
}
