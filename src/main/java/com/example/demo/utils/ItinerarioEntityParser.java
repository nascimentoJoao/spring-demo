package com.example.demo.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.entities.itinerario.CoordenadasItinerario;
import com.example.demo.entities.itinerario.ItinerarioOnibus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ItinerarioEntityParser {
	
	
	public ItinerarioOnibus parseStringToItinerarioOnibusEntity(String rawEntityResponse) throws JsonMappingException, JsonProcessingException {
		String mapValues = "";
		String linhaValues = "";
		Boolean keepConstructingLinhasOnibus = true;
		
		for(int i = 0; i < rawEntityResponse.length(); i++) {

			if(keepConstructingLinhasOnibus) {
				linhaValues += rawEntityResponse.charAt(i);
			} else {
				mapValues += rawEntityResponse.charAt(i);
			} 
			
			if(rawEntityResponse.charAt(i) == '\"' && rawEntityResponse.charAt(i + 1) == '0') {
				linhaValues = linhaValues.substring(0, linhaValues.length() - 2) + "}";
				keepConstructingLinhasOnibus = false;
			}
		}
		
		mapValues = "{\"" + mapValues;
		
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<HashMap<String, CoordenadasItinerario>>() {}.getType();
		
        Map<String, CoordenadasItinerario> map = gson.fromJson(mapValues, type);

		ItinerarioOnibus response = new ObjectMapper().readValue(linhaValues, new TypeReference<ItinerarioOnibus>() {});
		
		response.setCoordenadas(map);
		
		return response;
	}

}
