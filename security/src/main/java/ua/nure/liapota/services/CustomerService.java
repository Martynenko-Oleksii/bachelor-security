package ua.nure.liapota.services;

import org.springframework.stereotype.Service;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.repositories.CustomerRepository;

@Service
public class CustomerService extends EntityService<Customer, Integer, CustomerRepository> {
    public Customer update(Customer updatedCustomer) {
        Customer savedCustomer = getById(updatedCustomer.getId());
        savedCustomer.setActivationDate(updatedCustomer.getActivationDate());
        savedCustomer.setDescription(updatedCustomer.getDescription());
        savedCustomer.setName(updatedCustomer.getName());
        savedCustomer.setAutoRenewal(updatedCustomer.isAutoRenewal());
        savedCustomer.setExpiringDate(updatedCustomer.getExpiringDate());
        savedCustomer.setContract(updatedCustomer.getContract());
        savedCustomer.setFacilities(updatedCustomer.getFacilities());
        return repository.save(savedCustomer);
    }
}
