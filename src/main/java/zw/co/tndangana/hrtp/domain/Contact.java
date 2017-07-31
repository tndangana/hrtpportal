package zw.co.tndangana.hrtp.domain;

import javax.persistence.*;

/**
 * Created by tndangana on 7/4/17.
 */
@Entity
public class Contact extends BaseEntityUniqueId {

    @Enumerated(EnumType.STRING)
private ContactType contactType;


private String contactDetail;
@ManyToOne
@JoinColumn(nullable = false,name="patient_id")
private Patient patient;


    public ContactType getContactType() {

        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}
