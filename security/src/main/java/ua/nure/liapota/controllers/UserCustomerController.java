package ua.nure.liapota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.services.UserCustomerService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCustomerController {
    private final UserCustomerService service;

    @Autowired
    public UserCustomerController(UserCustomerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserCustomer>> getUsersByCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getByCustomerId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId) {
        service.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCustomer> create(@RequestBody UserCustomer userCustomer) {
        return new ResponseEntity<>(service.create(userCustomer), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UserCustomer userCustomer) {
        service.update(userCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
