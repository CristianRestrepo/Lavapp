
/**
 * VPOSWS20SOAPCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */

    package com.alignet.www.vposws20;

    /**
     *  VPOSWS20SOAPCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VPOSWS20SOAPCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VPOSWS20SOAPCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VPOSWS20SOAPCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for authorize method
            * override this method for handling normal response from authorize operation
            */
           public void receiveResultauthorize(
                    com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authorize operation
           */
            public void receiveErrorauthorize(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reverse method
            * override this method for handling normal response from reverse operation
            */
           public void receiveResultreverse(
                    com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reverse operation
           */
            public void receiveErrorreverse(java.lang.Exception e) {
            }
                


    }
    