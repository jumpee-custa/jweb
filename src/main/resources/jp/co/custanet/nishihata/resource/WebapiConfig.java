package jp.co.custanet.nishihata.resource;

import javax.ws.rs.ApplicationPath;

import jp.co.custanet.nishihata.service.CustaDialogService;
import jp.co.custanet.nishihata.service.CustaNlcService;
import jp.co.custanet.nishihata.service.DatabaseService;
import jp.co.custanet.nishihata.util.JsonConverter;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("webapi")
public class WebapiConfig extends ResourceConfig {

    public WebapiConfig() {

	    super(MultiPartFeature.class);
        //packages(this.getClass().getPackage().getName());

    	packages("jp.co.custanet.nishihata.resource");


    	register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(CustaDialogService.class);
                bindAsContract(CustaNlcService.class);
                bindAsContract(DatabaseService.class);
                bindAsContract(JsonConverter.class);
            }
        });
    }

}