package ua.nure.liapota.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(service.create(newCustomer), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer updatedCustomer) {
        return new ResponseEntity<>(service.update(updatedCustomer), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Customer> delete(@RequestBody Customer deletedCustomer) {
        return new ResponseEntity<>(service.delete(deletedCustomer), HttpStatus.OK);
    }
}
