package com.ParseJSON.parseJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.ParseJSON.parseJson.ParseJson.parseJson;

@SpringBootApplication
public class ParseJsonApplication {

	public static void main(String[] args) {
		try {
			// Test with various JSON data
			String jsonObject = "{\"name\": \"Priyanka\", \"age\": 25, \"balance\": 53245.6789033214570902345}";
			System.out.println(ParseJson.parseJson(jsonObject));

			String jsonArray = "[{\"value\": 12345674433123}, {\"value\": 99876.6712389}]";
			System.out.println(ParseJson.parseJson(jsonArray));

			String jsonString = "\"I love Java!\"";
			System.out.println(ParseJson.parseJson(jsonString));

		} catch (
				JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
