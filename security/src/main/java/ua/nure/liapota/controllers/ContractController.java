package ua.nure.liapota.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.Contract;
import ua.nure.liapota.services.ContractService;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService service;

    @Autowired
    public ContractController(ContractService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contract> create(@RequestBody Contract newContract) {
        return new ResponseEntity<>(service.create(newContract), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Contract updatedContract) {
        service.update(updatedContract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Integer contractId) {
        service.delete(contractId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
