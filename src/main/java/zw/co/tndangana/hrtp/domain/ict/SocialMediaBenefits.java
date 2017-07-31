package zw.co.tndangana.hrtp.domain.ict;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;

import javax.persistence.Entity;

/**
 * Created by tndangana on 7/5/17.
 */
@Entity
public class SocialMediaBenefits extends BaseEntityUniqueId {

    private String benefit1;
    private String benefit2;
    private String benefit3;
    private String benefit4;



    public String getBenefit1() {
        return benefit1;
    }

    public void setBenefit1(String benefit1) {
        this.benefit1 = benefit1;
    }

    public String getBenefit2() {
        return benefit2;
    }

    public void setBenefit2(String benefit2) {
        this.benefit2 = benefit2;
    }

    public String getBenefit3() {
        return benefit3;
    }

    public void setBenefit3(String benefit3) {
        this.benefit3 = benefit3;
    }

    public String getBenefit4() {
        return benefit4;
    }

    public void setBenefit4(String benefit4) {
        this.benefit4 = benefit4;
    }


}
