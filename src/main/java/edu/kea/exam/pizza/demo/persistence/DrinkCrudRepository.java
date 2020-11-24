package edu.kea.exam.pizza.demo.persistence;

import edu.kea.exam.pizza.demo.model.Drink;
import org.springframework.data.repository.CrudRepository;

public interface DrinkCrudRepository extends CrudRepository<Drink,Integer> {
}
