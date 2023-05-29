package ua.nure.liapota.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department_groups")
public class DepartmentGroup {
    @Id
    @Column(name = "department_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int customerId;

    @ManyToMany
    @JoinTable(
            name = "standart_departments_groups",
            joinColumns = @JoinColumn(name = "department_group_id"),
            inverseJoinColumns = @JoinColumn(name = "standart_department_id"))
    private Set<StandardDepartment> standardDepartments;
    @JsonIgnore
    @OneToMany(mappedBy = "departmentGroup")
    private Set<UserCustomer> usersCustomers;

    public Set<StandardDepartment> getStandardDepartments() {
        return standardDepartments;
    }

    public void setStandardDepartments(Set<StandardDepartment> standardDepartments) {
        this.standardDepartments = standardDepartments;
    }

    public Set<UserCustomer> getUsersCustomers() {
        return usersCustomers;
    }

    public void setUsersCustomers(Set<UserCustomer> usersCustomers) {
        this.usersCustomers = usersCustomers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customer_id) {
        this.customerId = customer_id;
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
