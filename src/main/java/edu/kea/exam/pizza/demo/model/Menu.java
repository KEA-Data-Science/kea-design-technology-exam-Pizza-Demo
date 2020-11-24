package edu.kea.exam.pizza.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Entity
public class Menu {

    public Menu() {
    }

    public Menu(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Id
    int id;

    @Positive(message = "Prisen kan ikke være negativ.")
    private float totalPrice;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private Side side;

    @ManyToOne
    private Dish dish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
