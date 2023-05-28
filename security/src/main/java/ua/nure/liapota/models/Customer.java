package ua.nure.liapota.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private int id;
    private String name;
    private String description;
    private Date activationDate;
    private boolean autoRenewal;
    private Date expiringDate;

    @OneToMany(mappedBy = "customer")
    private Set<Facility> facilities;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Contract getContract() {
        return contract;
    }

    public Set<Facility> getFacilities() {
        return facilities;
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

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public boolean isAutoRenewal() {
        return autoRenewal;
    }
}
