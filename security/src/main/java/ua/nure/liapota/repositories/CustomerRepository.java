package ua.nure.liapota.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customers WHERE DATEDIFF(day, GETDATE(), expiring_date) <= 14", nativeQuery = true)
    List<Customer> getExpiringCustomers();
}
