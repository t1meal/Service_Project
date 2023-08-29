package ru.t1meal.service_project.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Random;
@Data
public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
        Random random = new Random();
        this.cost = new BigDecimal(random.nextInt());
    }
}
