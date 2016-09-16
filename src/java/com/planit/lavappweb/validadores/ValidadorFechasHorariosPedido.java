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
import java.util.Calendar;
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
@FacesValidator("ValidadorFechasHorariosPedido")
public class ValidadorFechasHorariosPedido implements Validator {

    Date fechaHoraActual = new Date();
    Date fechaEntrega = new Date();
    Date fechaRecogida = new Date();
    Date horaRecogida = new Date();
    Date horaEntrega = new Date();

    Date fechaActual = new Date();
    Date HoraActual = new Date();
    HorarioDao horarioDao = new HorarioDao();

    long milis1;
    long milis2;

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        //Definimos formato para las fechas
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Horario_TO horarioRecogida = new Horario_TO();
        horarioRecogida.setHorario((String) uic.getAttributes().get("horarioRecogida"));
        Horario_TO horarioEntrega = new Horario_TO();
        horarioEntrega.setHorario((String) o);

        horarioEntrega = horarioDao.consultarHorario(horarioEntrega);
        horarioRecogida = horarioDao.consultarHorario(horarioRecogida);

        //Obtenemos los valores de cada variable desde el contexto de la vista
        try {
            fechaEntrega = sdf.parse(sdf.format((Date) uic.getAttributes().get("fechaEntrega")));
            fechaRecogida = sdf.parse(sdf.format((Date) uic.getAttributes().get("fechaRecogida")));
            horaRecogida = sdft.parse(horarioRecogida.getHoraInicio());
            horaEntrega = sdft.parse(horarioEntrega.getHoraInicio());

            fechaActual = sdf.parse(sdf.format(fechaHoraActual));
            HoraActual = sdft.parse(sdft.format(fechaHoraActual));
        } catch (ParseException e) {
            e.getMessage();
        }

        //Evaluamos las fechas y horas
        if (!fechaRecogida.equals(fechaActual)) {
            if (fechaRecogida.after(fechaActual)) {
                if (!fechaEntrega.equals(fechaRecogida)) {
                    if (fechaEntrega.before(fechaRecogida)) {
                        FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de entrega de su pedido debe ser minimo un dia despues de la fecha de recogida");
                        throw new ValidatorException(fmsg);
                    } else if (fechaEntrega.after(fechaRecogida)) {

                        Calendar calHoraRecogida = Calendar.getInstance();
                        calHoraRecogida.setTime(horaRecogida);
                        Calendar calHoraEntrega = Calendar.getInstance();
                        calHoraEntrega.setTime(horaEntrega);
                        Calendar calFechaRecogida = Calendar.getInstance();
                        calFechaRecogida.setTime(fechaRecogida);
                        Calendar calFechaEntrega = Calendar.getInstance();
                        calFechaEntrega.setTime(fechaEntrega);

                        // conseguir la representacion de la fecha en milisegundos
                        milis1 = calFechaRecogida.getTimeInMillis();
                        milis2 = calFechaEntrega.getTimeInMillis();

                        // calcular la diferencia en dias
                        long diff = milis2 - milis1;
                        long diffDays = diff / (24 * 60 * 60 * 1000);

                        milis1 = calHoraRecogida.getTimeInMillis();
                        milis2 = calHoraEntrega.getTimeInMillis();

                        long diffHourDifferentDay;

                        diff = milis1 - milis2;
                        diffHourDifferentDay = (diffDays * 24) - (diff / (60 * 60 * 1000));

                        if (diffHourDifferentDay < 24) {
                            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El tiempo entre fechas de recogida y entrega debe ser de 24 horas minimos");
                            throw new ValidatorException(fmsg);
                        }
                    }
                } else {
                    FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de entrega de su pedido debe ser minimo un dia despues de la fecha de recogida");
                    throw new ValidatorException(fmsg);
                }
            } else if (fechaEntrega.before(fechaActual)) {
                FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La fecha de recogida es anterior a la fecha actual");
                throw new ValidatorException(fmsg);
            }
        } else {
            if (horaRecogida.before(HoraActual)) {
                FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La hora de recogida del pedido es menor a la hora actual");
                throw new ValidatorException(fmsg);
            } else if (horaRecogida.after(HoraActual)) {
                Calendar calHoraRecogida = Calendar.getInstance();
                calHoraRecogida.setTime(horaRecogida);
                Calendar calHoraEntrega = Calendar.getInstance();
                calHoraEntrega.setTime(horaEntrega);
                Calendar calFechaRecogida = Calendar.getInstance();
                calFechaRecogida.setTime(fechaRecogida);
                Calendar calFechaEntrega = Calendar.getInstance();
                calFechaEntrega.setTime(fechaEntrega);

                // conseguir la representacion de la fecha en milisegundos
                milis1 = calFechaRecogida.getTimeInMillis();
                milis2 = calFechaEntrega.getTimeInMillis();

                // calcular la diferencia en dias
                long diff = milis2 - milis1;
                long diffDays = diff / (24 * 60 * 60 * 1000);

                milis1 = calHoraRecogida.getTimeInMillis();
                milis2 = calHoraEntrega.getTimeInMillis();

                long diffHourDifferentDay;

                diff = milis1 - milis2;
                diffHourDifferentDay = (diffDays * 24) - (diff / (60 * 60 * 1000));

                if (diffHourDifferentDay < 24) {
                    FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El tiempo entre fechas de recogida y entrega debe ser de 24 horas minimos");
                    throw new ValidatorException(fmsg);
                }
            }
        }
    }
}
