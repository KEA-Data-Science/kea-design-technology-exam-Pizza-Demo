package edu.kea.exam.pizza.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Dish {

    public Dish() {
    }

    public Dish(@Size(min = 3, max = 45, message = "Beskrivelsen af retten kan være 3-45 tegn lang.") String description, @Size(min = 1, max = 15, message = "Beskrivelsen af typen kan være 2-15 tegn lang.") String type, @Positive(message = "Prisen på retten kan ikke være negativ.") float price) {
        this.description = description;
        this.type = type;
        this.price = price;
    }

    @Id
    private Integer id;

    @Size(min = 3, max = 45,message = "Beskrivelsen af retten kan være 3-45 tegn lang.")
    private String description;

    @Size(min = 1, max = 15, message = "Beskrivelsen af typen kan være 2-15 tegn lang.")
    private String type;

    @Positive(message = "Prisen på retten kan ikke være negativ.")
    private float price;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

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
}
