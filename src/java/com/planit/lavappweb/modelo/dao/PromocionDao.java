/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Promocion_TO;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPromocion;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarPromociones;
import com.planit.lavappweb.webservices.clientes.ClienteEditarPromocion;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarPromocion;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarPromocion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionDao {

    public List<Promocion_TO> consultarPromociones() {
        ClienteConsultarPromociones cliente = new ClienteConsultarPromociones();
        List<HashMap> datos = cliente.consultarPromociones(List.class);
        List<Promocion_TO> promociones = new ArrayList<>();

        for (int i = 0; i < datos.size(); i++) {
            promociones.add(new Promocion_TO((int) datos.get(i).get("idPromocion"),
                    (Date) datos.get(i).get("fechaInicio"),
                    (Date) datos.get(i).get("fechaFinal"),
                    (int) datos.get(i).get("porcentaje"),
                    (String) datos.get(i).get("horaInicio"),
                    (String) datos.get(i).get("horafinal"),
                    (String) datos.get(i).get("nombre")));
        }
        return promociones;
    } 

    public Promocion_TO consultarPromocion(Promocion_TO promocion) {
        ClienteConsultarPromocion cliente = new ClienteConsultarPromocion();
        return cliente.consultarPromocion(Promocion_TO.class, "" + promocion.getIdPromocion(), promocion.getNombre());
    }

    public void registrarPromocion(Promocion_TO promocion) {
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        ClienteRegistrarPromocion cliente = new ClienteRegistrarPromocion();
        cliente.registrarPromocion(Promocion_TO.class,
                formatoDeFecha.format(promocion.getFechaInicio()),
                formatoDeFecha.format(promocion.getFechaFinal()),
                "" + promocion.getPorcentaje(),
                promocion.getHoraInicio(),
                promocion.getHorafinal(),
                promocion.getNombre());
    }

    public void modificarPromocion(Promocion_TO promocion) {
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        ClienteEditarPromocion cliente = new ClienteEditarPromocion();
        cliente.modificarPromocion(Promocion_TO.class,
                "" + promocion.getIdPromocion(),
                formatoDeFecha.format(promocion.getFechaInicio()),
                formatoDeFecha.format(promocion.getFechaFinal()),
                "" + promocion.getPorcentaje(),
                promocion.getHoraInicio(),
                promocion.getHorafinal(),
                promocion.getNombre());
    }

    public void eliminarPromocion(Promocion_TO promocion) {
        ClienteEliminarPromocion cliente = new ClienteEliminarPromocion();
        cliente.eliminarPromocion(Promocion_TO.class, "" + promocion.getIdPromocion());
    }
}
