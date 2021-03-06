/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.metodos;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author SISTEMAS
 */
public class Upload {

    //Variable
    UploadedFile archivo;

    //Getters & Setters
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    //Metodos
    //Retorna la ruta completa de la ubicacion de proyecto
    public static String getPath() {
        try {
            ExternalContext tmpEC;
            tmpEC = FacesContext.getCurrentInstance().getExternalContext();
            String realPath = tmpEC.getRealPath("/");
            return realPath;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
  
    public static HashMap<String, String> getMapPathFotosProducto() {
        try {
            HashMap<String, String> map = new HashMap<>();
            String path = getPathFotosProductos();
            map.put("path", path);
//          map.put("url", "/resources/images/upload/Productos/");
            map.put("url", "http://localhost:8084/LavappService/resources/images/upload/Productos/");
            return map;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
  
    public static String getPathFotosProductos() {
        try {
//          String path = getPath() + "/resources/images/upload/Productos/";
            String path = getPath() + "http://localhost:8084/LavappService/resources/images/upload/Productos/";
            return path;
        } catch (Exception e) {
            throw e;
        }
    }

    public static HashMap<String, String> getMapPathFotosSubProducto() {
        try {
            HashMap<String, String> map = new HashMap<>();
            String path = getPathFotosSubProductos();
            map.put("path", path);
            map.put("url", "/resources/images/upload/SubProductos/");
            return map;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static String getPathFotosSubProductos() {
        try {
            String path = getPath() + "/resources/images/upload/SubProductos/";
            return path;
        } catch (Exception e) {
            throw e;
        }
    }

    public static HashMap<String, String> getMapPathFotosUsuarios() {
        try {
            HashMap<String, String> map = new HashMap<>();
            String path = getPathFotosUsuarios();
            map.put("path", path);
            map.put("url", "/resources/images/upload/Usuarios/");
            return map;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static String getPathFotosUsuarios() {
        try {
            String path = getPath() + "/resources/images/upload/Usuarios/";
            return path;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getPathDefaultUsuario() {

        try {
            String path = "/resources/images/upload/Usuarios/user.jpg";
            return path;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void uploadFile(byte[] b, String nombre, String destino) throws IOException {

        String FilePath = destino;
        if (null != b) {
            byte[] bytes = b;
            String filename = nombre;

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(FilePath + filename)));
            stream.write(bytes);
            stream.close();
        }
    }
}
