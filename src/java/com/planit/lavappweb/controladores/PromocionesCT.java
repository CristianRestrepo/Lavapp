/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelo.dao.PromocionDao;
import com.planit.lavappweb.modelo.dto.Promocion_TO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionesCT {

    private Promocion_TO promocion = new Promocion_TO();
    private List<Promocion_TO> promociones = new ArrayList<>();

    private int operacion;
    private String nombreOperacion;
    private String buscar;

    private String horainicio;
    private String minutoinicio;

    private String horafinal;
    private String minutofinal;

    public PromocionesCT() {
        promocion = new Promocion_TO();
        promociones = new ArrayList<>();

        nombreOperacion = "Registrar";

        //Inicializacion de las variables para registro de horas y minutos
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
    }

    @PostConstruct
    public void init() {
        PromocionDao promocionDao = new PromocionDao();
        promociones = promocionDao.consultarPromociones();

    }

    public Promocion_TO getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion_TO promocion) {
        this.promocion = promocion;
    }

    public List<Promocion_TO> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion_TO> promociones) {
        this.promociones = promociones;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
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

    //Metodos
    public void registrar() {
        promocion.setHoraInicio(horainicio + ":" + minutoinicio);
        promocion.setHorafinal(horafinal + ":" + minutofinal);

        PromocionDao promocionDao = new PromocionDao();
        promocionDao.registrarPromocion(promocion);
        promocion = new Promocion_TO();
        promociones = promocionDao.consultarPromociones();

        //Inicializacion de las variables para registro de horas y minutos
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
    }

    public void modificar() {
        promocion.setHoraInicio(horainicio + ":" + minutoinicio);
        promocion.setHorafinal(horafinal + ":" + minutofinal);

        PromocionDao promocionDao = new PromocionDao();
        promocionDao.modificarPromocion(promocion);
        promocion = new Promocion_TO();
        promociones = promocionDao.consultarPromociones();

        //Inicializacion de las variables para registro de horas y minutos
        horainicio = "00";
        minutoinicio = "00";

        horafinal = "00";
        minutofinal = "00";
    }

    public void eliminar() {
        PromocionDao promocionDao = new PromocionDao();
        promocionDao.eliminarPromocion(promocion);
        promocion = new Promocion_TO();
        promociones = promocionDao.consultarPromociones();
    }

    //Metodos
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
            Date HI = dt.parse(promocion.getHoraInicio());
            Date HF = dt.parse(promocion.getHorafinal());

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
        PromocionDao promocionDao = new PromocionDao();
        promocion = new Promocion_TO();    
        promociones = promocionDao.consultarPromociones();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
