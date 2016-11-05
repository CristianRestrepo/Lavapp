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
    
    VPOSWS20SOAPStub.AddressData addressData;
    
    VPOSWS20SOAPStub.Person billing;
    
    ShippingData shipping;

    public Transaccion_TO() {
        purchaseData = new VPOSWS20SOAPStub.PurchaseData();
        cardData = new VPOSWS20SOAPStub.CardData();
        addressData = new VPOSWS20SOAPStub.AddressData();
        billing = new VPOSWS20SOAPStub.Person();
        shipping = new ShippingData();
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

    @Override
    public String toString() {
        return "Transaccion_TO{" + "purchaseData=" + purchaseData + ", cardData=" + cardData + ", addressData=" + addressData + ", billing=" + billing + ", shipping=" + shipping + '}';
    }        
}
    
