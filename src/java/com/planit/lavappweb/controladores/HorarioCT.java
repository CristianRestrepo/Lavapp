/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.HorarioDao;
import com.planit.lavappweb.modelo.dto.Horario_TO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class HorarioCT {

    private Horario_TO horario;
    private List<Horario_TO> horarios;

    private String horainicio;
    private String minutoinicio;
    private String segundoinicio;

    private String horafinal;
    private String minutofinal;
    private String segundofinal;

    private List<String> horas;
    private List<String> minutos;
    private List<String> segundos;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar

    private String buscar;

    public HorarioCT() {
        horario = new Horario_TO();
        horarios = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;

        horainicio = "00";
        minutoinicio = "00";
        segundoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
        segundofinal = "00";

        horas = new ArrayList<>();
        minutos = new ArrayList<>();
        segundos = new ArrayList<>();

        buscar = null;
    }

    @PostConstruct
    public void init() {
        HorarioDao horarioDao = new HorarioDao();
        horarios = horarioDao.consultarHorarios();
        cargarhoras();
        cargarminutos();
        cargarsegundos();
    }

    //Getter & Setter
    public Horario_TO getHorario() {
        return horario;
    }

    public void setHorario(Horario_TO horario) {
        this.horario = horario;
    }

    public List<Horario_TO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario_TO> horarios) {
        this.horarios = horarios;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    public List<String> getMinutos() {
        return minutos;
    }

    public void setMinutos(List<String> minutos) {
        this.minutos = minutos;
    }

    public List<String> getSegundos() {
        return segundos;
    }

    public void setSegundos(List<String> segundos) {
        this.segundos = segundos;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getMinutoinicio() {
        return minutoinicio;
    }

    public void setMinutoinicio(String minutoinicio) {
        this.minutoinicio = minutoinicio;
    }

    public String getSegundoinicio() {
        return segundoinicio;
    }

    public void setSegundoinicio(String segundoinicio) {
        this.segundoinicio = segundoinicio;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }

    public String getMinutofinal() {
        return minutofinal;
    }

    public void setMinutofinal(String minutofinal) {
        this.minutofinal = minutofinal;
    }

    public String getSegundofinal() {
        return segundofinal;
    }

    public void setSegundofinal(String segundofinal) {
        this.segundofinal = segundofinal;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos
    public void registrar() {

        HorarioDao horarioDao = new HorarioDao();
        horario.setHoraInicio(horainicio + ":" + minutoinicio + ":" + segundoinicio);
        horario.setHoraFinal(horafinal + ":" + minutofinal + ":" + segundofinal);
        horario.setHorario("" + horario.getHoraInicio() + "-" + horario.getHoraFinal());

        horario = horarioDao.registrarHorario(horario);
        horarios = horarioDao.consultarHorarios();

        horainicio = "00";
        minutoinicio = "00";
        segundoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
        segundofinal = "00";
    }

    public void modificar() {
        
        HorarioDao horarioDao = new HorarioDao();
        horario.setHoraInicio(horainicio + ":" + minutoinicio + ":" + segundoinicio);
        horario.setHoraFinal(horafinal + ":" + minutofinal + ":" + segundofinal);
        horario.setHorario("" + horario.getHoraInicio() + "-" + horario.getHoraFinal());
        
        horario = horarioDao.registrarHorario(horario);
        horarios = horarioDao.consultarHorarios();

        horainicio = "00";
        minutoinicio = "00";
        segundoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
        segundofinal = "00";
    }

    public void eliminar() {
        HorarioDao horarioDao = new HorarioDao();
        horario = horarioDao.eliminarHorario(horario);
        horarios = horarioDao.consultarHorarios();
    }

    public void cargarhoras() {
        horas = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                horas.add("0" + i);
            } else {
                horas.add("" + i);
            }
        }
    }

    public void cargarminutos() {
        minutos = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                minutos.add("0" + i);
            } else {
                minutos.add("" + i);
            }
        }
    }

    public void cargarsegundos() {
        segundos = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                segundos.add("0" + i);
            } else {
                segundos.add("" + i);
            }
        }
    }

    //Metodos Propios
    public void metodo() {
        if (operacion == 0) {
            registrar();
        } else if (operacion == 1) {
            modificar();
            //Reiniciamos banderas          
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) throws ParseException {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
            SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
            Date HI = dt.parse(horario.getHoraInicio());
            Date HF = dt.parse(horario.getHoraFinal());

            if (HI.getHours() < 10) {
                horainicio = "0" + HI.getHours();
            } else {
                horainicio = "" + HI.getHours();
            }

            if (HI.getMinutes() < 10) {
                minutoinicio = "0" + HI.getMinutes();
            } else {
                minutoinicio = "" + HI.getMinutes();
            }

            if (HI.getSeconds() < 10) {
                segundoinicio = "0" + HI.getSeconds();
            } else {
                segundoinicio = "" + HI.getSeconds();
            }

            if (HF.getHours() < 10) {
                horafinal = "0" + HF.getHours();
            } else {
                horafinal = "" + HF.getHours();
            }

            if (HF.getMinutes() < 10) {
                minutofinal = "0" + HF.getMinutes();
            } else {
                minutofinal = "" + HF.getMinutes();
            }

            if (HF.getSeconds() < 10) {
                segundofinal = "0" + HF.getSeconds();
            } else {
                segundofinal = "" + HF.getSeconds();
            }
        }
    }

    public void cancelar() {
        horainicio = "00";
        minutoinicio = "00";
        segundoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
        segundofinal = "00";

        horario = new Horario_TO();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarHorario() {
        HorarioDao horarioDao = new HorarioDao();
        horarios = new ArrayList<>();
        if (buscar == null) {
            horarios = horarioDao.consultarHorarios();
        } else {
            horarios = horarioDao.buscarBarrios(buscar);
        }
    }
}
