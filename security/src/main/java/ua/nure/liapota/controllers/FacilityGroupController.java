package ua.nure.liapota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.liapota.annotations.Authorize;
import ua.nure.liapota.models.FacilityGroup;
import ua.nure.liapota.services.FacilityGroupService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Authorize("security,access-control")
@RestController
@RequestMapping("/facilityGroups")
@CrossOrigin(origins = "http://localhost:4200")
public class FacilityGroupController {
    private final FacilityGroupService service;

    @Autowired
    public FacilityGroupController(FacilityGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FacilityGroup>> getFacilityGroupsByCustomer(HttpServletRequest request) {
        return new ResponseEntity<>(service.getByCustomerId((Integer) request.getAttribute("customerId")),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacilityGroup> create(@RequestBody FacilityGroup newFacilityGroup) {
        return new ResponseEntity<>(service.create(newFacilityGroup), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody FacilityGroup updatedFacilityGroup) {
        service.update(updatedFacilityGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
