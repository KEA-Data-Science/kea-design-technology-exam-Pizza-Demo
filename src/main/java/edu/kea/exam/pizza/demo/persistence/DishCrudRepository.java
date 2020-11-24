package edu.kea.exam.pizza.demo.persistence;

import edu.kea.exam.pizza.demo.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishCrudRepository extends CrudRepository<Dish, Integer> {
//    List<Dish> findAll();
}
