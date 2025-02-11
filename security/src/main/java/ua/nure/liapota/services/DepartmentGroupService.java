package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.DepartmentGroup;
import ua.nure.liapota.repositories.DepartmentGroupRepository;

import java.util.List;

@Service
public class DepartmentGroupService extends EntityService<DepartmentGroup, Integer, DepartmentGroupRepository> {
    @Autowired
    public DepartmentGroupService(DepartmentGroupRepository repository) {
        this.repository = repository;
    }

    public List<DepartmentGroup> getByCustomerId(Integer id) {
        return repository.getDepartmentGroupByCustomerId(id);
    }

    public void update(DepartmentGroup updatedDepartmentGroup) {
        DepartmentGroup savedDepartmentGroup = getById(updatedDepartmentGroup.getId());
        savedDepartmentGroup.setDescription(updatedDepartmentGroup.getDescription());
        savedDepartmentGroup.setName(updatedDepartmentGroup.getName());
        savedDepartmentGroup.setCustomerId(updatedDepartmentGroup.getCustomerId());
        savedDepartmentGroup.setStandardDepartments(updatedDepartmentGroup.getStandardDepartments());
        repository.save(savedDepartmentGroup);
    }
}
