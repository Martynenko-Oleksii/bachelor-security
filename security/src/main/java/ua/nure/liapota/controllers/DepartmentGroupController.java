package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.DepartmentGroup;
import ua.nure.liapota.services.DepartmentGroupService;

import java.util.List;

@RestController
@RequestMapping("/departmentGroups")
public class DepartmentGroupController {
    private final DepartmentGroupService service;

    @Autowired
    public DepartmentGroupController(DepartmentGroupService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DepartmentGroup>> getDepartmentGroupsByCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getByCustomerId(id), HttpStatus.OK);
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
