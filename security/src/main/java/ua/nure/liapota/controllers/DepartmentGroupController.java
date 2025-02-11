package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.DepartmentGroup;
import ua.nure.liapota.services.DepartmentGroupService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Authorize("security,access-control")
@RestController
@RequestMapping("/departmentGroups")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentGroupController {
    private final DepartmentGroupService service;

    @Autowired
    public DepartmentGroupController(DepartmentGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentGroup>> getDepartmentGroupsByCustomer(HttpServletRequest request) {
        return new ResponseEntity<>(service.getByCustomerId((Integer) request.getAttribute("customerId")),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentGroup> create(@RequestBody DepartmentGroup newDepartmentGroup) {
        return new ResponseEntity<>(service.create(newDepartmentGroup), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody DepartmentGroup updatedDepartmentGroup) {
        service.update(updatedDepartmentGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
