package ua.nure.liapota.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    private int id;
    private String name;
    private String abbreviation;
    private String ZIPCode;
    private String address1;
    private String address2;
    private String city;
    private String contactPhone;
    private String contactEmail;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "facilities_facility_groups",
            joinColumns = @JoinColumn(name = "facility_id"),
            inverseJoinColumns = @JoinColumn(name = "facility_group_id"))
    private Set<FacilityGroup> facilityGroups;
    @ManyToMany
    @JoinTable(
            name = "facilities_standart_departments",
            joinColumns = @JoinColumn(name = "facility_id"),
            inverseJoinColumns = @JoinColumn(name = "standart_department_id"))
    private Set<StandardDepartment> facilityStandardDepartments;

    public Customer getCustomer() {
        return customer;
    }

    public Set<FacilityGroup> getFacilityGroups() {
        return facilityGroups;
    }

    public Set<StandardDepartment> getFacilityStandardDepartments() {
        return facilityStandardDepartments;
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

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setZIPCode(String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getZIPCode() {
        return ZIPCode;
    }
}
