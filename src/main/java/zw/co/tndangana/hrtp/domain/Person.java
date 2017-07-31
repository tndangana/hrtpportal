package zw.co.tndangana.hrtp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tndangana on 6/12/17.
 */
@MappedSuperclass
public class Person extends BaseEntityUniqueId {
    @NotEmpty(message = "Please provider first name!!")
    private String firstName;
    @NotEmpty(message = "Please provider last name!!")
    private String lastName;
    @NotEmpty( message = "Please provider a date of birth!!")
    private Date birthDate;
    private String identityType;
    @NotEmpty(message = "Please provider a marital status!!")
    @ManyToOne
    private MaritalStatus maritalStatus;
    @ManyToOne
    private Religion religion;
    @NotEmpty(message = "Please provider gender!!")
    private Gender gender;
    @ManyToOne(cascade = CascadeType.ALL)
    private Title title;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Religion getReligion() {
        return religion;
    }
    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }


}
