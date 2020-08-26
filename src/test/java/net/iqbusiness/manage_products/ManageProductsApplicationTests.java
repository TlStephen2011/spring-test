package net.iqbusiness.manage_products;

import net.iqbusiness.manage_products.entities.Product;
import net.iqbusiness.manage_products.repositories.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ManageProductsApplicationTests {

	@Autowired
		private ProductRepository productRepository;

	@BeforeAll
		void emptyDatabase() {
			productRepository.deleteAll();
		}

	@BeforeEach
		void initEach() {
			Product p1 = new Product("First", "Test", (long) 15.15,  5);
			Product p2 = new Product("Second", "Test", (long)15.15,  5);
			Product p3 = new Product("Third", "Test", (long) 15.15,  5);
			Product p4 = new Product("Fourth", "Test", (long) 15.15,  5);
			Product p5 = new Product("Fifth", "Test", (long) 15.15,  5);

			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);
			productRepository.save(p4);
			productRepository.save(p5);
		}

		@AfterEach
			void dropProducts() {
				productRepository.deleteAll();
			}

			@Test
				void contextLoads() {
					Assertions.assertNotNull(productRepository);
				}

			@Test
				void initialProductLoad() {
					List<Product> products = productRepository.findAll();
					Assertions.assertEquals(5, products.size());
				}

			@Test
				void deletesProduct() {
					Product p1 = new Product("Sixth", "Test", (long) 15.15, 5);
					productRepository.save(p1);
					productRepository.delete(p1);

					List<Product> products = productRepository.findAll();
					Assertions.assertEquals(5, products.size());
				}

			@Test
			void savesProduct() {
			    Product p1 = new Product("Sixth", "Test", (long) 15.15, 5);
			    productRepository.save(p1);

			    List<Product> products = productRepository.findAll();
			    Assertions.assertEquals(6,products.size() );
			}

			@Test
			void updatesProduct() {
			    Product p1 = new Product("Sixth", "Test", (long) 15.15, 5);
			    productRepository.save(p1);

			    p1.setName("name");

			    productRepository.save(p1);

			    Optional<Product> fromDb = productRepository.findById(p1.getId());

			    fromDb.ifPresentOrElse(product -> {
			        Assertions.assertEquals("name", product.getName());
			    }, () -> {
			        Assertions.assertEquals(1, 2);
			    });
			}



}
