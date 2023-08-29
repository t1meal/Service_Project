package ru.t1meal.service_project.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.t1meal.service_project.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> container;

    @PostConstruct
    private void firstAdd(){
        container = new ArrayList<>(Arrays.asList(
                new Product(1L, "bread"),
                new Product(2L, "bread"),
                new Product(3L, "bread"),
                new Product(4L, "bread"),
                new Product(5L, "bread")));
    }

    public List<Product> getProducts() {
        return container;
    }

    public Product getProductById(Long id) {
        
        for (Product p: container) {
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
