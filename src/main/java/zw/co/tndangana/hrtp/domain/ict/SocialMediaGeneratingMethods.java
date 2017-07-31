package zw.co.tndangana.hrtp.domain.ict;

import zw.co.tndangana.hrtp.domain.BaseEntityUniqueId;

import javax.persistence.Entity;

/**
 * Created by tndangana on 7/5/17.
 */
@Entity
public class SocialMediaGeneratingMethods extends BaseEntityUniqueId {

    private String method1;
    private String method2;
    private String method3;
    private String method4;


    public String getMethod1() {
        return method1;
    }

    public void setMethod1(String method1) {
        this.method1 = method1;
    }

    public String getMethod2() {
        return method2;
    }

    public void setMethod2(String method2) {
        this.method2 = method2;
    }

    public String getMethod3() {
        return method3;
    }

    public void setMethod3(String method3) {
        this.method3 = method3;
    }

    public String getMethod4() {
        return method4;
    }

    public void setMethod4(String method4) {
        this.method4 = method4;
    }
}
