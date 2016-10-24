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

        //consultamos los objetos incluidos dentro de la clase barrio
        barrio.setEstrato(ed.consultarEstrato(barrio.getEstrato()));
        barrio.setLocalidad(ld.consultarLocalidad(barrio.getLocalidad()));
        barrio.setZona(zd.consultarZona(barrio.getZona()));

        //Se crea una instacia del cliente del web service registrar barrio
        ClienteRegistrarBarrio cliente = new ClienteRegistrarBarrio();
        //Retorna el resultado del metodo registrar barrio
        return cliente.registrarBarrio(Barrio_TO.class, barrio.getNombre(),
                "" + barrio.getLocalidad().getIdLocalidad(),
                "" + barrio.getZona().getIdZona(),
                "" + barrio.getEstrato().getIdEstrato());
    }

    public Barrio_TO modificarBarrio(Barrio_TO barrio) {

        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        //consultamos los objetos incluidos dentro de la clase barrio
        barrio.getEstrato().setIdEstrato(0);
        barrio.setEstrato(ed.consultarEstrato(barrio.getEstrato()));
        barrio.getLocalidad().setIdLocalidad(0);
        barrio.setLocalidad(ld.consultarLocalidad(barrio.getLocalidad()));
        barrio.getZona().setIdZona(0);
        barrio.setZona(zd.consultarZona(barrio.getZona()));

        //Se crea una instacia del cliente del web service editar barrio
        ClienteEditarBarrio cliente = new ClienteEditarBarrio();
        //Retorna el resultado del metodo editar barrio
        return cliente.modificarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios(),
                barrio.getNombre(),
                "" + barrio.getLocalidad().getIdLocalidad(),
                "" + barrio.getZona().getIdZona(),
                "" + barrio.getEstrato().getIdEstrato());
    }

    public Barrio_TO eliminarBarrio(Barrio_TO barrio) {
        //Se crea una instacia del cliente del web service eliminar barrio
        ClienteEliminarBarrio cliente = new ClienteEliminarBarrio();
        //Retorna el resultado del metodo eliminar barrio 
        return cliente.eliminarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios());
    }

    public Barrio_TO consultarBarrio(Barrio_TO barrio) {
        //Se crea una instacia del cliente del web service consultar barrio
        ClienteConsultarBarrio cliente = new ClienteConsultarBarrio();
        //Retorna el resultado del metodo consultar barrio
        return cliente.consultarBarrio(Barrio_TO.class, "" + barrio.getIdBarrios(),
                barrio.getNombre());
    }

    public List<Barrio_TO> buscarBarrio(String valor) {
        ClienteBuscarBarrios cliente = new ClienteBuscarBarrios();
        List<LinkedHashMap> datos = cliente.buscarBarrios(List.class, valor);//guardamos en la lista datos el resultado del metodo buscar barrios
        List<Barrio_TO> barrios = new ArrayList<>();
        
        //instancias de los dao necesarios para rearmar un objeto barrio
        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();
        
        for (int i = 0; i < datos.size(); i++) {
            //el web service retorna una lista de objetos haspmap, rearmamos los datos extrayendo cada elemento que compone cada objeto barrio
            //segun la cantidad de datos retornados por el metodo del web service
            LinkedHashMap localidad = (LinkedHashMap) datos.get(i).get("localidad");
            LinkedHashMap zona = (LinkedHashMap) datos.get(i).get("zona");
            LinkedHashMap estrato = (LinkedHashMap) datos.get(i).get("estrato");
            //agregamos a la lista de barrios cada objeto barrio rearmado
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

        //instancias de los dao necesarios para rearmar un objeto barrio
        LocalidadDao ld = new LocalidadDao();
        ZonaDao zd = new ZonaDao();
        EstratoDao ed = new EstratoDao();

        //el web service retorna una lista de objetos haspmap, rearmamos los datos extrayendo cada elemento que compone cada objeto barrio
        //segun la cantidad de datos retornados por el metodo del web service
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
