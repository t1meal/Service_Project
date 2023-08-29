package ru.t1meal.service_project.model;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
import ru.t1meal.service_project.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class Cart {

    private final ProductRepository repository;
    private List<Product> cartList;

    @PostConstruct
    private void initCartList(){
        this.cartList = new ArrayList<>();
    }

    public void addProduct(Long id){
        cartList.add(repository.getProductById(id));
    }

    public void removeProduct(Long id){
        cartList.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getCart() {
        return cartList;
    }
}
