package ua.nure.liapota.services;

import ua.nure.liapota.models.DepartmentGroup;
import ua.nure.liapota.repositories.DepartmentGroupRepository;

public class DepartmentGroupService extends EntityService<DepartmentGroup, Integer, DepartmentGroupRepository> {
    public DepartmentGroup update(DepartmentGroup updatedDepartmentGroup) {
        DepartmentGroup savedDepartmentGroup = getById(updatedDepartmentGroup.getId());
        savedDepartmentGroup.setDescription(updatedDepartmentGroup.getDescription());
        savedDepartmentGroup.setName(updatedDepartmentGroup.getName());
        return repository.save(savedDepartmentGroup);
    }
}
