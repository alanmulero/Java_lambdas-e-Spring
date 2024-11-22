package br.com.alura.screnMatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumoApi {
	
	
	public String consultaApi(String dado) throws IOException, InterruptedException {
		
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(dado))
		      .build();
		
		HttpResponse<String> response = client
				  .send(request, BodyHandlers.ofString());
			
		
		
		
		
		// Retornando uma String
		
		String json = response.body();
        return json;
	}
	
	

}
