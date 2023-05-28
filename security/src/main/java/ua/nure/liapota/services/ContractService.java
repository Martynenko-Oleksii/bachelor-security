package ua.nure.liapota.services;

import ua.nure.liapota.models.Contract;
import ua.nure.liapota.repositories.ContractRepository;

public class ContractService extends EntityService<Contract, Integer, ContractRepository>{
    public Contract update(Contract updatedContract) {
        Contract savedEntity = getById(updatedContract.getId());
        savedEntity.setName(updatedContract.getName());
        savedEntity.setStart(updatedContract.getStart());
        savedEntity.setDuration(updatedContract.getDuration());
        savedEntity.setDescription(updatedContract.getDescription());
        return repository.save(savedEntity);
    }
}
