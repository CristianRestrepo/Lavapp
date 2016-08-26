/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.planit.lavappweb.modelo.dto.Barrio_TO;
import com.planit.lavappweb.modelo.dto.Estrato_TO;
import com.planit.lavappweb.modelo.dto.Localidad_TO;
import com.planit.lavappweb.modelo.dto.Zona_TO;
import com.planit.lavappweb.webservices.clientes.ClienteBuscarBarrios;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteConsultarBarrios;
import com.planit.lavappweb.webservices.clientes.ClienteEditarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteEliminarBarrio;
import com.planit.lavappweb.webservices.clientes.ClienteRegistrarBarrio;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Desarrollo_Planit
 */
public class BarriosDao {

    public Barrio_TO registrarBarrio(Barrio_TO barrio) {
        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        barrio.setEstrato(ed.consultarEstrato(barrio.getEstrato()));
        barrio.setLocalidad(ld.consultarLocalidad(barrio.getLocalidad()));
        barrio.setZona(zd.consultarZona(barrio.getZona()));

        ClienteRegistrarBarrio cliente = new ClienteRegistrarBarrio();
        return cliente.registrarBarrio(Barrio_TO.class, barrio.getNombre(),
                "" + barrio.getLocalidad().getIdLocalidad(),
                "" + barrio.getZona().getIdZona(),
                "" + barrio.getEstrato().getIdEstrato());
    }

    public Barrio_TO modificarBarrio(Barrio_TO barrio) {

        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        barrio.setEstrato(ed.consultarEstrato(barrio.getEstrato()));
        barrio.setLocalidad(ld.consultarLocalidad(barrio.getLocalidad()));
        barrio.setZona(zd.consultarZona(barrio.getZona()));

        ClienteEditarBarrio cliente = new ClienteEditarBarrio();
        return cliente.modificarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios(),
                barrio.getNombre(),
                "" + barrio.getLocalidad().getIdLocalidad(),
                "" + barrio.getZona().getIdZona(),
                "" + barrio.getEstrato().getIdEstrato());
    }

    public Barrio_TO eliminarBarrio(Barrio_TO barrio) {
        ClienteEliminarBarrio cliente = new ClienteEliminarBarrio();
        return cliente.eliminarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios());
    }

    public Barrio_TO consultarBarrio(Barrio_TO barrio) {
        ClienteConsultarBarrio cliente = new ClienteConsultarBarrio();
        return cliente.consultarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios(),
                barrio.getNombre());
    }

    public List<Barrio_TO> buscarBarrio(String valor) {
        ClienteBuscarBarrios cliente = new ClienteBuscarBarrios();
        List<LinkedHashMap> datos = cliente.buscarBarrios(List.class, valor);
        List<Barrio_TO> barrios = new ArrayList<>();

        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap localidad = (LinkedHashMap) datos.get(i).get("localidad");
            LinkedHashMap zona = (LinkedHashMap) datos.get(i).get("zona");
            LinkedHashMap estrato = (LinkedHashMap) datos.get(i).get("estrato");
            barrios.add(new Barrio_TO((int) datos.get(i).get("idBarrios"),
                    (String) datos.get(i).get("nombre"),
                    ld.consultarLocalidad(new Localidad_TO((int) localidad.get("idLocalidad"), "")),
                    zd.consultarZona(new Zona_TO((int) zona.get("idZona"), "")),
                    ed.consultarEstrato(new Estrato_TO((int) estrato.get("idEstrato"), ""))));
        }
        return barrios;
    }

    public List<Barrio_TO> consultarBarrios() {
        ClienteConsultarBarrios cliente = new ClienteConsultarBarrios();
        List<LinkedHashMap> datos = cliente.consultarBarrios(List.class);
        List<Barrio_TO> barrios = new ArrayList<>();

        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        for (int i = 0; i < datos.size(); i++) {
            LinkedHashMap localidad = (LinkedHashMap) datos.get(i).get("localidad");
            LinkedHashMap zona = (LinkedHashMap) datos.get(i).get("zona");
            LinkedHashMap estrato = (LinkedHashMap) datos.get(i).get("estrato");
            barrios.add(new Barrio_TO((int) datos.get(i).get("idBarrios"),
                    (String) datos.get(i).get("nombre"),
                    ld.consultarLocalidad(new Localidad_TO((int) localidad.get("idLocalidad"), "")),
                    zd.consultarZona(new Zona_TO((int) zona.get("idZona"), "")),
                    ed.consultarEstrato(new Estrato_TO((int) estrato.get("idEstrato"), ""))));
        }
        return barrios;
    }

}
