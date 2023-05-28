package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.repositories.UserCustomerRepository;

import java.util.List;

@Service
public class UserCustomerService extends EntityService<UserCustomer, String, UserCustomerRepository> {
    @Autowired
    public UserCustomerService(UserCustomerRepository repository) {
        this.repository = repository;
    }

    public List<String> getByCustomerId(Integer id) {
        return repository.getUserCustomerByCustomerId(id);
    }
}
