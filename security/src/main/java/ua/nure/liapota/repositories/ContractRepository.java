package ua.nure.liapota.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.Contract;

public interface ContractRepository extends CrudRepository<Contract, Integer> {
}
