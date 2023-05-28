package ua.nure.liapota.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.Contract;
import ua.nure.liapota.services.ContractService;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    ContractService service;

    @GetMapping
    public ResponseEntity<List<Contract>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contract> create(@RequestBody Contract newContract) {
        return new ResponseEntity<>(service.create(newContract), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Contract> update(@RequestBody Contract updatedContract) {
        return new ResponseEntity<>(service.update(updatedContract), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Contract> delete(@RequestBody Contract deletedContract) {
        return new ResponseEntity<>(service.delete(deletedContract), HttpStatus.OK);
    }
}
