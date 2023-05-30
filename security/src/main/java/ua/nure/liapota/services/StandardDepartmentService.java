package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.StandardDepartment;
import ua.nure.liapota.repositories.StandardDepartmentRepository;

@Service
public class StandardDepartmentService extends EntityService<StandardDepartment, Integer, StandardDepartmentRepository> {
    @Autowired
    public StandardDepartmentService(StandardDepartmentRepository repository) {
        this.repository = repository;
    }
}
