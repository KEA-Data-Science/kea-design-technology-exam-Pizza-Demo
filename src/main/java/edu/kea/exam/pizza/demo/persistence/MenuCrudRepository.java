package edu.kea.exam.pizza.demo.persistence;

import edu.kea.exam.pizza.demo.model.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuCrudRepository extends CrudRepository<Menu,Integer> {

}
