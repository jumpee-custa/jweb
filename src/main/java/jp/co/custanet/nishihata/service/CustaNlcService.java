package jp.co.custanet.nishihata.service;

import java.io.File;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;

public class CustaNlcService implements CustaServiceImpl{

	private final String DIALOG_PASSWORD = "Ut0TcxJmsmbj";
	private final String DIALOG_USER = "89c290b6-ac8b-4238-8699-e965f29d8ee5";

	NaturalLanguageClassifier service = new NaturalLanguageClassifier();
	@Override
	public void login() {
		// TODO 自動生成されたメソッド・スタブ
		service.setUsernameAndPassword(DIALOG_USER,DIALOG_PASSWORD);
	}


	public Classifiers list(){
		this.Auth();
		Classifiers classifiers = service.getClassifiers().execute();
		return classifiers;

	}

	public Classification query(String question){

		this.Auth();
		Classification classification = service.classify("3a84dfx64-nlc-2022", question).execute();

		return classification;

	}

	public Classifier training(File trainingData){


		this.Auth();
		Classifier classifier = service.createClassifier("dq_magic", "ja", trainingData).execute();
		return classifier;

	}

	private void Auth(){
		service.setUsernameAndPassword(DIALOG_USER,DIALOG_PASSWORD);
	}
}
