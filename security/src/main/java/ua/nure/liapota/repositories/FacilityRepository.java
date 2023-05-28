package ua.nure.liapota.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.nure.liapota.models.Facility;

public interface FacilityRepository extends CrudRepository<Facility, Integer> {
}
