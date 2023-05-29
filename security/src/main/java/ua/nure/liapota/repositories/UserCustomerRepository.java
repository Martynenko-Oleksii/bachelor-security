package ua.nure.liapota.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.UserCustomer;

import java.util.List;

public interface UserCustomerRepository extends CrudRepository<UserCustomer, String> {
    @Query(value = "SELECT * FROM users_customers WHERE customer_id = ?1", nativeQuery = true)
    List<UserCustomer> getUserCustomerByCustomerId(Integer customerId);
}
