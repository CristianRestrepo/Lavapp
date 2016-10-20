package com.alignet.www.vposws20;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.description.Parameter;
import org.apache.rampart.handler.WSSHandlerConstants;
import org.apache.rampart.handler.config.InflowConfiguration;
import org.apache.rampart.handler.config.OutflowConfiguration;

import com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class VPOS20 {

    public static AuthorizeResponse authorize(Authorize request) throws IOException, Throwable {

        Properties myProperties = new Properties();
        myProperties.load(VPOS20.class.getClassLoader().getResourceAsStream("COMKEYCONFIG.properties"));
        String urlService = myProperties.getProperty("com.alignet.www.vpos2.services.vposws20soap.url");

        VPOSWS20SOAPStub.Authorize req = request;
        VPOSWS20SOAPStub.AuthorizeResponse reqResp = new AuthorizeResponse();

        try {

            	ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("resources/", null);
         //   URL repositoy = new URL("http://10.0.2.2:8084/Pagos/resources/modules");
            
         //   repositoy.openStream();

         //   try {
                // Volcamos lo recibido al buffer
       //         BufferedReader in = new BufferedReader(new InputStreamReader(repositoy.openStream()));
      //      } catch (Throwable t) {
       //     }

         //   ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromURIs(null, repositoy);

           
            VPOSWS20SOAPStub serviceVPOSWS = new VPOSWS20SOAPStub(ctx, urlService);

            try {

                ServiceClient client = serviceVPOSWS._getServiceClient();

                Options clientOptions = new Options();
                clientOptions.setTo(new EndpointReference(urlService));
                clientOptions.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

                client.engageModule("rampart");

                System.out.println("ruta4: " + client.getServiceContext());

                clientOptions.setProperty(WSSHandlerConstants.OUTFLOW_SECURITY, getOutflowConfiguration());
                clientOptions.setProperty(WSSHandlerConstants.INFLOW_SECURITY, getInflowConfiguration());
                clientOptions.setTimeOutInMilliSeconds(Long.parseLong(myProperties.getProperty("com.alignet.www.vpos2.services.vposws20.time.out.client")));
                client.setOptions(clientOptions);

                serviceVPOSWS._setServiceClient(client);

                reqResp = serviceVPOSWS.authorize(req);

            } catch (RemoteException e) {
                e.printStackTrace();
                if (e.getCause() == null) {
                    System.out.println("*No existe conexi�n con el servidor...");
                } else if (e.getCause().getMessage().equals("Read timed out")) {
                    System.out.println("*Error de timeout.");
                } else {
                    System.out.println("Se produjo una excepci�n en la petici�n del servicio.");
                }
            }
        } catch (AxisFault e1) {
            e1.printStackTrace();
        }

        return reqResp;
    }

    public static ReverseResponse reserve(Reverse request) throws IOException, Throwable {

        Properties myProperties = new Properties();
        myProperties.load(VPOS20.class.getClassLoader().getResourceAsStream("COMKEYCONFIG.properties"));
        String urlService = myProperties.getProperty("com.alignet.www.vpos2.services.vposws20soap.url");

        VPOSWS20SOAPStub.Reverse req = request;
        VPOSWS20SOAPStub.ReverseResponse reqResp = new ReverseResponse();

        try {

            ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("resources/", null);

            // URL repositoy = new URL("http://192.168.100.251:8080/LavappService/webresources/consultarCiudades");
            //  ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromURIs(null, repositoy);
            System.out.println("ruta2: " + ctx);

            VPOSWS20SOAPStub serviceVPOSWS = new VPOSWS20SOAPStub(ctx, urlService);

            try {

                ServiceClient client = serviceVPOSWS._getServiceClient();

                Options clientOptions = new Options();
                clientOptions.setTo(new EndpointReference(urlService));
                clientOptions.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

                client.engageModule("rampart");

                clientOptions.setProperty(WSSHandlerConstants.OUTFLOW_SECURITY, getOutflowConfiguration());
                clientOptions.setProperty(WSSHandlerConstants.INFLOW_SECURITY, getInflowConfiguration());
                clientOptions.setTimeOutInMilliSeconds(Long.parseLong(myProperties.getProperty("com.alignet.www.vpos2.services.vposws20.time.out.client")));
                client.setOptions(clientOptions);

                serviceVPOSWS._setServiceClient(client);

                reqResp = serviceVPOSWS.reverse(req);

            } catch (RemoteException e) {
                e.printStackTrace();
                if (e.getCause() == null) {
                    System.out.println("*No existe conexi�n con el servidor...");
                } else if (e.getCause().getMessage().equals("Read timed out")) {
                    System.out.println("*Error de timeout.");
                } else {
                    System.out.println("Se produjo una excepci�n en la petici�n del servicio.");
                }
            }
        } catch (AxisFault e1) {
            e1.printStackTrace();
        }

        return reqResp;
    }

    private static Parameter getOutflowConfiguration() {
        OutflowConfiguration ofc = new OutflowConfiguration();
        ofc.setActionItems("Signature Encrypt Timestamp");
        ofc.setSignaturePropFile("COMKEYCONFIG.properties");
        ofc.setSignatureKeyIdentifier("X509KeyIdentifier");
        ofc.setUser("client cert");
        ofc.setPasswordCallbackClass("com.alignet.www.vposws20.ClientPWCBHandler");

        ofc.setEncryptionPropFile("COMKEYCONFIG.properties");
        ofc.setEncryptionUser("vposwscrypto");
        ofc.setEncryptionKeyIdentifier("X509KeyIdentifier");

        return ofc.getProperty();
    }

    private static Parameter getInflowConfiguration() {
        InflowConfiguration ifc = new InflowConfiguration();
        ifc.setActionItems("Signature Timestamp");
        ifc.setSignaturePropFile("COMKEYCONFIG.properties");
        ifc.setPasswordCallbackClass("com.alignet.www.vposws20.ClientPWCBHandler");

        return ifc.getProperty();
    }

}
