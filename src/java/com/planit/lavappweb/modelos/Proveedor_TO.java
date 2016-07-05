/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Proveedor
 *
 * Tabla Relacionada Proveedor
 *
 * @author Planit
 */
@XmlRootElement
public class Proveedor_TO {

    /**
     *
     * Columna idProveedor
     */
    private int idProveedor;

    /**
     *
     * Columna razonSocial
     */
    private String razonSocial;

    /**
     *
     * Columna nit
     */
    private String nit;

    /**
     *
     * Columna telefono
     */
    private String telefono;

    /**
     *
     * Columna direccion
     */
    private String direccion;

    /**
     *
     * Columna idUsuario
     */
    private Usuario_TO usuario;

    /**
     *
     * Columna cupo
     */
    private int cupo;

    /**
     *
     * Columna zona
     */
    private Zona_TO zona;

    //Constructores
    public Proveedor_TO() {
        usuario = new Usuario_TO();
        zona = new Zona_TO();
    }

    public Proveedor_TO(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor_TO(int idProveedor, String razonSocial, String nit, String telefono, String direccion, Usuario_TO usuario, int cupo, Zona_TO zona) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.cupo = cupo;
        this.zona = zona;
    }

    //Getter & Setter
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Zona_TO getZona() {
        return zona;
    }

    //Getter and Setter
    public void setZona(Zona_TO zona) {
        this.zona = zona;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Proveedor_TO{" + "idProveedor=" + idProveedor + ", razonSocial=" + razonSocial + ", nit=" + nit + ", telefono=" + telefono + ", direccion=" + direccion + ", usuario=" + usuario + ", cupo=" + cupo + ", zona=" + zona + '}';
    }

}
