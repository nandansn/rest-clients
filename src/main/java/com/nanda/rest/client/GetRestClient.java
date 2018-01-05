package com.nanda.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.MediaTypes;

public class GetRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client restClient = Client.create();
		
		WebResource resource = restClient.resource("http://localhost:8891/product-service/v1/products");
		
		resource.accept(MediaType.APPLICATION_JSON);
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		System.out.println(response.getStatus());

	}

}
