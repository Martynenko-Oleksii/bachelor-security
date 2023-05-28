package ua.nure.liapota.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.DepartmentGroup;
import ua.nure.liapota.services.DepartmentGroupService;

import java.util.List;

@RestController
@RequestMapping("/departmentGroups")
public class DepartmentGroupController {
    DepartmentGroupService service;

    @GetMapping
    public ResponseEntity<List<DepartmentGroup>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentGroup> create(@RequestBody DepartmentGroup newDepartmentGroup) {
        return new ResponseEntity<>(service.create(newDepartmentGroup), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DepartmentGroup> update(@RequestBody DepartmentGroup updatedDepartmentGroup) {
        return new ResponseEntity<>(service.update(updatedDepartmentGroup), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DepartmentGroup> delete(@RequestBody DepartmentGroup deletedDepartmentGroup) {
        return new ResponseEntity<>(service.delete(deletedDepartmentGroup), HttpStatus.OK);
    }
}
