package ua.nure.liapota.services;

import org.springframework.stereotype.Service;
import ua.nure.liapota.models.Contract;
import ua.nure.liapota.repositories.ContractRepository;

@Service
public class ContractService extends EntityService<Contract, Integer, ContractRepository>{
    public Contract update(Contract updatedContract) {
        Contract savedContract = getById(updatedContract.getId());
        savedContract.setName(updatedContract.getName());
        savedContract.setStart(updatedContract.getStart());
        savedContract.setDuration(updatedContract.getDuration());
        savedContract.setDescription(updatedContract.getDescription());
        savedContract.setCustomers(updatedContract.getCustomers());
        return repository.save(savedContract);
    }
}
