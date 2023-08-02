package de.diskostu.demo.graphqldemo.repository;

import de.diskostu.demo.graphqldemo.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country, Integer> {
}
