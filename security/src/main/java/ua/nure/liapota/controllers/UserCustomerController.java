package ua.nure.liapota.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.services.UserCustomerService;

@RestController
@RequestMapping("/users")
public class UserCustomerController {
    UserCustomerService service;

    @GetMapping
    public ResponseEntity<List<String>> getUsersByCustomer(@RequestBody Integer customerId) {
        return new ResponseEntity<>(service.getByCustomerId(customerId), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody String userId) {
        service.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public UserCustomer create(@RequestBody UserCustomer userCustomer) {
        return service.create(userCustomer);
    }
}
