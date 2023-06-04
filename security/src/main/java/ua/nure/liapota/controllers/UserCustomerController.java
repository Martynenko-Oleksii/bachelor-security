package ua.nure.liapota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.services.UserCustomerService;

import javax.servlet.http.HttpServletRequest;

@Authorize("security,access-control")
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCustomerController {
    private final UserCustomerService service;

    @Autowired
    public UserCustomerController(UserCustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserCustomer>> getUsersByCustomer(HttpServletRequest request) {
        return new ResponseEntity<>(service.getByCustomerId((Integer) request.getAttribute("customerId")),
                HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId, HttpServletRequest request) {
        if (!userId.equals(request.getAttribute("userId"))) {
            service.delete(userId);
        }
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
