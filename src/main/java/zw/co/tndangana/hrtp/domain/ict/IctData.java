package zw.co.tndangana.hrtp.domain.ict;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;
import zw.co.tndangana.hrtp.domain.Patient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Entity
public class IctData extends BaseEntityUniqueId {
    @Enumerated(EnumType.STRING)
    private IsOnSocialMedia isOnSocialMedia;
    @Enumerated(EnumType.STRING)
    private IsSocialMediaGeneratingIncome isSocialMediaGeneratingIncome;
    @ManyToOne
    private MobileOperatingSystem mobileOperatingSystem;
    @ManyToOne
    private SocialMediaApplication socialMediaApplication;
    @ManyToOne(cascade = CascadeType.ALL)
    private SocialMediaGeneratingMethods socialMediaGeneratingMethods;
    @ManyToOne(cascade = CascadeType.ALL)
    private SocialMediaBenefits socialMediaBenefits;
    @Enumerated(EnumType.STRING)
    private SocialMediaTraining socialMediaTraining;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @Enumerated(EnumType.STRING)
    private InternetAccessOnDevice internetAccessOnDevice;
    @Enumerated(EnumType.STRING)
    private HivDiscusionOnMedia hivDiscusionOnMedia;
    @Enumerated(EnumType.STRING)
    private UsedSocialMForMarketing usedSocialMForMarketing;
    @ManyToOne(cascade = CascadeType.ALL)
    private SelfBusinessHelpFromSocialMedia selfBusinessHelpFromSocialMedia;
    @Enumerated(EnumType.STRING)
    private SafeTrainingOfPatient safeTrainingOfPatient;
    @ManyToOne
    private ServiceProvider serviceProvider;






    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public IsOnSocialMedia getIsOnSocialMedia() {
        return isOnSocialMedia;
    }

    public void setIsOnSocialMedia(IsOnSocialMedia isOnSocialMedia) {
        this.isOnSocialMedia = isOnSocialMedia;
    }

    public IsSocialMediaGeneratingIncome getIsSocialMediaGeneratingIncome() {
        return isSocialMediaGeneratingIncome;
    }

    public void setIsSocialMediaGeneratingIncome(IsSocialMediaGeneratingIncome isSocialMediaGeneratingIncome) {
        this.isSocialMediaGeneratingIncome = isSocialMediaGeneratingIncome;
    }

    public MobileOperatingSystem getMobileOperatingSystem() {
        return mobileOperatingSystem;
    }

    public void setMobileOperatingSystem(MobileOperatingSystem mobileOperatingSystem) {
        this.mobileOperatingSystem = mobileOperatingSystem;
    }

    public SocialMediaApplication getSocialMediaApplication() {
        return socialMediaApplication;
    }

    public void setSocialMediaApplication(SocialMediaApplication socialMediaApplication) {
        this.socialMediaApplication = socialMediaApplication;
    }

    public SocialMediaGeneratingMethods getSocialMediaGeneratingMethods() {
        return socialMediaGeneratingMethods;
    }

    public void setSocialMediaGeneratingMethods(SocialMediaGeneratingMethods socialMediaGeneratingMethods) {
        this.socialMediaGeneratingMethods = socialMediaGeneratingMethods;
    }

    public SocialMediaBenefits getSocialMediaBenefits() {
        return socialMediaBenefits;
    }

    public void setSocialMediaBenefits(SocialMediaBenefits socialMediaBenefits) {
        this.socialMediaBenefits = socialMediaBenefits;
    }

    public SocialMediaTraining getSocialMediaTraining() {
        return socialMediaTraining;
    }

    public void setSocialMediaTraining(SocialMediaTraining socialMediaTraining) {
        this.socialMediaTraining = socialMediaTraining;

    }

    public InternetAccessOnDevice getInternetAccessOnDevice() {
        return internetAccessOnDevice;
    }

    public void setInternetAccessOnDevice(InternetAccessOnDevice internetAccessOnDevice) {
        this.internetAccessOnDevice = internetAccessOnDevice;
    }

    public HivDiscusionOnMedia getHivDiscusionOnMedia() {
        return hivDiscusionOnMedia;
    }

    public void setHivDiscusionOnMedia(HivDiscusionOnMedia hivDiscusionOnMedia) {
        this.hivDiscusionOnMedia = hivDiscusionOnMedia;
    }



    public UsedSocialMForMarketing getUsedSocialMForMarketing() {
        return usedSocialMForMarketing;
    }

    public void setUsedSocialMForMarketing(UsedSocialMForMarketing usedSocialMForMarketing) {
        this.usedSocialMForMarketing = usedSocialMForMarketing;
    }

    public SelfBusinessHelpFromSocialMedia getSelfBusinessHelpFromSocialMedia() {
        return selfBusinessHelpFromSocialMedia;
    }

    public void setSelfBusinessHelpFromSocialMedia(SelfBusinessHelpFromSocialMedia selfBusinessHelpFromSocialMedia) {
        this.selfBusinessHelpFromSocialMedia = selfBusinessHelpFromSocialMedia;
    }

    public SafeTrainingOfPatient getSafeTrainingOfPatient() {
        return safeTrainingOfPatient;
    }

    public void setSafeTrainingOfPatient(SafeTrainingOfPatient safeTrainingOfPatient) {
        this.safeTrainingOfPatient = safeTrainingOfPatient;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
