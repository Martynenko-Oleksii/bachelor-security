package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.FacilityGroup;
import ua.nure.liapota.repositories.FacilityGroupRepository;

@Service
public class FacilityGroupService extends EntityService<FacilityGroup, Integer, FacilityGroupRepository> {
    @Autowired
    public FacilityGroupService(FacilityGroupRepository repository) {
        this.repository = repository;
    }

    public FacilityGroup update(FacilityGroup updatedFacilityGroup) {
        FacilityGroup savedFacilityGroup = getById(updatedFacilityGroup.getId());
        savedFacilityGroup.setDescription(updatedFacilityGroup.getDescription());
        savedFacilityGroup.setName(updatedFacilityGroup.getName());
        return repository.save(savedFacilityGroup);
    }
}
