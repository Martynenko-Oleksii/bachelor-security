package ua.nure.liapota.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
