package edu.kea.exam.pizza.demo.model;

import org.hibernate.annotations.AccessType;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Component
public class Dish {


    public Dish() {
    }

    public Dish(@Size(min = 3, max = 45, message = "Beskrivelsen af retten kan være 3-45 tegn lang.") String description, @Size(min = 2, max = 150, message = "Topping-listen skal være mellem 2 og 150 karakterer lang.") String toppings, @Size(min = 1, max = 15, message = "Beskrivelsen af typen kan være 2-15 tegn lang.") String type, @Positive(message = "Prisen på retten kan ikke være negativ.") float price) {
        this.description = description;
        this.toppings = toppings;
        this.type = type;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 10, message = "Menuens nummer skal være mellem 1-10 karaktere, tallet 0 betyder inaktiv")
    private String menuNumber;

    @Size(min = 3, max = 45, message = "Beskrivelsen af retten kan være 3-45 tegn lang.")
    private String description;

    @Size(min = 2, max = 150, message = "Topping-listen skal være mellem 2 og 150 karakterer lang.")
    private String toppings;

    @Size(min = 1, max = 15, message = "Beskrivelsen af typen kan være 2-15 tegn lang.")
    private String type;

    @Positive(message = "Prisen på retten kan ikke være negativ.")
    private float price;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() { return id; }

    public String getDescription() { return description; }

    public String getMenuNumber() { return menuNumber; }

    public void setMenuNumber(String menuNumber) { this.menuNumber = menuNumber; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", toppings='" + toppings + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

/*
 * Link for getting bean validation to work: https://reflectoring.io/bean-validation-with-spring-boot/
 *
 *  */
