package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.models.Facility;
import ua.nure.liapota.repositories.CustomerRepository;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService extends EntityService<Customer, Integer, CustomerRepository> {
    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void update(Customer updatedCustomer) {
        Customer savedCustomer = getById(updatedCustomer.getId());
        savedCustomer.setActivationDate(updatedCustomer.getActivationDate());
        savedCustomer.setDescription(updatedCustomer.getDescription());
        savedCustomer.setName(updatedCustomer.getName());
        savedCustomer.setAutoRenewal(updatedCustomer.isAutoRenewal());
        savedCustomer.setExpiringDate(updatedCustomer.getExpiringDate());
        savedCustomer.setContract(updatedCustomer.getContract());
        repository.save(savedCustomer);
    }

    public List<Facility> getFacilities(Integer customerId) {
        Customer customer = getById(customerId);
        return new ArrayList<>(customer.getFacilities());
    }

    public List<Customer> getExpiring() {
        return repository.getExpiringCustomers();
    }

    @Override
    public Customer create(Customer customer) {
        byte daysToWait = customer.getContract().getStart();
        LocalDate activationDate = LocalDate.now().plusDays(daysToWait);
        byte monthToWork = customer.getContract().getDuration();
        LocalDate expiringDate = activationDate.plusMonths(monthToWork);
        customer.setActivationDate(Date.from(activationDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        customer.setExpiringDate(Date.from(expiringDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return super.create(customer);
    }
}
