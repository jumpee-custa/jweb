package jp.co.custanet.nishihata.service;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;


public class CustaDialogService implements CustaServiceImpl {


	private final String DIALOG_PASSWORD = "aDUtyDbYGHcR";
	private final String DIALOG_USER = "03efdd6f-164b-4cb0-ac1e-f7e0d8a49025";

	DialogService service = new DialogService();

	@Override
	public void login(){

		service.setUsernameAndPassword(DIALOG_USER,DIALOG_PASSWORD);
	}



	public List<Dialog> getDialogs(){
		List<Dialog> dlist = new ArrayList<Dialog>();
		dlist = service.getDialogs().execute();
		return dlist;
	}



}
