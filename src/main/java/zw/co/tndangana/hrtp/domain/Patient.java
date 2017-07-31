package zw.co.tndangana.hrtp.domain;

import org.hibernate.validator.constraints.NotEmpty;
import zw.co.tndangana.hrtp.domain.ict.IctData;
import zw.co.tndangana.hrtp.domain.nutrition.Nutrition;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tndangana on 6/21/17.
 */
@Entity
public class Patient extends Person  {

    private Double incomeEarned;
    @NotEmpty(message = "Please enter qualification data!!")
    @ManyToOne
    private Qualification qualification;
    @NotEmpty(message = "Please enter accommodation data")
    @ManyToOne
    private Accommodation accommodation;
    @ManyToOne
    private Occupation occupation;
    @OneToMany(mappedBy = "patient")
    private List<Address> addressList;
    @OneToMany(mappedBy = "patient")
    private List<Contact> contactList;
    @OneToMany(mappedBy = "patient")
    private List<IctData> ictDataList;
    @OneToMany(mappedBy = "patient")
    private List<PsychoSocial> psychoSocialList;
    @OneToMany(mappedBy = "patient")
    private List<Nutrition> nutritionList;


    public Patient(){}

    public Patient(Double incomeEarned, Qualification qualification, Accommodation accommodation, Occupation occupation){
        this.accommodation = accommodation;
        this.incomeEarned =incomeEarned;

        this.qualification = qualification;
        this.occupation= occupation;
    }

    public List<IctData> getIctDataList() {
        return ictDataList;
    }

    public void setIctDataList(List<IctData> ictDataList) {
        this.ictDataList = ictDataList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Double getIncomeEarned() {
        return incomeEarned;
    }

    public void setIncomeEarned(Double incomeEarned) {
        this.incomeEarned = incomeEarned;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }


    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public List<PsychoSocial> getPsychoSocialList() {
        return psychoSocialList;
    }

    public void setPsychoSocialList(List<PsychoSocial> psychoSocialList) {
        this.psychoSocialList = psychoSocialList;
    }
}
