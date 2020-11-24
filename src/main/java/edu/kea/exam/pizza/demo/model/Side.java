package edu.kea.exam.pizza.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Side {

    public Side() {    }

    public Side(@Size(min = 3, max = 45, message = "Beskrivelsen af ekstra-retten kan være mellem 3 - 45 tegn.") String description, float price) {
        this.description = description;
        this.price = price;
    }

    @Id
    int id;

    @Size(min = 3, max = 45, message="Beskrivelsen af ekstra-retten kan være mellem 3 - 45 tegn.")
    private String description;

    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
