package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.Customer;
import ua.nure.liapota.models.Facility;
import ua.nure.liapota.services.CustomerService;
import ua.nure.liapota.services.FacilityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Authorize("security,customer-management")
@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerService customerService;
    private final FacilityService facilityService;

    @Autowired
    public CustomerController(CustomerService customerService, FacilityService facilityService) {
        this.customerService = customerService;
        this.facilityService = facilityService;
    }

    @GetMapping("/expiring")
    public ResponseEntity<List<Customer>> getExpiring() {
        return new ResponseEntity<>(customerService.getExpiring(), HttpStatus.OK);
    }

    @GetMapping("/facilities")
    public ResponseEntity<List<Facility>> getFacilities(HttpServletRequest request) {
        return new ResponseEntity<>(customerService.getFacilities((Integer) request.getAttribute("customerId")),
                HttpStatus.OK);
    }

    @PostMapping("/facilities")
    public ResponseEntity<Facility> createFacility(@RequestBody Facility newFacility, HttpServletRequest request) {
        return new ResponseEntity<>(facilityService.create(newFacility,
                customerService.getById((Integer) request.getAttribute("customerId"))),
                HttpStatus.OK);
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
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id, HttpServletRequest request) {
        if (id != request.getAttribute("customerId")) {
            customerService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
