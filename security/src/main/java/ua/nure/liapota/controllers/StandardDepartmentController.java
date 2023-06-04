package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.StandardDepartment;
import ua.nure.liapota.services.StandardDepartmentService;

import java.util.List;

@Authorize("security,access-control")
@RestController
@RequestMapping("/standardDepartments")
@CrossOrigin(origins = "http://localhost:4200")
public class StandardDepartmentController {

    private final StandardDepartmentService service;

    @Autowired
    public StandardDepartmentController(StandardDepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StandardDepartment>> getStandardDepartments() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
