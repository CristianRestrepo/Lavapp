package com.alignet.www.vposws20;

import java.io.IOException;
import java.util.Properties;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class ClientPWCBHandler implements CallbackHandler{
	
   public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
    	
   Properties myProperties = new Properties();
   myProperties.load(ClientPWCBHandler.class.getClassLoader().getResourceAsStream("COMKEYCONFIG.properties")); 
   
   
   for (int i = 0; i < callbacks.length; i++) {
    
    WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];
       
    if(pwcb.getIdentifier().equals("client cert") ) {
    	pwcb.setPassword(myProperties.getProperty("org.apache.ws.security.crypto.merlin.keystore.password")); 
        return;
     }  
    }
   
   throw new UnsupportedCallbackException(null, "Authentication CLIENT check failed!!.");  
  }
}
