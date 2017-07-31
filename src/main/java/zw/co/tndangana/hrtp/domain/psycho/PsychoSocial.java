package zw.co.tndangana.hrtp.domain.psycho;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;
import zw.co.tndangana.hrtp.domain.Patient;

import javax.persistence.*;

/**
 * Created by tndangana on 7/13/17.
 */
@Entity
public class PsychoSocial extends BaseEntityUniqueId{
    @ManyToOne(cascade = CascadeType.ALL)
    private SkillTrainingReceived skillTrainingReceived;
    @ManyToOne(cascade = CascadeType.ALL)
    private IncomeGeneratingProject incomeGeneratingProject;
    @Enumerated(EnumType.STRING)
    private ZNNPAffiliation znnpAffiliation;
    private Integer DurationOfznnpAffiliation;
    @ManyToOne
    private AgricPractise agricPractise;
    @Enumerated(EnumType.STRING)
    private SurplusProduce surplusProduce;
    @ManyToOne(cascade = CascadeType.ALL)
    private SurplusProduceUsage surplusProduceUsage;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public SkillTrainingReceived getSkillTrainingReceived() {
        return skillTrainingReceived;
    }

    public void setSkillTrainingReceived(SkillTrainingReceived skillTrainingReceived) {
        this.skillTrainingReceived = skillTrainingReceived;
    }

    public IncomeGeneratingProject getIncomeGeneratingProject() {
        return incomeGeneratingProject;
    }

    public void setIncomeGeneratingProject(IncomeGeneratingProject incomeGeneratingProject) {
        this.incomeGeneratingProject = incomeGeneratingProject;
    }

    public ZNNPAffiliation getZnnpAffiliation() {
        return znnpAffiliation;
    }

    public void setZnnpAffiliation(ZNNPAffiliation znnpAffiliation) {
        this.znnpAffiliation = znnpAffiliation;
    }

    public Integer getDurationOfznnpAffiliation() {
        return DurationOfznnpAffiliation;
    }

    public void setDurationOfznnpAffiliation(Integer durationOfznnpAffiliation) {
        DurationOfznnpAffiliation = durationOfznnpAffiliation;
    }

    public AgricPractise getAgricPractise() {
        return agricPractise;
    }

    public void setAgricPractise(AgricPractise agricPractise) {
        this.agricPractise = agricPractise;
    }

    public SurplusProduce getSurplusProduce() {
        return surplusProduce;
    }

    public void setSurplusProduce(SurplusProduce surplusProduce) {
        this.surplusProduce = surplusProduce;
    }

    public SurplusProduceUsage getSurplusProduceUsage() {
        return surplusProduceUsage;
    }

    public void setSurplusProduceUsage(SurplusProduceUsage surplusProduceUsage) {
        this.surplusProduceUsage = surplusProduceUsage;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
