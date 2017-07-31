package zw.co.tndangana.hrtp.domain.psycho;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by tndangana on 7/13/17.
 */
@Entity
public class SkillTrainingReceived extends BaseEntityUniqueId {
    private String skillTrainingReceived1;
    private String skillTrainingReceived2;
    private String skillTrainingReceived3;



    public String getSkillTrainingReceived1() {
        return skillTrainingReceived1;
    }

    public void setSkillTrainingReceived1(String skillTrainingReceived1) {
        this.skillTrainingReceived1 = skillTrainingReceived1;
    }

    public String getSkillTrainingReceived2() {
        return skillTrainingReceived2;
    }

    public void setSkillTrainingReceived2(String skillTrainingReceived2) {
        this.skillTrainingReceived2 = skillTrainingReceived2;
    }

    public String getSkillTrainingReceived3() {
        return skillTrainingReceived3;
    }

    public void setSkillTrainingReceived3(String skillTrainingReceived3) {
        this.skillTrainingReceived3 = skillTrainingReceived3;
    }

}
