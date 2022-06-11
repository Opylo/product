package com.optimartnetcom.productapi;

import com.optimartnetcom.productapi.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductapiApplicationTests {

	@Value("${productapi.services.url}")
	private String baseUrl;

	@Test
	public void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + "/1", Product.class);
		assertNotNull(product);
		assertEquals(1, product.getId());
	}

	@Test
	public void testCreateProduct(){
		RestTemplate restTemplate = new RestTemplate();
		Product product[] = new Product[1];
		product[1].setName("iPhone");
		product[1].setDescription("Apple product");
		product[1].setPrice(1000);
		product[1] = restTemplate.postForObject(baseUrl, product, Product.class);
		assertNotNull(product);
		assertNotNull(product[1].getName());
	}

	@Test
	public void testUpdateProduct() {
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + "/1", Product.class);
		product.setName("iPhone");
		product.setDescription("Apple phone");
		product.setPrice(100);
		restTemplate.put(baseUrl, product);
	}

}
