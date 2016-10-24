/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.HorarioDao;
import com.planit.lavappweb.modelo.dto.Horario_TO;
import java.io.Serializable;
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
public class HorarioCT implements Serializable {

    //Variables
    private Horario_TO horario;
    private List<Horario_TO> horarios;

    private String horainicio;
    private String minutoinicio;

    private String horafinal;
    private String minutofinal;

    private List<String> horas;
    private List<String> minutos;

    private String nombreOperacion;
    protected int operacion; //Controla la operacion a ejecutar

    private String buscar;

    //Constructores
    public HorarioCT() {
        horario = new Horario_TO();
        horarios = new ArrayList<>();
        nombreOperacion = "Registrar";
        operacion = 0;

        //Inicializacion de las variables para registro de horas y minutos
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";

        horas = new ArrayList<>();
        minutos = new ArrayList<>();
        buscar = null;
    }

    @PostConstruct
    public void init() {
        HorarioDao horarioDao = new HorarioDao();
        horarios = horarioDao.consultarHorarios();
        cargarhoras();
        cargarminutos();
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    //Metodos
    public void registrar() {

        HorarioDao horarioDao = new HorarioDao();
        //Setea la hora de inicio y fin concatenando los string de hora y minutos
        horario.setHoraInicio(horainicio + ":" + minutoinicio);
        horario.setHoraFinal(horafinal + ":" + minutofinal);
        //Setea el horario concatenando la hora de inicio y final
        horario.setHorario("" + horario.getHoraInicio() + "-" + horario.getHoraFinal());

        horario = horarioDao.registrarHorario(horario);
        horarios = horarioDao.consultarHorarios();

        //Reiniciamos los valores para un nuevo registro
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
    }

    public void modificar() {

        HorarioDao horarioDao = new HorarioDao();
        horario.setHoraInicio(horainicio + ":" + minutoinicio);
        horario.setHoraFinal(horafinal + ":" + minutofinal);
        horario.setHorario("" + horario.getHoraInicio() + "-" + horario.getHoraFinal());

        horario = horarioDao.editarHorario(horario);
        horarios = horarioDao.consultarHorarios();

        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
    }

    public void eliminar() {
        HorarioDao horarioDao = new HorarioDao();
        horario = horarioDao.eliminarHorario(horario);
        horarios = horarioDao.consultarHorarios();
    }

    public void cargarhoras() {
        //Carga a la lista 'horas' las 24 horas del dia
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
        //Carga a la lista 'minutos' los 60 munitos que componen una hora 
        minutos = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                minutos.add("0" + i);
            } else {
                minutos.add("" + i);
            }
        }
    }

    //Metodos Propios
    public void metodo() {
        //segun el valor de la bandera operacion valida que operacion se realiza, ya sea modificacion o registro
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
        //Setea un valor en la variable operacion para determinar que funcion realizara proximamente
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
            SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
            Date HI = dt.parse(horario.getHoraInicio());
            Date HF = dt.parse(horario.getHoraFinal());

            //Valida las horas y los minutos del horario seleccionado y rearma los string segun el valor que tengan
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
        }
    }

    public void cancelar() {
        //reinicia los valores de las variables y vuelve a 0 la bandera operacion
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";

        horario = new Horario_TO();
        operacion = 0;
        nombreOperacion = "Registrar";
    }

    public void buscarHorario() {
        //filtra la lista de barrios segun el valor que se consulte, si valor es vacio consulta todos los barrios
        HorarioDao horarioDao = new HorarioDao();
        horarios = new ArrayList<>();
        if (buscar.isEmpty()) {
            horarios = horarioDao.consultarHorarios();
        } else {
            horarios = horarioDao.buscarBarrios(buscar);
        }
    }
}
