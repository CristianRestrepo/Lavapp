/**
 * VPOSWS20SOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
package com.alignet.www.vposws20;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axis2.databinding.ADBException;

/*
 *  VPOSWS20SOAPStub java implementation
 */

public class VPOSWS20SOAPStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(System.currentTimeMillis()) + "_"
				+ counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("VPOSWS20SOAP"
				+ getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "authorize"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "reverse"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

	}

	// populates the faults
	private void populateFaults() {

	}

	/**
	 * Constructor that takes in a configContext
     * @param configurationContext
     * @param targetEndpoint
     * @throws org.apache.axis2.AxisFault
	 */

	public VPOSWS20SOAPStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public VPOSWS20SOAPStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener)
			throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(
				configurationContext, _service);

		_serviceClient.getOptions().setTo(
				new org.apache.axis2.addressing.EndpointReference(
						targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

	}

	/**
	 * Default Constructor
     * @param configurationContext
     * @throws org.apache.axis2.AxisFault
	 */
	public VPOSWS20SOAPStub(
			org.apache.axis2.context.ConfigurationContext configurationContext)
			throws org.apache.axis2.AxisFault {

		this(configurationContext,
				"http://localhost:8080/ServerVPOSWS2/services/VPOSWS20SOAP");

	}

	/**
	 * Default Constructor
     * @throws org.apache.axis2.AxisFault
	 */
	public VPOSWS20SOAPStub() throws org.apache.axis2.AxisFault {

		this("http://localhost:8080/ServerVPOSWS2/services/VPOSWS20SOAP");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public VPOSWS20SOAPStub(java.lang.String targetEndpoint)
			throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.alignet.www.vposws20.VPOSWS20SOAP#authorize
	 * @param authorize0
	 */

	public com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse authorize(

	com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize authorize0)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction(
					"http://www.alignet.com/VPOSWS20/authorize");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), authorize0,
					optimizeContent(new javax.xml.namespace.QName(
							"http://www.alignet.com/VPOSWS20/", "authorize")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender()
					.cleanup(_messageContext);
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.alignet.www.vposws20.VPOSWS20SOAP#startauthorize
	 * @param authorize0
	 */
	public void startauthorize(

	com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize authorize0,

	final com.alignet.www.vposws20.VPOSWS20SOAPCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction(
				"http://www.alignet.com/VPOSWS20/authorize");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), authorize0,
				optimizeContent(new javax.xml.namespace.QName(
						"http://www.alignet.com/VPOSWS20/", "authorize")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultauthorize((com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorauthorize(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap.containsKey(faultElt
										.getQName())) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(faultElt.getQName());
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.Exception ex = (java.lang.Exception) exceptionClass
												.newInstance();
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(faultElt.getQName());
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										callback.receiveErrorauthorize(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorauthorize(f);
									}
								} else {
									callback.receiveErrorauthorize(f);
								}
							} else {
								callback.receiveErrorauthorize(f);
							}
						} else {
							callback.receiveErrorauthorize(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorauthorize(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.alignet.www.vposws20.VPOSWS20SOAP#reverse
	 * @param reverse2
	 */

	public com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse reverse(

	com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse reverse2)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction(
					"http://www.alignet.com/VPOSWS20/reverse");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), reverse2,
					optimizeContent(new javax.xml.namespace.QName(
							"http://www.alignet.com/VPOSWS20/", "reverse")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender()
					.cleanup(_messageContext);
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.alignet.www.vposws20.VPOSWS20SOAP#startreverse
	 * @param reverse2
	 */
	public void startreverse(

	com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse reverse2,

	final com.alignet.www.vposws20.VPOSWS20SOAPCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction(
				"http://www.alignet.com/VPOSWS20/reverse");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), reverse2,
				optimizeContent(new javax.xml.namespace.QName(
						"http://www.alignet.com/VPOSWS20/", "reverse")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultreverse((com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorreverse(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap.containsKey(faultElt
										.getQName())) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(faultElt.getQName());
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.Exception ex = (java.lang.Exception) exceptionClass
												.newInstance();
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(faultElt.getQName());
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										callback.receiveErrorreverse(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorreverse(f);
									}
								} else {
									callback.receiveErrorreverse(f);
								}
							} else {
								callback.receiveErrorreverse(f);
							}
						} else {
							callback.receiveErrorreverse(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorreverse(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[1].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(
			org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
					.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// http://localhost:8080/ServerVPOSWS2/services/VPOSWS20SOAP

	public static class OrderWeb implements org.apache.axis2.databinding.ADBBean {

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Reference1
		 */

		protected java.lang.String localReference1;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference1Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference1() {
			return localReference1;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference1
		 */
		public void setReference1(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference1Tracker = true;
			} else {
				localReference1Tracker = false;

			}

			this.localReference1 = param;

		}

		/**
		 * field for Reference2
		 */

		protected java.lang.String localReference2;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference2Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference2() {
			return localReference2;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference2
		 */
		public void setReference2(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference2Tracker = true;
			} else {
				localReference2Tracker = false;

			}

			this.localReference2 = param;

		}

		/**
		 * field for Reference3
		 */

		protected java.lang.String localReference3;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference3Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference3() {
			return localReference3;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference3
		 */
		public void setReference3(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference3Tracker = true;
			} else {
				localReference3Tracker = false;

			}

			this.localReference3 = param;

		}

		/**
		 * field for Reference4
		 */

		protected java.lang.String localReference4;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference4Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference4() {
			return localReference4;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference4
		 */
		public void setReference4(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference4Tracker = true;
			} else {
				localReference4Tracker = false;

			}

			this.localReference4 = param;

		}

		/**
		 * field for Reference5
		 */

		protected java.lang.String localReference5;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference5Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference5() {
			return localReference5;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference5
		 */
		public void setReference5(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference5Tracker = true;
			} else {
				localReference5Tracker = false;

			}

			this.localReference5 = param;

		}

		/**
		 * field for Reference6
		 */

		protected java.lang.String localReference6;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference6Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference6() {
			return localReference6;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference6
		 */
		public void setReference6(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference6Tracker = true;
			} else {
				localReference6Tracker = false;

			}

			this.localReference6 = param;

		}

		/**
		 * field for Reference7
		 */

		protected java.lang.String localReference7;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference7Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference7() {
			return localReference7;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference7
		 */
		public void setReference7(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference7Tracker = true;
			} else {
				localReference7Tracker = false;

			}

			this.localReference7 = param;

		}

		/**
		 * field for Reference8
		 */

		protected java.lang.String localReference8;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference8Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference8() {
			return localReference8;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference8
		 */
		public void setReference8(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference8Tracker = true;
			} else {
				localReference8Tracker = false;

			}

			this.localReference8 = param;

		}

		/**
		 * field for Reference9
		 */

		protected java.lang.String localReference9;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference9Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference9() {
			return localReference9;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference9
		 */
		public void setReference9(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference9Tracker = true;
			} else {
				localReference9Tracker = false;

			}

			this.localReference9 = param;

		}

		/**
		 * field for Reference10
		 */

		protected java.lang.String localReference10;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReference10Tracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReference10() {
			return localReference10;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reference10
		 */
		public void setReference10(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReference10Tracker = true;
			} else {
				localReference10Tracker = false;

			}

			this.localReference10 = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					OrderWeb.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":OrderWeb", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "OrderWeb", xmlWriter);
				}

			}
			if (localReference1Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference1",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference1");
					}

				} else {
					xmlWriter.writeStartElement("reference1");
				}

				if (localReference1 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference1 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference1);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference2Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference2",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference2");
					}

				} else {
					xmlWriter.writeStartElement("reference2");
				}

				if (localReference2 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference2 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference2);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference3Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference3",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference3");
					}

				} else {
					xmlWriter.writeStartElement("reference3");
				}

				if (localReference3 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference3 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference3);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference4Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference4",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference4");
					}

				} else {
					xmlWriter.writeStartElement("reference4");
				}

				if (localReference4 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference4 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference4);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference5Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference5",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference5");
					}

				} else {
					xmlWriter.writeStartElement("reference5");
				}

				if (localReference5 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference5 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference5);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference6Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference6",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference6");
					}

				} else {
					xmlWriter.writeStartElement("reference6");
				}

				if (localReference6 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference6 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference6);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference7Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference7",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference7");
					}

				} else {
					xmlWriter.writeStartElement("reference7");
				}

				if (localReference7 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference7 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference7);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference8Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference8",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference8");
					}

				} else {
					xmlWriter.writeStartElement("reference8");
				}

				if (localReference8 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference8 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference8);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference9Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference9",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference9");
					}

				} else {
					xmlWriter.writeStartElement("reference9");
				}

				if (localReference9 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference9 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference9);

				}

				xmlWriter.writeEndElement();
			}
			if (localReference10Tracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reference10",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reference10");
					}

				} else {
					xmlWriter.writeStartElement("reference10");
				}

				if (localReference10 == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reference10 cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReference10);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localReference1Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference1"));

				if (localReference1 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference1));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference1 cannot be null!!");
				}
			}
			if (localReference2Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference2"));

				if (localReference2 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference2));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference2 cannot be null!!");
				}
			}
			if (localReference3Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference3"));

				if (localReference3 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference3));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference3 cannot be null!!");
				}
			}
			if (localReference4Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference4"));

				if (localReference4 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference4));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference4 cannot be null!!");
				}
			}
			if (localReference5Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference5"));

				if (localReference5 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference5));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference5 cannot be null!!");
				}
			}
			if (localReference6Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference6"));

				if (localReference6 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference6));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference6 cannot be null!!");
				}
			}
			if (localReference7Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference7"));

				if (localReference7 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference7));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference7 cannot be null!!");
				}
			}
			if (localReference8Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference8"));

				if (localReference8 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference8));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference8 cannot be null!!");
				}
			}
			if (localReference9Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference9"));

				if (localReference9 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference9));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference9 cannot be null!!");
				}
			}
			if (localReference10Tracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reference10"));

				if (localReference10 != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReference10));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reference10 cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static OrderWeb parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				OrderWeb object = new OrderWeb();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"OrderWeb".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (OrderWeb) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference1")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference1(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference2")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference2(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference3")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference3(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference4")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference4(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference5")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference5(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference6")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference6(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference7")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference7(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference8")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference8(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference9")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference9(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reference10")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReference10(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	/*##########################################################################################################################*/
	public static class AuthorizeResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "authorizeResponse", "ns1");

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Result
		 */

		protected int localResult;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getResult() {
			return localResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(int param) {

			this.localResult = param;

		}

		/**
		 * field for ErrorCode
		 */

		protected java.lang.String localErrorCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorCode() {
			return localErrorCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorCode
		 */
		public void setErrorCode(java.lang.String param) {

			this.localErrorCode = param;

		}

		/**
		 * field for ErrorMessage
		 */

		protected java.lang.String localErrorMessage;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorMessage() {
			return localErrorMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorMessage
		 */
		public void setErrorMessage(java.lang.String param) {

			this.localErrorMessage = param;

		}

		/**
		 * field for AdditionalMessage
		 */

		protected java.lang.String localAdditionalMessage;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdditionalMessage() {
			return localAdditionalMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdditionalMessage
		 */
		public void setAdditionalMessage(java.lang.String param) {

			this.localAdditionalMessage = param;

		}

		/**
		 * field for AuthorizationCode
		 */

		protected java.lang.String localAuthorizationCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAuthorizationCode() {
			return localAuthorizationCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AuthorizationCode
		 */
		public void setAuthorizationCode(java.lang.String param) {

			this.localAuthorizationCode = param;

		}

		/**
		 * field for AuthorizedAmount
		 */

		protected java.lang.String localAuthorizedAmount;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAuthorizedAmount() {
			return localAuthorizedAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AuthorizedAmount
		 */
		public void setAuthorizedAmount(java.lang.String param) {

			this.localAuthorizedAmount = param;

		}

		/**
		 * field for FraudScore
		 */

		protected int localFraudScore;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getFraudScore() {
			return localFraudScore;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FraudScore
		 */
		public void setFraudScore(int param) {

			this.localFraudScore = param;

		}

		/**
		 * field for FraudFactors
		 */

		protected java.lang.String localFraudFactors;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFraudFactors() {
			return localFraudFactors;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FraudFactors
		 */
		public void setFraudFactors(java.lang.String param) {

			this.localFraudFactors = param;

		}

		/**
		 * field for ResultAR
		 */

		protected int localResultAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localResultARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getResultAR() {
			return localResultAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ResultAR
		 */
		public void setResultAR(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localResultARTracker = false;

			} else {
				localResultARTracker = true;
			}

			this.localResultAR = param;

		}

		/**
		 * field for ErrorCodeAR
		 */

		protected java.lang.String localErrorCodeAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localErrorCodeARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorCodeAR() {
			return localErrorCodeAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorCodeAR
		 */
		public void setErrorCodeAR(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localErrorCodeARTracker = true;
			} else {
				localErrorCodeARTracker = false;

			}

			this.localErrorCodeAR = param;

		}

		/**
		 * field for ErrorMessageAR
		 */

		protected java.lang.String localErrorMessageAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localErrorMessageARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorMessageAR() {
			return localErrorMessageAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorMessageAR
		 */
		public void setErrorMessageAR(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localErrorMessageARTracker = true;
			} else {
				localErrorMessageARTracker = false;

			}

			this.localErrorMessageAR = param;

		}

		/**
		 * field for AuthorizationCodeAR
		 */

		protected java.lang.String localAuthorizationCodeAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAuthorizationCodeARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAuthorizationCodeAR() {
			return localAuthorizationCodeAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AuthorizationCodeAR
		 */
		public void setAuthorizationCodeAR(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAuthorizationCodeARTracker = true;
			} else {
				localAuthorizationCodeARTracker = false;

			}

			this.localAuthorizationCodeAR = param;

		}

		/**
		 * field for AuthorizedAmountAR
		 */

		protected java.lang.String localAuthorizedAmountAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAuthorizedAmountARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAuthorizedAmountAR() {
			return localAuthorizedAmountAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AuthorizedAmountAR
		 */
		public void setAuthorizedAmountAR(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAuthorizedAmountARTracker = true;
			} else {
				localAuthorizedAmountARTracker = false;

			}

			this.localAuthorizedAmountAR = param;

		}

		/**
		 * field for FraudScoreAR
		 */

		protected int localFraudScoreAR;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFraudScoreARTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getFraudScoreAR() {
			return localFraudScoreAR;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FraudScoreAR
		 */
		public void setFraudScoreAR(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localFraudScoreARTracker = false;

			} else {
				localFraudScoreARTracker = true;
			}

			this.localFraudScoreAR = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					AuthorizeResponse.this.serialize(MY_QNAME, factory,
							xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":authorizeResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "authorizeResponse", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "result", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "result");
				}

			} else {
				xmlWriter.writeStartElement("result");
			}

			if (localResult == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"result cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localResult));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "errorCode", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "errorCode");
				}

			} else {
				xmlWriter.writeStartElement("errorCode");
			}

			if (localErrorCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"errorCode cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localErrorCode);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "errorMessage",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "errorMessage");
				}

			} else {
				xmlWriter.writeStartElement("errorMessage");
			}

			if (localErrorMessage == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"errorMessage cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localErrorMessage);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "additionalMessage",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "additionalMessage");
				}

			} else {
				xmlWriter.writeStartElement("additionalMessage");
			}

			if (localAdditionalMessage == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"additionalMessage cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAdditionalMessage);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "authorizationCode",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "authorizationCode");
				}

			} else {
				xmlWriter.writeStartElement("authorizationCode");
			}

			if (localAuthorizationCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"authorizationCode cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAuthorizationCode);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "authorizedAmount",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "authorizedAmount");
				}

			} else {
				xmlWriter.writeStartElement("authorizedAmount");
			}

			if (localAuthorizedAmount == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"authorizedAmount cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAuthorizedAmount);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter
							.writeStartElement(prefix, "fraudScore", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "fraudScore");
				}

			} else {
				xmlWriter.writeStartElement("fraudScore");
			}

			if (localFraudScore == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"fraudScore cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localFraudScore));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "fraudFactors",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "fraudFactors");
				}

			} else {
				xmlWriter.writeStartElement("fraudFactors");
			}

			if (localFraudFactors == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"fraudFactors cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localFraudFactors);

			}

			xmlWriter.writeEndElement();
			if (localResultARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "resultAR",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "resultAR");
					}

				} else {
					xmlWriter.writeStartElement("resultAR");
				}

				if (localResultAR == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"resultAR cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localResultAR));
				}

				xmlWriter.writeEndElement();
			}
			if (localErrorCodeARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "errorCodeAR",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "errorCodeAR");
					}

				} else {
					xmlWriter.writeStartElement("errorCodeAR");
				}

				if (localErrorCodeAR == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"errorCodeAR cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localErrorCodeAR);

				}

				xmlWriter.writeEndElement();
			}
			if (localErrorMessageARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "errorMessageAR",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter
								.writeStartElement(namespace, "errorMessageAR");
					}

				} else {
					xmlWriter.writeStartElement("errorMessageAR");
				}

				if (localErrorMessageAR == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"errorMessageAR cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localErrorMessageAR);

				}

				xmlWriter.writeEndElement();
			}
			if (localAuthorizationCodeARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"authorizationCodeAR", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"authorizationCodeAR");
					}

				} else {
					xmlWriter.writeStartElement("authorizationCodeAR");
				}

				if (localAuthorizationCodeAR == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"authorizationCodeAR cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAuthorizationCodeAR);

				}

				xmlWriter.writeEndElement();
			}
			if (localAuthorizedAmountARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"authorizedAmountAR", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"authorizedAmountAR");
					}

				} else {
					xmlWriter.writeStartElement("authorizedAmountAR");
				}

				if (localAuthorizedAmountAR == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"authorizedAmountAR cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAuthorizedAmountAR);

				}

				xmlWriter.writeEndElement();
			}
			if (localFraudScoreARTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "fraudScoreAR",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "fraudScoreAR");
					}

				} else {
					xmlWriter.writeStartElement("fraudScoreAR");
				}

				if (localFraudScoreAR == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"fraudScoreAR cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localFraudScoreAR));
				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "result"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localResult));

			elementList.add(new javax.xml.namespace.QName("", "errorCode"));

			if (localErrorCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localErrorCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"errorCode cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "errorMessage"));

			if (localErrorMessage != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localErrorMessage));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"errorMessage cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("",
					"additionalMessage"));

			if (localAdditionalMessage != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAdditionalMessage));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"additionalMessage cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("",
					"authorizationCode"));

			if (localAuthorizationCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAuthorizationCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"authorizationCode cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("",
					"authorizedAmount"));

			if (localAuthorizedAmount != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAuthorizedAmount));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"authorizedAmount cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "fraudScore"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localFraudScore));

			elementList.add(new javax.xml.namespace.QName("", "fraudFactors"));

			if (localFraudFactors != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localFraudFactors));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"fraudFactors cannot be null!!");
			}
			if (localResultARTracker) {
				elementList.add(new javax.xml.namespace.QName("", "resultAR"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localResultAR));
			}
			if (localErrorCodeARTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "errorCodeAR"));

				if (localErrorCodeAR != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localErrorCodeAR));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"errorCodeAR cannot be null!!");
				}
			}
			if (localErrorMessageARTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"errorMessageAR"));

				if (localErrorMessageAR != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localErrorMessageAR));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"errorMessageAR cannot be null!!");
				}
			}
			if (localAuthorizationCodeARTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"authorizationCodeAR"));

				if (localAuthorizationCodeAR != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAuthorizationCodeAR));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"authorizationCodeAR cannot be null!!");
				}
			}
			if (localAuthorizedAmountARTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"authorizedAmountAR"));

				if (localAuthorizedAmountAR != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAuthorizedAmountAR));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"authorizedAmountAR cannot be null!!");
				}
			}
			if (localFraudScoreARTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"fraudScoreAR"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localFraudScoreAR));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AuthorizeResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				AuthorizeResponse object = new AuthorizeResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"authorizeResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (AuthorizeResponse) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "result")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setResult(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "errorCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "errorMessage")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorMessage(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"additionalMessage").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdditionalMessage(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"authorizationCode").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAuthorizationCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"authorizedAmount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAuthorizedAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "fraudScore")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFraudScore(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "fraudFactors")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFraudFactors(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "resultAR")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setResultAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setResultAR(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "errorCodeAR")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorCodeAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"errorMessageAR").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorMessageAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"authorizationCodeAR").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAuthorizationCodeAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"authorizedAmountAR").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAuthorizedAmountAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "fraudScoreAR")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFraudScoreAR(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setFraudScoreAR(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Passenger implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Passenger Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for FirstName
		 */

		protected java.lang.String localFirstName;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFirstName() {
			return localFirstName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FirstName
		 */
		public void setFirstName(java.lang.String param) {

			this.localFirstName = param;

		}

		/**
		 * field for LastName
		 */

		protected java.lang.String localLastName;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLastName() {
			return localLastName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            LastName
		 */
		public void setLastName(java.lang.String param) {

			this.localLastName = param;

		}

		/**
		 * field for DocumentType
		 */

		protected java.lang.String localDocumentType;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDocumentTypeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDocumentType() {
			return localDocumentType;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DocumentType
		 */
		public void setDocumentType(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDocumentTypeTracker = true;
			} else {
				localDocumentTypeTracker = false;

			}

			this.localDocumentType = param;

		}

		/**
		 * field for DocumentNumber
		 */

		protected java.lang.String localDocumentNumber;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDocumentNumberTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDocumentNumber() {
			return localDocumentNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DocumentNumber
		 */
		public void setDocumentNumber(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDocumentNumberTracker = true;
			} else {
				localDocumentNumberTracker = false;

			}

			this.localDocumentNumber = param;

		}

		/**
		 * field for AgencyCode
		 */

		protected java.lang.String localAgencyCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAgencyCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAgencyCode() {
			return localAgencyCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AgencyCode
		 */
		public void setAgencyCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAgencyCodeTracker = true;
			} else {
				localAgencyCodeTracker = false;

			}

			this.localAgencyCode = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Passenger.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":Passenger", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "Passenger", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "firstName", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "firstName");
				}

			} else {
				xmlWriter.writeStartElement("firstName");
			}

			if (localFirstName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"firstName cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localFirstName);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "lastName", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "lastName");
				}

			} else {
				xmlWriter.writeStartElement("lastName");
			}

			if (localLastName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"lastName cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localLastName);

			}

			xmlWriter.writeEndElement();
			if (localDocumentTypeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "documentType",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "documentType");
					}

				} else {
					xmlWriter.writeStartElement("documentType");
				}

				if (localDocumentType == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"documentType cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDocumentType);

				}

				xmlWriter.writeEndElement();
			}
			if (localDocumentNumberTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "documentNumber",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter
								.writeStartElement(namespace, "documentNumber");
					}

				} else {
					xmlWriter.writeStartElement("documentNumber");
				}

				if (localDocumentNumber == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"documentNumber cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDocumentNumber);

				}

				xmlWriter.writeEndElement();
			}
			if (localAgencyCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "agencyCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "agencyCode");
					}

				} else {
					xmlWriter.writeStartElement("agencyCode");
				}

				if (localAgencyCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"agencyCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAgencyCode);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "firstName"));

			if (localFirstName != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localFirstName));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"firstName cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "lastName"));

			if (localLastName != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localLastName));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"lastName cannot be null!!");
			}
			if (localDocumentTypeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"documentType"));

				if (localDocumentType != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDocumentType));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"documentType cannot be null!!");
				}
			}
			if (localDocumentNumberTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"documentNumber"));

				if (localDocumentNumber != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDocumentNumber));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"documentNumber cannot be null!!");
				}
			}
			if (localAgencyCodeTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "agencyCode"));

				if (localAgencyCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAgencyCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"agencyCode cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Passenger parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Passenger object = new Passenger();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Passenger".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Passenger) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "firstName")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFirstName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "lastName")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setLastName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "documentType")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDocumentType(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"documentNumber").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDocumentNumber(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "agencyCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAgencyCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Tax implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name = Tax
		 * Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace Prefix =
		 * ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Id
		 */

		protected int localId;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(int param) {

			this.localId = param;

		}

		/**
		 * field for Name
		 */

		protected java.lang.String localName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getName() {
			return localName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Name
		 */
		public void setName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localNameTracker = true;
			} else {
				localNameTracker = false;

			}

			this.localName = param;

		}

		/**
		 * field for Amount
		 */

		protected java.lang.String localAmount;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAmount() {
			return localAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Amount
		 */
		public void setAmount(java.lang.String param) {

			this.localAmount = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Tax.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":Tax", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "Tax", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "id", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "id");
				}

			} else {
				xmlWriter.writeStartElement("id");
			}

			if (localId == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"id cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localId));
			}

			xmlWriter.writeEndElement();
			if (localNameTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "name", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "name");
					}

				} else {
					xmlWriter.writeStartElement("name");
				}

				if (localName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"name cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localName);

				}

				xmlWriter.writeEndElement();
			}
			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "amount", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "amount");
				}

			} else {
				xmlWriter.writeStartElement("amount");
			}

			if (localAmount == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"amount cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAmount);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "id"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localId));
			if (localNameTracker) {
				elementList.add(new javax.xml.namespace.QName("", "name"));

				if (localName != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localName));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"name cannot be null!!");
				}
			}
			elementList.add(new javax.xml.namespace.QName("", "amount"));

			if (localAmount != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAmount));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"amount cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Tax parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Tax object = new Tax();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Tax".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Tax) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "id")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "name")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "amount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class ShippingData extends Person implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * ShippingData Namespace URI = http://www.alignet.com/VPOSWS20/
		 * Namespace Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for ReceptionMethod
		 */

		protected java.lang.String localReceptionMethod;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceptionMethodTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReceptionMethod() {
			return localReceptionMethod;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceptionMethod
		 */
		public void setReceptionMethod(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReceptionMethodTracker = true;
			} else {
				localReceptionMethodTracker = false;

			}

			this.localReceptionMethod = param;

		}

		/**
		 * field for ReceiverName
		 */

		protected java.lang.String localReceiverName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiverNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReceiverName() {
			return localReceiverName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiverName
		 */
		public void setReceiverName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReceiverNameTracker = true;
			} else {
				localReceiverNameTracker = false;

			}

			this.localReceiverName = param;

		}

		/**
		 * field for ReceiverLastName
		 */

		protected java.lang.String localReceiverLastName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiverLastNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReceiverLastName() {
			return localReceiverLastName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiverLastName
		 */
		public void setReceiverLastName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReceiverLastNameTracker = true;
			} else {
				localReceiverLastNameTracker = false;

			}

			this.localReceiverLastName = param;

		}

		/**
		 * field for ReceiverIdentifier
		 */

		protected java.lang.String localReceiverIdentifier;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiverIdentifierTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReceiverIdentifier() {
			return localReceiverIdentifier;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiverIdentifier
		 */
		public void setReceiverIdentifier(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReceiverIdentifierTracker = true;
			} else {
				localReceiverIdentifierTracker = false;

			}

			this.localReceiverIdentifier = param;

		}

		/**
		 * field for ShippingCode
		 */

		protected java.lang.String localShippingCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localShippingCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getShippingCode() {
			return localShippingCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ShippingCode
		 */
		public void setShippingCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localShippingCodeTracker = true;
			} else {
				localShippingCodeTracker = false;

			}

			this.localShippingCode = param;

		}

		/**
		 * field for ShippingCharges
		 */

		protected java.lang.String localShippingCharges;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localShippingChargesTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getShippingCharges() {
			return localShippingCharges;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ShippingCharges
		 */
		public void setShippingCharges(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localShippingChargesTracker = true;
			} else {
				localShippingChargesTracker = false;

			}

			this.localShippingCharges = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					ShippingData.this
							.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://www.alignet.com/VPOSWS20/");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":ShippingData", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"ShippingData", xmlWriter);
			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "names", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "names");
				}

			} else {
				xmlWriter.writeStartElement("names");
			}

			if (localNames == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"names cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localNames);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "lastNames", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "lastNames");
				}

			} else {
				xmlWriter.writeStartElement("lastNames");
			}

			if (localLastNames == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"lastNames cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localLastNames);

			}

			xmlWriter.writeEndElement();
			if (localNumberIdentifierTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "numberIdentifier",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"numberIdentifier");
					}

				} else {
					xmlWriter.writeStartElement("numberIdentifier");
				}

				if (localNumberIdentifier == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"numberIdentifier cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localNumberIdentifier);

				}

				xmlWriter.writeEndElement();
			}
			if (localGenderTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "gender", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "gender");
					}

				} else {
					xmlWriter.writeStartElement("gender");
				}

				if (localGender == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"gender cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localGender);

				}

				xmlWriter.writeEndElement();
			}
			if (localAddressTracker) {
				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"address cannot be null!!");
				}
				localAddress.serialize(new javax.xml.namespace.QName("",
						"address"), factory, xmlWriter);
			}
			if (localBirthdayTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "birthday",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "birthday");
					}

				} else {
					xmlWriter.writeStartElement("birthday");
				}

				if (localBirthday == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"birthday cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localBirthday);

				}

				xmlWriter.writeEndElement();
			}
			if (localOutIdentifierCityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"outIdentifierCity", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"outIdentifierCity");
					}

				} else {
					xmlWriter.writeStartElement("outIdentifierCity");
				}

				if (localOutIdentifierCity == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"outIdentifierCity cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localOutIdentifierCity);

				}

				xmlWriter.writeEndElement();
			}
			if (localDateIdentifierDateTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"dateIdentifierDate", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"dateIdentifierDate");
					}

				} else {
					xmlWriter.writeStartElement("dateIdentifierDate");
				}

				if (localDateIdentifierDate == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"dateIdentifierDate cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDateIdentifierDate);

				}

				xmlWriter.writeEndElement();
			}
			if (localNationalityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "nationality",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "nationality");
					}

				} else {
					xmlWriter.writeStartElement("nationality");
				}

				if (localNationality == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"nationality cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localNationality);

				}

				xmlWriter.writeEndElement();
			}
			if (localReceptionMethodTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "receptionMethod",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"receptionMethod");
					}

				} else {
					xmlWriter.writeStartElement("receptionMethod");
				}

				if (localReceptionMethod == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"receptionMethod cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReceptionMethod);

				}

				xmlWriter.writeEndElement();
			}
			if (localReceiverNameTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "receiverName",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "receiverName");
					}

				} else {
					xmlWriter.writeStartElement("receiverName");
				}

				if (localReceiverName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"receiverName cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReceiverName);

				}

				xmlWriter.writeEndElement();
			}
			if (localReceiverLastNameTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "receiverLastName",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"receiverLastName");
					}

				} else {
					xmlWriter.writeStartElement("receiverLastName");
				}

				if (localReceiverLastName == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"receiverLastName cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReceiverLastName);

				}

				xmlWriter.writeEndElement();
			}
			if (localReceiverIdentifierTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"receiverIdentifier", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"receiverIdentifier");
					}

				} else {
					xmlWriter.writeStartElement("receiverIdentifier");
				}

				if (localReceiverIdentifier == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"receiverIdentifier cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReceiverIdentifier);

				}

				xmlWriter.writeEndElement();
			}
			if (localShippingCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "shippingCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "shippingCode");
					}

				} else {
					xmlWriter.writeStartElement("shippingCode");
				}

				if (localShippingCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"shippingCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localShippingCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localShippingChargesTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "shippingCharges",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"shippingCharges");
					}

				} else {
					xmlWriter.writeStartElement("shippingCharges");
				}

				if (localShippingCharges == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"shippingCharges cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localShippingCharges);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName(
					"http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName(
					"http://www.alignet.com/VPOSWS20/", "ShippingData"));

			elementList.add(new javax.xml.namespace.QName("", "names"));

			if (localNames != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localNames));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"names cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "lastNames"));

			if (localLastNames != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localLastNames));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"lastNames cannot be null!!");
			}
			if (localNumberIdentifierTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"numberIdentifier"));

				if (localNumberIdentifier != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localNumberIdentifier));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"numberIdentifier cannot be null!!");
				}
			}
			if (localGenderTracker) {
				elementList.add(new javax.xml.namespace.QName("", "gender"));

				if (localGender != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localGender));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"gender cannot be null!!");
				}
			}
			if (localAddressTracker) {
				elementList.add(new javax.xml.namespace.QName("", "address"));

				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"address cannot be null!!");
				}
				elementList.add(localAddress);
			}
			if (localBirthdayTracker) {
				elementList.add(new javax.xml.namespace.QName("", "birthday"));

				if (localBirthday != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localBirthday));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"birthday cannot be null!!");
				}
			}
			if (localOutIdentifierCityTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"outIdentifierCity"));

				if (localOutIdentifierCity != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localOutIdentifierCity));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"outIdentifierCity cannot be null!!");
				}
			}
			if (localDateIdentifierDateTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"dateIdentifierDate"));

				if (localDateIdentifierDate != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDateIdentifierDate));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"dateIdentifierDate cannot be null!!");
				}
			}
			if (localNationalityTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "nationality"));

				if (localNationality != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localNationality));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"nationality cannot be null!!");
				}
			}
			if (localReceptionMethodTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"receptionMethod"));

				if (localReceptionMethod != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReceptionMethod));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"receptionMethod cannot be null!!");
				}
			}
			if (localReceiverNameTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"receiverName"));

				if (localReceiverName != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReceiverName));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"receiverName cannot be null!!");
				}
			}
			if (localReceiverLastNameTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"receiverLastName"));

				if (localReceiverLastName != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReceiverLastName));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"receiverLastName cannot be null!!");
				}
			}
			if (localReceiverIdentifierTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"receiverIdentifier"));

				if (localReceiverIdentifier != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReceiverIdentifier));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"receiverIdentifier cannot be null!!");
				}
			}
			if (localShippingCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"shippingCode"));

				if (localShippingCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localShippingCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"shippingCode cannot be null!!");
				}
			}
			if (localShippingChargesTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"shippingCharges"));

				if (localShippingCharges != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localShippingCharges));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"shippingCharges cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ShippingData parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				ShippingData object = new ShippingData();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"ShippingData".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (ShippingData) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "names")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNames(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "lastNames")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setLastNames(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"numberIdentifier")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNumberIdentifier(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "gender")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setGender(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "address")
									.equals(reader.getName())) {

						object.setAddress(AddressData.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "birthday")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setBirthday(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"outIdentifierCity").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setOutIdentifierCity(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"dateIdentifierDate").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDateIdentifierDate(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "nationality")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNationality(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"receptionMethod").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReceptionMethod(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "receiverName")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReceiverName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"receiverLastName")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReceiverLastName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"receiverIdentifier").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReceiverIdentifier(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "shippingCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setShippingCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"shippingCharges").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setShippingCharges(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Product implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Product Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Item
		 */

		protected int localItem;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localItemTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getItem() {
			return localItem;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Item
		 */
		public void setItem(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localItemTracker = false;

			} else {
				localItemTracker = true;
			}

			this.localItem = param;

		}

		/**
		 * field for Code
		 */

		protected java.lang.String localCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCode() {
			return localCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Code
		 */
		public void setCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCodeTracker = true;
			} else {
				localCodeTracker = false;

			}

			this.localCode = param;

		}

		/**
		 * field for Amount
		 */

		protected java.lang.String localAmount;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAmountTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAmount() {
			return localAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Amount
		 */
		public void setAmount(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAmountTracker = true;
			} else {
				localAmountTracker = false;

			}

			this.localAmount = param;

		}

		/**
		 * field for PromotionCode
		 */

		protected java.lang.String localPromotionCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPromotionCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPromotionCode() {
			return localPromotionCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PromotionCode
		 */
		public void setPromotionCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localPromotionCodeTracker = true;
			} else {
				localPromotionCodeTracker = false;

			}

			this.localPromotionCode = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Product.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":Product", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "Product", xmlWriter);
				}

			}
			if (localItemTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "item", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "item");
					}

				} else {
					xmlWriter.writeStartElement("item");
				}

				if (localItem == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"item cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localItem));
				}

				xmlWriter.writeEndElement();
			}
			if (localCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "code", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "code");
					}

				} else {
					xmlWriter.writeStartElement("code");
				}

				if (localCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localAmountTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "amount", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "amount");
					}

				} else {
					xmlWriter.writeStartElement("amount");
				}

				if (localAmount == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAmount);

				}

				xmlWriter.writeEndElement();
			}
			if (localPromotionCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "promotionCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "promotionCode");
					}

				} else {
					xmlWriter.writeStartElement("promotionCode");
				}

				if (localPromotionCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPromotionCode);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localItemTracker) {
				elementList.add(new javax.xml.namespace.QName("", "item"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localItem));
			}
			if (localCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("", "code"));

				if (localCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");
				}
			}
			if (localAmountTracker) {
				elementList.add(new javax.xml.namespace.QName("", "amount"));

				if (localAmount != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAmount));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");
				}
			}
			if (localPromotionCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"promotionCode"));

				if (localPromotionCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPromotionCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Product parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Product object = new Product();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Product".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Product) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "item")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setItem(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setItem(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "code")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "amount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"promotionCode").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPromotionCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class ReverseResponse implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "reverseResponse", "ns1");

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Result
		 */

		protected int localResult;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getResult() {
			return localResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(int param) {

			this.localResult = param;

		}

		/**
		 * field for ErrorCode
		 */

		protected java.lang.String localErrorCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorCode() {
			return localErrorCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorCode
		 */
		public void setErrorCode(java.lang.String param) {

			this.localErrorCode = param;

		}

		/**
		 * field for ErrorMessage
		 */

		protected java.lang.String localErrorMessage;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getErrorMessage() {
			return localErrorMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ErrorMessage
		 */
		public void setErrorMessage(java.lang.String param) {

			this.localErrorMessage = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					ReverseResponse.this
							.serialize(MY_QNAME, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":reverseResponse",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "reverseResponse", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "result", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "result");
				}

			} else {
				xmlWriter.writeStartElement("result");
			}

			if (localResult == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"result cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localResult));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "errorCode", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "errorCode");
				}

			} else {
				xmlWriter.writeStartElement("errorCode");
			}

			if (localErrorCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"errorCode cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localErrorCode);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "errorMessage",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "errorMessage");
				}

			} else {
				xmlWriter.writeStartElement("errorMessage");
			}

			if (localErrorMessage == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"errorMessage cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localErrorMessage);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "result"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localResult));

			elementList.add(new javax.xml.namespace.QName("", "errorCode"));

			if (localErrorCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localErrorCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"errorCode cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "errorMessage"));

			if (localErrorMessage != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localErrorMessage));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"errorMessage cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ReverseResponse parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				ReverseResponse object = new ReverseResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"reverseResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (ReverseResponse) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "result")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setResult(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "errorCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "errorMessage")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setErrorMessage(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Good extends Product implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name = Good
		 * Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace Prefix =
		 * ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Name
		 */

		protected java.lang.String localName;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getName() {
			return localName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Name
		 */
		public void setName(java.lang.String param) {

			this.localName = param;

		}

		/**
		 * field for Description
		 */

		protected java.lang.String localDescription;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDescriptionTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDescription() {
			return localDescription;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Description
		 */
		public void setDescription(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDescriptionTracker = true;
			} else {
				localDescriptionTracker = false;

			}

			this.localDescription = param;

		}

		/**
		 * field for Quantity
		 */

		protected int localQuantity;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localQuantityTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getQuantity() {
			return localQuantity;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Quantity
		 */
		public void setQuantity(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localQuantityTracker = false;

			} else {
				localQuantityTracker = true;
			}

			this.localQuantity = param;

		}

		/**
		 * field for UnitPrice
		 */

		protected java.lang.String localUnitPrice;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localUnitPriceTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getUnitPrice() {
			return localUnitPrice;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            UnitPrice
		 */
		public void setUnitPrice(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localUnitPriceTracker = true;
			} else {
				localUnitPriceTracker = false;

			}

			this.localUnitPrice = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Good.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://www.alignet.com/VPOSWS20/");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":Good", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Good", xmlWriter);
			}

			if (localItemTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "item", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "item");
					}

				} else {
					xmlWriter.writeStartElement("item");
				}

				if (localItem == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"item cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localItem));
				}

				xmlWriter.writeEndElement();
			}
			if (localCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "code", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "code");
					}

				} else {
					xmlWriter.writeStartElement("code");
				}

				if (localCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localAmountTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "amount", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "amount");
					}

				} else {
					xmlWriter.writeStartElement("amount");
				}

				if (localAmount == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAmount);

				}

				xmlWriter.writeEndElement();
			}
			if (localPromotionCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "promotionCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "promotionCode");
					}

				} else {
					xmlWriter.writeStartElement("promotionCode");
				}

				if (localPromotionCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPromotionCode);

				}

				xmlWriter.writeEndElement();
			}
			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "name", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "name");
				}

			} else {
				xmlWriter.writeStartElement("name");
			}

			if (localName == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"name cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localName);

			}

			xmlWriter.writeEndElement();
			if (localDescriptionTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "description",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "description");
					}

				} else {
					xmlWriter.writeStartElement("description");
				}

				if (localDescription == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"description cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDescription);

				}

				xmlWriter.writeEndElement();
			}
			if (localQuantityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "quantity",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "quantity");
					}

				} else {
					xmlWriter.writeStartElement("quantity");
				}

				if (localQuantity == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"quantity cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localQuantity));
				}

				xmlWriter.writeEndElement();
			}
			if (localUnitPriceTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "unitPrice",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "unitPrice");
					}

				} else {
					xmlWriter.writeStartElement("unitPrice");
				}

				if (localUnitPrice == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"unitPrice cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localUnitPrice);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName(
					"http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName(
					"http://www.alignet.com/VPOSWS20/", "Good"));
			if (localItemTracker) {
				elementList.add(new javax.xml.namespace.QName("", "item"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localItem));
			}
			if (localCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("", "code"));

				if (localCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");
				}
			}
			if (localAmountTracker) {
				elementList.add(new javax.xml.namespace.QName("", "amount"));

				if (localAmount != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAmount));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");
				}
			}
			if (localPromotionCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"promotionCode"));

				if (localPromotionCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPromotionCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");
				}
			}
			elementList.add(new javax.xml.namespace.QName("", "name"));

			if (localName != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localName));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"name cannot be null!!");
			}
			if (localDescriptionTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "description"));

				if (localDescription != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDescription));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"description cannot be null!!");
				}
			}
			if (localQuantityTracker) {
				elementList.add(new javax.xml.namespace.QName("", "quantity"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localQuantity));
			}
			if (localUnitPriceTracker) {
				elementList.add(new javax.xml.namespace.QName("", "unitPrice"));

				if (localUnitPrice != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localUnitPrice));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"unitPrice cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Good parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Good object = new Good();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Good".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Good) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "item")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setItem(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setItem(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "code")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "amount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"promotionCode").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPromotionCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "name")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "description")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDescription(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "quantity")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setQuantity(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setQuantity(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "unitPrice")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setUnitPrice(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Person implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Person Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Names
		 */

		protected java.lang.String localNames;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getNames() {
			return localNames;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Names
		 */
		public void setNames(java.lang.String param) {

			this.localNames = param;

		}

		/**
		 * field for LastNames
		 */

		protected java.lang.String localLastNames;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLastNames() {
			return localLastNames;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            LastNames
		 */
		public void setLastNames(java.lang.String param) {

			this.localLastNames = param;

		}

		/**
		 * field for NumberIdentifier
		 */

		protected java.lang.String localNumberIdentifier;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localNumberIdentifierTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getNumberIdentifier() {
			return localNumberIdentifier;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            NumberIdentifier
		 */
		public void setNumberIdentifier(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localNumberIdentifierTracker = true;
			} else {
				localNumberIdentifierTracker = false;

			}

			this.localNumberIdentifier = param;

		}

		/**
		 * field for Gender
		 */

		protected java.lang.String localGender;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localGenderTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getGender() {
			return localGender;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Gender
		 */
		public void setGender(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localGenderTracker = true;
			} else {
				localGenderTracker = false;

			}

			this.localGender = param;

		}

		/**
		 * field for Address
		 */

		protected AddressData localAddress;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAddressTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return AddressData
		 */
		public AddressData getAddress() {
			return localAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Address
		 */
		public void setAddress(AddressData param) {

			if (param != null) {
				// update the setting tracker
				localAddressTracker = true;
			} else {
				localAddressTracker = false;

			}

			this.localAddress = param;

		}

		/**
		 * field for Birthday
		 */

		protected java.lang.String localBirthday;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localBirthdayTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getBirthday() {
			return localBirthday;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Birthday
		 */
		public void setBirthday(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localBirthdayTracker = true;
			} else {
				localBirthdayTracker = false;

			}

			this.localBirthday = param;

		}

		/**
		 * field for OutIdentifierCity
		 */

		protected java.lang.String localOutIdentifierCity;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localOutIdentifierCityTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getOutIdentifierCity() {
			return localOutIdentifierCity;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            OutIdentifierCity
		 */
		public void setOutIdentifierCity(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localOutIdentifierCityTracker = true;
			} else {
				localOutIdentifierCityTracker = false;

			}

			this.localOutIdentifierCity = param;

		}

		/**
		 * field for DateIdentifierDate
		 */

		protected java.lang.String localDateIdentifierDate;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDateIdentifierDateTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDateIdentifierDate() {
			return localDateIdentifierDate;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DateIdentifierDate
		 */
		public void setDateIdentifierDate(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDateIdentifierDateTracker = true;
			} else {
				localDateIdentifierDateTracker = false;

			}

			this.localDateIdentifierDate = param;

		}

		/**
		 * field for Nationality
		 */

		protected java.lang.String localNationality;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localNationalityTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getNationality() {
			return localNationality;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Nationality
		 */
		public void setNationality(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localNationalityTracker = true;
			} else {
				localNationalityTracker = false;

			}

			this.localNationality = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Person.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":Person", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "Person", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "names", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "names");
				}

			} else {
				xmlWriter.writeStartElement("names");
			}

			if (localNames == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"names cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localNames);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "lastNames", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "lastNames");
				}

			} else {
				xmlWriter.writeStartElement("lastNames");
			}

			if (localLastNames == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"lastNames cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localLastNames);

			}

			xmlWriter.writeEndElement();
			if (localNumberIdentifierTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "numberIdentifier",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"numberIdentifier");
					}

				} else {
					xmlWriter.writeStartElement("numberIdentifier");
				}

				if (localNumberIdentifier == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"numberIdentifier cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localNumberIdentifier);

				}

				xmlWriter.writeEndElement();
			}
			if (localGenderTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "gender", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "gender");
					}

				} else {
					xmlWriter.writeStartElement("gender");
				}

				if (localGender == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"gender cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localGender);

				}

				xmlWriter.writeEndElement();
			}
			if (localAddressTracker) {
				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"address cannot be null!!");
				}
				localAddress.serialize(new javax.xml.namespace.QName("",
						"address"), factory, xmlWriter);
			}
			if (localBirthdayTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "birthday",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "birthday");
					}

				} else {
					xmlWriter.writeStartElement("birthday");
				}

				if (localBirthday == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"birthday cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localBirthday);

				}

				xmlWriter.writeEndElement();
			}
			if (localOutIdentifierCityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"outIdentifierCity", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"outIdentifierCity");
					}

				} else {
					xmlWriter.writeStartElement("outIdentifierCity");
				}

				if (localOutIdentifierCity == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"outIdentifierCity cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localOutIdentifierCity);

				}

				xmlWriter.writeEndElement();
			}
			if (localDateIdentifierDateTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"dateIdentifierDate", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"dateIdentifierDate");
					}

				} else {
					xmlWriter.writeStartElement("dateIdentifierDate");
				}

				if (localDateIdentifierDate == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"dateIdentifierDate cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDateIdentifierDate);

				}

				xmlWriter.writeEndElement();
			}
			if (localNationalityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "nationality",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "nationality");
					}

				} else {
					xmlWriter.writeStartElement("nationality");
				}

				if (localNationality == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"nationality cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localNationality);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "names"));

			if (localNames != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localNames));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"names cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "lastNames"));

			if (localLastNames != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localLastNames));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"lastNames cannot be null!!");
			}
			if (localNumberIdentifierTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"numberIdentifier"));

				if (localNumberIdentifier != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localNumberIdentifier));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"numberIdentifier cannot be null!!");
				}
			}
			if (localGenderTracker) {
				elementList.add(new javax.xml.namespace.QName("", "gender"));

				if (localGender != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localGender));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"gender cannot be null!!");
				}
			}
			if (localAddressTracker) {
				elementList.add(new javax.xml.namespace.QName("", "address"));

				if (localAddress == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"address cannot be null!!");
				}
				elementList.add(localAddress);
			}
			if (localBirthdayTracker) {
				elementList.add(new javax.xml.namespace.QName("", "birthday"));

				if (localBirthday != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localBirthday));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"birthday cannot be null!!");
				}
			}
			if (localOutIdentifierCityTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"outIdentifierCity"));

				if (localOutIdentifierCity != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localOutIdentifierCity));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"outIdentifierCity cannot be null!!");
				}
			}
			if (localDateIdentifierDateTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"dateIdentifierDate"));

				if (localDateIdentifierDate != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDateIdentifierDate));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"dateIdentifierDate cannot be null!!");
				}
			}
			if (localNationalityTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "nationality"));

				if (localNationality != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localNationality));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"nationality cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Person parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Person object = new Person();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Person".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Person) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "names")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNames(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "lastNames")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setLastNames(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"numberIdentifier")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNumberIdentifier(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "gender")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setGender(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "address")
									.equals(reader.getName())) {

						object.setAddress(AddressData.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "birthday")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setBirthday(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"outIdentifierCity").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setOutIdentifierCity(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"dateIdentifierDate").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDateIdentifierDate(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "nationality")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNationality(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class ReservedField implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * ReservedField Namespace URI = http://www.alignet.com/VPOSWS20/
		 * Namespace Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Id
		 */

		protected int localId;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getId() {
			return localId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Id
		 */
		public void setId(int param) {

			this.localId = param;

		}

		/**
		 * field for Value
		 */

		protected java.lang.String localValue;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getValue() {
			return localValue;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Value
		 */
		public void setValue(java.lang.String param) {

			this.localValue = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					ReservedField.this.serialize(parentQName, factory,
							xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":ReservedField",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "ReservedField", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "id", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "id");
				}

			} else {
				xmlWriter.writeStartElement("id");
			}

			if (localId == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"id cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localId));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "value", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "value");
				}

			} else {
				xmlWriter.writeStartElement("value");
			}

			if (localValue == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"value cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localValue);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "id"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localId));

			elementList.add(new javax.xml.namespace.QName("", "value"));

			if (localValue != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localValue));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"value cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ReservedField parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				ReservedField object = new ReservedField();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"ReservedField".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (ReservedField) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "id")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "value")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setValue(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class CardData implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * CardData Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Brand
		 */

		protected java.lang.String localBrand;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getBrand() {
			return localBrand;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Brand
		 */
		public void setBrand(java.lang.String param) {

			this.localBrand = param;

		}

		/**
		 * field for Number
		 */

		protected java.lang.String localNumber;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getNumber() {
			return localNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Number
		 */
		public void setNumber(java.lang.String param) {

			this.localNumber = param;

		}

		/**
		 * field for ExpiryMonth
		 */

		protected int localExpiryMonth;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getExpiryMonth() {
			return localExpiryMonth;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ExpiryMonth
		 */
		public void setExpiryMonth(int param) {

			this.localExpiryMonth = param;

		}

		/**
		 * field for ExpiryYear
		 */

		protected int localExpiryYear;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getExpiryYear() {
			return localExpiryYear;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ExpiryYear
		 */
		public void setExpiryYear(int param) {

			this.localExpiryYear = param;

		}

		/**
		 * field for FinancialId
		 */

		protected int localFinancialId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFinancialIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getFinancialId() {
			return localFinancialId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FinancialId
		 */
		public void setFinancialId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localFinancialIdTracker = false;

			} else {
				localFinancialIdTracker = true;
			}

			this.localFinancialId = param;

		}

		/**
		 * field for AccountTypeId
		 */

		protected int localAccountTypeId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAccountTypeIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getAccountTypeId() {
			return localAccountTypeId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AccountTypeId
		 */
		public void setAccountTypeId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localAccountTypeIdTracker = false;

			} else {
				localAccountTypeIdTracker = true;
			}

			this.localAccountTypeId = param;

		}

		/**
		 * field for SecurityCode
		 */

		protected java.lang.String localSecurityCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSecurityCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSecurityCode() {
			return localSecurityCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SecurityCode
		 */
		public void setSecurityCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localSecurityCodeTracker = true;
			} else {
				localSecurityCodeTracker = false;

			}

			this.localSecurityCode = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					CardData.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":CardData", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "CardData", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "brand", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "brand");
				}

			} else {
				xmlWriter.writeStartElement("brand");
			}

			if (localBrand == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"brand cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localBrand);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "number", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "number");
				}

			} else {
				xmlWriter.writeStartElement("number");
			}

			if (localNumber == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"number cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localNumber);

			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "expiryMonth",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "expiryMonth");
				}

			} else {
				xmlWriter.writeStartElement("expiryMonth");
			}

			if (localExpiryMonth == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"expiryMonth cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localExpiryMonth));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter
							.writeStartElement(prefix, "expiryYear", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "expiryYear");
				}

			} else {
				xmlWriter.writeStartElement("expiryYear");
			}

			if (localExpiryYear == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"expiryYear cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localExpiryYear));
			}

			xmlWriter.writeEndElement();
			if (localFinancialIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "financialId",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "financialId");
					}

				} else {
					xmlWriter.writeStartElement("financialId");
				}

				if (localFinancialId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"financialId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localFinancialId));
				}

				xmlWriter.writeEndElement();
			}
			if (localAccountTypeIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "accountTypeId",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "accountTypeId");
					}

				} else {
					xmlWriter.writeStartElement("accountTypeId");
				}

				if (localAccountTypeId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"accountTypeId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAccountTypeId));
				}

				xmlWriter.writeEndElement();
			}
			if (localSecurityCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "securityCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "securityCode");
					}

				} else {
					xmlWriter.writeStartElement("securityCode");
				}

				if (localSecurityCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"securityCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localSecurityCode);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "brand"));

			if (localBrand != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localBrand));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"brand cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "number"));

			if (localNumber != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localNumber));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"number cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "expiryMonth"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localExpiryMonth));

			elementList.add(new javax.xml.namespace.QName("", "expiryYear"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localExpiryYear));
			if (localFinancialIdTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "financialId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localFinancialId));
			}
			if (localAccountTypeIdTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"accountTypeId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAccountTypeId));
			}
			if (localSecurityCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"securityCode"));

				if (localSecurityCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localSecurityCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"securityCode cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static CardData parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				CardData object = new CardData();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"CardData".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (CardData) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "brand")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setBrand(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "number")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setNumber(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "expiryMonth")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setExpiryMonth(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "expiryYear")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setExpiryYear(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "financialId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFinancialId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setFinancialId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"accountTypeId").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAccountTypeId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setAccountTypeId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "securityCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setSecurityCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(
				java.lang.String namespaceURI, java.lang.String typeName,
				javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "OrderWeb".equals(typeName)) {

				return OrderWeb.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Passenger".equals(typeName)) {

				return Passenger.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Tax".equals(typeName)) {

				return Tax.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "ShippingData".equals(typeName)) {

				return ShippingData.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Product".equals(typeName)) {

				return Product.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Good".equals(typeName)) {

				return Good.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Person".equals(typeName)) {

				return Person.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "ReservedField".equals(typeName)) {

				return ReservedField.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "CardData".equals(typeName)) {

				return CardData.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "PurchaseData".equals(typeName)) {

				return PurchaseData.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "AdministrativeRate".equals(typeName)) {

				return AdministrativeRate.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Airport".equals(typeName)) {

				return Airport.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "AddressData".equals(typeName)) {

				return AddressData.Factory.parse(reader);

			}

			if ("http://www.alignet.com/VPOSWS20/".equals(namespaceURI)
					&& "Flight".equals(typeName)) {

				return Flight.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException(
					"Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class PurchaseData implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * PurchaseData Namespace URI = http://www.alignet.com/VPOSWS20/
		 * Namespace Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for CurrencyCode
		 */

		protected int localCurrencyCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getCurrencyCode() {
			return localCurrencyCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CurrencyCode
		 */
		public void setCurrencyCode(int param) {

			this.localCurrencyCode = param;

		}

		/**
		 * field for PurchaseCode
		 */

		protected java.lang.String localPurchaseCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPurchaseCode() {
			return localPurchaseCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PurchaseCode
		 */
		public void setPurchaseCode(java.lang.String param) {

			this.localPurchaseCode = param;

		}

		/**
		 * field for TotalAmount
		 */

		protected java.lang.String localTotalAmount;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTotalAmountTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTotalAmount() {
			return localTotalAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TotalAmount
		 */
		public void setTotalAmount(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localTotalAmountTracker = true;
			} else {
				localTotalAmountTracker = false;

			}

			this.localTotalAmount = param;

		}

		/**
		 * field for Seller
		 */

		protected java.lang.String localSeller;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSellerTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSeller() {
			return localSeller;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Seller
		 */
		public void setSeller(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localSellerTracker = true;
			} else {
				localSellerTracker = false;

			}

			this.localSeller = param;

		}

		/**
		 * field for CallerPhoneNumber
		 */

		protected java.lang.String localCallerPhoneNumber;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCallerPhoneNumberTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCallerPhoneNumber() {
			return localCallerPhoneNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CallerPhoneNumber
		 */
		public void setCallerPhoneNumber(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCallerPhoneNumberTracker = true;
			} else {
				localCallerPhoneNumberTracker = false;

			}

			this.localCallerPhoneNumber = param;

		}

		/**
		 * field for TerminalCode
		 */

		protected java.lang.String localTerminalCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTerminalCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTerminalCode() {
			return localTerminalCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TerminalCode
		 */
		public void setTerminalCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localTerminalCodeTracker = true;
			} else {
				localTerminalCodeTracker = false;

			}

			this.localTerminalCode = param;

		}

		/**
		 * field for PlanId
		 */

		protected int localPlanId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPlanIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getPlanId() {
			return localPlanId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PlanId
		 */
		public void setPlanId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localPlanIdTracker = false;

			} else {
				localPlanIdTracker = true;
			}

			this.localPlanId = param;

		}

		/**
		 * field for QuotaId
		 */

		protected int localQuotaId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localQuotaIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getQuotaId() {
			return localQuotaId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            QuotaId
		 */
		public void setQuotaId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localQuotaIdTracker = false;

			} else {
				localQuotaIdTracker = true;
			}

			this.localQuotaId = param;

		}

		/**
		 * field for Iva
		 */

		protected java.lang.String localIva;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localIvaTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getIva() {
			return localIva;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Iva
		 */
		public void setIva(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localIvaTracker = true;
			} else {
				localIvaTracker = false;

			}

			this.localIva = param;

		}

		/**
		 * field for IvaReturn
		 */

		protected java.lang.String localIvaReturn;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localIvaReturnTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getIvaReturn() {
			return localIvaReturn;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            IvaReturn
		 */
		public void setIvaReturn(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localIvaReturnTracker = true;
			} else {
				localIvaReturnTracker = false;

			}

			this.localIvaReturn = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					PurchaseData.this
							.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":PurchaseData",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "PurchaseData", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "currencyCode",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "currencyCode");
				}

			} else {
				xmlWriter.writeStartElement("currencyCode");
			}

			if (localCurrencyCode == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"currencyCode cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCurrencyCode));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "purchaseCode",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "purchaseCode");
				}

			} else {
				xmlWriter.writeStartElement("purchaseCode");
			}

			if (localPurchaseCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"purchaseCode cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localPurchaseCode);

			}

			xmlWriter.writeEndElement();
			if (localTotalAmountTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "totalAmount",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "totalAmount");
					}

				} else {
					xmlWriter.writeStartElement("totalAmount");
				}

				if (localTotalAmount == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"totalAmount cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localTotalAmount);

				}

				xmlWriter.writeEndElement();
			}
			if (localSellerTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "seller", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "seller");
					}

				} else {
					xmlWriter.writeStartElement("seller");
				}

				if (localSeller == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"seller cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localSeller);

				}

				xmlWriter.writeEndElement();
			}
			if (localCallerPhoneNumberTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"callerPhoneNumber", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"callerPhoneNumber");
					}

				} else {
					xmlWriter.writeStartElement("callerPhoneNumber");
				}

				if (localCallerPhoneNumber == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"callerPhoneNumber cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCallerPhoneNumber);

				}

				xmlWriter.writeEndElement();
			}
			if (localTerminalCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "terminalCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "terminalCode");
					}

				} else {
					xmlWriter.writeStartElement("terminalCode");
				}

				if (localTerminalCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"terminalCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localTerminalCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localPlanIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "planId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "planId");
					}

				} else {
					xmlWriter.writeStartElement("planId");
				}

				if (localPlanId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"planId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPlanId));
				}

				xmlWriter.writeEndElement();
			}
			if (localQuotaIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "quotaId",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "quotaId");
					}

				} else {
					xmlWriter.writeStartElement("quotaId");
				}

				if (localQuotaId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"quotaId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localQuotaId));
				}

				xmlWriter.writeEndElement();
			}
			if (localIvaTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "iva", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "iva");
					}

				} else {
					xmlWriter.writeStartElement("iva");
				}

				if (localIva == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"iva cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localIva);

				}

				xmlWriter.writeEndElement();
			}
			if (localIvaReturnTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "ivaReturn",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "ivaReturn");
					}

				} else {
					xmlWriter.writeStartElement("ivaReturn");
				}

				if (localIvaReturn == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"ivaReturn cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localIvaReturn);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "currencyCode"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localCurrencyCode));

			elementList.add(new javax.xml.namespace.QName("", "purchaseCode"));

			if (localPurchaseCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localPurchaseCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"purchaseCode cannot be null!!");
			}
			if (localTotalAmountTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "totalAmount"));

				if (localTotalAmount != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localTotalAmount));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"totalAmount cannot be null!!");
				}
			}
			if (localSellerTracker) {
				elementList.add(new javax.xml.namespace.QName("", "seller"));

				if (localSeller != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localSeller));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"seller cannot be null!!");
				}
			}
			if (localCallerPhoneNumberTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"callerPhoneNumber"));

				if (localCallerPhoneNumber != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCallerPhoneNumber));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"callerPhoneNumber cannot be null!!");
				}
			}
			if (localTerminalCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"terminalCode"));

				if (localTerminalCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localTerminalCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"terminalCode cannot be null!!");
				}
			}
			if (localPlanIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "planId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localPlanId));
			}
			if (localQuotaIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "quotaId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localQuotaId));
			}
			if (localIvaTracker) {
				elementList.add(new javax.xml.namespace.QName("", "iva"));

				if (localIva != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localIva));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"iva cannot be null!!");
				}
			}
			if (localIvaReturnTracker) {
				elementList.add(new javax.xml.namespace.QName("", "ivaReturn"));

				if (localIvaReturn != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localIvaReturn));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"ivaReturn cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static PurchaseData parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				PurchaseData object = new PurchaseData();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"PurchaseData".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (PurchaseData) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "currencyCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCurrencyCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "purchaseCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPurchaseCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "totalAmount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setTotalAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "seller")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setSeller(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"callerPhoneNumber").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCallerPhoneNumber(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "terminalCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setTerminalCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "planId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPlanId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setPlanId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "quotaId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setQuotaId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setQuotaId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "iva")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setIva(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "ivaReturn")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setIvaReturn(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class AdministrativeRate implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * AdministrativeRate Namespace URI = http://www.alignet.com/VPOSWS20/
		 * Namespace Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for AdministrativeRateAmount
		 */

		protected java.lang.String localAdministrativeRateAmount;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdministrativeRateAmount() {
			return localAdministrativeRateAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdministrativeRateAmount
		 */
		public void setAdministrativeRateAmount(java.lang.String param) {

			this.localAdministrativeRateAmount = param;

		}

		/**
		 * field for AdministrativeRateIva
		 */

		protected java.lang.String localAdministrativeRateIva;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAdministrativeRateIvaTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdministrativeRateIva() {
			return localAdministrativeRateIva;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdministrativeRateIva
		 */
		public void setAdministrativeRateIva(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAdministrativeRateIvaTracker = true;
			} else {
				localAdministrativeRateIvaTracker = false;

			}

			this.localAdministrativeRateIva = param;

		}

		/**
		 * field for AdministrativeRateIvaReturn
		 */

		protected java.lang.String localAdministrativeRateIvaReturn;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAdministrativeRateIvaReturnTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdministrativeRateIvaReturn() {
			return localAdministrativeRateIvaReturn;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdministrativeRateIvaReturn
		 */
		public void setAdministrativeRateIvaReturn(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAdministrativeRateIvaReturnTracker = true;
			} else {
				localAdministrativeRateIvaReturnTracker = false;

			}

			this.localAdministrativeRateIvaReturn = param;

		}

		/**
		 * field for AdministrativeRateCode
		 */

		protected java.lang.String localAdministrativeRateCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAdministrativeRateCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdministrativeRateCode() {
			return localAdministrativeRateCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdministrativeRateCode
		 */
		public void setAdministrativeRateCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAdministrativeRateCodeTracker = true;
			} else {
				localAdministrativeRateCodeTracker = false;

			}

			this.localAdministrativeRateCode = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					AdministrativeRate.this.serialize(parentQName, factory,
							xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":AdministrativeRate",
							xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "AdministrativeRate", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix,
							"administrativeRateAmount", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace,
							"administrativeRateAmount");
				}

			} else {
				xmlWriter.writeStartElement("administrativeRateAmount");
			}

			if (localAdministrativeRateAmount == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"administrativeRateAmount cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAdministrativeRateAmount);

			}

			xmlWriter.writeEndElement();
			if (localAdministrativeRateIvaTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"administrativeRateIva", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"administrativeRateIva");
					}

				} else {
					xmlWriter.writeStartElement("administrativeRateIva");
				}

				if (localAdministrativeRateIva == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateIva cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAdministrativeRateIva);

				}

				xmlWriter.writeEndElement();
			}
			if (localAdministrativeRateIvaReturnTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"administrativeRateIvaReturn", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"administrativeRateIvaReturn");
					}

				} else {
					xmlWriter.writeStartElement("administrativeRateIvaReturn");
				}

				if (localAdministrativeRateIvaReturn == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateIvaReturn cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAdministrativeRateIvaReturn);

				}

				xmlWriter.writeEndElement();
			}
			if (localAdministrativeRateCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"administrativeRateCode", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"administrativeRateCode");
					}

				} else {
					xmlWriter.writeStartElement("administrativeRateCode");
				}

				if (localAdministrativeRateCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAdministrativeRateCode);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("",
					"administrativeRateAmount"));

			if (localAdministrativeRateAmount != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAdministrativeRateAmount));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"administrativeRateAmount cannot be null!!");
			}
			if (localAdministrativeRateIvaTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"administrativeRateIva"));

				if (localAdministrativeRateIva != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAdministrativeRateIva));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateIva cannot be null!!");
				}
			}
			if (localAdministrativeRateIvaReturnTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"administrativeRateIvaReturn"));

				if (localAdministrativeRateIvaReturn != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAdministrativeRateIvaReturn));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateIvaReturn cannot be null!!");
				}
			}
			if (localAdministrativeRateCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"administrativeRateCode"));

				if (localAdministrativeRateCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAdministrativeRateCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRateCode cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AdministrativeRate parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				AdministrativeRate object = new AdministrativeRate();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"AdministrativeRate".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (AdministrativeRate) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"administrativeRateAmount").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdministrativeRateAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"administrativeRateIva").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdministrativeRateIva(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"administrativeRateIvaReturn")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdministrativeRateIvaReturn(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"administrativeRateCode").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdministrativeRateCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Reverse implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "reverse", "ns1");

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for AcquirerId
		 */

		protected int localAcquirerId;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getAcquirerId() {
			return localAcquirerId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AcquirerId
		 */
		public void setAcquirerId(int param) {

			this.localAcquirerId = param;

		}

		/**
		 * field for CommerceId
		 */

		protected int localCommerceId;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getCommerceId() {
			return localCommerceId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CommerceId
		 */
		public void setCommerceId(int param) {

			this.localCommerceId = param;

		}

		/**
		 * field for PurchaseCode
		 */

		protected java.lang.String localPurchaseCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPurchaseCode() {
			return localPurchaseCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PurchaseCode
		 */
		public void setPurchaseCode(java.lang.String param) {

			this.localPurchaseCode = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Reverse.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":reverse", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "reverse", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter
							.writeStartElement(prefix, "acquirerId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "acquirerId");
				}

			} else {
				xmlWriter.writeStartElement("acquirerId");
			}

			if (localAcquirerId == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"acquirerId cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAcquirerId));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter
							.writeStartElement(prefix, "commerceId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "commerceId");
				}

			} else {
				xmlWriter.writeStartElement("commerceId");
			}

			if (localCommerceId == java.lang.Integer.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"commerceId cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCommerceId));
			}

			xmlWriter.writeEndElement();

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "purchaseCode",
							namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "purchaseCode");
				}

			} else {
				xmlWriter.writeStartElement("purchaseCode");
			}

			if (localPurchaseCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"purchaseCode cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localPurchaseCode);

			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "acquirerId"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localAcquirerId));

			elementList.add(new javax.xml.namespace.QName("", "commerceId"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localCommerceId));

			elementList.add(new javax.xml.namespace.QName("", "purchaseCode"));

			if (localPurchaseCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localPurchaseCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"purchaseCode cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Reverse parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Reverse object = new Reverse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"reverse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Reverse) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "acquirerId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAcquirerId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "commerceId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCommerceId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "purchaseCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPurchaseCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Airport implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Airport Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Code
		 */

		protected java.lang.String localCode;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCode() {
			return localCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Code
		 */
		public void setCode(java.lang.String param) {

			this.localCode = param;

		}

		/**
		 * field for City
		 */

		protected java.lang.String localCity;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCityTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCity() {
			return localCity;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            City
		 */
		public void setCity(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCityTracker = true;
			} else {
				localCityTracker = false;

			}

			this.localCity = param;

		}

		/**
		 * field for Country
		 */

		protected java.lang.String localCountry;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCountryTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCountry() {
			return localCountry;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Country
		 */
		public void setCountry(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCountryTracker = true;
			} else {
				localCountryTracker = false;

			}

			this.localCountry = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Airport.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":Airport", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "Airport", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "code", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "code");
				}

			} else {
				xmlWriter.writeStartElement("code");
			}

			if (localCode == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"code cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localCode);

			}

			xmlWriter.writeEndElement();
			if (localCityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "city", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "city");
					}

				} else {
					xmlWriter.writeStartElement("city");
				}

				if (localCity == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"city cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCity);

				}

				xmlWriter.writeEndElement();
			}
			if (localCountryTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "country",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "country");
					}

				} else {
					xmlWriter.writeStartElement("country");
				}

				if (localCountry == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"country cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCountry);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "code"));

			if (localCode != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCode));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"code cannot be null!!");
			}
			if (localCityTracker) {
				elementList.add(new javax.xml.namespace.QName("", "city"));

				if (localCity != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCity));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"city cannot be null!!");
				}
			}
			if (localCountryTracker) {
				elementList.add(new javax.xml.namespace.QName("", "country"));

				if (localCountry != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCountry));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"country cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Airport parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Airport object = new Airport();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Airport".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Airport) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "code")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "city")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCity(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "country")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCountry(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Authorize implements
			org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.alignet.com/VPOSWS20/", "authorize", "ns1");

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for CommerceId
		 */

		protected int localCommerceId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCommerceIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getCommerceId() {
			return localCommerceId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CommerceId
		 */
		public void setCommerceId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localCommerceIdTracker = false;

			} else {
				localCommerceIdTracker = true;
			}

			this.localCommerceId = param;

		}

		/**
		 * field for AcquirerId
		 */

		protected int localAcquirerId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAcquirerIdTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return int
		 */
		public int getAcquirerId() {
			return localAcquirerId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AcquirerId
		 */
		public void setAcquirerId(int param) {

			// setting primitive attribute tracker to true

			if (param == java.lang.Integer.MIN_VALUE) {
				localAcquirerIdTracker = false;

			} else {
				localAcquirerIdTracker = true;
			}

			this.localAcquirerId = param;

		}

		/**
		 * field for Language
		 */

		protected java.lang.String localLanguage;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localLanguageTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLanguage() {
			return localLanguage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Language
		 */
		public void setLanguage(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localLanguageTracker = true;
			} else {
				localLanguageTracker = false;

			}

			this.localLanguage = param;

		}

		/**
		 * field for IpAddress
		 */

		protected java.lang.String localIpAddress;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localIpAddressTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getIpAddress() {
			return localIpAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            IpAddress
		 */
		public void setIpAddress(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localIpAddressTracker = true;
			} else {
				localIpAddressTracker = false;

			}

			this.localIpAddress = param;

		}

		/**
		 * field for TransactionTrace
		 */

		protected java.lang.String localTransactionTrace;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTransactionTraceTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTransactionTrace() {
			return localTransactionTrace;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TransactionTrace
		 */
		public void setTransactionTrace(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localTransactionTraceTracker = true;
			} else {
				localTransactionTraceTracker = false;

			}

			this.localTransactionTrace = param;

		}

		/**
		 * field for Fingerprint
		 */

		protected java.lang.String localFingerprint;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFingerprintTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFingerprint() {
			return localFingerprint;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Fingerprint
		 */
		public void setFingerprint(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localFingerprintTracker = true;
			} else {
				localFingerprintTracker = false;

			}

			this.localFingerprint = param;

		}

		/**
		 * field for AdditionalObservations
		 */

		protected java.lang.String localAdditionalObservations;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAdditionalObservationsTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAdditionalObservations() {
			return localAdditionalObservations;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdditionalObservations
		 */
		public void setAdditionalObservations(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAdditionalObservationsTracker = true;
			} else {
				localAdditionalObservationsTracker = false;

			}

			this.localAdditionalObservations = param;

		}

		/**
		 * field for PurchaseData
		 */

		protected PurchaseData localPurchaseData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPurchaseDataTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return PurchaseData
		 */
		public PurchaseData getPurchaseData() {
			return localPurchaseData;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PurchaseData
		 */
		public void setPurchaseData(PurchaseData param) {

			if (param != null) {
				// update the setting tracker
				localPurchaseDataTracker = true;
			} else {
				localPurchaseDataTracker = false;

			}

			this.localPurchaseData = param;

		}

		/**
		 * field for CardData
		 */

		protected CardData localCardData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCardDataTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return CardData
		 */
		public CardData getCardData() {
			return localCardData;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CardData
		 */
		public void setCardData(CardData param) {

			if (param != null) {
				// update the setting tracker
				localCardDataTracker = true;
			} else {
				localCardDataTracker = false;

			}

			this.localCardData = param;

		}

		/**
		 * field for BillingData
		 */

		protected Person localBillingData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localBillingDataTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Person
		 */
		public Person getBillingData() {
			return localBillingData;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            BillingData
		 */
		public void setBillingData(Person param) {

			if (param != null) {
				// update the setting tracker
				localBillingDataTracker = true;
			} else {
				localBillingDataTracker = false;

			}

			this.localBillingData = param;

		}

		/**
		 * field for ShippingData
		 */

		protected ShippingData localShippingData;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localShippingDataTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return ShippingData
		 */
		public ShippingData getShippingData() {
			return localShippingData;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ShippingData
		 */
		public void setShippingData(ShippingData param) {

			if (param != null) {
				// update the setting tracker
				localShippingDataTracker = true;
			} else {
				localShippingDataTracker = false;

			}

			this.localShippingData = param;

		}

		/**
		 * field for OrderWeb
		 */

		protected OrderWeb localOrderWeb;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localOrderWebTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return OrderWeb
		 */
		public OrderWeb getOrderWeb() {
			return localOrderWeb;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            OrderWeb
		 */
		public void setOrderWeb(OrderWeb param) {

			if (param != null) {
				// update the setting tracker
				localOrderWebTracker = true;
			} else {
				localOrderWebTracker = false;

			}

			this.localOrderWeb = param;

		}

		/**
		 * field for Flight
		 */

		protected Flight localFlight;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFlightTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Flight
		 */
		public Flight getFlight() {
			return localFlight;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Flight
		 */
		public void setFlight(Flight param) {

			if (param != null) {
				// update the setting tracker
				localFlightTracker = true;
			} else {
				localFlightTracker = false;

			}

			this.localFlight = param;

		}

		/**
		 * field for Good
		 */

		protected Good localGood;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localGoodTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Good
		 */
		public Good getGood() {
			return localGood;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Good
		 */
		public void setGood(Good param) {

			if (param != null) {
				// update the setting tracker
				localGoodTracker = true;
			} else {
				localGoodTracker = false;

			}

			this.localGood = param;

		}

		/**
		 * field for AdministrativeRate
		 */

		protected AdministrativeRate localAdministrativeRate;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAdministrativeRateTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return AdministrativeRate
		 */
		public AdministrativeRate getAdministrativeRate() {
			return localAdministrativeRate;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AdministrativeRate
		 */
		public void setAdministrativeRate(AdministrativeRate param) {

			if (param != null) {
				// update the setting tracker
				localAdministrativeRateTracker = true;
			} else {
				localAdministrativeRateTracker = false;

			}

			this.localAdministrativeRate = param;

		}

		/**
		 * field for Taxes This was an Array!
		 */

		protected Tax[] localTaxes;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTaxesTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Tax[]
		 */
		public Tax[] getTaxes() {
			return localTaxes;
		}

		/**
		 * validate the array for Taxes
		 */
		protected void validateTaxes(Tax[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Taxes
		 */
		public void setTaxes(Tax[] param) {

			validateTaxes(param);

			if (param != null) {
				// update the setting tracker
				localTaxesTracker = true;
			} else {
				localTaxesTracker = false;

			}

			this.localTaxes = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            Tax
		 */
		public void addTaxes(Tax param) {
			if (localTaxes == null) {
				localTaxes = new Tax[] {};
			}

			// update the setting tracker
			localTaxesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localTaxes);
			list.add(param);
			this.localTaxes = (Tax[]) list.toArray(new Tax[list.size()]);

		}

		/**
		 * field for ReservedFields This was an Array!
		 */

		protected ReservedField[] localReservedFields;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReservedFieldsTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return ReservedField[]
		 */
		public ReservedField[] getReservedFields() {
			return localReservedFields;
		}

		/**
		 * validate the array for ReservedFields
		 */
		protected void validateReservedFields(ReservedField[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReservedFields
		 */
		public void setReservedFields(ReservedField[] param) {

			validateReservedFields(param);

			if (param != null) {
				// update the setting tracker
				localReservedFieldsTracker = true;
			} else {
				localReservedFieldsTracker = false;

			}

			this.localReservedFields = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            ReservedField
		 */
		public void addReservedFields(ReservedField param) {
			if (localReservedFields == null) {
				localReservedFields = new ReservedField[] {};
			}

			// update the setting tracker
			localReservedFieldsTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localReservedFields);
			list.add(param);
			this.localReservedFields = (ReservedField[]) list
					.toArray(new ReservedField[list.size()]);

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, MY_QNAME) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Authorize.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":authorize", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "authorize", xmlWriter);
				}

			}
			if (localCommerceIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "commerceId",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "commerceId");
					}

				} else {
					xmlWriter.writeStartElement("commerceId");
				}

				if (localCommerceId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"commerceId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCommerceId));
				}

				xmlWriter.writeEndElement();
			}
			if (localAcquirerIdTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "acquirerId",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "acquirerId");
					}

				} else {
					xmlWriter.writeStartElement("acquirerId");
				}

				if (localAcquirerId == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"acquirerId cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAcquirerId));
				}

				xmlWriter.writeEndElement();
			}
			if (localLanguageTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "language",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "language");
					}

				} else {
					xmlWriter.writeStartElement("language");
				}

				if (localLanguage == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"language cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localLanguage);

				}

				xmlWriter.writeEndElement();
			}
			if (localIpAddressTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "ipAddress",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "ipAddress");
					}

				} else {
					xmlWriter.writeStartElement("ipAddress");
				}

				if (localIpAddress == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"ipAddress cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localIpAddress);

				}

				xmlWriter.writeEndElement();
			}
			if (localTransactionTraceTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "transactionTrace",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"transactionTrace");
					}

				} else {
					xmlWriter.writeStartElement("transactionTrace");
				}

				if (localTransactionTrace == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"transactionTrace cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localTransactionTrace);

				}

				xmlWriter.writeEndElement();
			}
			if (localFingerprintTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "fingerprint",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "fingerprint");
					}

				} else {
					xmlWriter.writeStartElement("fingerprint");
				}

				if (localFingerprint == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"fingerprint cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localFingerprint);

				}

				xmlWriter.writeEndElement();
			}
			if (localAdditionalObservationsTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix,
								"additionalObservations", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"additionalObservations");
					}

				} else {
					xmlWriter.writeStartElement("additionalObservations");
				}

				if (localAdditionalObservations == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"additionalObservations cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAdditionalObservations);

				}

				xmlWriter.writeEndElement();
			}
			if (localPurchaseDataTracker) {
				if (localPurchaseData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"purchaseData cannot be null!!");
				}
				localPurchaseData.serialize(new javax.xml.namespace.QName("",
						"purchaseData"), factory, xmlWriter);
			}
			if (localCardDataTracker) {
				if (localCardData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"cardData cannot be null!!");
				}
				localCardData.serialize(new javax.xml.namespace.QName("",
						"cardData"), factory, xmlWriter);
			}
			if (localBillingDataTracker) {
				if (localBillingData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"billingData cannot be null!!");
				}
				localBillingData.serialize(new javax.xml.namespace.QName("",
						"billingData"), factory, xmlWriter);
			}
			if (localShippingDataTracker) {
				if (localShippingData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"shippingData cannot be null!!");
				}
				localShippingData.serialize(new javax.xml.namespace.QName("",
						"shippingData"), factory, xmlWriter);
			}
			if (localOrderWebTracker) {
				if (localOrderWeb == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"orderWeb cannot be null!!");
				}
				localOrderWeb.serialize(new javax.xml.namespace.QName("",
						"orderWeb"), factory, xmlWriter);
			}
			if (localFlightTracker) {
				if (localFlight == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"flight cannot be null!!");
				}
				localFlight.serialize(new javax.xml.namespace.QName("",
						"flight"), factory, xmlWriter);
			}
			if (localGoodTracker) {
				if (localGood == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"good cannot be null!!");
				}
				localGood.serialize(new javax.xml.namespace.QName("", "good"),
						factory, xmlWriter);
			}
			if (localAdministrativeRateTracker) {
				if (localAdministrativeRate == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRate cannot be null!!");
				}
				localAdministrativeRate
						.serialize(new javax.xml.namespace.QName("",
								"administrativeRate"), factory, xmlWriter);
			}
			if (localTaxesTracker) {
				if (localTaxes != null) {
					for (int i = 0; i < localTaxes.length; i++) {
						if (localTaxes[i] != null) {
							localTaxes[i].serialize(
									new javax.xml.namespace.QName("", "taxes"),
									factory, xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"taxes cannot be null!!");

				}
			}
			if (localReservedFieldsTracker) {
				if (localReservedFields != null) {
					for (int i = 0; i < localReservedFields.length; i++) {
						if (localReservedFields[i] != null) {
							localReservedFields[i].serialize(
									new javax.xml.namespace.QName("",
											"reservedFields"), factory,
									xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"reservedFields cannot be null!!");

				}
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localCommerceIdTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "commerceId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localCommerceId));
			}
			if (localAcquirerIdTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "acquirerId"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAcquirerId));
			}
			if (localLanguageTracker) {
				elementList.add(new javax.xml.namespace.QName("", "language"));

				if (localLanguage != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localLanguage));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"language cannot be null!!");
				}
			}
			if (localIpAddressTracker) {
				elementList.add(new javax.xml.namespace.QName("", "ipAddress"));

				if (localIpAddress != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localIpAddress));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"ipAddress cannot be null!!");
				}
			}
			if (localTransactionTraceTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"transactionTrace"));

				if (localTransactionTrace != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localTransactionTrace));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"transactionTrace cannot be null!!");
				}
			}
			if (localFingerprintTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "fingerprint"));

				if (localFingerprint != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localFingerprint));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"fingerprint cannot be null!!");
				}
			}
			if (localAdditionalObservationsTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"additionalObservations"));

				if (localAdditionalObservations != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAdditionalObservations));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"additionalObservations cannot be null!!");
				}
			}
			if (localPurchaseDataTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"purchaseData"));

				if (localPurchaseData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"purchaseData cannot be null!!");
				}
				elementList.add(localPurchaseData);
			}
			if (localCardDataTracker) {
				elementList.add(new javax.xml.namespace.QName("", "cardData"));

				if (localCardData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"cardData cannot be null!!");
				}
				elementList.add(localCardData);
			}
			if (localBillingDataTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "billingData"));

				if (localBillingData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"billingData cannot be null!!");
				}
				elementList.add(localBillingData);
			}
			if (localShippingDataTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"shippingData"));

				if (localShippingData == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"shippingData cannot be null!!");
				}
				elementList.add(localShippingData);
			}
			if (localOrderWebTracker) {
				elementList.add(new javax.xml.namespace.QName("", "orderWeb"));

				if (localOrderWeb == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"orderWeb cannot be null!!");
				}
				elementList.add(localOrderWeb);
			}
			if (localFlightTracker) {
				elementList.add(new javax.xml.namespace.QName("", "flight"));

				if (localFlight == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"flight cannot be null!!");
				}
				elementList.add(localFlight);
			}
			if (localGoodTracker) {
				elementList.add(new javax.xml.namespace.QName("", "good"));

				if (localGood == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"good cannot be null!!");
				}
				elementList.add(localGood);
			}
			if (localAdministrativeRateTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"administrativeRate"));

				if (localAdministrativeRate == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"administrativeRate cannot be null!!");
				}
				elementList.add(localAdministrativeRate);
			}
			if (localTaxesTracker) {
				if (localTaxes != null) {
					for (int i = 0; i < localTaxes.length; i++) {

						if (localTaxes[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"taxes"));
							elementList.add(localTaxes[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"taxes cannot be null!!");

				}

			}
			if (localReservedFieldsTracker) {
				if (localReservedFields != null) {
					for (int i = 0; i < localReservedFields.length; i++) {

						if (localReservedFields[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"reservedFields"));
							elementList.add(localReservedFields[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"reservedFields cannot be null!!");

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Authorize parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Authorize object = new Authorize();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"authorize".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Authorize) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list16 = new java.util.ArrayList();

					java.util.ArrayList list17 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "commerceId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCommerceId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setCommerceId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "acquirerId")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAcquirerId(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setAcquirerId(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "language")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setLanguage(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "ipAddress")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setIpAddress(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"transactionTrace")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setTransactionTrace(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "fingerprint")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setFingerprint(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"additionalObservations").equals(reader
									.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAdditionalObservations(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "purchaseData")
									.equals(reader.getName())) {

						object.setPurchaseData(PurchaseData.Factory
								.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "cardData")
									.equals(reader.getName())) {

						object.setCardData(CardData.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "billingData")
									.equals(reader.getName())) {

						object.setBillingData(Person.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "shippingData")
									.equals(reader.getName())) {

						object.setShippingData(ShippingData.Factory
								.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "orderWeb")
									.equals(reader.getName())) {

						object.setOrderWeb(OrderWeb.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "flight")
									.equals(reader.getName())) {

						object.setFlight(Flight.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "good")
									.equals(reader.getName())) {

						object.setGood(Good.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"administrativeRate").equals(reader
									.getName())) {

						object.setAdministrativeRate(AdministrativeRate.Factory
								.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "taxes")
									.equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list16.add(Tax.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone16 = false;
						while (!loopDone16) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone16 = true;
							} else {
								if (new javax.xml.namespace.QName("", "taxes")
										.equals(reader.getName())) {
									list16.add(Tax.Factory.parse(reader));

								} else {
									loopDone16 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setTaxes((Tax[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(Tax.class, list16));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"reservedFields").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list17.add(ReservedField.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone17 = false;
						while (!loopDone17) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone17 = true;
							} else {
								if (new javax.xml.namespace.QName("",
										"reservedFields").equals(reader
										.getName())) {
									list17.add(ReservedField.Factory
											.parse(reader));

								} else {
									loopDone17 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setReservedFields((ReservedField[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(ReservedField.class, list17));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	public static class Flight extends Product implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * Flight Namespace URI = http://www.alignet.com/VPOSWS20/ Namespace
		 * Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for AirlineCode
		 */

		protected java.lang.String localAirlineCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAirlineCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAirlineCode() {
			return localAirlineCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AirlineCode
		 */
		public void setAirlineCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAirlineCodeTracker = true;
			} else {
				localAirlineCodeTracker = false;

			}

			this.localAirlineCode = param;

		}

		/**
		 * field for DepartureAirport
		 */

		protected Airport localDepartureAirport;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDepartureAirportTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Airport
		 */
		public Airport getDepartureAirport() {
			return localDepartureAirport;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DepartureAirport
		 */
		public void setDepartureAirport(Airport param) {

			if (param != null) {
				// update the setting tracker
				localDepartureAirportTracker = true;
			} else {
				localDepartureAirportTracker = false;

			}

			this.localDepartureAirport = param;

		}

		/**
		 * field for ArriveAirport
		 */

		protected Airport localArriveAirport;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localArriveAirportTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Airport
		 */
		public Airport getArriveAirport() {
			return localArriveAirport;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ArriveAirport
		 */
		public void setArriveAirport(Airport param) {

			if (param != null) {
				// update the setting tracker
				localArriveAirportTracker = true;
			} else {
				localArriveAirportTracker = false;

			}

			this.localArriveAirport = param;

		}

		/**
		 * field for DepartureDate
		 */

		protected java.lang.String localDepartureDate;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDepartureDateTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDepartureDate() {
			return localDepartureDate;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DepartureDate
		 */
		public void setDepartureDate(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDepartureDateTracker = true;
			} else {
				localDepartureDateTracker = false;

			}

			this.localDepartureDate = param;

		}

		/**
		 * field for DepartureTime
		 */

		protected java.lang.String localDepartureTime;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localDepartureTimeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDepartureTime() {
			return localDepartureTime;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DepartureTime
		 */
		public void setDepartureTime(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localDepartureTimeTracker = true;
			} else {
				localDepartureTimeTracker = false;

			}

			this.localDepartureTime = param;

		}

		/**
		 * field for ArriveDate
		 */

		protected java.lang.String localArriveDate;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localArriveDateTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getArriveDate() {
			return localArriveDate;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ArriveDate
		 */
		public void setArriveDate(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localArriveDateTracker = true;
			} else {
				localArriveDateTracker = false;

			}

			this.localArriveDate = param;

		}

		/**
		 * field for ArriveTime
		 */

		protected java.lang.String localArriveTime;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localArriveTimeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getArriveTime() {
			return localArriveTime;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ArriveTime
		 */
		public void setArriveTime(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localArriveTimeTracker = true;
			} else {
				localArriveTimeTracker = false;

			}

			this.localArriveTime = param;

		}

		/**
		 * field for PassengerList This was an Array!
		 */

		protected Passenger[] localPassengerList;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPassengerListTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Passenger[]
		 */
		public Passenger[] getPassengerList() {
			return localPassengerList;
		}

		/**
		 * validate the array for PassengerList
		 */
		protected void validatePassengerList(Passenger[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PassengerList
		 */
		public void setPassengerList(Passenger[] param) {

			validatePassengerList(param);

			if (param != null) {
				// update the setting tracker
				localPassengerListTracker = true;
			} else {
				localPassengerListTracker = false;

			}

			this.localPassengerList = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            Passenger
		 */
		public void addPassengerList(Passenger param) {
			if (localPassengerList == null) {
				localPassengerList = new Passenger[] {};
			}

			// update the setting tracker
			localPassengerListTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
					.toList(localPassengerList);
			list.add(param);
			this.localPassengerList = (Passenger[]) list
					.toArray(new Passenger[list.size()]);

		}

		/**
		 * field for Reservation
		 */

		protected java.lang.String localReservation;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReservationTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getReservation() {
			return localReservation;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Reservation
		 */
		public void setReservation(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localReservationTracker = true;
			} else {
				localReservationTracker = false;

			}

			this.localReservation = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					Flight.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://www.alignet.com/VPOSWS20/");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":Flight", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Flight", xmlWriter);
			}

			if (localItemTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "item", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "item");
					}

				} else {
					xmlWriter.writeStartElement("item");
				}

				if (localItem == java.lang.Integer.MIN_VALUE) {

					throw new org.apache.axis2.databinding.ADBException(
							"item cannot be null!!");

				} else {
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localItem));
				}

				xmlWriter.writeEndElement();
			}
			if (localCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "code", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "code");
					}

				} else {
					xmlWriter.writeStartElement("code");
				}

				if (localCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localAmountTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter
								.writeStartElement(prefix, "amount", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "amount");
					}

				} else {
					xmlWriter.writeStartElement("amount");
				}

				if (localAmount == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAmount);

				}

				xmlWriter.writeEndElement();
			}
			if (localPromotionCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "promotionCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "promotionCode");
					}

				} else {
					xmlWriter.writeStartElement("promotionCode");
				}

				if (localPromotionCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPromotionCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localAirlineCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "airlineCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "airlineCode");
					}

				} else {
					xmlWriter.writeStartElement("airlineCode");
				}

				if (localAirlineCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"airlineCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localAirlineCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localDepartureAirportTracker) {
				if (localDepartureAirport == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"departureAirport cannot be null!!");
				}
				localDepartureAirport.serialize(new javax.xml.namespace.QName(
						"", "departureAirport"), factory, xmlWriter);
			}
			if (localArriveAirportTracker) {
				if (localArriveAirport == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"arriveAirport cannot be null!!");
				}
				localArriveAirport.serialize(new javax.xml.namespace.QName("",
						"arriveAirport"), factory, xmlWriter);
			}
			if (localDepartureDateTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "departureDate",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "departureDate");
					}

				} else {
					xmlWriter.writeStartElement("departureDate");
				}

				if (localDepartureDate == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"departureDate cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDepartureDate);

				}

				xmlWriter.writeEndElement();
			}
			if (localDepartureTimeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "departureTime",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "departureTime");
					}

				} else {
					xmlWriter.writeStartElement("departureTime");
				}

				if (localDepartureTime == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"departureTime cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localDepartureTime);

				}

				xmlWriter.writeEndElement();
			}
			if (localArriveDateTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "arriveDate",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "arriveDate");
					}

				} else {
					xmlWriter.writeStartElement("arriveDate");
				}

				if (localArriveDate == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"arriveDate cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localArriveDate);

				}

				xmlWriter.writeEndElement();
			}
			if (localArriveTimeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "arriveTime",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "arriveTime");
					}

				} else {
					xmlWriter.writeStartElement("arriveTime");
				}

				if (localArriveTime == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"arriveTime cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localArriveTime);

				}

				xmlWriter.writeEndElement();
			}
			if (localPassengerListTracker) {
				if (localPassengerList != null) {
					for (int i = 0; i < localPassengerList.length; i++) {
						if (localPassengerList[i] != null) {
							localPassengerList[i].serialize(
									new javax.xml.namespace.QName("",
											"passengerList"), factory,
									xmlWriter);
						} else {

							// we don't have to do any thing since minOccures is
							// zero

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"passengerList cannot be null!!");

				}
			}
			if (localReservationTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "reservation",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "reservation");
					}

				} else {
					xmlWriter.writeStartElement("reservation");
				}

				if (localReservation == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"reservation cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localReservation);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			attribList.add(new javax.xml.namespace.QName(
					"http://www.w3.org/2001/XMLSchema-instance", "type"));
			attribList.add(new javax.xml.namespace.QName(
					"http://www.alignet.com/VPOSWS20/", "Flight"));
			if (localItemTracker) {
				elementList.add(new javax.xml.namespace.QName("", "item"));

				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localItem));
			}
			if (localCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("", "code"));

				if (localCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"code cannot be null!!");
				}
			}
			if (localAmountTracker) {
				elementList.add(new javax.xml.namespace.QName("", "amount"));

				if (localAmount != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAmount));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"amount cannot be null!!");
				}
			}
			if (localPromotionCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"promotionCode"));

				if (localPromotionCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPromotionCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"promotionCode cannot be null!!");
				}
			}
			if (localAirlineCodeTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "airlineCode"));

				if (localAirlineCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localAirlineCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"airlineCode cannot be null!!");
				}
			}
			if (localDepartureAirportTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"departureAirport"));

				if (localDepartureAirport == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"departureAirport cannot be null!!");
				}
				elementList.add(localDepartureAirport);
			}
			if (localArriveAirportTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"arriveAirport"));

				if (localArriveAirport == null) {
					throw new org.apache.axis2.databinding.ADBException(
							"arriveAirport cannot be null!!");
				}
				elementList.add(localArriveAirport);
			}
			if (localDepartureDateTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"departureDate"));

				if (localDepartureDate != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDepartureDate));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"departureDate cannot be null!!");
				}
			}
			if (localDepartureTimeTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"departureTime"));

				if (localDepartureTime != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localDepartureTime));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"departureTime cannot be null!!");
				}
			}
			if (localArriveDateTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "arriveDate"));

				if (localArriveDate != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localArriveDate));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"arriveDate cannot be null!!");
				}
			}
			if (localArriveTimeTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "arriveTime"));

				if (localArriveTime != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localArriveTime));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"arriveTime cannot be null!!");
				}
			}
			if (localPassengerListTracker) {
				if (localPassengerList != null) {
					for (int i = 0; i < localPassengerList.length; i++) {

						if (localPassengerList[i] != null) {
							elementList.add(new javax.xml.namespace.QName("",
									"passengerList"));
							elementList.add(localPassengerList[i]);
						} else {

							// nothing to do

						}

					}
				} else {

					throw new org.apache.axis2.databinding.ADBException(
							"passengerList cannot be null!!");

				}

			}
			if (localReservationTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "reservation"));

				if (localReservation != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localReservation));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"reservation cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static Flight parse(javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				Flight object = new Flight();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"Flight".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (Flight) ExtensionMapper.getTypeObject(
										nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list12 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "item")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setItem(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToInt(content));

						reader.next();

					} // End of if for expected property start element

					else {

						object.setItem(java.lang.Integer.MIN_VALUE);

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "code")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "amount")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAmount(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"promotionCode").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPromotionCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "airlineCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAirlineCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"departureAirport")
									.equals(reader.getName())) {

						object.setDepartureAirport(Airport.Factory
								.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"arriveAirport").equals(reader.getName())) {

						object.setArriveAirport(Airport.Factory.parse(reader));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"departureDate").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDepartureDate(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"departureTime").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setDepartureTime(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "arriveDate")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setArriveDate(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "arriveTime")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setArriveTime(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"passengerList").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.
						list12.add(Passenger.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone12 = false;
						while (!loopDone12) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement()
									&& !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone12 = true;
							} else {
								if (new javax.xml.namespace.QName("",
										"passengerList").equals(reader
										.getName())) {
									list12.add(Passenger.Factory.parse(reader));

								} else {
									loopDone12 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setPassengerList((Passenger[]) org.apache.axis2.databinding.utils.ConverterUtil
								.convertToArray(Passenger.class, list12));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "reservation")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setReservation(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class AddressData implements
			org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had name =
		 * AddressData Namespace URI = http://www.alignet.com/VPOSWS20/
		 * Namespace Prefix = ns1
		 */

		private static java.lang.String generatePrefix(
				java.lang.String namespace) {
			if (namespace.equals("http://www.alignet.com/VPOSWS20/")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil
					.getUniquePrefix();
		}

		/**
		 * field for Address
		 */

		protected java.lang.String localAddress;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAddress() {
			return localAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Address
		 */
		public void setAddress(java.lang.String param) {

			this.localAddress = param;

		}

		/**
		 * field for City
		 */

		protected java.lang.String localCity;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCityTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCity() {
			return localCity;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            City
		 */
		public void setCity(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCityTracker = true;
			} else {
				localCityTracker = false;

			}

			this.localCity = param;

		}

		/**
		 * field for State
		 */

		protected java.lang.String localState;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localStateTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getState() {
			return localState;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            State
		 */
		public void setState(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localStateTracker = true;
			} else {
				localStateTracker = false;

			}

			this.localState = param;

		}

		/**
		 * field for PostalCode
		 */

		protected java.lang.String localPostalCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPostalCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPostalCode() {
			return localPostalCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PostalCode
		 */
		public void setPostalCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localPostalCodeTracker = true;
			} else {
				localPostalCodeTracker = false;

			}

			this.localPostalCode = param;

		}

		/**
		 * field for CountryCode
		 */

		protected java.lang.String localCountryCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCountryCodeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCountryCode() {
			return localCountryCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CountryCode
		 */
		public void setCountryCode(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCountryCodeTracker = true;
			} else {
				localCountryCodeTracker = false;

			}

			this.localCountryCode = param;

		}

		/**
		 * field for PhoneNumber
		 */

		protected java.lang.String localPhoneNumber;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localPhoneNumberTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getPhoneNumber() {
			return localPhoneNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PhoneNumber
		 */
		public void setPhoneNumber(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localPhoneNumberTracker = true;
			} else {
				localPhoneNumberTracker = false;

			}

			this.localPhoneNumber = param;

		}

		/**
		 * field for CellPhoneNumber
		 */

		protected java.lang.String localCellPhoneNumber;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCellPhoneNumberTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCellPhoneNumber() {
			return localCellPhoneNumber;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            CellPhoneNumber
		 */
		public void setCellPhoneNumber(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localCellPhoneNumberTracker = true;
			} else {
				localCellPhoneNumberTracker = false;

			}

			this.localCellPhoneNumber = param;

		}

		/**
		 * field for Email
		 */

		protected java.lang.String localEmail;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localEmailTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getEmail() {
			return localEmail;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Email
		 */
		public void setEmail(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localEmailTracker = true;
			} else {
				localEmailTracker = false;

			}

			this.localEmail = param;

		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(
				javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE
						.equals(reader
								.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory)
				throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
					this, parentQName) {

				public void serialize(
						org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
						throws javax.xml.stream.XMLStreamException {
					AddressData.this.serialize(parentQName, factory, xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName, factory, dataSource);

		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {
			serialize(parentQName, factory, xmlWriter, false);
		}

		public void serialize(
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
				boolean serializeType)
				throws javax.xml.stream.XMLStreamException,
				org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if ((namespace != null) && (namespace.trim().length() > 0)) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace,
							parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix,
							parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter,
						"http://www.alignet.com/VPOSWS20/");
				if ((namespacePrefix != null)
						&& (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", namespacePrefix + ":AddressData", xmlWriter);
				} else {
					writeAttribute("xsi",
							"http://www.w3.org/2001/XMLSchema-instance",
							"type", "AddressData", xmlWriter);
				}

			}

			namespace = "";
			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "address", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, "address");
				}

			} else {
				xmlWriter.writeStartElement("address");
			}

			if (localAddress == null) {
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException(
						"address cannot be null!!");

			} else {

				xmlWriter.writeCharacters(localAddress);

			}

			xmlWriter.writeEndElement();
			if (localCityTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "city", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "city");
					}

				} else {
					xmlWriter.writeStartElement("city");
				}

				if (localCity == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"city cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCity);

				}

				xmlWriter.writeEndElement();
			}
			if (localStateTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "state", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "state");
					}

				} else {
					xmlWriter.writeStartElement("state");
				}

				if (localState == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"state cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localState);

				}

				xmlWriter.writeEndElement();
			}
			if (localPostalCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "postalCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "postalCode");
					}

				} else {
					xmlWriter.writeStartElement("postalCode");
				}

				if (localPostalCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"postalCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPostalCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localCountryCodeTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "countryCode",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "countryCode");
					}

				} else {
					xmlWriter.writeStartElement("countryCode");
				}

				if (localCountryCode == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"countryCode cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCountryCode);

				}

				xmlWriter.writeEndElement();
			}
			if (localPhoneNumberTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "phoneNumber",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "phoneNumber");
					}

				} else {
					xmlWriter.writeStartElement("phoneNumber");
				}

				if (localPhoneNumber == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"phoneNumber cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localPhoneNumber);

				}

				xmlWriter.writeEndElement();
			}
			if (localCellPhoneNumberTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "cellPhoneNumber",
								namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace,
								"cellPhoneNumber");
					}

				} else {
					xmlWriter.writeStartElement("cellPhoneNumber");
				}

				if (localCellPhoneNumber == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"cellPhoneNumber cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localCellPhoneNumber);

				}

				xmlWriter.writeEndElement();
			}
			if (localEmailTracker) {
				namespace = "";
				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "email", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);

					} else {
						xmlWriter.writeStartElement(namespace, "email");
					}

				} else {
					xmlWriter.writeStartElement("email");
				}

				if (localEmail == null) {
					// write the nil attribute

					throw new org.apache.axis2.databinding.ADBException(
							"email cannot be null!!");

				} else {

					xmlWriter.writeCharacters(localEmail);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,
				java.lang.String namespace, java.lang.String attName,
				java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace, attName, attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,
				java.lang.String attName, java.lang.String attValue,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace,
				java.lang.String attName, javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter
					.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix
							+ ":"
							+ org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter
							.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qname));
				}

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter)
				throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite
									.append(prefix)
									.append(":")
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						} else {
							stringToWrite
									.append(org.apache.axis2.databinding.utils.ConverterUtil
											.convertToString(qnames[i]));
						}
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(
				javax.xml.stream.XMLStreamWriter xmlWriter,
				java.lang.String namespace)
				throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil
							.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(
				javax.xml.namespace.QName qName)
				throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "address"));

			if (localAddress != null) {
				elementList
						.add(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localAddress));
			} else {
				throw new org.apache.axis2.databinding.ADBException(
						"address cannot be null!!");
			}
			if (localCityTracker) {
				elementList.add(new javax.xml.namespace.QName("", "city"));

				if (localCity != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCity));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"city cannot be null!!");
				}
			}
			if (localStateTracker) {
				elementList.add(new javax.xml.namespace.QName("", "state"));

				if (localState != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localState));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"state cannot be null!!");
				}
			}
			if (localPostalCodeTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "postalCode"));

				if (localPostalCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPostalCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"postalCode cannot be null!!");
				}
			}
			if (localCountryCodeTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "countryCode"));

				if (localCountryCode != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCountryCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"countryCode cannot be null!!");
				}
			}
			if (localPhoneNumberTracker) {
				elementList
						.add(new javax.xml.namespace.QName("", "phoneNumber"));

				if (localPhoneNumber != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localPhoneNumber));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"phoneNumber cannot be null!!");
				}
			}
			if (localCellPhoneNumberTracker) {
				elementList.add(new javax.xml.namespace.QName("",
						"cellPhoneNumber"));

				if (localCellPhoneNumber != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localCellPhoneNumber));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"cellPhoneNumber cannot be null!!");
				}
			}
			if (localEmailTracker) {
				elementList.add(new javax.xml.namespace.QName("", "email"));

				if (localEmail != null) {
					elementList
							.add(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(localEmail));
				} else {
					throw new org.apache.axis2.databinding.ADBException(
							"email cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
					qName, elementList.toArray(), attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static AddressData parse(
					javax.xml.stream.XMLStreamReader reader)
					throws java.lang.Exception {
				AddressData object = new AddressData();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type") != null) {
						java.lang.String fullTypeName = reader
								.getAttributeValue(
										"http://www.w3.org/2001/XMLSchema-instance",
										"type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0,
										fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName
									.substring(fullTypeName.indexOf(":") + 1);

							if (!"AddressData".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader
										.getNamespaceContext().getNamespaceURI(
												nsPrefix);
								return (AddressData) ExtensionMapper
										.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "address")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setAddress(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "city")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCity(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "state")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setState(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "postalCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPostalCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "countryCode")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCountryCode(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "phoneNumber")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setPhoneNumber(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("",
									"cellPhoneNumber").equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setCellPhoneNumber(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()
							&& new javax.xml.namespace.QName("", "email")
									.equals(reader.getName())) {

						java.lang.String content = reader.getElementText();

						object.setEmail(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException(
								"Unexpected subelement "
										+ reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

		public void serialize(QName arg0, XMLStreamWriter arg1)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

		public void serialize(QName arg0, XMLStreamWriter arg1, boolean arg2)
				throws XMLStreamException, ADBException {
			// TODO Auto-generated method stub
			
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(
					com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize.class
					.equals(type)) {

				return com.alignet.www.vposws20.VPOSWS20SOAPStub.Authorize.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse.class
					.equals(type)) {

				return com.alignet.www.vposws20.VPOSWS20SOAPStub.AuthorizeResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse.class
					.equals(type)) {

				return com.alignet.www.vposws20.VPOSWS20SOAPStub.Reverse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse.class
					.equals(type)) {

				return com.alignet.www.vposws20.VPOSWS20SOAPStub.ReverseResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
