package ua.nure.liapota.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.FacilityGroup;

import java.util.List;

public interface FacilityGroupRepository extends CrudRepository<FacilityGroup, Integer> {
    @Query(value = "SELECT * FROM facility_groups WHERE customer_id = ?1", nativeQuery = true)
    List<FacilityGroup> getFacilityGroupByCustomerId(Integer customerId);
}
