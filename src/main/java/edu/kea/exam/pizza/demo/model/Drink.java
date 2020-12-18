package edu.kea.exam.pizza.demo.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Component
public class Drink {

    public Drink() {
    }

    public Drink(Integer id, @Size(min = 3, max = 45, message = "Beskrivelsen af drinken kan være 3-45 tegn lang.") String description, @Positive(message = "Prisen på drinken kan ikke være negativ.") float price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 45, message = "Beskrivelsen af drinken kan være 3-45 tegn lang.")
    private String description;

    @Positive(message = "Prisen på drinken kan ikke være negativ.")
    private float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
