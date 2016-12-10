package com.alignet.www.vposws20;

import com.alignet.www.vposws20.VPOSWS20SOAPStub.AddressData;
import java.io.IOException;

import com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.CardData;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.PurchaseData;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.Person;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.ShippingData;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {

    public Prueba() {
    }

    /**
     * @param args
     * @throws Throwable
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, Throwable {

        realizarLosPagos();

    }

    public static void realizarLosPagos() {

        //agregar la ip, fingerprint, 
        String commerceId = "1774";
        int acquirerId = 1;
        String language = "SP";
        String ipAddress = "127.0.0.1";

        PurchaseData purchaseData = new PurchaseData();
        purchaseData.setCurrencyCode(170);
        purchaseData.setPurchaseCode("00756");
        purchaseData.setPlanId(01);
        purchaseData.setQuotaId(012);
        purchaseData.setTotalAmount("100000");
        purchaseData.setTerminalCode("00031329");
        purchaseData.setIva("10000");

        CardData cardData = new CardData();
        cardData.setAccountTypeId(01);
        cardData.setBrand("VISA");
        cardData.setExpiryMonth(12);
        cardData.setExpiryYear(2018);
        cardData.setNumber("4005580000050003");
        cardData.setSecurityCode("130");
        cardData.setFinancialId(0);

        AddressData addressData = new AddressData();

        addressData.setAddress("Calle 70 # 7-30");
        addressData.setCity("Bogotá");
        addressData.setCountryCode("CO");
        addressData.setState("CM");
        addressData.setPhoneNumber("3151111111");
        addressData.setCellPhoneNumber("3152222222");
        addressData.setPostalCode("110911");
        addressData.setEmail("gcardenas.planit@gmail.com");

        // metodo autorizar - BillingData
        Person billing = new Person();

        billing.setNames("Johan");
        billing.setLastNames("Cannon");
        billing.setGender("M");
        billing.setNumberIdentifier("963852741");
        billing.setNationality("CO");
        billing.setAddress(addressData);

        System.out.println("direccion-----------------------: " + billing.getAddress().getAddress());

        ShippingData shipping = new ShippingData();

        shipping.setAddress(addressData);
        shipping.setNames("Johan");
        shipping.setLastNames("Cannon");
        shipping.setNumberIdentifier("963852741");
        
        Authorize req = new Authorize();
        AuthorizeResponse reqResp = new AuthorizeResponse();
        
        req.setPurchaseData(purchaseData);
        req.setCardData(cardData);
        req.setAcquirerId(acquirerId);
        req.setCommerceId(Integer.parseInt(commerceId));
        req.setFingerprint(purchaseData.getPurchaseCode());
        req.setFingerprint("00006");
        req.setLanguage(language);
        req.setIpAddress(ipAddress);
        req.setBillingData(billing);
        req.setShippingData(shipping);

        try {
            reqResp = VPOS20.authorize(req);
        } catch (Throwable ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Result authorize: " + reqResp.getResult());
        System.out.println("ErrorCode: " + reqResp.getErrorCode());
        System.out.println("ErrorMessage: " + reqResp.getErrorMessage());
        System.out.println("AuthorizationCode: " + reqResp.getAuthorizationCode());
    }

}
