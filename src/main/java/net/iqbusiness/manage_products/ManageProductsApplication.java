package net.iqbusiness.manage_products;

import net.iqbusiness.manage_products.entities.Product;
import net.iqbusiness.manage_products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ManageProductsApplication {

	@Autowired
	private ProductRepository productRepository;

	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationEventStarted() {
	    Product p1 = new Product("First", "Test",(long)15.15, 5);
	    Product p2 = new Product("Second", "Test", (long)15.15, 5);
	    Product p3 = new Product("Third", "Test", (long)15.15, 5);
	    Product p4 = new Product("Fourth", "Test", (long)15.15, 5);
	    Product p5 = new Product("Fifth", "Test", (long)15.15, 5);

	    productRepository.save(p1);
	    productRepository.save(p2);
	    productRepository.save(p3);
	    productRepository.save(p4);
	    productRepository.save(p5);
	}

	public static void main(String[] args) {
		SpringApplication.run(ManageProductsApplication.class, args);
	}

}
