package net.iqbusiness.manage_products.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @Column(name = "price")
    private Long price;

    public Product(String name, String description, Long price, Integer unitsInStock) {
        this.name = name;
        this.description = description;
        this.unitsInStock = unitsInStock;
        this.price = price;
    }
}
