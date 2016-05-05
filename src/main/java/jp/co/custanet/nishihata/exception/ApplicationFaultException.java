package jp.co.custanet.nishihata.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.soap.AddressingFeature.Responses;

public class ApplicationFaultException extends WebApplicationException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 213988090514471704L;

	public ApplicationFaultException(String message) {
		super(Response.status(Status.NOT_FOUND).
			    entity(message).type("text/plain").build());
	 }
}
