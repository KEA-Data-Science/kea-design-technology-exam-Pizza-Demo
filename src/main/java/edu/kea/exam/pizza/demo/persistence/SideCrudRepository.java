package edu.kea.exam.pizza.demo.persistence;

import edu.kea.exam.pizza.demo.model.Side;
import org.springframework.data.repository.CrudRepository;

public interface SideCrudRepository extends CrudRepository<Side, Integer> {
}
