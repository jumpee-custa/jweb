package jp.co.custanet.nishihata.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloService {

	@GET
	@Produces("text/plain")
	public String hello(){

		return "hello";
	}

}
