/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.metodos.Upload;
import com.planit.lavappweb.modelos.Costo_TO;
import com.planit.lavappweb.modelos.SubProductoCosto_TO;
import com.planit.lavappweb.modelos.SubProducto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosCosto;
import com.planit.lavappweb.webservices.implementaciones.ServiciosProducto;
import com.planit.lavappweb.webservices.implementaciones.ServiciosSubProductos;
import com.planit.lavappweb.webservices.implementaciones.ServiciosZona;
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

    protected ServiciosSubProductos serviciosSubProducto;
    protected ServiciosCosto serviciosCosto;
    //Variables    
    private String nombreOperacion;
    protected int operacion;
    private String imagen;

    public SubProductoCT() {
        subproducto = new SubProducto_TO();
        subproductos = new ArrayList<>();

        serviciosSubProducto = new ServiciosSubProductos();
        subProductosConCosto = new ArrayList<>();

        serviciosCosto = new ServiciosCosto();
        subProductosClasificados = new ArrayList<>();

        costo = new Costo_TO();

        imagen = "";
        operacion = 0;
        nombreOperacion = "Registrar";
        ControladorArchivos = new Upload();
    }

    @PostConstruct
    public void init() {
        subproductos = serviciosSubProducto.consultarSubProductos();
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

    //Metodos
    public void registrar() {
        ServiciosProducto sp = new ServiciosProducto();
        ServiciosZona sz = new ServiciosZona();

        subproducto.setProducto(sp.consultarProducto(subproducto.getProducto().getIdProducto(), subproducto.getProducto().getNombre()));
        serviciosSubProducto.registrarSubproducto(subproducto.getNombre(), subproducto.getDescripcion(), subproducto.getProducto().getIdProducto(), subproducto.getRutaImagen());
        costo.setSubProducto((SubProducto_TO) serviciosSubProducto.consultarSubProducto(subproducto.getIdSubProducto(), subproducto.getNombre()));
        costo = serviciosCosto.RegistrarCosto(costo.getValor(), costo.getSubProducto().getIdSubProducto(), sz.consultarZona(0, "Zona General").getIdZona());
        subproducto = new SubProducto_TO();
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    public void modificar() {
        ServiciosProducto sp = new ServiciosProducto();
        subproducto.setProducto(sp.consultarProducto(subproducto.getProducto().getIdProducto(), subproducto.getProducto().getNombre()));
        subproducto = serviciosSubProducto.editarSubProducto(subproducto.getIdSubProducto(), subproducto.getNombre(), subproducto.getDescripcion(), subproducto.getProducto().getIdProducto(), subproducto.getRutaImagen());
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    public void eliminar() {
        costo = serviciosCosto.consultarCostoSubProducto(subproducto.getIdSubProducto());
        costo = serviciosCosto.eliminarCosto(operacion);
        subproducto = serviciosSubProducto.eliminarSubProducto(subproducto.getIdSubProducto());
        subproductos = serviciosSubProducto.consultarSubProductos();
    }

    public void consultarProductosSegunProducto(int idProducto) {
        subProductosClasificados = new ArrayList<>();
        subProductosClasificados = serviciosSubProducto.consultarSubProductosSegunProducto(idProducto);
        subProductosConCosto = serviciosSubProducto.consultarSubProductosConCostoSegunProducto(idProducto);
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
            costo = serviciosCosto.consultarCostoSubProducto(subproducto.getIdSubProducto());
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
        subproducto = new SubProducto_TO();
        subproductos = serviciosSubProducto.consultarSubProductos();
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
}
