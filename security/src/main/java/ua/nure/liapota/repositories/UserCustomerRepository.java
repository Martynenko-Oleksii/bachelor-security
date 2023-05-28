package ua.nure.liapota.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.UserCustomer;

import java.util.List;

public interface UserCustomerRepository extends CrudRepository<UserCustomer, String> {
    @Query(value = "SELECT user_id FROM users_customers u WHERE u.customer_id = ?1", nativeQuery = true)
    List<String> getUserCustomerByCustomerId(Integer customerId);


}
