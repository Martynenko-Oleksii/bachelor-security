package ua.nure.liapota.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.models.FacilityGroup;
import ua.nure.liapota.services.FacilityGroupService;

import java.util.List;

@RestController
@RequestMapping("/facilityGroups")
public class FacilityGroupController {
    FacilityGroupService service;

    @GetMapping
    public ResponseEntity<List<FacilityGroup>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacilityGroup> create(@RequestBody FacilityGroup newFacilityGroup) {
        return new ResponseEntity<>(service.create(newFacilityGroup), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FacilityGroup> update(@RequestBody FacilityGroup updatedFacilityGroup) {
        return new ResponseEntity<>(service.update(updatedFacilityGroup), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<FacilityGroup> delete(@RequestBody FacilityGroup deletedFacilityGroup) {
        return new ResponseEntity<>(service.delete(deletedFacilityGroup), HttpStatus.OK);
    }
}
