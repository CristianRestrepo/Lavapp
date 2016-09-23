/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.validadores;

import com.planit.lavappweb.modelo.dao.HorarioDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@FacesValidator("validadorFechaRecogida")
public class ValidadorFechaRecogida implements Validator {

    Date fechaActual = new Date();
    Date fechaRecogida = new Date();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        //Obtenemos y formateamos el valor de la fecha seleccionada
        try {
            fechaRecogida = sdf.parse(sdf.format((Date) o));
            fechaActual = sdf.parse(sdf.format(fechaActual));
        } catch (ParseException ex) {
            ex.getMessage();
        }

        if (fechaRecogida.before(fechaActual)) {
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de recogida es anterior a la fecha actual");
            throw new ValidatorException(fmsg);
        }
    }
}
