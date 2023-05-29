package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.models.Facility;
import ua.nure.liapota.repositories.FacilityRepository;

@Service
public class FacilityService extends EntityService<Facility, Integer, FacilityRepository> {
    @Autowired
    public FacilityService(FacilityRepository repository) {
        this.repository = repository;
    }

    public Facility create(Facility facility, Customer customer) {
        facility.setCustomer(customer);
        return repository.save(facility);
    }

    public void update(Facility updatedFacility) {
        Facility savedFacility = getById(updatedFacility.getId());
        savedFacility.setZipCode(updatedFacility.getZipCode());
        savedFacility.setContactEmail(updatedFacility.getContactEmail());
        savedFacility.setName(updatedFacility.getName());
        savedFacility.setCity(updatedFacility.getCity());
        savedFacility.setContactPhone(updatedFacility.getContactPhone());
        savedFacility.setAddress2(updatedFacility.getAddress2());
        savedFacility.setAddress1(updatedFacility.getAddress1());
        savedFacility.setAbbreviation(updatedFacility.getAbbreviation());
        savedFacility.setFacilityStandardDepartments(updatedFacility.getFacilityStandardDepartments());
        repository.save(savedFacility);
    }
}
