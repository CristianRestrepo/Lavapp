/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.validadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author VaioDevelopment
 */
@FacesValidator("validadorFechaEntrega")
public class ValidadorFechaEntrega implements Validator{
    
    Date fechaEntrega = new Date();
    Date fechaRecogida = new Date();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        //Obtenemos y formateamos el valor de la fecha seleccionada
        try {
            fechaEntrega = sdf.parse(sdf.format((Date) o));
            fechaRecogida = sdf.parse(sdf.format((Date) uic.getAttributes().get("fechaRecogida")));
        } catch (ParseException ex) {
            ex.getMessage();
        }
        
        if(fechaEntrega.before(fechaRecogida) || fechaEntrega.equals(fechaRecogida)){
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de entrega del pedido es menor o igual a la fecha de inicio del servicio");
            throw new ValidatorException(fmsg);
        }
        
    }
    
}
