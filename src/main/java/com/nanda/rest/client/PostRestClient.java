package com.nanda.rest.client;

import java.math.BigDecimal;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class PostRestClient {

	public static void main(String[] args) {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		Client restClient = Client.create(clientConfig);

		WebResource resource = restClient.resource("http://localhost:8891/product-service/v1/products");

		resource.accept(MediaType.APPLICATION_JSON);

		Product product = new Product();

		product.setCategory("Mobile");
		product.setDescription("Good Mobiles");
		product.setPrice(new BigDecimal(100.25));
		product.setProductName("Nanda");

		ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, product);

		System.out.println(clientResponse.getStatus());

	}

}
