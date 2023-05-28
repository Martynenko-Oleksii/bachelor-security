package ua.nure.liapota.models;

import javax.persistence.*;

@Entity
@Table(name = "users_customers")
public class UsersCustomers {
    @Id
    private String userId;
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "facility_group_id")
    private FacilityGroup facilityGroup;
    @ManyToOne
    @JoinColumn(name = "department_group_id")
    private DepartmentGroup departmentGroup;

    public FacilityGroup getFacilityGroup() {
        return facilityGroup;
    }

    public void setFacilityGroup(FacilityGroup facilityGroup) {
        this.facilityGroup = facilityGroup;
    }

    public DepartmentGroup getDepartmentGroup() {
        return departmentGroup;
    }

    public void setDepartmentGroup(DepartmentGroup departmentGroup) {
        this.departmentGroup = departmentGroup;
    }

    public String getUserId() {
        return userId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
