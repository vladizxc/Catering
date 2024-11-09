package festival.catering;

import jakarta.persistence.Entity;

import org.javamoney.moneta.Money;
import org.salespointframework.catalog.Product;

@Entity
public class Food extends Product {

    //private String name;

    private Food(){}

    public Food(String name, Money price) {
        super(name, price);
    }

}
