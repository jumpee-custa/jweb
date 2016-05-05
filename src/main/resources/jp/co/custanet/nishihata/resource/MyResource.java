package jp.co.custanet.nishihata.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.co.custanet.nishihata.dto.TestDto;
import jp.co.custanet.nishihata.service.CustaDialogService;
import jp.co.custanet.nishihata.service.CustaNlcService;
import jp.co.custanet.nishihata.service.DatabaseService;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;

@Path("myresource")
public class MyResource {

	@Inject CustaDialogService custaDialogService;
	@Inject CustaNlcService custaNlcService;
	@Inject DatabaseService dbService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getit")
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    
    public String hello(){
    	return "hello";

    }

    @GET
    @Path("dialogs")
    @Produces(MediaType.APPLICATION_JSON)
    public String dialogs(){

    	String ids = "";
    	custaDialogService.login();

    	List<Dialog> dlist = custaDialogService.getDialogs();

    	for(Dialog d : dlist){
    		ids = ids + "," + d.getId();

    	}

    	return ids;
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String list(){

    	Classifiers classifiers = custaNlcService.list();
    	return "list";
    }



    @POST
    @Path("classifier")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public String classifier(@FormDataParam("traningdata") InputStream infile){

    	File file = new File("./", "training.csv");
    	try {

			Files.copy(infile, file.toPath());

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return "failed";
		}
    	custaNlcService.training(file);
    	return "success";
    }

    @POST
    @Path("question")
    @Produces("application/json;charset=UTF-8")
    public String question(@FormParam("question") String question){

    	System.out.println("quesetion:" + question);

    	Classification classification =  custaNlcService.query(question);
    	System.out.println(classification.toString());


    	return classification.toString();
    }


    @GET
    @Path("dbtest")
    @Produces("application/json;charset=UTF-8")
    public String dbtest(){
    	
    	String data = "";
    	
    	List<TestDto> testlist =  dbService.getTest();
    	
    	return data;
    }


}