package ua.nure.liapota.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.liapota.models.Contract;
import ua.nure.liapota.repositories.ContractRepository;

@Service
public class ContractService extends EntityService<Contract, Integer, ContractRepository>{
    @Autowired
    public ContractService(ContractRepository repository) {
        this.repository = repository;
    }

    public void update(Contract updatedContract) {
        Contract savedContract = getById(updatedContract.getId());
        savedContract.setName(updatedContract.getName());
        savedContract.setStart(updatedContract.getStart());
        savedContract.setDuration(updatedContract.getDuration());
        savedContract.setDescription(updatedContract.getDescription());
        repository.save(savedContract);
    }
}
