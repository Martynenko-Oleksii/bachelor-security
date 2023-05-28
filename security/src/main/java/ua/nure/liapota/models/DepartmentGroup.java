package ua.nure.liapota.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DepartmentGroup {
    @Id
    private int id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "standart_departments_groups",
            joinColumns = @JoinColumn(name = "department_group_id"),
            inverseJoinColumns = @JoinColumn(name = "standart_department_id"))
    private Set<StandardDepartment> standardDepartments;
    @OneToMany(mappedBy = "departmentGroup")
    private Set<UsersCustomers> usersCustomers;

    public Set<StandardDepartment> getStandardDepartments() {
        return standardDepartments;
    }

    public void setStandardDepartments(Set<StandardDepartment> standardDepartments) {
        this.standardDepartments = standardDepartments;
    }

    public Set<UsersCustomers> getUsersCustomers() {
        return usersCustomers;
    }

    public void setUsersCustomers(Set<UsersCustomers> usersCustomers) {
        this.usersCustomers = usersCustomers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
