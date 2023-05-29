package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.FacilityGroup;
import ua.nure.liapota.repositories.FacilityGroupRepository;

import java.util.List;

@Service
public class FacilityGroupService extends EntityService<FacilityGroup, Integer, FacilityGroupRepository> {
    @Autowired
    public FacilityGroupService(FacilityGroupRepository repository) {
        this.repository = repository;
    }

    public List<FacilityGroup> getByCustomerId(Integer id) {
        return repository.getFacilityGroupByCustomerId(id);
    }

    public void update(FacilityGroup updatedFacilityGroup) {
        FacilityGroup savedFacilityGroup = getById(updatedFacilityGroup.getId());
        savedFacilityGroup.setDescription(updatedFacilityGroup.getDescription());
        savedFacilityGroup.setName(updatedFacilityGroup.getName());
        savedFacilityGroup.setCustomerId(updatedFacilityGroup.getCustomerId());
        savedFacilityGroup.setFacilities(updatedFacilityGroup.getFacilities());
        repository.save(savedFacilityGroup);
    }
}
