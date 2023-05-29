package ua.nure.liapota.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.DepartmentGroup;

import java.util.List;

public interface DepartmentGroupRepository extends CrudRepository<DepartmentGroup, Integer> {
    @Query(value = "SELECT * FROM department_groups WHERE customer_id = ?1", nativeQuery = true)
    List<DepartmentGroup> getDepartmentGroupByCustomerId(Integer customerId);
}
