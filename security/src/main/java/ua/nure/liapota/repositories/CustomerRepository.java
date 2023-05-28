package ua.nure.liapota.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.Contract;

public interface CustomerRepository extends CrudRepository<Contract, Integer> {

}
