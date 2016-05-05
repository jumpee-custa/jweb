package jp.co.custanet.nishihata.dto;

public class TestDto {

	public TestDto(){};

	public Number id;
	public String kind;
	public String text;

	public TestDto(Integer id, String kind, String text){
		
		this.id = id;
		this.kind = kind;
		this.text = text;
		
	}
	
}
