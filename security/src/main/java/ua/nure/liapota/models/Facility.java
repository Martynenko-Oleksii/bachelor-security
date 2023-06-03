package ua.nure.liapota.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facilities")
public class Facility {
    @Id
    @Column(name = "facility_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String abbreviation;
    @Column(name = "ZIP_code")
    private String zipCode;
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    private String city;
    private String contactPhone;
    private String contactEmail;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @JsonIgnore
    @ManyToMany(mappedBy = "facilities")
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<FacilityGroup> getFacilityGroups() {
        return facilityGroups;
    }

    public void setFacilityGroups(Set<FacilityGroup> facilityGroups) {
        this.facilityGroups = facilityGroups;
    }

    public Set<StandardDepartment> getFacilityStandardDepartments() {
        return facilityStandardDepartments;
    }

    public void setFacilityStandardDepartments(Set<StandardDepartment> facilityStandardDepartments) {
        this.facilityStandardDepartments = facilityStandardDepartments;
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

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
