/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dao;

import com.alignet.www.vposws20.Prueba;
import com.alignet.www.vposws20.VPOS20;
import com.planit.lavappweb.modelo.dto.Transaccion_TO;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize;
import com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VaioDevelopment
 */
public class TransaccionDao {

    public int realizarTransaccion(Transaccion_TO transaccion) {

        Authorize req = new Authorize();
        AuthorizeResponse reqResp = new AuthorizeResponse();

        int resultado = 0;
        req.setPurchaseData(transaccion.getPurchaseData());
        req.setCardData(transaccion.getCardData());
        req.setAcquirerId(transaccion.getAcquirerId());
        req.setCommerceId(Integer.parseInt(transaccion.getCommerceId()));
        req.setFingerprint(transaccion.getPurchaseData().getPurchaseCode());
        req.setFingerprint("00006");
        req.setLanguage(req.getLanguage());
        req.setIpAddress(req.getIpAddress());
        req.setBillingData(transaccion.getBilling());
        req.setShippingData(transaccion.getShipping());

        try {
            reqResp = VPOS20.authorize(req);
            resultado = reqResp.getResult();
        } catch (Throwable ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Result authorize: " + reqResp.getResult());
        System.out.println("ErrorCode: " + reqResp.getErrorCode());
        System.out.println("ErrorMessage: " + reqResp.getErrorMessage());
        System.out.println("AuthorizationCode: " + reqResp.getAuthorizationCode());
        return resultado;
    }
}
