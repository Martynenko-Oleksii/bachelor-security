package ua.nure.liapota.services;

import ua.nure.liapota.models.Contract;
import ua.nure.liapota.repositories.ContractRepository;

public class ContractService extends EntityService<Contract, Integer, ContractRepository>{
    public Contract update(Contract updatedContract) {
        Contract savedContract = getById(updatedContract.getId());
        savedContract.setName(updatedContract.getName());
        savedContract.setStart(updatedContract.getStart());
        savedContract.setDuration(updatedContract.getDuration());
        savedContract.setDescription(updatedContract.getDescription());
        return repository.save(savedContract);
    }
}
