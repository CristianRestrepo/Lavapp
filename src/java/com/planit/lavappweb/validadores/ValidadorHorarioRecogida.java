/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.validadores;

import com.planit.lavappweb.modelo.dao.HorarioDao;
import com.planit.lavappweb.modelo.dto.Horario_TO;
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
@FacesValidator("validadorHorarioRecogida")
public class ValidadorHorarioRecogida implements Validator {

    Date fechaHoraActual = new Date();
    Date fechaRecogida = new Date();
    Date horaRecogida = new Date();
    Date fechaActual = new Date();
    Date horaActual = new Date();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        //Definimos formato para las fechas
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HorarioDao horarioDao = new HorarioDao();
        Horario_TO horario = new Horario_TO();

        //Obtenemos los valores de cada variable desde el contexto de la vista
        horario.setHorario((String) o);
        try {//Formateamos las fechas segun lo necesitemos
            fechaRecogida = sdf.parse(sdf.format((Date) uic.getAttributes().get("fechaRecogida")));
            horaRecogida = sdft.parse(horarioDao.consultarHorario(horario).getHoraInicio());
            fechaActual = sdf.parse(sdf.format(fechaHoraActual));
            horaActual = sdft.parse(sdft.format(fechaHoraActual));
        } catch (ParseException e) {
            e.getMessage();
        }

        if (fechaRecogida.equals(fechaActual)) {
            if (horaRecogida.before(horaActual)) {
                FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La hora de recogida del pedido es menor a la hora actual");
                throw new ValidatorException(fmsg);
            }
        }

    }

}
