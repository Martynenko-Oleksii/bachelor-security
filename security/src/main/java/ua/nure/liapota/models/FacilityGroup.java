package ua.nure.liapota.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class FacilityGroup {
    @Id
    private int id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "facilityGroups")
    private Set<Facility> facilities;
    @OneToMany(mappedBy = "facilityGroup")
    private Set<UsersCustomers> usersCustomers;

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
