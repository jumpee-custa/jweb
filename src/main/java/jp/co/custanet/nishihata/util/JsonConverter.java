package jp.co.custanet.nishihata.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	public static String object2json(Object obj) throws JsonProcessingException{

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(obj);

		return json;
	}
}
