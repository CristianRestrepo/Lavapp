/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import com.alignet.www.vposws20.VPOSWS20SOAPStub;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.ShippingData;

/**
 *
 * @author VaioDevelopment
 */
public class Transaccion_TO {

    private VPOSWS20SOAPStub.PurchaseData purchaseData;
    private VPOSWS20SOAPStub.CardData cardData;
    private VPOSWS20SOAPStub.AddressData addressData;
    private VPOSWS20SOAPStub.Person billing;
    private ShippingData shipping;

    private String commerceId;
    private int acquirerId;
    private String language;
    private String ipAddress;

    public Transaccion_TO() {
        commerceId = "1774";
        acquirerId = 1;
        language = "SP";
        ipAddress = "127.0.0.1";

        purchaseData = new VPOSWS20SOAPStub.PurchaseData();
        cardData = new VPOSWS20SOAPStub.CardData();
        addressData = new VPOSWS20SOAPStub.AddressData();
        billing = new VPOSWS20SOAPStub.Person();
        shipping = new ShippingData();

        purchaseData.setCurrencyCode(170);
        purchaseData.setPlanId(01);
        purchaseData.setTerminalCode("00031329");

        cardData.setAccountTypeId(01);
        cardData.setSecurityCode("130");
        cardData.setFinancialId(0);

        addressData.setCountryCode("CO");
        addressData.setState("CM");

        billing.setNationality("CO");
    }

    public VPOSWS20SOAPStub.PurchaseData getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(VPOSWS20SOAPStub.PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }

    public VPOSWS20SOAPStub.CardData getCardData() {
        return cardData;
    }

    public void setCardData(VPOSWS20SOAPStub.CardData cardData) {
        this.cardData = cardData;
    }

    public VPOSWS20SOAPStub.AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(VPOSWS20SOAPStub.AddressData addressData) {
        this.addressData = addressData;
    }

    public VPOSWS20SOAPStub.Person getBilling() {
        return billing;
    }

    public void setBilling(VPOSWS20SOAPStub.Person billing) {
        this.billing = billing;
    }

    public ShippingData getShipping() {
        return shipping;
    }

    public void setShipping(ShippingData shipping) {
        this.shipping = shipping;
    }

    public String getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(String commerceId) {
        this.commerceId = commerceId;
    }

    public int getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(int acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Transaccion_TO{" + "purchaseData=" + purchaseData + ", cardData=" + cardData + ", addressData=" + addressData + ", billing=" + billing + ", shipping=" + shipping + '}';
    }
}
