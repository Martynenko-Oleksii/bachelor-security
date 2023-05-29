package ua.nure.liapota.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "standart_departments")
public class StandardDepartment {
    @Id
    @Column(name = "standart_department_id")
    private int id;
    private String name;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "facilityStandardDepartments")
    private Set<Facility> facilities;
    @JsonIgnore
    @ManyToMany(mappedBy = "standardDepartments")
    private Set<DepartmentGroup> departmentGroups;

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public Set<DepartmentGroup> getDepartmentGroups() {
        return departmentGroups;
    }

    public void setDepartmentGroups(Set<DepartmentGroup> departmentGroups) {
        this.departmentGroups = departmentGroups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
