package ua.nure.liapota.controllers;

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
    CustomerService customerService;
    FacilityService facilityService;

    @GetMapping("/facilities")
    public ResponseEntity<List<Facility>> getFacilities(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.getFacilities(customer), HttpStatus.OK);
    }

    @PostMapping("/facilities")
    public ResponseEntity<Facility> createFacility(@RequestBody Facility newFacility) {
        return new ResponseEntity<>(facilityService.create(newFacility), HttpStatus.OK);
    }

    @PutMapping("/facilities")
    public ResponseEntity<Facility> updateFacility(@RequestBody Facility updatedFacility) {
        return new ResponseEntity<>(facilityService.update(updatedFacility), HttpStatus.OK);
    }

    @DeleteMapping("/facilities")
    public ResponseEntity<Void> deleteFacility(@RequestBody Integer facilityId) {
        facilityService.delete(facilityId);
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
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer updatedCustomer) {
        return new ResponseEntity<>(customerService.update(updatedCustomer), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@RequestBody Integer customerId) {
        customerService.delete(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
