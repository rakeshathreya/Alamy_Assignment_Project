/**
 * 
 */
package com.assignmentsdemo.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.assignmentsdemo.Date.DateFormat;
import com.assignmentsdemo.configs.APIConfigs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * TODO: DEFINE ME!! Rakesh
 * @author Rakesh
 * 14-Dec-2020 
 * 
 */
public class MetaWeatherTestAPI {
	
	@Test
	public void weatherTestAPI() throws IOException, ParseException { 

		final RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", ContentType.JSON);
		Response	response = httpRequest.get(APIConfigs.searchlocationsUrl+APIConfigs.nottingham);
		System.out.println("searchlocationResponse====>>"+response.asString());
		//read response using object mapper
		ObjectMapper mapper=new ObjectMapper();
		JsonNode woeidNode=mapper.readTree(response.asString());
		List<JsonNode> woeid=woeidNode.findValues(APIConfigs.woeid);
		//get the woeId
		String woeId=woeid.get(0).asText();
		System.out.println(woeId);
		//pass earth Id 
		Response	earthIDResponse = httpRequest.get(APIConfigs.earthIDAPIUrl+woeId);
		System.out.println("earthIDResponse=====>>"+earthIDResponse.asString());
		//read the earthId Response
		JsonNode earthIDNode=mapper.readTree(earthIDResponse.asString());
		List<JsonNode>ffd=earthIDNode.findValues(APIConfigs.applicable_date);
		//get applicable_date
		String applicable_date=ffd.get(0).asText();
		//convert date Format
		DateFormat date=new DateFormat();
		String applicable_dates=date.convertDateFormat(applicable_date);
		//pass applicable date
		Response dateresponse = httpRequest.get(APIConfigs.earthIDAPIUrl+woeId+"/"+applicable_dates);
		System.out.println("dateresponse=====>>"+dateresponse.asString());
		
		
		
		
		
			
		
		
		
		
	}

}
