package ua.nure.liapota.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "contracts")
public class Contract{
    @Id
    private int id;
    private String name;
    private String description;
    private byte duration;
    private byte start;

    @JsonIgnore
    @OneToMany(mappedBy = "contract")
    private Set<Customer> customers;

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Contract(){}

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
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

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public byte getStart() {
        return start;
    }

    public void setStart(byte start) {
        this.start = start;
    }
}
