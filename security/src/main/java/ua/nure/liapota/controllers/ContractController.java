package ua.nure.liapota.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.Contract;
import ua.nure.liapota.services.ContractService;

import java.util.List;

@Authorize("security,contract-management")
@RestController
@RequestMapping("/contracts")
@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
