package zw.co.tndangana.hrtp.domain;

import javax.persistence.*;

/**
 * Created by tndangana on 7/4/17.
 */
@Entity
public class Address extends BaseEntityUniqueId {
    private String buildingNumber;
    private String streetName;
    private String surbub;
    @ManyToOne
    private City city;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private Boolean currentResident = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(nullable = false, name = "patient_id")
    private Patient patient;


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSurbub() {
        return surbub;
    }

    public void setSurbub(String surbub) {
        this.surbub = surbub;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Boolean getCurrentResident() {
        return currentResident;
    }

    public void setCurrentResident(Boolean currentResident) {
        this.currentResident = currentResident;
    }


    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
