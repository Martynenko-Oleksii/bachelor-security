package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.models.Facility;
import ua.nure.liapota.services.CustomerService;
import ua.nure.liapota.services.FacilityService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final FacilityService facilityService;

    @Autowired
    public CustomerController(CustomerService customerService, FacilityService facilityService) {
        this.customerService = customerService;
        this.facilityService = facilityService;
    }

    @GetMapping("/facilities/{id}")
    public ResponseEntity<List<Facility>> getFacilities(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.getFacilities(id), HttpStatus.OK);
    }

    @PostMapping("/facilities/{id}")
    public ResponseEntity<Facility> createFacility(@RequestBody Facility newFacility, @PathVariable Integer id) {
        return new ResponseEntity<>(facilityService.create(newFacility, customerService.getById(id)), HttpStatus.OK);
    }

    @PutMapping("/facilities")
    public ResponseEntity<Void> updateFacility(@RequestBody Facility updatedFacility) {
        facilityService.update(updatedFacility);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/facilities/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Integer id) {
        facilityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(customerService.create(newCustomer), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer updatedCustomer) {
        customerService.update(updatedCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
