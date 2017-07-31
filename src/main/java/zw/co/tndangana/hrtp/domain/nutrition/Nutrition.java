package zw.co.tndangana.hrtp.domain.nutrition;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;
import zw.co.tndangana.hrtp.domain.Patient;

import javax.persistence.*;

/**
 * Created by tndangana on 7/13/17.
 */
@Entity
public class Nutrition extends BaseEntityUniqueId{

    private Integer frequencyOfTraditionalFoodConsumption;
    @Enumerated(EnumType.STRING)
    private TakingTradFood takingTradFood;
    @ManyToOne
    private TradFoodBeingTaken tradFoodBeingTaken;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Integer getFrequencyOfTraditionalFoodConsumption() {
        return frequencyOfTraditionalFoodConsumption;
    }

    public void setFrequencyOfTraditionalFoodConsumption(Integer frequencyOfTraditionalFoodConsumption) {
        this.frequencyOfTraditionalFoodConsumption = frequencyOfTraditionalFoodConsumption;
    }

    public TakingTradFood getTakingTradFood() {
        return takingTradFood;
    }

    public void setTakingTradFood(TakingTradFood takingTradFood) {
        this.takingTradFood = takingTradFood;
    }

    public TradFoodBeingTaken getTradFoodBeingTaken() {
        return tradFoodBeingTaken;
    }

    public void setTradFoodBeingTaken(TradFoodBeingTaken tradFoodBeingTaken) {
        this.tradFoodBeingTaken = tradFoodBeingTaken;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
