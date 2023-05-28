package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.liapota.models.Facility;
import ua.nure.liapota.repositories.FacilityRepository;

public class FacilityService extends EntityService<Facility, Integer, FacilityRepository> {
    @Autowired
    public FacilityService(FacilityRepository repository) {
        this.repository = repository;
    }

    public Facility update(Facility updatedFacility) {
        Facility savedFacility = getById(updatedFacility.getId());
        savedFacility.setZIPCode(updatedFacility.getZIPCode());
        savedFacility.setContactEmail(updatedFacility.getContactEmail());
        savedFacility.setName(updatedFacility.getName());
        savedFacility.setCity(updatedFacility.getCity());
        savedFacility.setContactPhone(updatedFacility.getContactPhone());
        savedFacility.setAddress2(updatedFacility.getAddress2());
        savedFacility.setAddress1(updatedFacility.getAddress1());
        savedFacility.setAbbreviation(updatedFacility.getAbbreviation());
        return repository.save(savedFacility);
    }
}
