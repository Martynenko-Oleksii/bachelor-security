package ua.nure.liapota.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.UserCustomer;
import ua.nure.liapota.services.UserCustomerService;

@RestController
@RequestMapping("/users")
public class UserCustomerController {
    UserCustomerService service;

    @GetMapping
    public List<String> getUsersByCustomer(@RequestBody Integer customerId) {
        return service.getByCustomerId(customerId);
    }

    @DeleteMapping
    public String delete(@RequestBody String userId) {
        return service.delete(service.getById(userId)).getUserId();
    }

    @PostMapping
    public UserCustomer create(@RequestBody UserCustomer userCustomer) {
        return service.create(userCustomer);
    }
}
