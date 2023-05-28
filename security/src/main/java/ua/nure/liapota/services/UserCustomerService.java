package ua.nure.liapota.services;

import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.repositories.UserCustomerRepository;

import java.util.List;

public class UserCustomerService extends EntityService<UserCustomer, String, UserCustomerRepository> {
    public List<String> getByCustomerId(Integer id) {
        return repository.getUserCustomerByCustomerId(id);
    }
}
